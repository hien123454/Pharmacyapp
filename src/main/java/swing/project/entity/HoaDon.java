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
public class HoaDon {

	@Id
	@Column
	private Long maHoaDon;

	@Column
	private LocalDate ngayLapHoaDon;

	@Column
	private int soLuongDuocPham;

	@Column
	private Long tongTien;

	@Column
	private String ghiChu;

	

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "maKhachHang")
	private KhachHang khachHang;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "maNhanVien")
	private NhanVien nhanVien;
	
	@OneToMany(mappedBy = "hoaDon")
	private Set<ChiTietHoaDon> chiTietHoaDon = new HashSet<ChiTietHoaDon>();
	
	
	
	public HoaDon() {

	}

	public HoaDon(Long maHoaDon, LocalDate ngayLapHoaDon, int soLuongDuocPham, Long tongTien, String ghiChu,
			KhachHang khachHang, NhanVien nhanVien) {
		super();
		this.maHoaDon = maHoaDon;
		this.ngayLapHoaDon = ngayLapHoaDon;
		this.soLuongDuocPham = soLuongDuocPham;
		this.tongTien = tongTien;
		this.ghiChu = ghiChu;
		this.khachHang = khachHang;
		this.nhanVien = nhanVien;
	}

//	public HoaDon(Long maHoaDon, LocalDate ngayLapHoaDon, int soLuongDuocPham, Long tongTien, String ghiChu,
//			Set<ChiTietHoaDon> chiTietHoaDon, KhachHang khachHang, NhanVien nhanVien) {
//		super();
//		this.maHoaDon = maHoaDon;
//		this.ngayLapHoaDon = ngayLapHoaDon;
//		this.soLuongDuocPham = soLuongDuocPham;
//		this.tongTien = tongTien;
//		this.ghiChu = ghiChu;
//		this.chiTietHoaDon = chiTietHoaDon;
//		this.khachHang = khachHang;
//		this.nhanVien = nhanVien;
//	}
	public Long getMaHoaDon() {
		return maHoaDon;
	}

	public void setMaHoaDon(Long maHoaDon) {
		this.maHoaDon = maHoaDon;
	}

	public LocalDate getNgayLapHoaDon() {
		return ngayLapHoaDon;
	}

	public void setNgayLapHoaDon(LocalDate ngayLapHoaDon) {
		this.ngayLapHoaDon = ngayLapHoaDon;
	}

	public int getSoLuongDuocPham() {
		return soLuongDuocPham;
	}

	public void setSoLuongDuocPham(int soLuongDuocPham) {
		this.soLuongDuocPham = soLuongDuocPham;
	}

	public Long getTongTien() {
		return tongTien;
	}

	public void setTongTien(long i) {
		this.tongTien = i;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public NhanVien getNhanVien() {
		return nhanVien;
	}

	public void setNhanVien(NhanVien nhanVien) {
		this.nhanVien = nhanVien;
	}

	public Set<ChiTietHoaDon> getChiTietHoaDon() {
		return chiTietHoaDon;
	}

	public void setChiTietHoaDon(Set<ChiTietHoaDon> chiTietHoaDon) {
		this.chiTietHoaDon = chiTietHoaDon;
	}

	@Override
	public String toString() {
		return "HoaDon [maHoaDon=" + maHoaDon + ", ngayLapHoaDon=" + ngayLapHoaDon + ", soLuongDuocPham="
				+ soLuongDuocPham + ", tongTien=" + tongTien + ", ghiChu=" + ghiChu + ", danhSachDuocPham="
				+ ", khachHang=" + khachHang.getMaKhachHang() + ", nhanVien=" + nhanVien.getMaNhanVien() + "]";
	}
}
