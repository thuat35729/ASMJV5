package com.example.asm.Controller;

import com.example.asm.Model.HoaDonChiTiet;
import com.example.asm.Model.HoaDonChiTiet;
import com.example.asm.Repository.HoaDonChiTietRepository;
import com.example.asm.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HoaDonController {
    @Autowired
    HoaDonRepository hoaDonR;
    @Autowired
    HoaDonChiTietRepository hoaDonChiTietR;
    float tongTien;

    @RequestMapping("/hoa-don/hien-thi")
    public String danhSachHoaDon(Model model) {
        model.addAttribute("listHD", hoaDonR.findAllByOrderByNgayTaoDesc());
        return "HoaDon";
    }

    @GetMapping("/hoa-don/chi-tiet")
    public String chiTietHoaDon(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listHDCT", hoaDonChiTietR.findByIdHoaDon_Id(id));
        tongTien = 0;
        for (HoaDonChiTiet hoaDonCT : hoaDonChiTietR.findByIdHoaDon_Id(id)) {
            tongTien += hoaDonCT.getTongTien();
        }
        model.addAttribute("tongTienHoaDon", tongTien);
        return "Detail/ThongTinHoaDonChiTiet";
    }
}
