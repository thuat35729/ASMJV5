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

    @RequestMapping("/san-pham/view")
    public String page(@RequestParam(value = "pageNo", defaultValue = "0") Integer pageNo,
                       //@RequestParam(value = "view", required = false) String view,
                       Model model) {
//         if ("submit".equals(view)) {
        Pageable pageable = PageRequest.of(pageNo, 5);
        Page<SanPham> page = spr.findAllByOrderByNgayTaoDesc(pageable);
        model.addAttribute("page", page.getContent());
        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPage", page.getTotalPages());
        model.addAttribute("listdm", dmr.findAll());
//        viewTable = view;
//         }
//        model.addAttribute("view", viewTable);
        return "SanPham";
    }


    @PostMapping("/san-pham/add")
    public String add(@ModelAttribute("sp") SanPham sanPham) {
        sanPham.setNgayTao(LocalDateTime.now());
        sanPham.setNgaySua(LocalDateTime.now());
        spr.save(sanPham);
        return "redirect:/san-pham/view";
    }

    @PostMapping("/san-pham/update")
    public String update(@ModelAttribute SanPham sanPham, @RequestParam("id") Integer id) {
//        SanPham sp = spr.findAllById(id);
//        sp.setMaSP(sanPham.getMaSP());
//        sp.setTenSP(sanPham.getTenSP());
//        sp.setTrangThai(sanPham.getTrangThai());
//        sp.setId_danhMuc(sanPham.getId_danhMuc());
        SanPham sp = spr.findAllById(id);
        sanPham.setNgaySua(LocalDateTime.now());
        sanPham.setNgayTao(sp.getNgayTao());
        spr.save(sanPham);
        return "redirect:/san-pham/view";
    }

    @GetMapping("/san-pham/delete")
    public String delete(@ModelAttribute("sp") SanPham sanPham, @RequestParam("id") Integer id) {
        spr.deleteById(id);
//        SanPham sp = spr.findAllById(id);
//        spr.delete(sp);
        return "redirect:/san-pham/view";
    }

    @GetMapping("/san-pham/detail")
    public String detail(@RequestParam("id") Integer id, Model model) {
        model.addAttribute("listdm", dmr.findAll());
        SanPham sp = spr.findAllById(id);
        model.addAttribute("listsp", sp);
        return "Detail/DetailSanPham";
    }

}
