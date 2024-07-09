package com.example.asm.Controller;

import com.example.asm.Model.MauSac;
import com.example.asm.Repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class MauSacController {
    @Autowired
    MauSacRepository mauSacRepository;

    @RequestMapping("/mau-sac/hien-thi")
    public String danhSachmauSac(Model model) {
        model.addAttribute("listms", mauSacRepository.findAll());
        return "Mau";
    }

    @PostMapping("/mau-sac/them")
    public String themMauSac(@ModelAttribute MauSac mauSac, Model model) {
        model.addAttribute("listms", mauSacRepository.findAll());
        if (mauSac.getMaMau().isEmpty()) {
            model.addAttribute("errorMaMau", "Mã màu không được để trống");
            return "Mau";
        }
        if (mauSac.getTenMau().isEmpty()) {
            model.addAttribute("errorTenMau", "Tên màu không được để trống");
            return "Mau";
        }
        mauSac.setNgaySua(LocalDateTime.now());
        mauSac.setNgayTao(LocalDateTime.now());
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/xoa")
    public String xoaMauSac(@RequestParam("id") Integer id) {
        mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/hien-thi";
    }

    @GetMapping("/mau-sac/chi-tiet")
    public String chiTietMauSac(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listMau", mauSacRepository.findAllById(id));
        return "Detail/DetailMauSac";
    }

    @PostMapping("/mau-sac/sua")
    public String suaMauSac(@ModelAttribute MauSac mauSac, @RequestParam("id") Integer id) {
        MauSac ms = mauSacRepository.findAllById(id);
        mauSac.setNgaySua(LocalDateTime.now());
        mauSac.setNgayTao(ms.getNgayTao());
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/hien-thi";
    }
}
