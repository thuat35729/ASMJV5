package com.example.asm.Controller;

import com.example.asm.Model.CoAo;
import com.example.asm.Repository.CoAoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class CoAoController {
    @Autowired
    CoAoRepository coAoRepository;

    @RequestMapping("/co-ao/hien-thi")
    public String danhSachCoAo(Model model) {
        model.addAttribute("listCoAo", coAoRepository.findAll());
        return "CoAo";
    }

    @PostMapping("/co-ao/them")
    public String themCoAo(@ModelAttribute CoAo coAo, Model model) {
        model.addAttribute("listCoAo", coAoRepository.findAll());
        if(Objects.isNull(coAo.getMaCoAo())){
            model.addAttribute("errorMaCoAo", "Không được để trống");
            return "CoAo";
        }
        if(Objects.isNull(coAo.getMaCoAo())){
            model.addAttribute("errorTenCoAo", "Không được để trống");
            return "CoAo";
        }
        coAo.setNgayTao(LocalDateTime.now());
        coAo.setNgaySua(LocalDateTime.now());
        coAoRepository.save(coAo);
        return "redirect:/co-ao/hien-thi";
    }

    @GetMapping("/co-ao/xoa")
    public String xoaCoAo(@RequestParam("id") Integer id) {
        coAoRepository.deleteById(id);
        return "redirect:/co-ao/hien-thi";
    }

    @PostMapping("/co-ao/sua")
    public String suaCoAo(@ModelAttribute CoAo coAo, @RequestParam(value = "id",required = false) Integer id, Model model) {
        if(Objects.isNull(coAo.getMaCoAo())){
            model.addAttribute("listCoAo", coAo);
            model.addAttribute("errorMaCoAo", "Không được để trống mã");
            return "CoAo";
        }
        if(Objects.isNull(coAo.getMaCoAo())){
            model.addAttribute("listCoAo", coAo);
            model.addAttribute("errorTenCoAo", "Không được để trống tên");
            return "CoAo";
        }
        CoAo ca = coAoRepository.findAllById(id);
        coAo.setNgaySua(LocalDateTime.now());
        coAo.setNgayTao(ca.getNgayTao());
        coAoRepository.save(coAo);
        return "redirect:/co-ao/hien-thi";
    }

    @GetMapping("/co-ao/chi-tiet")
    public String chiTietCoAo(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("listCoAo", coAoRepository.findAllById(id));
        return "Detail/DetailCoAo";
    }
}
