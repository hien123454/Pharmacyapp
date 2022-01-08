package swing.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.NhanVienDAO;
import swing.project.entity.DuocPham;
import swing.project.entity.NhanVien;
import swing.project.hibernate.HibernateUtil;

public class NhanVienDAOImpl implements NhanVienDAO {

	public NhanVienDAOImpl() {

	}
	
	@Override
	public List<NhanVien> getNhanVien() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM NhanVien");
			List<NhanVien> result = query.getResultList();
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
	public boolean suaNV(NhanVien nhanVien) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(nhanVien);
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
	public boolean xoaNV(Long maNhanVien) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM NhanVien d WHERE d.maNhanVien=:maNhanVien_id ")
					.setParameter("maNhanVien_id", maNhanVien);
			int result = query.executeUpdate();
			System.out.println(" :" + result);
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
}
