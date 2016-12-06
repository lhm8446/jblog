package com.bit2016.jblog.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bit2016.jblog.service.CategoryService;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.UserVo;
import com.bit2016.security.Auth;
import com.bit2016.security.AuthUser;

@Controller("categoryAPI")
@RequestMapping("/api")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@ResponseBody
	@RequestMapping("categoryform")
	public Object categoryFetch(){
		
		List<CategoryVo> list = categoryService.getCategory();
		
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("result", "success");
		map.put("data", list);
		
		return map;
	}
	
	@Auth
	@ResponseBody
	@RequestMapping("/category")
	public Object categoryUpdate(@AuthUser UserVo authUser, 
								 @RequestParam(value="name", required=true, defaultValue="") String name,
							     @RequestParam(value="des", required=true, defaultValue="") String des){

		CategoryVo categoryVo = new CategoryVo();
		categoryVo.setName(name);
		categoryVo.setDes(des);
		categoryVo.setUserNo(authUser.getNo());
		
		categoryService.insertCategory(categoryVo);
		
		CategoryVo vo = categoryService.getCategory(categoryVo.getNo());
				
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("result", "success");
		map.put("data",vo);
		
		return map;
	}
	
	@RequestMapping("/categorydelete/{cno}")
	public void categoryDelete(@PathVariable("no")Long no){
		
		categoryService.deleteCategory(no);
		
	}
}
