package com.h2h.dao;

import java.io.Serializable;

import com.h2h.interfaces.Operations;

public interface PersonDao<T extends Serializable> extends Operations<T> {

}
