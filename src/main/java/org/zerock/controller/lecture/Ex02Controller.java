package org.zerock.controller.lecture;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/ex02/*")
@Log4j
public class Ex02Controller {
	
	@RequestMapping("/sub01")
	public void method01(HttpServletRequest request){
		log.info("ex02, sub01 method");
		log.info(request);
	}
	
	@RequestMapping("/sub02")
	public void method02(HttpServletRequest req) {
		log.info("ex02/sub02 method");
		log.info(req.getParameter("id"));
		log.info(req.getParameter("age"));
	}
	
	@RequestMapping("/sub03")
	public void method03(@RequestParam("id") String idparam) {
		// prameter에 id 라는 값이 있다면 , 값을 받아서 idparam 변수에 담아줘라 라는 뜻.
		log.info("ex02, sub03 method.....파라미터 받는 방법");
		log.info(idparam);
	}
	
	
	@RequestMapping("/sub04")
	public void method04(@RequestParam("id") String idparam, @RequestParam("age") String ageParam) {
		log.info("ex02, sub04 method.....prameter 여러 개 받는 방법");
		log.info(idparam);
		log.info(ageParam);
	}
	
	// 파라미터 생략하고서도 가능 , spring에서 알아서 잡아줌
	@RequestMapping("/sub05")
	public void method05(@RequestParam /*("id")*/ String id, @RequestParam /*("age")*/ String age) {
		// String id = request.getParameter("id");
		// String age = request.getParameter("age");
		log.info("ex02, sub05....");
		log.info(id);
		log.info(age);
	}
	
	@RequestMapping("/sub06")
	public void method06(@RequestParam int age) {
	//	int age = Integer.parseInt(request.getParameter("age"));
		log.info("ex02 sub06 method... @RequestParam이 자동으로 타입변환도 해줌");
		log.info(age);
		
	}
	
	// 배열을 사용하여 값들을 넣어줄 수 있다
	@RequestMapping("/sub07")
	public void method07(@RequestParam String[] fav) {
		log.info("ex02 sub07 method");
		
		for(String f : fav) {	
		log.info(f);
		}
	}
	
	
	// ArrayList를 사용해서 만들 수 있다
	@RequestMapping("/sub08")
	public void method08(@RequestParam List<String> fav) {
		log.info("ex02 sub08 method");
		
		log.info(fav);
		}
	
	
	
	}

