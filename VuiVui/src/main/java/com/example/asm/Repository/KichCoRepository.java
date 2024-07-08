package com.example.asm.Repository;

import com.example.asm.Model.KichCo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KichCoRepository extends JpaRepository<KichCo, Integer> {
   // List<KichCo> findAllById(Integer id);

    KichCo findAllById(Integer id);
}
