package com.bit2016.jblog.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2016.jblog.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	public Long insert(UserVo vo){
		sqlSession.insert("user.insert", vo);
		return vo.getNo();
	}
		
	public UserVo get(String id, String password){
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("password", password);

		return sqlSession.selectOne("user.getByIdPassword", map);
	}
}
