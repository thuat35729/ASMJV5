package com.example.asm.Controller;

import com.example.asm.Repository.HoaDonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TrangChuController {
    @Autowired
    HoaDonRepository hdr;

    @RequestMapping("/home/view")
    public String view(Model model) {
        model.addAttribute("list", hdr.findAll());
        return "TrangChu";
    }
}
