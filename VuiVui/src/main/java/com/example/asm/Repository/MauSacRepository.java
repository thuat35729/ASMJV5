package com.example.asm.Repository;

import com.example.asm.Model.MauSac;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSac, Integer> {
    MauSac findAllById(Integer id);
}
