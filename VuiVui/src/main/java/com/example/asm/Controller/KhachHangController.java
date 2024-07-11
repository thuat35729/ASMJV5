package com.example.asm.Controller;

import com.example.asm.Model.KhachHang;
import com.example.asm.Repository.KhachHangRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Controller
public class KhachHangController {
    @Autowired
    KhachHangRepository khachHangRepository;

    @RequestMapping(value = "/khach-hang/hien-thi")
    public void danhSachKhachHang(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/khach-hang/hien-thi")) {
            request.setAttribute("listkh", khachHangRepository.findAll());
            request.getRequestDispatcher("/WEB-INF/views/KhachHang.jsp").forward(request, response);
        }
    }

    @PostMapping("/khach-hang/them")
    public String themThongTinKhachHang(@ModelAttribute KhachHang khachHang, HttpServletResponse response, Model model) throws IOException {
        model.addAttribute("listkh", khachHangRepository.findAll());
        boolean check = true;
        if (khachHang.getHoTen().isEmpty()) {
            model.addAttribute("errorTenKhachHang", "Tên khách hàng không được để trống");
            check = false;
        }
        if (khachHang.getDiaChi().isEmpty()) {
            model.addAttribute("errorDiaChi", "Đia chỉ khách hàng không được để trống");
            check = false;
        }
        if (khachHang.getSdt().isEmpty()) {
            model.addAttribute("errorSDT", "Số điện thoaị không được để trống");
            check = false;
        }
        if (khachHang.getSdt().length() != 10) {
            model.addAttribute("errorSDT", "Số điện thoaị phải là 10 số");
            check = false;
        }
        if (!check) {
            return "KhachHang";
        }
        khachHang.setNgayTao(LocalDateTime.now());
        khachHang.setNgaySua(LocalDateTime.now());
        khachHangRepository.save(khachHang);
        //response.sendRedirect("/khach-hang/hien-thi");
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/xoa")
    public String xoaKhachHang(@RequestParam("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/hien-thi";
    }

    @GetMapping("/khach-hang/chi-tiet")
    public String chiTietKhachHang(Model model, @RequestParam("id") Integer id) {
        model.addAttribute("listKH", khachHangRepository.findAllById(id));
        return "Detail/ChiTietKhachHang";
    }
    @PostMapping("/khach-hang/sua")
    public String suaThongTinKhachHang(@ModelAttribute KhachHang khachHang, @RequestParam("id") Integer id){
        KhachHang kh = khachHangRepository.findAllById(id);
        khachHang.setNgayTao(kh.getNgaySua());
        khachHang.setNgaySua(LocalDateTime.now());
        khachHangRepository.save(khachHang);
        return "redirect:/khach-hang/hien-thi";
    }
}
