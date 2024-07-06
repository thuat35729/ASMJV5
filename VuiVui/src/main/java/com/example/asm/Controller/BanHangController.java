package com.example.asm.Controller;

import com.example.asm.Model.CTSP;
import com.example.asm.Model.HoaDon;
import com.example.asm.Model.HoaDonCT;
import com.example.asm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.lang.ref.SoftReference;
import java.time.LocalDateTime;
import java.time.temporal.TemporalQueries;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public BanHangController() {
        idHD = 0;
        tongTien = 0;

    }

    @RequestMapping("/ban-hang/view")
    public String view(Model model, @RequestParam(value = "id", defaultValue = "0") Integer id,
                       @RequestParam(value = "sdt", defaultValue = "a") String sdt,
                       @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<HoaDon> page = hdr.findAllByOrderByNgayTaoDesc(pageable);
        model.addAttribute("listhd", page.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listctsp", ctspr.findAllByTrangThaiLike("Active"));
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
    public String themHD(@ModelAttribute("hd") HoaDon hoaDon, Model model, @RequestParam(value = "sdt", defaultValue = "a") String sdt) {
        if (hoaDon.getIdKhachHang() == null) {
            model.addAttribute("message", "vui long chon, tim khach hang de tao hoa don");
            model.addAttribute("listhd", hdr.findAll());
            model.addAttribute("listctsp", ctspr.findAll());
            model.addAttribute("listkh", khr.findTop1BySdtLike(sdt));
            return "BanHang";
        }
        hoaDon.setNgaySua(LocalDateTime.now());
        hoaDon.setNgayTao(LocalDateTime.now());
        hoaDon.setTrangThai("Chua Thanh Toan");
        hdr.save(hoaDon);
        return "redirect:/ban-hang/view";
    }

    @GetMapping("/ban-hang/thanh-toan")
    public String thanhToan(@RequestParam(value = "idHoaDon", defaultValue = "0") Integer idHoaDon, Model model,
                            @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        HoaDon hd = hdr.findAllById(idHoaDon);
        HoaDonCT hdct = hdctr.findTop1ByIdHoaDon_Id(idHoaDon);
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<HoaDon> page = hdr.findAllByOrderByNgayTaoDesc(pageable);
        model.addAttribute("listhd", page.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listctsp", ctspr.findAllByTrangThaiLike("Active"));
        if (idHoaDon == 0) {
            model.addAttribute("errorThanhToan", "Vui long chon hoa don can thanh toan");
            return "BanHang";
        }
        if (hdct == null || hdct.getTongTien() == null) {
            model.addAttribute("errorThanhToan", "Ban phai them san pham vao gio hang");
            return "BanHang";
        }
        hd.setTrangThai("Da Thanh Toan");
        hd.setNgaySua(LocalDateTime.now());
        hdr.save(hd);
        return "redirect:/ban-hang/view";
    }

    @GetMapping("/ban-hang/them-sp")
    public String themSP(@RequestParam("idSPCT") Integer idSPCT, @RequestParam("soLuong") Integer soLuong, Model model) {
        HoaDonCT hoaDonChiTietTonTai = hdctr.findTop1ByIdCtsp_Id(idSPCT);
        CTSP ctsp = ctspr.findAllById(idSPCT);
        if (soLuong > ctsp.getSoLuongTon()) {
            model.addAttribute("errorSoLuong", "Không được nhập số lượng lớn hơn số lượng tồn");
        }
        if (ctsp.getSoLuongTon() == 0) {
            soLuong = ctsp.getSoLuongTon();
            ctsp.setTrangThai("Inactive");
            ctspr.save(ctsp);
        }
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
            int soLuongMoi = hoaDonChiTietTonTai.getSoLuong() + soLuong;
            hoaDonChiTietTonTai.setSoLuong(soLuongMoi);
            hoaDonChiTietTonTai.setTongTien(hoaDonChiTietTonTai.getGiaBan() * soLuongMoi);
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soLuong);
            hoaDonChiTietTonTai.setNgaySua(LocalDateTime.now());
            hdctr.save(hoaDonChiTietTonTai);

        } else {
            int soLuongMoi = soLuong;
            ctsp.setSoLuongTon(ctsp.getSoLuongTon() - soLuong);
            hoaDonCT.setIdHoaDon(hd);
            hoaDonCT.setGiaBan(ctsp.getGiaBan());
            hoaDonCT.setIdCtsp(ctsp);
            hoaDonCT.setSoLuong(soLuongMoi);
            hoaDonCT.setTrangThai("Active");
            hoaDonCT.setNgayTao(LocalDateTime.now());
            hoaDonCT.setNgaySua(LocalDateTime.now());
            hoaDonCT.setTongTien(hoaDonCT.getGiaBan() * hoaDonCT.getSoLuong());
            hdctr.save(hoaDonCT);
        }

        return "redirect:/ban-hang/view?id=" + idHD;
    }

    @GetMapping("/ban-hang/xoaSP")
    public String xoaSP(@RequestParam("idHDCT") Integer id) {
        HoaDonCT hdct = hdctr.findAllById(id);
        int soLuongMoi = hdct.getSoLuong();
        CTSP ctsp = ctspr.findAllById(hdct.getIdCtsp().getId());
        ctsp.setSoLuongTon(ctsp.getSoLuongTon() + soLuongMoi);
        ctspr.save(ctsp);
        hdctr.deleteById(id);
        return "redirect:/ban-hang/view?id=" + idHD;
    }


}
