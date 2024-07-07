package com.example.asm.Controller;

import com.example.asm.Model.CTSP;
import com.example.asm.Repository.CTSPRespository;
import com.example.asm.Repository.MauSacRepository;
import com.example.asm.Repository.SanPhamRepository;
import com.example.asm.Repository.KichCoRepository;
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
public class CTSPController {
    @Autowired
    CTSPRespository ctspr;
    @Autowired
    SanPhamRepository spr;
    @Autowired
    KichCoRepository sizer;
    @Autowired
    MauSacRepository mr;

    @RequestMapping("/ctsp/view")
    public String page(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo, Model model, @RequestParam(value = "id_size", defaultValue = "0") Integer id) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CTSP> page = ctspr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("test", sizer.findAllById(id));
        return "CTSP";
    }

    @PostMapping("/ctsp/add")
    public String add(@ModelAttribute CTSP ctsp, RedirectAttributes redirectAttributes, Model model,
                      @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CTSP> page = ctspr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
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
            return "CTSP";
        }
        ctsp.setNgaySua(LocalDateTime.now());
        ctsp.setNgayTao(LocalDateTime.now());
        ctspr.save(ctsp);
        redirectAttributes.addFlashAttribute("message", "Thêm thành công");
        return "redirect:/ctsp/view";
    }


    @GetMapping("/ctsp/delete")
    public String delete(@RequestParam("id") Integer id) {
        ctspr.deleteById(id);
        return "redirect:/ctsp/view";
    }


}
