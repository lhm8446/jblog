package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.vo.CategoryVo;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	
	public void insertCategory(CategoryVo vo){
		categoryDao.insertCategory(vo);
	}
	
	public CategoryVo getCategory(Long categoryNo){
		return categoryDao.getCategory(categoryNo);
	}
	
	public List<CategoryVo> getCategory(){
		return categoryDao.getCategory();
	}
	
	public List<CategoryVo> getMainCategory(String id){
		return categoryDao.getMainCategory(id);
	}
	
	public List<CategoryVo> getCategoryName(Long userNo){
		return categoryDao.getCategoryName(userNo);
	}
	
	public void deleteCategory(Long no){
		categoryDao.deleteCategory(no);
	}
}
