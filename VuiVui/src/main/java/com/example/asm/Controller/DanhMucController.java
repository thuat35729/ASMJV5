package com.example.asm.Controller;

import com.example.asm.Model.DanhMuc;
import com.example.asm.Repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class DanhMucController {
    @Autowired
    DanhMucRepository danhMucRepository;

    @RequestMapping("/danh-muc/hien-thi")
    public String danhSachDanhMuc(Model model) {
        model.addAttribute("listdm", danhMucRepository.findAll());
        return "DanhMuc";
    }

    @PostMapping("/danh-muc/them")
    public String themDanhMuc(@ModelAttribute DanhMuc danhMuc, Model model) {
        model.addAttribute("listdm", danhMucRepository.findAll());
        if (Objects.isNull(danhMuc.getMaDanhMuc())) {
            model.addAttribute("errorMaDanhMuc", "Mã danh mục không được để trống");
            return "DanhMuc";
        }
        if (Objects.isNull(danhMuc.getMaDanhMuc())) {
            model.addAttribute("errorMaDanhMuc", "Mã danh mục không được để trống");
            return "DanhMuc";
        }
        danhMuc.setNgaySua(LocalDateTime.now());
        danhMuc.setNgayTao(LocalDateTime.now());
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/danh-muc/xoa")
    public String xoaDanhMuc(@RequestParam("id") Integer id) {
        danhMucRepository.deleteById(id);
        return "redirect:/danh-muc/hien-thi";
    }

    @GetMapping("/danh-muc/chi-tiet")
    public String chiTietDanhMuc(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listDM", danhMucRepository.findAllById(id));
        return "Detail/DetailDanhMuc";
    }

    @PostMapping("/danh-muc/sua")
    public String suaDanhMuc(@ModelAttribute DanhMuc danhMuc) {
        danhMuc.setNgaySua(LocalDateTime.now());
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/hien-thi";
    }
}
