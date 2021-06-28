package org.zerock.controller.lecture.normal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/ex06/*")
public class Ex06Controller {
	
	@RequestMapping("/sub01")
	public String method01() {
		log.info("ex06 sub01 method");
		
		/*
		request.getRequestDispatcher("/WEB-INF/viewsex06/sub01.jsp).forward(request, response);
		*/
		
		//예전 서브렛에서 했던일을	
		//String을 리턴 하는것만으로 포워딩을 시켜줄수 있다.
		return "ex06/sub01";
		
		// /WEB-INF/views/ex06/sub01.jsp	
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex06 sub02 method");
		
		// /WEB-INF/views/ex06/sub02.jsp
		//리턴타입을 명시해주지 않아도 spring이 자동으로 위에 경로를 지정 시켜줌
		
	}
	
	@RequestMapping("/sub03")
	public String method03() {
		log.info("ex06 sub03 method");
		
		return "forward:/ex06/sub02"; 
		
		//중요!!
		//forward는 하나의 요청 --> 안 바뀜
		//, redirect는 두개의 요청  --> 해당 페이지 주소로 바뀜
		// view로 해석되지않음
	
	}
	
	@RequestMapping("/sub04")
	public String method04() {
		
		log.info("ex06 sub04 method");
		
		// response.sendRedirect(request.getContextPath() + "/otherPath");
	    // 같은 경로내에 있으면 request.getContextPath() 생략 가능
		
		return "redirect:/ex06/sub02";
	}
	
	
}
