package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="mau_sac")
public class MauSac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="ma_mau")
    private String maMau;
    @Column(name="ten_mau")
    private String tenMau;
    @Column(name="trang_thai")
    private String trangThai;
    @Column(name="ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name="ngay_tao")
    private LocalDateTime ngayTao;

}
