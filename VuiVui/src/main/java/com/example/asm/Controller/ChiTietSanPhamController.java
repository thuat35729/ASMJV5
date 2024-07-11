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
        setModel(model, pageNo);
        return "ChiTietSanPham";
    }

    @PostMapping("/ctsp/them")
    public String themCTSP(@ModelAttribute CTSP ctsp, RedirectAttributes redirectAttributes, Model model,
                           @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        setModel(model, pageNo);
        boolean check = checkValidate(ctsp, model);
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

    @GetMapping("/ctsp/chi-tiet")
    public String chiTietSPCT(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("listCoAo", cr.findAll());
        model.addAttribute("listctsp", ctspr.findAllById(id));
        return "Detail/DetailChiTietSanPham";
    }

    @PostMapping("/ctsp/sua")
    public String suaSPCT(@ModelAttribute CTSP ctsp, Model model,
                          @RequestParam(value = "id", required = false) Integer id) {
        setModelAttributes(model);
        CTSP ct = ctspr.findById(id).orElse(null);
        if (ct == null) {
            model.addAttribute("error", "Sản phẩm không tồn tại.");
            return "Detail/DetailChiTietSanPham";
        }

        boolean check = checkValidate(ctsp, model);
        if (!check) {
            model.addAttribute("listctsp", ctsp);
            return "Detail/ThongTinChiTietSanPham";
        }

        ctsp.setNgayTao(ct.getNgayTao());
        ctsp.setNgaySua(LocalDateTime.now());
        ctspr.save(ctsp);

        return "redirect:/ctsp/hien-thi";
    }

    private void setModelAttributes(Model model) {
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("listCoAo", cr.findAll());
    }


    private void setModel(Model model, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 2);
        Page<CTSP> page = ctspr.findAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("listctsp", ctspr.findAll());
        model.addAttribute("listsp", spr.findAll());
        model.addAttribute("listsize", sizer.findAll());
        model.addAttribute("listmau", mr.findAll());
        model.addAttribute("listCoAo", cr.findAll());
    }

    private boolean checkValidate(CTSP ctsp, Model model) {
        boolean check = true;
        if (Objects.isNull(ctsp.getGiaBan()) || ctsp.getGiaBan() <= 0) {
            model.addAttribute("errorGiaBan", "Gia ban phai > 0");
            check = false;
        }
        if (Objects.isNull(ctsp.getSoLuongTon()) || ctsp.getSoLuongTon() <= 0) {
            model.addAttribute("errorSoLuong", "So Luong phai > 0");
            check = false;
        }
        return check;
    }
}
