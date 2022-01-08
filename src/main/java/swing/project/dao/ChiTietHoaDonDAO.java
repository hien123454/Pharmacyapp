package swing.project.dao;

import java.util.List;

import swing.project.entity.ChiTietHoaDon;

public interface ChiTietHoaDonDAO {

	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon);

	public List<ChiTietHoaDon> getDanhSachChiTietHoaDonTheoMaHoaDon(Long tenKhachHang);

	public List<ChiTietHoaDon> getDanhSachCTHD();

}
