package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ctsp")
public class CTSP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_mau_sac")
    private MauSac id_mauSac;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham id_sanPham;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private Size id_size;
    @Column(name = "gia_ban")
    private Float giaBan;
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Column(name = "ngay_sua")
    private Date ngaySua;
}