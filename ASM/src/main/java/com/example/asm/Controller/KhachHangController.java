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

    @RequestMapping(value = "/khach-hang/view")
    public void view(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/khach-hang/view")) {
            request.setAttribute("listkh", khachHangRepository.findAll());
            request.getRequestDispatcher("/WEB-INF/views/KhachHang.jsp").forward(request, response);
        }
    }

    @PostMapping("/khach-hang/add")
    public void add(@ModelAttribute KhachHang khachHang,HttpServletResponse response) throws IOException {
        khachHang.setNgayTao(LocalDate.now());
        khachHang.setNgaySua(LocalDate.now());
        khachHangRepository.save(khachHang);
        response.sendRedirect("/khach-hang/view");
    }

    @GetMapping("/khach-hang/delete")
    public String delete(@RequestParam("id") Integer id) {
        khachHangRepository.deleteById(id);
        return "redirect:/khach-hang/view";
    }
}
