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
@Table(name = "hoa_don")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "id_khach_hang")
    private KhachHang idKhachHang;
    @Column(name = "trang_thai")
    private String trangThai;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
    @Column(name ="dia_chi")
    private String diaChi;
    @Column(name="so_dien_thoai")
    private String sdt;
}
