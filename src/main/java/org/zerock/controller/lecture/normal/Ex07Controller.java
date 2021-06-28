package org.zerock.controller.lecture.normal;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.controller.lecture.domain.User;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex07/*")
@Log4j
public class Ex07Controller {
	
	// 응답
	@RequestMapping("/sub01")
	public @ResponseBody String method01() {
		log.info("ex07 sub01 method");
		
		return "Hello world";
	}
	
	// 객체정보를 리턴하는 경우
	@GetMapping("/sub02")
	public @ResponseBody String method02() {
		log.info("ex07 sub02 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(51);
		
		return user.toString();
	}
	
	
	
	@GetMapping("/sub03")
	public @ResponseBody String method03() {
log.info("ex07 sub03 method");
		
		User user = new User();
		user.setId("donald");
		user.setAge(51);
		
		// 작업이 복잡하기때문에 누군가 만든 라이브러리를 써야한다
		return "{\"id\":" + user.getId() + "," + "\"age\":" + user.getAge() + "}";
	}
	
	
	//위 코드가 복잡하니 라이브러리 download 하여 사용해보자
	@GetMapping("/sub04")
	public @ResponseBody User method04() {
		log.info("ex07 sub04 method 실행");
		
		User user = new User();
		user.setId("JINKI");
		user.setAge(25);
		
		return user;
		
	}
	
	// 응답자체를 수정 할수도 있다.
	// 응답자체를 제어
	@GetMapping("/sub05")
	public ResponseEntity<String> method05() {
		log.info("ex07 sub05 method");
		
		HttpHeaders head = new HttpHeaders();
		head.add("Content-Type", "text/html; charset=utf-8");
		head.add("my-header", "my-value");
		
		String body = "<h1>hello Entity</h1>";
		
		// 본문(body)
		//부가정보(header)
		//상태 코드 값
		
		
		return new ResponseEntity<String>(body, head, HttpStatus.OK);
	}
	
}
