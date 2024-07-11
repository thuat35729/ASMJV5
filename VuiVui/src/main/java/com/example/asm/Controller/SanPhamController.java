package com.example.asm.Controller;

import com.example.asm.Model.SanPham;
import com.example.asm.Repository.DanhMucRepository;
import com.example.asm.Repository.SanPhamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;

@Controller
public class SanPhamController {
    @Autowired
    DanhMucRepository dmr;
    @Autowired
    SanPhamRepository spr;

    //    @ResponseBody
//    @RequestMapping("/home/viewSP")
//    public String view(Model model) {
//        List<SanPham> list = spr.findAllByOrderByNgayTaoDesc();
//        model.addAttribute("list", list);
//        return "viewSP";
//    }
//    public String page(@RequestParam("pageNo") Integer pageNo, Model model
//    ) {
//        Pageable pageable = PageRequest.of(pageNo, 2, Sort.unsorted());
//        Page<SanPham> page = spr.findAll(pageable);
//        model.addAttribute("page", page);
//        return "viewSP";
//    }
    // String viewTable = null;

    @RequestMapping("/san-pham/hien-thi")
    public String danhSachSanPham(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                                  //@RequestParam(value = "view", required = false) String view,
                                  Model model) {
//         if ("submit".equals(view)) {
        setModel(model, pageNo);
//        viewTable = view;
//         }
//        model.addAttribute("view", viewTable);
        return "SanPham";
    }


    @PostMapping("/san-pham/them")
    public String themSanPham(@ModelAttribute("sp") SanPham sanPham, Model model, @RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo) {
        setModel(model, pageNo);
        boolean check = true;
        if (sanPham.getMaSP().isEmpty()) {
            model.addAttribute("errorMaSP", "Mã sản phẩm không được để trống");
            check = false;
        }
        if (sanPham.getTenSP().isEmpty()) {
            model.addAttribute("errorMaSP", "Mã sản phẩm không được để trống");
            check = false;
        }
        if (!check) {
            return "SanPham";
        }
        sanPham.setNgayTao(LocalDateTime.now());
        sanPham.setNgaySua(LocalDateTime.now());
        spr.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @PostMapping("/san-pham/sua")
    public String suaSanPham(@ModelAttribute SanPham sanPham, @RequestParam("id") Integer id) {
//        SanPham sp = spr.findAllById(id);
//        sp.setMaSP(sanPham.getMaSP());
//        sp.setTenSP(sanPham.getTenSP());
//        sp.setTrangThai(sanPham.getTrangThai());
//        sp.setId_danhMuc(sanPham.getId_danhMuc());
        SanPham sp = spr.findAllById(id);
        sanPham.setNgaySua(LocalDateTime.now());
        sanPham.setNgayTao(sp.getNgayTao());
        spr.save(sanPham);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/delete")
    public String XoaSanPham(@ModelAttribute("sp") SanPham sanPham, @RequestParam("id") Integer id) {
        spr.deleteById(id);
//        SanPham sp = spr.findAllById(id);
//        spr.delete(sp);
        return "redirect:/san-pham/hien-thi";
    }

    @GetMapping("/san-pham/chi-tiet")
    public String chiTietSanPham(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("listdm", dmr.findAll());
        SanPham sp = spr.findAllById(id);
        model.addAttribute("listsp", sp);
        return "Detail/ChiTietSanPham";
    }

    private void setModel(Model model, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> page = spr.findAllByOrderByNgayTaoDesc(pageable);
        model.addAttribute("page", page.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listdm", dmr.findAll());
    }

}
