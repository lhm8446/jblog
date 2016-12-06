package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertCategory(CategoryVo vo){
		sqlSession.insert("category.insertCategory",vo);
	}
	
	public CategoryVo getCategory(Long categoryNo){
		return sqlSession.selectOne("category.ajaxGetCategory", categoryNo);
	}
	
	public List<CategoryVo> getCategory(){
		List<CategoryVo> list = sqlSession.selectList("category.getCategory");
		return list;
	}
	
	public List<CategoryVo> getMainCategory(String id){
		return sqlSession.selectList("category.getMainCategory", id);
	}
	
	public List<CategoryVo> getCategoryName(Long userNo){
		return sqlSession.selectList("category.getCategoryName",userNo);
	}
	
	public Long getFirstCategoryNo(){
		return sqlSession.selectOne("category.getFristCategoryNo");
	}
	
	public void deleteCategory(Long no){
		sqlSession.delete("category.deleteCategory", no);
	}
}
