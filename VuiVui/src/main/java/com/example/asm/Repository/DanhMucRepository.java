package com.example.asm.Repository;

import com.example.asm.Model.DanhMuc;
import org.eclipse.tags.shaded.org.apache.bcel.generic.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMuc, Integer> {
    DanhMuc findAllById(Integer id);
}
