package com.javaweb.dao;

import java.util.List;


import com.javaweb.model.NewModel;


public interface INewDAO  {
	NewModel findOne(Long id);
	List<NewModel> findByCategoryId(Long categoryId);
	Long save(NewModel newModel);
	void update(NewModel updateNew);
	void delete(long id);
	int getTotalItem();
}
