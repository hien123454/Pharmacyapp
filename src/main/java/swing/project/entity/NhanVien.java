package swing.project.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class NhanVien {

	@Id
	@Column
	private Long maNhanVien;

	@Column
	private String tenNhanVien;

	@Column
	private int caLam;

	@Column
	private double tienLuong;

	@Column
	private String soDienThoai;

	@Column
	private String diaChi;
	@Column
	private String taiKhoan;
	@Column
	private String matKhau;

	@OneToMany(mappedBy = "nhanVien")
	Set<HoaDon> danhSachHoaDon = new HashSet<HoaDon>();

	public NhanVien() {

	}

	public NhanVien(Long maNhanVien, String tenNhanVien, String soDienThoai, String diaChi) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;

	}

	public Long getMaNhanVien() {
		return maNhanVien;
	}

	public void setMaNhanVien(Long maNhanVien) {
		this.maNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return tenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

	public int getCaLam() {
		return caLam;
	}

	public void setCaLam(int caLam) {
		this.caLam = caLam;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public Set<HoaDon> getDanhSachHoaDon() {
		return danhSachHoaDon;
	}

	public void setDanhSachHoaDon(Set<HoaDon> danhSachHoaDon) {
		this.danhSachHoaDon = danhSachHoaDon;
	}

	public NhanVien(Long maNhanVien, String tenNhanVien, int caLam, double tienLuong, String soDienThoai, String diaChi,
			String taiKhoan, String matKhau) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.caLam = caLam;
		this.tienLuong = tienLuong;
		this.soDienThoai = soDienThoai;
		this.diaChi = diaChi;
		this.taiKhoan = taiKhoan;
		this.matKhau = matKhau;
	}

	@Override
	public String toString() {
		return "NhanVien [maNhanVien=" + maNhanVien + ", tenNhanVien=" + tenNhanVien + ", caLam=" + caLam
				+ ", tienLuong=" + tienLuong + ", soDienThoai=" + soDienThoai + ", diaChi=" + diaChi + ", taiKhoan="
				+ taiKhoan + ", matKhau=" + matKhau + ", danhSachHoaDon=" + danhSachHoaDon + "]";
	}

}
