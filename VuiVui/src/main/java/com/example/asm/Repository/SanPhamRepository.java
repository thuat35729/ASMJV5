package com.example.asm.Repository;

import com.example.asm.Model.SanPham;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPham, Integer> {
    List<SanPham> findAllByOrderByNgayTaoDesc();
    SanPham findAllById(Integer id);
    Page<SanPham> findAllByOrderByNgayTaoDesc(Pageable pageable);
}
