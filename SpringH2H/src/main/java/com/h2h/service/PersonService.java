package com.h2h.service;

import java.io.Serializable;

import com.h2h.dao.PersonDao;
import com.h2h.interfaces.Operations;

public interface PersonService<T extends Serializable> extends Operations<T>, PersonDao<T> {

}