package com.example.asm.Respository;

import com.example.asm.Model.DanhMuc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRespository extends JpaRepository<DanhMuc, Integer> {

}
