package com.example.asm.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private MauSac idMauSac;
    @ManyToOne
    @JoinColumn(name = "id_sp")
    private SanPham idSanPham;
    @ManyToOne
    @JoinColumn(name = "id_size")
    private KichCo idSize;
    @ManyToOne
    @JoinColumn(name = "id_co_ao")
    private CoAo idCoAo;
    @Column(name = "gia_ban")
    private Double giaBan;
    @Column(name = "so_luong_ton")
    private Integer soLuongTon;
    @Column(name = "trang_thai")
    private String trangThai;
    @Column(name = "ngay_tao")
    private LocalDateTime ngayTao;
    @Column(name = "ngay_sua")
    private LocalDateTime ngaySua;
}
