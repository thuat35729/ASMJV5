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
    @RequestMapping("/mau-sac/view")
    public String view(Model model){
        model.addAttribute("listms", mauSacRepository.findAll());
        return "Mau";
    }
    @PostMapping("/mau-sac/add")
    public String add(@ModelAttribute MauSac mauSac){
        mauSac.setNgaySua(LocalDateTime.now());
        mauSac.setNgayTao(LocalDateTime.now());
        mauSacRepository.save(mauSac);
        return "redirect:/mau-sac/view";
    }
    @GetMapping("/mau-sac/delete")
    public String delete(@RequestParam("id") Integer id){
        mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/view";
    }
    @GetMapping("/mau-sac/detail")
    public String detail(Model model, @RequestParam("id") Integer id){
        model.addAttribute("listMau", mauSacRepository.findAllById(id));
        return "Detail/DetailMauSac";
    }
}
