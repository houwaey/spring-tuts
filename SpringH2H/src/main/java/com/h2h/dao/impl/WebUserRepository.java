package com.h2h.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.h2h.abstracts.AbstractHibernateDao;
import com.h2h.dao.UserDao;
import com.h2h.model.WebUser;

@Repository
public class WebUserRepository extends AbstractHibernateDao<WebUser> implements UserDao<WebUser> {

	public WebUserRepository() {
		super();
		setClazz(WebUser.class);
	}

	@Override
	public boolean updateStatus(WebUser user) {
		Session session = getCurrentSession();
		Transaction tx = session.beginTransaction();
		if (user.getStatus() != null) {
			try {
				CriteriaBuilder builder = session.getCriteriaBuilder();
				CriteriaUpdate<WebUser> cUpdate = builder.createCriteriaUpdate(clazz);
				Root<WebUser> root = cUpdate.from(clazz);
				cUpdate.set(root.get("status"), user.getStatus())
					.where(builder.equal(root.get("id"), user.getId()));				
				session.createQuery(cUpdate).executeUpdate();
				tx.commit();
				return true;
			} catch (Exception e) {
				logger.error(e.getMessage());
				tx.rollback();
				return false;
			} finally {
				session.close();
			}
		}
		return false;
	}
	
	
}
