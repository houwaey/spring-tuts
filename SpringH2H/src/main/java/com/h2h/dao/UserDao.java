package com.h2h.dao;

import java.io.Serializable;

import com.h2h.interfaces.Operations;

public interface UserDao<T extends Serializable> extends Operations<T> {

	public boolean updateStatus(T entity);
	
}
