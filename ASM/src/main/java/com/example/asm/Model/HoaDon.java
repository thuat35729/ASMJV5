package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang id_khachHang;
    @Column(name = "trang_thai")
    private String trangThai;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_tao")
    private Date ngayTao;
    @Temporal(TemporalType.DATE)
    @Column(name = "ngay_sua")
    private Date ngaySua;
}
