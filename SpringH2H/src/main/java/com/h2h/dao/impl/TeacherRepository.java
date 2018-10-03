package com.h2h.dao.impl;

import org.springframework.stereotype.Repository;

import com.h2h.abstracts.AbstractHibernateDao;
import com.h2h.dao.PersonDao;
import com.h2h.model.Teacher;

@Repository
public class TeacherRepository extends AbstractHibernateDao<Teacher> implements PersonDao<Teacher> {

	public TeacherRepository() {
		super();
		setClazz(Teacher.class);
	}
	
}