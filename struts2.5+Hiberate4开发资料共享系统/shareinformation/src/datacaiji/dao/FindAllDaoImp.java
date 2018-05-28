package datacaiji.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Projections;

import datacaiji.bean.Information;
import datacaiji.bean.User;

public class FindAllDaoImp implements FindAllDao{

	@Override
	public List<User> FindAllUser() {//查询所有的用户第一种方法
		Session session = null;
		Transaction transaction = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			String hql = "from user";  
	        Query query = session.createQuery(hql);
	        transaction.commit();
	        List<User> users = query.list();
	        return users;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return null;
	}

	@Override
	public List<Information> FindAllFile() {//查询所有的信息第二种方法
		Session session = null;
		Transaction transaction = null;
		List<Information> informations = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Information.class);
			informations = criteria.list();
	        transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return informations;
	}

	@Override
	public long countUser() {
		Session session = null;
		Transaction transaction = null;
		long count = 0;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class);
			criteria.setProjection(Projections.rowCount());
			count = (long) criteria.uniqueResult();
			transaction.commit();
			return count;
		}catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public long countInformation() {
		Session session = null;
		Transaction transaction = null;
		long count = 0;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Information.class);
			criteria.setProjection(Projections.rowCount());
			count = (long) criteria.uniqueResult();
			transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
		finally {
			if (session!=null) {
				session.close();
			}
		}
		return count;
	}

	@Override
	public List<User> queryUserByPage(int offset, int pageSize) {
		Session session = null;
		Transaction transaction = null;
		List<User> someusers = null;
		
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(User.class).setFirstResult(offset).setMaxResults(pageSize);
            someusers = criteria.list();
            transaction.commit();  
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return someusers;
	}

	@Override
	public List<Information> queryIfoByPage(int offset, int pageSize) {
		Session session = null;
		Transaction transaction = null;
		List<Information> someifo = null;
		try {
			session = SessionUtil.getFactory().openSession();
			transaction = session.beginTransaction();
			Criteria criteria = session.createCriteria(Information.class).setFirstResult(offset).setMaxResults(pageSize);
			someifo = criteria.list();
            transaction.commit();  
		} catch (Exception e) {
			transaction.rollback();
		}
		finally {
			if(session!=null) {
				session.close();
			}
		}
		
		return someifo;
	}

}
