package com.example.hojinToyProj.main;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.hojinToyProj.HojinUserDetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class mainService {
	
	private final MainDao mainDao;

	public void mainMethod() {
		Date date = new Date();
		log.info("[mainService] - mainMethod in "+date.toString());
	}
	
	public String getUserNameService(String id) {
		Date date = new Date();
		log.info("[mainService] - getUserName in "+date.toString());
		return mainDao.getUserName(id);
	}
	
	public List<HojinUserDetail> getMembers(){
		return mainDao.getMembers();
	}
	
	public int registerMember(HashMap<String,String> user) {
		Iterator<String> userAttributes = user.keySet().iterator();
		while(userAttributes.hasNext()) {
			String userAttribute = userAttributes.next();
			log.info("[memberRegister] - "+userAttribute+" / "
			+ user.get(userAttribute));
		}
		return mainDao.registerMember(user);
	}
	
}
