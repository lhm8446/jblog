package com.bit2016.jblog.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.PostVo;

@Repository
public class PostDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public void wirtePost(PostVo vo){
		sqlSession.insert("post.writePost", vo);
	}
	
	public List<PostVo> getPost(Long categoryNo){
		return sqlSession.selectList("post.getPost",categoryNo);
	}
	
	public PostVo getPostContent(Long postNo){
		return sqlSession.selectOne("post.getPostContent",postNo);
	}
}
