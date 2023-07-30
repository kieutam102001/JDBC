package com.laptrinhjavaweb.service.impl;

import java.util.List;


import javax.inject.Inject;
import com.javaweb.dao.ICategoryDAO;
import com.javaweb.dao.impl.CategoryDAO;
import com.javaweb.model.CategoryModel;
import com.javaweb.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	private ICategoryDAO categoryDao;
	
	@Override
	public List<CategoryModel> findAll() {
		return categoryDao.findAll();
	}
}
