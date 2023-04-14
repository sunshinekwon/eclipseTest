package com.example.hojinToyProj.main;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.example.hojinToyProj.HojinUserDetail;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final mainService service;

	
	@GetMapping(value = {"","/"})
	@ResponseStatus(HttpStatus.OK)
	public String mainController(Model model,HttpServletRequest req,HttpSession sess) {
		
		String userName = String.valueOf(service.getUserNameService("admin"));
		
		model.addAttribute("userName", userName);
		
		log.info("[MainController] - model value : "+userName);
		
		
			model.addAttribute("greetings","none");
		
		
		
		return "hojinMain";
	}
	
	@GetMapping(value = {"/loginP"})
	@ResponseStatus(HttpStatus.OK)
	public String loginController() {
		
		return "hjLoginPage";
	}
	
	@GetMapping(value = {"/loginAfter"})
	@ResponseStatus(HttpStatus.OK)
	public String loginAfterController(Model model,HttpSession sess,HttpServletRequest req) {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		HojinUserDetail user = (HojinUserDetail)auth.getPrincipal();
		
		log.info("[loginAfter] - SecurityContextHolder in UserDetails id -"+user.getId());
		
		
		// request headers 꺼내찍기 
		Enumeration<String> enu = req.getHeaderNames();
		
		while(enu.hasMoreElements()) {
			log.info("[loginAfter] request headers - "+enu.nextElement());
		}
		
		model.addAttribute("greetings", user.getId()+"님 환영합니다.");
		
		return "loginAfter";
	}
	
	
	
	 /* 
	  * 
	  * 	rest - url 형식은 명사여야하고 동사표현은 http method로 표현한다.
			 get - 해당 도메인의 데이터 가져오기 
			 post - 해당 도메인의 데이터 삽입하기
			 put - 해당 도메인의 기존 데이터 수정하기
			 delete - 해당 도메인의 기존 데이터 삭제하기 
	*/
	
	@GetMapping(value = {"/member"})
	public String getMemberCon(Model model) {
		
		List<HojinUserDetail> memList = service.getMembers();
		
		model.addAttribute("MemberList",memList);
		
		return "members";
	}
	
	@PostMapping(value = {"/member"})
	@ResponseBody
	public String postMemberCon(@RequestParam HashMap<String,String> user) {
		
		int res = service.registerMember(user);
		
		if(res != 1) {
			return "fail";
		}
		return "success";
		
	}
	
	@PutMapping(value = {"/member"})
	public String putMemberCon() {
		
		return "";
	}
	
	@DeleteMapping(value = {"/member"})
	public String deleteMemberCon() {
		return "";
	}
	
}
