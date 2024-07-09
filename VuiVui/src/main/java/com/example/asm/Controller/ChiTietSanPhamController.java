package com.example.asm.Controller;

import com.example.asm.Model.CTSP;
import com.example.asm.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDateTime;
import java.util.Objects;

@Controller
public class ChiTietSanPhamController {
    @Autowired
    CTSPRepository ctspr;
    @Autowired
    SanPhamRepository spr;
    @Autowired
    KichCoRepository sizer;
    @Autowired
    MauSacRepository mr;
    @Autowired
    CoAoRepository cr;

    @RequestMapping("/ctsp/hien-thi")
    public String trangChiTietSanPham(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, Model model, @RequestParam(value = "id_size", defaultValue = "0") Integer id) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CTSP> page = ctspr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("listCoAo", cr.findAll());
        model.addAttribute("test", sizer.findAllById(id));
        return "ChiTietSanPham";
    }

    @PostMapping("/ctsp/them")
    public String themCTSP(@ModelAttribute CTSP ctsp, RedirectAttributes redirectAttributes, Model model,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CTSP> page = ctspr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("listCoAo", cr.findAll());
        boolean check = true;
        if (Objects.isNull(ctsp.getGiaBan()) || ctsp.getGiaBan() <= 0) {
            model.addAttribute("errorGiaBan", "Gia ban phai > 0");
            check = false;
        }
        if (Objects.isNull(ctsp.getSoLuongTon()) || ctsp.getSoLuongTon() <= 0) {
            model.addAttribute("errorSoLuong", "So Luong phai > 0");
            check = false;
        }
        if (!check) {
            return "ChiTietSanPham";
        }
        ctsp.setNgaySua(LocalDateTime.now());
        ctsp.setNgayTao(LocalDateTime.now());
        ctspr.save(ctsp);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/ctsp/hien-thi";
    }


    @GetMapping("/ctsp/xoa")
    public String xoaCTSP(@RequestParam("id") Integer id) {
        ctspr.deleteById(id);
        return "redirect:/ctsp/hien-thi";
    }


}
