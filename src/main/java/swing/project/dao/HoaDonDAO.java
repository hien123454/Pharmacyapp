package swing.project.dao;

import java.util.List;

import swing.project.entity.HoaDon;

public interface HoaDonDAO {

	public boolean themHoaDon(HoaDon hoaDon);

	public boolean xoaHoaDon(Long maHoaDon);

	public HoaDon timHoaDonTheoMa(Long maHoaDon);

	public List<HoaDon> getDanhSachHoaDon();

	public List<HoaDon> getDanhSachHoaDonTheoTenKhachHang(String tenKhachHang);

	public List<HoaDon> getTheoNam(int namLap);

	public List<HoaDon> getTheoThang(int thangLap, int namLap);

	public List<HoaDon> getTheoNgay(int ngayLap, int thangLap, int namLap);

}
