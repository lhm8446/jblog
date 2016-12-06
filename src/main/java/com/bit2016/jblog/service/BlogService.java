package com.bit2016.jblog.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bit2016.jblog.repository.BlogDao;
import com.bit2016.jblog.repository.CategoryDao;
import com.bit2016.jblog.repository.PostDao;
import com.bit2016.jblog.vo.BlogVo;
import com.bit2016.jblog.vo.CategoryVo;
import com.bit2016.jblog.vo.PostVo;

@Service
public class BlogService {
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private PostDao postDao;
		
	private static final String SAVE_PATH = "/upload";
	private static final String URL = "/gallery/assets/";
	
	public String updateBlog(MultipartFile multipartFile, String title, Long userNo){
		
		String url="";
		
		try{
			
		if(multipartFile.isEmpty()==true){
			return url;
		}
		
		String originalFileName = multipartFile.getOriginalFilename();
		String extName = originalFileName.substring(originalFileName.lastIndexOf('.')+1, originalFileName.length());
		String saveFileName = generateSaveFileName(extName);
		//Long fileSize = multipartFile.getSize();
		
		//파일 쓰기 
		wirteFile(multipartFile,saveFileName);
		
		BlogVo blogVo = new BlogVo();
		blogVo.setLogo(saveFileName);
		blogVo.setTitle(title);
		blogVo.setUserNo(userNo);
		url = URL + saveFileName;
		
		blogDao.updateBlog(blogVo);

		}catch(IOException e){
		//	throw new UploadFileException("write file");
		//  log 남기기
			throw new RuntimeException("upload file");
		}
		return url;

	}
	private void wirteFile(MultipartFile multipartFile, String saveFileName)throws IOException{
		byte[] fileData = multipartFile.getBytes();
		FileOutputStream fos = new FileOutputStream(SAVE_PATH + "/" + saveFileName);
		fos.write(fileData);
		fos.close();
	}
	private String generateSaveFileName(String extName){
		String fileName = "";
		Calendar calendar = Calendar.getInstance();
		fileName += calendar.get(Calendar.YEAR);
		fileName += calendar.get(Calendar.MONTH)+1;
		fileName += calendar.get(Calendar.DATE);
		fileName += calendar.get(Calendar.HOUR);
		fileName += calendar.get(Calendar.MINUTE);
		fileName += calendar.get(Calendar.SECOND);
		fileName += calendar.get(Calendar.MILLISECOND);
		fileName += ("."+extName);
		
		return fileName;
	}

	public Map<String,Object> getBlog(String id){
		Long firstCategoryNo = categoryDao.getFirstCategoryNo();

		BlogVo           blogVo       = blogDao.getBlog(id);
		List<CategoryVo> categoryVo   = categoryDao.getMainCategory(id);
		List<PostVo>     postVo       = postDao.getPost(firstCategoryNo);
		PostVo 			 postContent  = postDao.getPostContent(1L);
		
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("blogVo", blogVo);
		map.put("categoryVo", categoryVo);
		map.put("postVo", postVo);
		map.put("postContent", postContent);
		
		return map;
	}
}
