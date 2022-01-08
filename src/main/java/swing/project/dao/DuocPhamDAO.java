package swing.project.dao;

import java.util.List;

import swing.project.entity.DuocPham;
import swing.project.entity.DuocPham2;

public interface DuocPhamDAO {
	public List<DuocPham> getDanhSachDuocPham();

	public boolean themDuocPham(DuocPham duocPham);

	public boolean themDuocPham2(DuocPham2 duocPham);

	public boolean xoaDuocPham(Long maDuocPham);

	public boolean xoaDuocPham2(Long maDuocPham);

	public boolean suaDuocPham(DuocPham duocPham);

	public boolean suaDuocPham2(DuocPham2 duocPham);

	public DuocPham timDuocPhamTheoMa(Long maDuocPham);

	public List<DuocPham> timDuocPhamTen(String maDuocPham);

	public List<DuocPham> timDuocPhamHH();

	public List<DuocPham> timCHH();

	public List<DuocPham2> timDuocPhamMN();

}
