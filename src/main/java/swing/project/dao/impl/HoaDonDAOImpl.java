package swing.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.HoaDonDAO;
import swing.project.entity.HoaDon;
import swing.project.hibernate.HibernateUtil;

public class HoaDonDAOImpl implements HoaDonDAO {

	public HoaDonDAOImpl() {

	}

	@Override
	public boolean themHoaDon(HoaDon hoaDon) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(hoaDon);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public boolean xoaHoaDon(Long maHoaDon) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM HoaDon d WHERE d.maHoaDon=:hoadon_id ")
					.setParameter("hoadon_id", maHoaDon);
			int result = query.executeUpdate();
			System.out.println("Cột đã bị xóa :" + result);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	@Override
	public HoaDon timHoaDonTheoMa(Long maHoaDon) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM HoaDon d WHERE d.maHoaDon=:hoadon_id ").setParameter("hoadon_id",
					maHoaDon);
			HoaDon hoaDon = (HoaDon) query.getSingleResult();
			transaction.commit();
			return hoaDon;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<HoaDon> getDanhSachHoaDon() {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM HoaDon");
			List<HoaDon> result = query.getResultList();
			transaction.commit();
			return result;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}
	
	

	@Override
	public List<HoaDon> getDanhSachHoaDonTheoTenKhachHang(String tenKhachHang) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery(
							"SELECT hd FROM HoaDon hd INNER JOIN hd.khachHang kh WHERE kh.tenKhachHang=:tenKhachHang")
					.setParameter("tenKhachHang", tenKhachHang);
			List<HoaDon> result = query.getResultList();
			transaction.commit();
			return result;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<HoaDon> getTheoNam(int namLap) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM HoaDon hd " + "WHERE YEAR(hd.ngayLapHoaDon)=:namLap")
					.setParameter("namLap", namLap);
			List<HoaDon> result = query.getResultList();
			transaction.commit();
			return result;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<HoaDon> getTheoThang(int thangLap, int namLap) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery("FROM HoaDon hd "
							+ "WHERE YEAR(hd.ngayLapHoaDon)=:namLap AND MONTH(hd.ngayLapHoaDon)=:thangLap")
					.setParameter("thangLap", thangLap).setParameter("namLap", namLap);
			List<HoaDon> result = query.getResultList();
			transaction.commit();
			return result;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<HoaDon> getTheoNgay(int ngayLap, int thangLap, int namLap) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM HoaDon hd "
					+ "WHERE YEAR(hd.ngayLapHoaDon)=:namLap AND MONTH(hd.ngayLapHoaDon)=:thangLap AND DAY(hd.ngayLapHoaDon)=:ngayLap")
					.setParameter("ngayLap", ngayLap).setParameter("thangLap", thangLap).setParameter("namLap", namLap);
			List<HoaDon> result = query.getResultList();
			transaction.commit();
			return result;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

}
