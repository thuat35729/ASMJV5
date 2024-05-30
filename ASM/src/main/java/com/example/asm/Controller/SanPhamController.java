package com.example.asm.Controller;

import com.example.asm.Model.SanPham;
import com.example.asm.Respository.SanPhamRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class SanPhamController {
    @Autowired
    SanPhamRespository spr;

    @RequestMapping("/home/viewSP")
    public String view(Model model) {
        List<SanPham> list = spr.findAllByOrderByNgayTaoDesc();
        model.addAttribute("list", list);
        return "viewSP";
    }

}
