package com.example.asm.Repository;

import com.example.asm.Model.CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CTSPRespository extends JpaRepository<CTSP, Integer> {
    CTSP findAllById(Integer id);

    List<CTSP> findAllByTrangThaiLike(String trangThai);
}
