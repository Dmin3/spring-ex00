package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex09/*")
@Log4j
public class Ex09Controller {

	
	//RedirectAttributes : 리다이렉트로 보내는 객체
	@RequestMapping("/sub01")
	public String method01(RedirectAttributes rttr) {
		log.info("ex09 sub01 method");
		rttr.addAttribute("name", "jin");
		rttr.addAttribute("id", 300);
		
		// rttr 객체에 메소드로 값을 받아 sub02 경로로 attribute를 보내준다
		
		return ("redirect:sub02"); // 상대경로
		//return ("redirect:/ex09/sub02"); 절대경로 
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex09 sub02 method");
	}
	
	@RequestMapping("/sub03")
	public String method03(RedirectAttributes rttr) {
		log.info("ex09 sub03 method");
		
	//	rttr.addAttribute("user", new User()); 안되는거임
	// RedirectAttributes로 객체를 다른 경로로 넘겨주고싶을때
		User user = new User();
		user.setAge(33333);
		user.setId("hihgihi");
		rttr.addFlashAttribute("user", user);
		
		return ("redirect:sub04");
	}
	
	@RequestMapping("/sub04")
	public void method04(Model model) {
		log.info("ex09 sub04 method");
		
		// Map을 꺼낸 뒤 attribute 이름으로 꺼내오기
		log.info(model.asMap().get("user"));
		
	}
}
