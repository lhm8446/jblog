package com.bit2016.jblog.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.BlogVo;

@Repository
public class BlogDao {
	
	@Autowired
	private SqlSession sqlSession;

	public void insertBlog(BlogVo vo ){
		sqlSession.insert("blog.insertBlog", vo);
	}
	
	public void updateBlog(BlogVo vo){
		sqlSession.update("blog.updateBlog", vo);
	}
	
	public BlogVo getBlog(String id){
		return sqlSession.selectOne("blog.getBlog", id);
	}
}