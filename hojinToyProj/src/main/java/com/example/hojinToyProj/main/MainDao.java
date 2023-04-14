package com.example.hojinToyProj.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.hojinToyProj.HojinUserDetail;

@Repository
@Mapper
public interface MainDao {

	public String getUserName(String id);
		
	public HojinUserDetail getUser(String id);
	
	public List<HojinUserDetail> getMembers();
	
	public int registerMember(HashMap<String,String> user);
}
