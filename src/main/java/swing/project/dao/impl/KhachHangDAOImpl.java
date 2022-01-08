package swing.project.dao.impl;



import org.hibernate.Session;
import org.hibernate.Transaction;

import swing.project.dao.KhachHangDAO;
import swing.project.entity.KhachHang;
import swing.project.hibernate.HibernateUtil;

public class KhachHangDAOImpl implements KhachHangDAO {

	public KhachHangDAOImpl() {

	}

	@Override
	public boolean themKH(KhachHang khachhang) {
		Transaction transaction = null;
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			session.save(khachhang);
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
