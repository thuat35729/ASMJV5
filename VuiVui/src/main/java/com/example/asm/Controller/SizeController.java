package com.example.asm.Controller;

import com.example.asm.Repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SizeController {
    @Autowired
    SizeRepository sizeRepository;

    @RequestMapping("/size/view")
    public String view(Model model) {
        model.addAttribute("listsz", sizeRepository.findAll());
        return "KichCo";
    }
}
