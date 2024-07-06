package com.example.asm.Repository;

import com.example.asm.Model.HoaDon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonRepository extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findTop1ById(Integer id);

    List<HoaDon> findAllByOrderByNgayTaoDesc();

    HoaDon findAllById(Integer id);

    Page<HoaDon> findAllByOrderByNgayTaoDesc(Pageable pageable);
}
