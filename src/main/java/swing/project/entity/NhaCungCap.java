package swing.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class NhaCungCap {

	@Id
	@Column
	private Long maNhaCungCap;

	@Column
	private String tenNhaCungCap;

	@OneToMany(mappedBy = "nhaCungCap")
	List<DuocPham> danhSachDuocPham = new ArrayList<DuocPham>();

	private String xuatXu;

	public NhaCungCap() {

	}

	public NhaCungCap(Long maNhaCungCap, String tenNhaCungCap, List<DuocPham> danhSachDuocPham, String xuatXu) {
		super();
		this.maNhaCungCap = maNhaCungCap;
		this.tenNhaCungCap = tenNhaCungCap;
		this.danhSachDuocPham = danhSachDuocPham;
		this.xuatXu = xuatXu;
	}

	public Long getMaNhaCungCap() {
		return maNhaCungCap;
	}

	public void setMaNhaCungCap(Long maNhaCungCap) {
		this.maNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return tenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		this.tenNhaCungCap = tenNhaCungCap;
	}

	public List<DuocPham> getDanhSachDuocPham() {
		return danhSachDuocPham;
	}

	public void setDanhSachDuocPham(List<DuocPham> danhSachDuocPham) {
		this.danhSachDuocPham = danhSachDuocPham;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	@Override
	public String toString() {
		return "NhaCungCap [maNhaCungCap=" + maNhaCungCap + ", tenNhaCungCap=" + tenNhaCungCap + ", danhSachDuocPham="
				+ danhSachDuocPham + ", xuatXu=" + xuatXu + "]";
	}

}
