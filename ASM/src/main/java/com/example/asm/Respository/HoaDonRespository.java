package com.example.asm.Respository;

import com.example.asm.Model.HoaDon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HoaDonRespository extends JpaRepository<HoaDon, Integer> {
}
