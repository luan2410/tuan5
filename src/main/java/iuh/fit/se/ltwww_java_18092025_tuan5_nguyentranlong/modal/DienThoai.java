package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "DIENTHOAI")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DienThoai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MADT")
    private Long maDT;
    @Column(name = "TENDT")
    private String tenDT;
    @Column(name = "NAMSANXUAT")
    private String namSX;
    @Column(name = "CAUHINH")
    private String cauHinh;
    @ManyToOne
    @JoinColumn(name = "MANCC")
    private NhaCungCap ncc;
    @Column(name = "HINHANH")
    private String hinhAnh;
}
