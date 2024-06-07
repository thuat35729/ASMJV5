package com.example.asm.Controller;

import com.example.asm.Repository.KhachHangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;
    @RequestMapping("/khach-hang/view")
    public String view(Model model){
        model.addAttribute("listkh", khachHangRepository.findAll());
        return "KhachHang";
    }
}
