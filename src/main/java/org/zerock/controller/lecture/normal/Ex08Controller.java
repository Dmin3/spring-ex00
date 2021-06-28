package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex08/*")
@Log4j
public class Ex08Controller {
	
	// MODEL
	
	@RequestMapping("/sub01")
	public void method01(Model model) {
		log.info("ex08 method01 실행 ");
		
		//key-value 형식으로 저장된다
		model.addAttribute("name","donald");
		model.addAttribute("age", 22);
	}
	
	@RequestMapping("/sub02")
	public void method02(Model model) {
		log.info("ex08 sub02 method 실행");
		
		User user = new User();
		user.setId("BTS");
		user.setAge(22);
		
		model.addAttribute("user", user); // <-- user라는 객체를 "user"라는 attribute로 넣어줌
		// Servlet에서 setAttrinbute와 유사
	}
	
	@GetMapping("/sub03")
	public String method03(Model model) {
		log.info("ex08 sub03 method");
		
		User user = new User();
		user.setAge(5000);
		user.setId("korea");
		
//		model.addAttribute("user", user);
		model.addAttribute(user); // 클래스명을 따라감(변수가 아님) 즉, User = user
		
		return "ex08/sub02"; // 위에 코드 jsp경로로 이동
	}
	
	@RequestMapping("/sub04")
	public String method04(User user, Model model) {
		log.info("ex08 sub04 method");
		
		model.addAttribute(user);
		
		return "ex08/sub02";
	}
	
	// 위 코드와 같은 역할 수행 , 파라미터에 @ModelAttribute 말고서는 불
	@RequestMapping("/sub05")
	public String method05(@ModelAttribute("user") User user, Model model) {
		log.info("ex08 sub05 method");
		
		return "ex08/sub02";
	}
	
	
	@RequestMapping("/sub06")
	public String method06(@ModelAttribute User user, Model model) { // attribute 생략 가능하다
		log.info("ex08 sub06 method");
		
		return "ex08/sub02";
	}
	
	// @ModelAttribute를 생략해도 같은역할을 수행한다.. 개사기 
	@RequestMapping("/sub07")
	public String method07(User user, Model model) { 
		log.info("ex08 sub07 method");
			
		model.addAttribute("hello world");
		return "ex08/sub02";
	}
	
	@RequestMapping("/sub08")
	public String method08(User user) { // 심지어 Model 객체도 생략가능
		log.info("ex08 sub08 method");
			
		
		return "ex08/sub02";
	}
	
	// @RequestParam 생략 가능
	// 객체가 아닌것들은 자동으로 @ModelAttribute로 들어가지 않기때문에
	// 어노테이션을 설정해줘야된다.
	@RequestMapping("/sub09")
	public void method09(@ModelAttribute("age") /*@RequestParam*/ int age,
			/*@RequestParam*/@ModelAttribute("name") String name) {
		
		log.info("ex08 sub09 method");
		log.info(name);
		log.info(age);
	}
}
