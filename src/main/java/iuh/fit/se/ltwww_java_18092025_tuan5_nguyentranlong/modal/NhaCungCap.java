package iuh.fit.se.ltwww_java_18092025_tuan5_nguyentranlong.modal;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "NHACUNGCAP")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NhaCungCap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MANCC")
    private Long maNCC;
    @Column(name = "NHHACC")
    private String tenNCC;
    @Column(name = "DIACHI")
    private String diaChi;
    @Column(name = "SODIENTHOAI")
    private String soDienThoai;
}
