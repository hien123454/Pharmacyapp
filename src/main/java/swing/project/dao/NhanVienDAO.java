package swing.project.dao;

import java.util.List;

import swing.project.entity.NhanVien;

public interface NhanVienDAO {

	public List<NhanVien> getNhanVien();

	public boolean suaNV(NhanVien nhanVien);

	public boolean xoaNV(Long maNhanVien);

}
