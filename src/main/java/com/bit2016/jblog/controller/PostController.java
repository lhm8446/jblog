package com.bit2016.jblog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.service.PostService;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
public class PostController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PostService postService;
	
	@Auth
	@RequestMapping("/{id}/admin/write")
	public String writeForm(@PathVariable(value="id") String id,
							@AuthUser UserVo authUser , 
							Model model){
		

		List<CategoryVo> list = categoryService.getCategoryName(authUser.getNo());
		
		model.addAttribute("list", list);
		model.addAttribute("id",id);

		return "/blog/blog-admin-write";
	}
	
	@RequestMapping("/write/{id}")
	public String writePost(@PathVariable(value="id") String id,@ModelAttribute PostVo vo,Model model){
	
		model.addAttribute("id",id);

		postService.writePost(vo);
		
		return "redirect:/{id}/admin/category";
		
	}
}
