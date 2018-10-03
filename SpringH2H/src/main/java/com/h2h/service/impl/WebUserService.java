package com.h2h.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2h.abstracts.AbstractHibernateService;
import com.h2h.dao.UserDao;
import com.h2h.interfaces.Operations;
import com.h2h.model.WebUser;
import com.h2h.service.UserService;

@Service
@Transactional
public class WebUserService extends AbstractHibernateService<WebUser> implements UserService<WebUser> {

	@Autowired
	private UserDao<WebUser> dao;
	
	public WebUserService() {
		super();
	}
	
	@Override
	protected Operations<WebUser> getDao() {
		return dao;
	}

	@Override
	public boolean updateStatus(WebUser entity) {
		return dao.updateStatus(entity);
	}

	
}
