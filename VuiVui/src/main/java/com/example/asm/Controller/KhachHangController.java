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
    public void themKhachHang(@ModelAttribute KhachHang khachHang,HttpServletResponse response) throws IOException {
        khachHang.setNgayTao(LocalDate.now());
        khachHang.setNgaySua(LocalDate.now());
        khachHangRepository.save(khachHang);
        response.sendRedirect("/khach-hang/hien-thi");
    }

    @GetMapping("/khach-hang/xoa")
    public String xoaKhachHang(@RequestParam("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/hien-thi";
    }
}
