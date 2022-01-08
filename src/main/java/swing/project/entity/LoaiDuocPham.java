package swing.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class LoaiDuocPham {
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long maLoai;

	@Column
	private String tenLoai;

	@OneToMany(mappedBy = "loaiDuocPham", cascade = CascadeType.ALL)
	List<DuocPham> danhSachDuocPhamLoai = new ArrayList<DuocPham>();

	public LoaiDuocPham() {

	}

	public LoaiDuocPham(String tenLoai) {
		super();
		this.tenLoai = tenLoai;
	}

	public Long getMaLoai() {
		return maLoai;
	}

	public void setMaLoai(Long maLoai) {
		this.maLoai = maLoai;
	}

	public String getTenLoai() {
		return tenLoai;
	}

	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}

	public List<DuocPham> getDanhSachDuocPhamLoai() {
		return danhSachDuocPhamLoai;
	}

	public void setDanhSachDuocPhamLoai(List<DuocPham> danhSachDuocPhamLoai) {
		this.danhSachDuocPhamLoai = danhSachDuocPhamLoai;
	}

	@Override
	public String toString() {
		return "LoaiDuocPham [maLoai=" + maLoai + ", tenLoai=" + tenLoai + ", danhSachDuocPhamLoai="
				+ danhSachDuocPhamLoai + "]";
	}

}
