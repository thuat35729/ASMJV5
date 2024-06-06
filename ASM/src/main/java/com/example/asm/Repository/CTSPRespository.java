package com.example.asm.Repository;

import com.example.asm.Model.CTSP;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CTSPRespository extends JpaRepository<CTSP, Integer> {
    CTSP findAllById(Integer id);
}
