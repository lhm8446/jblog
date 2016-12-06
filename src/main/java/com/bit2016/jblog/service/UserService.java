package com.bit2016.jblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.UserDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.UserVo;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	public void join(UserVo userVo){
		Long userNo = userDao.insert(userVo);
		
		BlogVo blogVo = new BlogVo();
		blogVo.setUserNo(userNo);
		blogVo.setTitle(userVo.getName() + "의 블로그");
		blogVo.setLogo("logo");
		
		blogDao.insertBlog(blogVo);
	}
	
	public UserVo login(String id, String password){
		return userDao.get(id, password);
	}
}
