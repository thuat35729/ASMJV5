package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "co_ao")
public class CoAo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "ma_co_ao")
    private String maCoAo;
    @Column(name = "ten_co_ao")
    private String tenCoAo;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
}
