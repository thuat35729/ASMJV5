package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class HoaDonCT {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_hoa_don")
    private Integer id_hoaDon;
    @Column(name = "id_ctsp")
    private Integer id_ctsp;
    @Column(name = "so_luong")
    private Integer soLuong;
    @Column(name = "gia_ban")
    private Float giaBan;
    @Column(name = "tong_tien")
    private Float tongTien;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name="ngay_tao")
    private Date ngayTao;
    @Column(name="ngay_sua")
    private Date ngaySua;
}
