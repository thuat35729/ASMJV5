package com.example.asm.Repository;

import com.example.asm.Model.HoaDon;
import com.example.asm.Model.HoaDonChiTiet;
import com.example.asm.Model.HoaDonChiTiet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HoaDonChiTietRepository extends JpaRepository<HoaDonChiTiet, Integer> {
    List<HoaDonChiTiet> findByIdHoaDon_Id(Integer idHoaDon);
    HoaDonChiTiet findTop1ByIdCtsp_Id(Integer idCTSP);
    HoaDonChiTiet findAllById(Integer id);
    HoaDonChiTiet findTop1ByIdHoaDon_Id(Integer idHoaDon);
}
