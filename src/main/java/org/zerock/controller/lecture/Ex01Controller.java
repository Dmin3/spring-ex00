package org.zerock.controller.lecture;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.log4j.Log4j;

@Controller// 이 클래스가 Controller 라는걸 명시해줌
@RequestMapping("/ex01/*") // 경로 설정
@Log4j
public class Ex01Controller {
	
	@RequestMapping("/sub01")
	public void method01() {
//		System.out.println("경로를 잘 찾았습니다");
		log.info("ex01, sub01 method");
	}
	
	@RequestMapping("/sub02")
	public void method02() {
		log.info("ex02, sub02 method");
	}
	
	// get방식으로 요청을 보내는 방법
	@RequestMapping(value ="/sub03", method = RequestMethod.GET)
	public void method3() {
		log.info("get방식으로 요청을 보내는 방법");
	}
	//post방식으로 요청을 보내는 방법
	@RequestMapping(value="/sub03", method = RequestMethod.POST)
	public void method04() {
		log.info("sub03 포스트 방식으로 요청 보내는 방법");
	}
	
	// 위에 get방식보다 간략한 get 코드
	@GetMapping("/sub05")
	public void method05() {
		log.info("위에 방식 보다 간략한 get방식 코드");
	}
	
	// 위에 post방식보다 간략한 post 코드
	@PostMapping("/sub06")
	public void method06() {
		log.info("위에 방식보다 간략한 post 코드");
	}
	
}
