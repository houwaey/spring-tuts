package com.h2h.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.h2h.abstracts.AbstractHibernateService;
import com.h2h.dao.PersonDao;
import com.h2h.interfaces.Operations;
import com.h2h.model.Teacher;
import com.h2h.service.PersonService;

@Service
@Transactional
public class TeacherService extends AbstractHibernateService<Teacher> implements PersonService<Teacher> {

	@Autowired
	private PersonDao<Teacher> dao;
	
	public TeacherService() {
		super();
	}
	
	@Override
	protected Operations<Teacher> getDao() {
		return dao;
	}

}
