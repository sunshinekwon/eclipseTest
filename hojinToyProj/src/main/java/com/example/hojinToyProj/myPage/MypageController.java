package com.example.hojinToyProj.myPage;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/my")
public class MypageController {
	
	
	@GetMapping(value = {"","/"})
	@Secured("ROLE_USER")
	public String myPageCon() {
		
		return "myPage";
	}
	
}
