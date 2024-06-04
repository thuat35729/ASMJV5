package com.example.asm.Controller;

import com.example.asm.Model.HoaDon;
import com.example.asm.Model.HoaDonCT;
import com.example.asm.Repository.CTSPRespository;
import com.example.asm.Repository.HoaDonChiTietRepository;
import com.example.asm.Repository.HoaDonRepository;
import com.example.asm.Repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @RequestMapping("/ban-hang/view")
    public String view(Model model) {
        model.addAttribute("listhd", hdr.findAll());
        model.addAttribute("listctsp", ctspr.findAll());
        //model.addAttribute("listhdct", hdctr.findAll());
        return "BanHang";
    }

    @GetMapping("/ban-hang/viewhdct")
    public String viewHDCT(Model model, @RequestParam("id") Integer id) {
        List<HoaDonCT> hdctList = hdctr.findHoaDonCTById_hoaDon(id);
        model.addAttribute("listhdct", hdctList);
        return "redirect:/ban-hang/view";
    }
}
