package com.example.asm.Controller;

import com.example.asm.Model.DanhMuc;
import com.example.asm.Repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
public class DanhMucController {
    @Autowired
    DanhMucRepository danhMucRepository;

    @RequestMapping("/danh-muc/view")
    public String view(Model model) {
        model.addAttribute("listdm", danhMucRepository.findAll());
        return "DanhMuc";
    }

    @PostMapping("/danh-muc/add")
    public String add(@ModelAttribute DanhMuc danhMuc) {
        danhMuc.setNgaySua(LocalDateTime.now());
        danhMuc.setNgayTao(LocalDateTime.now());
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/view";
    }

    @GetMapping("/danh-muc/delete")
    public String delete(@RequestParam("id") Integer id) {
        danhMucRepository.deleteById(id);
        return "redirect:/danh-muc/view";
    }

    @GetMapping("/danh-muc/detail")
    public String detail(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listDM", danhMucRepository.findAllById(id));
        return "Detail/DetailDanhMuc";
    }

    @PostMapping("/danh-muc/update")
    public String update(@ModelAttribute DanhMuc danhMuc) {
        danhMuc.setNgaySua(LocalDateTime.now());
        danhMucRepository.save(danhMuc);
        return "redirect:/danh-muc/view";
    }
}
