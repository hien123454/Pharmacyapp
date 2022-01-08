package swing.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.ChiTietHoaDonDAO;
import swing.project.entity.ChiTietHoaDon;
import swing.project.hibernate.HibernateUtil;

public class ChiTietHoaDonDAOImpl implements ChiTietHoaDonDAO {

	public ChiTietHoaDonDAOImpl() {

	}

	@Override
	public boolean themChiTietHoaDon(ChiTietHoaDon chiTietHoaDon) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(chiTietHoaDon);
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
	public List<ChiTietHoaDon> getDanhSachChiTietHoaDonTheoMaHoaDon(Long maHoaDon) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session
					.createQuery(
							"SELECT cthd FROM ChiTietHoaDon cthd inner join cthd.hoaDon hd WHERE hd.maHoaDon=:maHoaDon")
					.setParameter("maHoaDon", maHoaDon);
			List<ChiTietHoaDon> chiTietHoaDon = (List<ChiTietHoaDon>) query.getResultList();

			transaction.commit();
			return chiTietHoaDon;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<ChiTietHoaDon> getDanhSachCTHD() {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM ChiTietHoaDon");
			List<ChiTietHoaDon> result = query.getResultList();
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
