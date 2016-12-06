package com.bit2016.jblog.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.service.BlogService;
import com.bit2016.jblog.service.PostService;
import com.bit2016.jblog.vo.PostVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private PostService postService;
	
	@RequestMapping("/{id}")
	public String main(@PathVariable(value="id")String id, Model model){
		
		Map<String,Object> map = blogService.getBlog(id);
		
		model.addAttribute("map", map);
		model.addAttribute("id", id);
		
		return "/blog/blog-main";
	}
	
	@RequestMapping("/post/{no}/{id}")
	public String getPost( @PathVariable(value="no")Long no, 
						   @PathVariable(value="id")String id,
						   Model model){
				
		List<PostVo> list = postService.getPost(no);
		Map<String,Object> map = blogService.getBlog(id);
		
		model.addAttribute("map", map);
		model.addAttribute("id", id);
		model.addAttribute("postList",list);

		return "/blog/blog-main";
	}
	
	@RequestMapping("/content/{no}/{id}")
	public String getContent( @PathVariable(value="no")Long no, 
							  @PathVariable(value="id")String id,
						      Model model){
				
		
		PostVo postVo = postService.getContent(no);
		Map<String,Object> map = blogService.getBlog(id);

		model.addAttribute("map", map);
		model.addAttribute("id", id);
		model.addAttribute("postVo",postVo);

		return "/blog/blog-main";
	}

	@RequestMapping("/{id}/admin/basic")
	public String basicForm(@PathVariable(value="id") String id, Model model){
		
		model.addAttribute("id",id);
		return "/blog/blog-admin-basic";
	}
	
	@RequestMapping("/{id}/admin/category")
	public String categoryForm(@PathVariable(value="id") String id, Model model){
		
		model.addAttribute("id",id);
		return "/blog/blog-admin-category";
	}
	
	@Auth
	@RequestMapping("/blogupdate/{id}")
	public String blogUpdate(@PathVariable(value="id") String id,
							 @RequestParam(value="title", required=true, defaultValue="")String title,
							 @RequestParam(value="logo") MultipartFile logo,
							 @AuthUser UserVo authUser, Model model){
		
		Long userNo = authUser.getNo();
				
		String logofile = blogService.updateBlog(logo, title, userNo);
				
		
		Map<String,Object> map = blogService.getBlog(id);
		
		model.addAttribute("logo", logofile);
		model.addAttribute("map", map);
		model.addAttribute("id", id);

		return "/blog/blog-main";
	}
}
