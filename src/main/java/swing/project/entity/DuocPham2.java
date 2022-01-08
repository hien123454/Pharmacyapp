package swing.project.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class DuocPham2 {

	@Id
	@Column
	private Long maDuocPham;

	@Column
	private String tenDuocPham;

	@Column
	private int soLuong;

	@Column
	private double giaNhap;

	@Column
	private double giaBan;

	@Column
	private String donViTinh;

	@Column
	private LocalDate ngayNhap;

	@Column

	private LocalDate ngaySanXuat;

	@Column

	private LocalDate ngayHetHan;

	@Column
	private String moTa;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maLoai")
	private LoaiDuocPham loaiDuocPham;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "maNhaCungCap")
	private NhaCungCap nhaCungCap;

	@OneToMany(mappedBy = "duocPham")
	private Set<ChiTietHoaDon> chiTietHoaDon = new HashSet<ChiTietHoaDon>();

	public DuocPham2() {

	}

	public DuocPham2(Long maDuocPham, String tenDuocPham, int soLuong, double giaNhap, double giaBan, String donViTinh,
			LocalDate ngayNhap, LocalDate ngaySanXuat, LocalDate ngayHetHan, String moTa, LoaiDuocPham loaiDuocPham,
			NhaCungCap nhaCungCap) {
		super();
		this.maDuocPham = maDuocPham;
		this.tenDuocPham = tenDuocPham;
		this.soLuong = soLuong;
		this.giaNhap = giaNhap;
		this.giaBan = giaBan;
		this.donViTinh = donViTinh;
		this.ngayNhap = ngayNhap;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
		this.moTa = moTa;
		this.loaiDuocPham = loaiDuocPham;
		this.nhaCungCap = nhaCungCap;
	}

	public Long getMaDuocPham() {
		return maDuocPham;
	}

	public void setMaDuocPham(Long maDuocPham) {
		this.maDuocPham = maDuocPham;
	}

	public String getTenDuocPham() {
		return tenDuocPham;
	}

	public void setTenDuocPham(String tenDuocPham) {
		this.tenDuocPham = tenDuocPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getGiaNhap() {
		return giaNhap;
	}

	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public String getDonViTinh() {
		return donViTinh;
	}

	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}

	public LocalDate getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(LocalDate ngayNhap) {
		this.ngayNhap = ngayNhap;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public LoaiDuocPham getLoaiDuocPham() {
		return loaiDuocPham;
	}

	public void setLoaiDuocPham(LoaiDuocPham loaiDuocPham) {
		this.loaiDuocPham = loaiDuocPham;
	}

	public NhaCungCap getNhaCungCap() {
		return nhaCungCap;
	}

	public void setNhaCungCap(NhaCungCap nhaCungCap) {
		this.nhaCungCap = nhaCungCap;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(Set<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	@Override
	public String toString() {
		return "DuocPham [maDuocPham=" + maDuocPham + ", tenDuocPham=" + tenDuocPham + ", soLuong=" + soLuong
				+ ", giaNhap=" + giaNhap + ", giaBan=" + giaBan + ", donViTinh=" + donViTinh + ", ngayNhap=" + ngayNhap
				+ ", ngaySanXuat=" + ngaySanXuat + ", ngayHetHan=" + ngayHetHan + ", moTa=" + moTa + ", loaiDuocPham="
				+ loaiDuocPham.getMaLoai() + ", nhaCungCap=" + nhaCungCap.getMaNhaCungCap() + "]";
	}
}
