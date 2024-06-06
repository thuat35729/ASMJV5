package com.example.asm.Controller;

import com.example.asm.Model.CTSP;
import com.example.asm.Model.HoaDon;
import com.example.asm.Model.HoaDonCT;
import com.example.asm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.SoftReference;
import java.util.Date;
import java.util.List;

@Controller
public class BanHangController {
    @Autowired
    HoaDonRepository hdr;
    @Autowired
    MauSacRepository mr;
    @Autowired
    HoaDonChiTietRepository hdctr;
    @Autowired
    CTSPRespository ctspr;
    @Autowired
    KhachHangRepository khr;
    Integer idHD;
    double tongTien;
    int soLuongMoi;

    public BanHangController() {
        idHD = 0;
        tongTien = 0;
    }

    @RequestMapping("/ban-hang/view")
    public String view(Model model, @RequestParam(value = "id", defaultValue = "0") Integer id, @RequestParam(value = "sdt", defaultValue = "a") String sdt) {
        model.addAttribute("listhd", hdr.findAll(Sort.by(Sort.Direction.DESC, "ngayTao")));
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listkh", khr.findTop1BySdtLike(sdt));
        idHD = id;
        //model.addAttribute("listtthd", hdr.findById(id));
        model.addAttribute("listtthd", hdr.findTop1ById(idHD));
        List<HoaDonCT> hdctList = hdctr.findByIdHoaDon_Id(id);
        model.addAttribute("listhdct", hdctList);
        double tongTienHoaDon = 0;
        for (HoaDon hd : hdr.findTop1ById(idHD)
        ) {
            for (HoaDonCT hdct : hdctr.findAll()
            ) {
                if (hd.getId().equals(hdct.getIdHoaDon().getId())) {
                    tongTienHoaDon += hdct.getTongTien();
                }
            }

        }
        model.addAttribute("tongTienHD", tongTienHoaDon);
        return "BanHang";
    }

    //    @GetMapping("/ban-hang/viewhdct")
//    public String viewHDCT(Model model, @RequestParam("id") Integer id) {
//        model.addAttribute("listhd", hdr.findAll());
//        model.addAttribute("listctsp", ctspr.findAll());
//        List<HoaDonCT> hdctList = hdctr.findByIdHoaDon_Id(id);
//        System.out.println(hdctList);
//        model.addAttribute("listhdct", hdctList);
//        return "BanHang";
//    }
    @PostMapping("/ban-hang/them-hd")
    public String themHD(@ModelAttribute("hd") HoaDon hoaDon, Model model) {
        if (hoaDon.getIdKhachHang() == null) {
            model.addAttribute("message", "vui long chon, tim khach hang de tao hoa don");
            model.addAttribute("listhd", hdr.findAll());
            model.addAttribute("listctsp", ctspr.findAll());
            return "BanHang";
        }
        hoaDon.setNgaySua(new Date());
        hoaDon.setNgayTao(new Date());
        hoaDon.setTrangThai("Chua Thanh Toan");
        hdr.save(hoaDon);
        return "redirect:/ban-hang/view";
    }

    @GetMapping("/ban-hang/thanh-toan")
    public String thanhToan(@RequestParam("idHoaDon") Integer id) {
        HoaDon hd = hdr.findAllById(id);
        hd.setTrangThai("Da Thanh Toan");
        hd.setNgaySua(new Date());
        hdr.save(hd);
        return "redirect:/ban-hang/view";
    }

    @GetMapping("/ban-hang/them-sp")
    public String themSP(@RequestParam("idSPCT") Integer idSPCT, @RequestParam("soLuong") Integer soLuong) {
        HoaDonCT hoaDonChiTietTonTai = hdctr.findTop1ByIdCtsp_Id(idSPCT);
        CTSP ctsp = ctspr.findAllById(idSPCT);
        ctsp.setId(idSPCT);
        HoaDonCT hoaDonCT = new HoaDonCT();
        HoaDon hd = new HoaDon();
        hd.setId(idHD);
        boolean productExistsInCurrentOrder = false;
        for (HoaDonCT hdct : hdctr.findAll()) {
            if (hdct.getIdHoaDon().getId().equals(idHD) && hdct.getIdCtsp().getId().equals(idSPCT)) {
                productExistsInCurrentOrder = true;
                hoaDonChiTietTonTai = hdct;
                break;
            }
        }
        if (productExistsInCurrentOrder) {
            soLuongMoi = hoaDonChiTietTonTai.getSoLuong() + soLuong;
            hoaDonChiTietTonTai.setSoLuong(soLuongMoi);
            hoaDonChiTietTonTai.setTongTien(hoaDonChiTietTonTai.getGiaBan() * soLuongMoi);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soLuong);
            hoaDonChiTietTonTai.setNgaySua(new Date());
            hdctr.save(hoaDonChiTietTonTai);
        } else {
            hoaDonCT.setIdHoaDon(hd);
            hoaDonCT.setGiaBan(ctsp.getGiaBan());
            hoaDonCT.setIdCtsp(ctsp);
            hoaDonCT.setSoLuong(soLuongMoi);
            hoaDonCT.setTrangThai("Active");
            hoaDonCT.setNgayTao(new Date());
            hoaDonCT.setNgaySua(new Date());
            hoaDonCT.setTongTien(hoaDonCT.getGiaBan() * hoaDonCT.getSoLuong());
            hdctr.save(hoaDonCT);
        }
        return "redirect:/ban-hang/view";
    }

    @GetMapping("/ban-hang/xoaSP")
    public String xoaSP(@RequestParam("idHDCT") Integer id) {
        HoaDonCT hdct = hdctr.findAllById(id);
        soLuongMoi = hdct.getSoLuong();
        CTSP ctsp = ctspr.findAllById(hdct.getIdCtsp().getId());
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() + soLuongMoi);
        ctspr.save(ctsp);
        hdctr.deleteById(id);
        return "redirect:/ban-hang/view";
    }

}
