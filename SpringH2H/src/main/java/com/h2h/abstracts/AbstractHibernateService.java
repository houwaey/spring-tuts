package com.h2h.abstracts;

import java.io.Serializable;
import org.springframework.transaction.annotation.Transactional;

import com.h2h.interfaces.Operations;

@Transactional
public abstract class AbstractHibernateService<T extends Serializable> 
	extends AbstractService<T> 
	implements Operations<T> {
	
	/** 
	 * Will automatically use all the superclass' (AbstractService) methods
	 * 
	 * */
	
}