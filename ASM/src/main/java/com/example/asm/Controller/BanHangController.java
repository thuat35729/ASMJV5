package com.example.asm.Controller;

import com.example.asm.Model.HoaDon;
import com.example.asm.Model.HoaDonCT;
import com.example.asm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/ban-hang/view")
    public String view(Model model, @RequestParam(value = "id", defaultValue = "0") Integer id, @RequestParam(value = "sdt", defaultValue = "a") String sdt) {
        model.addAttribute("listhd", hdr.findAll());
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listkh", khr.findTop1BySdtLike(sdt));
        //model.addAttribute("listtthd", hdr.findById(id));
        model.addAttribute("listtthd", hdr.findTop1ById(id));
        List<HoaDonCT> hdctList = hdctr.findByIdHoaDon_Id(id);
        model.addAttribute("listhdct", hdctList);
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
        if (hoaDon.getId_khachHang() == null) {
            model.addAttribute("message","vui long chon, tim khach hang de tao hoa don");
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
    @PostMapping("/ban-hang/them-sp")
    public String themSP(@ModelAttribute("sp") HoaDonCT hoaDonCT){
        
        return null;
    }

}
