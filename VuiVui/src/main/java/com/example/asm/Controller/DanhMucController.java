package com.example.asm.Controller;

import com.example.asm.Repository.DanhMucRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DanhMucController {
    @Autowired
    DanhMucRepository danhMucRepository;
    @RequestMapping("/danh-muc/view")
    public String view(Model model){
        model.addAttribute("listdm", danhMucRepository.findAll());
        return "DanhMuc";
    }
}
