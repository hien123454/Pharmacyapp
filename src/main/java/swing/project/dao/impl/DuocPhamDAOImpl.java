package swing.project.dao.impl;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.DuocPhamDAO;
import swing.project.entity.DuocPham;
import swing.project.entity.DuocPham2;
import swing.project.hibernate.HibernateUtil;

public class DuocPhamDAOImpl implements DuocPhamDAO {

	public DuocPhamDAOImpl() {

	}

	@Override
	public List<DuocPham> getDanhSachDuocPham() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham");
			List<DuocPham> result = query.getResultList();
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
	public boolean themDuocPham(DuocPham duocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(duocPham);
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
	public boolean themDuocPham2(DuocPham2 duocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(duocPham);
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
	public boolean xoaDuocPham(Long maDuocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM DuocPham d WHERE d.maDuocPham=:duocpham_id ")
					.setParameter("duocpham_id", maDuocPham);
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
	public boolean xoaDuocPham2(Long maDuocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("DELETE FROM DuocPham2 d WHERE d.maDuocPham=:duocpham_id ")
					.setParameter("duocpham_id", maDuocPham);
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
	public boolean suaDuocPham(DuocPham duocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(duocPham);
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
	public boolean suaDuocPham2(DuocPham2 duocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.saveOrUpdate(duocPham);
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
	public DuocPham timDuocPhamTheoMa(Long maDuocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham d WHERE d.maDuocPham=:duocpham_id ")
					.setParameter("duocpham_id", maDuocPham);
			DuocPham duocPham = (DuocPham) query.getSingleResult();
			transaction.commit();
			return duocPham;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<DuocPham> timDuocPhamTen(String tenDuocPham) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham d WHERE d.tenDuocPham like :tenDuocPham");
			query.setParameter("tenDuocPham", "%" + tenDuocPham + "%");
			List<DuocPham> danhSachDuocPham = query.getResultList();
			transaction.commit();
			return danhSachDuocPham;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	@Override
	public List<DuocPham> timDuocPhamHH() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham d WHERE d.ngayHetHan < now()");
			List<DuocPham> result = query.getResultList();
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
	public List<DuocPham> timCHH() {
		Transaction transaction = null;
		Session session = null;

		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham d WHERE d.ngayHetHan > now()");
			List<DuocPham> result = query.getResultList();
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
	public List<DuocPham2> timDuocPhamMN() {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			Query query = session.createQuery("FROM DuocPham2");
			List<DuocPham2> result = query.getResultList();
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
