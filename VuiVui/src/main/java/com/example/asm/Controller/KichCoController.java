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

    @RequestMapping("/kich-co/view")
    public String view(Model model) {
        model.addAttribute("listsz", kichCoRepository.findAll());
        return "KichCo";
    }

    @PostMapping("/kich-co/add")
    public String add(@ModelAttribute KichCo kc) {
        kc.setNgaySua(LocalDateTime.now());
        kc.setNgayTao(LocalDateTime.now());
        kichCoRepository.save(kc);
        return "redirect:/kich-co/view";
    }

    @GetMapping("/kich-co/delete")
    public String delete(@RequestParam("id") Integer id) {
        kichCoRepository.deleteById(id);
        return "redirect:/kich-co/view";
    }
    @GetMapping("/kich-co/detail")
    public String detail(@RequestParam("id") Integer id, Model model){
        model.addAttribute("listKC", kichCoRepository.findAllById(id));
        return "Detail/DetailKichCo";
    }
    @GetMapping("/kich-co/update")
    public String update(@ModelAttribute KichCo kichCo){
        kichCo.setNgaySua(LocalDateTime.now());
        kichCoRepository.save(kichCo);
        return "redirect:/kich-co/view";
    }
}
