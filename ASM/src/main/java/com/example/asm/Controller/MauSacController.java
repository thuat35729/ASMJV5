package com.example.asm.Controller;

import com.example.asm.Repository.MauSacRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MauSacController {
    @Autowired
    MauSacRepository mauSacRepository;
    @RequestMapping("/mau-sac/view")
    public String view(Model model){
        model.addAttribute("listms", mauSacRepository.findAll());
        return "Mau";
    }
}
