package com.bit2016.jblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.PostDao;
import com.bit2016.jblog.vo.PostVo;

@Service
public class PostService {
	
	@Autowired
	private PostDao postDao;
	
	public void writePost(PostVo vo){
		postDao.wirtePost(vo);
	}
	
	public List<PostVo> getPost(Long categoryNo){
		return postDao.getPost(categoryNo);
	}
	
	public PostVo getContent(Long no){
		return postDao.getPostContent(no);
	}
}
