package com.h2h.service;

import java.io.Serializable;

import com.h2h.dao.UserDao;
import com.h2h.interfaces.Operations;

public interface UserService<T extends Serializable> extends Operations<T>, UserDao<T> {

}
