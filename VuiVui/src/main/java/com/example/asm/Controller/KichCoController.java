package com.example.asm.Controller;

import com.example.asm.Model.KichCo;
import com.example.asm.Repository.KichCoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class KichCoController {
    @Autowired
    KichCoRepository kichCoRepository;

    @RequestMapping("/kich-co/hien-thi")
    public String danhSachKichCo(Model model) {
        model.addAttribute("listsz", kichCoRepository.findAll());
        return "KichCo";
    }

    @PostMapping("/kich-co/them")
    public String themKichCo(@ModelAttribute KichCo kc, Model model) {
        model.addAttribute("listsz", kichCoRepository.findAll());
        boolean check = true;
        if (kc.getMaSize().isEmpty()) {
            model.addAttribute("errorMaKichCo", "Mã kích cỡ không được để trống");
            check = false;
        }
        if (kc.getTenSize().isEmpty()) {
            model.addAttribute("errorTenKichCo", "Tên kích cỡ không được để trống");
            check = false;
        }
        if (!check) {
            return "KichCo";
        }
        kc.setNgaySua(LocalDateTime.now());
        kc.setNgayTao(LocalDateTime.now());
        kichCoRepository.save(kc);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("/kich-co/xoa")
    public String xoaKichCo(@RequestParam("id") Integer id) {
        kichCoRepository.deleteById(id);
        return "redirect:/kich-co/hien-thi";
    }

    @GetMapping("/kich-co/chi-tiet")
    public String chiTietKichCo(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("listKC", kichCoRepository.findAllById(id));
        return "Detail/ChiTietKichCo";
    }

    @GetMapping("/kich-co/sua")
    public String suaKichCo(@ModelAttribute KichCo kichCo, @RequestParam("id") Integer id) {
        KichCo kc = kichCoRepository.findAllById(id);
        kichCo.setNgayTao(kc.getNgayTao());
        kichCo.setNgaySua(LocalDateTime.now());
        kichCoRepository.save(kichCo);
        return "redirect:/kich-co/hien-thi";
    }
}
