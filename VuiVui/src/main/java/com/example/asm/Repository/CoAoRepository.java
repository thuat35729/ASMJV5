package com.example.asm.Repository;

import com.example.asm.Model.CoAo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoAoRepository extends JpaRepository<CoAo, Integer> {
    CoAo findAllById(Integer id);
}
