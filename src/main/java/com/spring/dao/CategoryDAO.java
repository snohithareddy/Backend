package com.spring.dao;

import java.util.List;

import com.spring.model.Category;

public interface CategoryDAO 

{

	public void insertCategory(Category category);
	public List<Category> retrieve();
	public Category findByCatId(int cid);
	public void deletecat(int cid);


	



}