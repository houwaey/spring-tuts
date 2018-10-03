package com.h2h.builder;

import java.io.Serializable;

import org.springframework.test.util.ReflectionTestUtils;

import com.google.common.base.Preconditions;

public class ClassBuilder<T extends Serializable> {

	private T model = null;
	
	public ClassBuilder(T entity) {
		model = Preconditions.checkNotNull(entity);
	}
	
	public ClassBuilder<T> setField(String name, Object value) {
		ReflectionTestUtils.setField(model, name, value);
		return this;
	}
	
	public T build() {
		return model;
	}
	
}
