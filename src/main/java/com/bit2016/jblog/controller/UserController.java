package com.bit2016.jblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.UserService;
import com.bit2016.jblog.vo.UserVo;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/loginform")
	public String loginform(){
		return "/user/login";
	}
	
	@RequestMapping("/joinform")
	public String joinform(){
		return "/user/join";
	}
	
	@RequestMapping("/join")
	public String join(UserVo vo){
		userService.join(vo);
		System.out.println(vo.getId());
		return "/user/joinsuccess";
	}
}
