package org.zerock.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {

	// 127쪽
	@RequestMapping("")
	public void basic() {
		log.info("basic.................");
	}
	
	//128쪽
	
	// GET,POST 방식을 모두 지원해야될때 배열로 묶어 처리할수있음.
	@RequestMapping(value="/basic", method = {RequestMethod.GET, RequestMethod.POST})
	public void basicGet() {
		log.info("basic....get");
	}
	
	// GET 방식만 지원
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("basic only get.............");
	}

	// Value값이 하나가 아닐수도 있다, 배열 가능
	@RequestMapping({"/basic3", "/basic4"})
	public void basic3() {
		log.info("value가 여러개입니다");
	}
	
	
	// 131쪽
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam String name, @RequestParam int age) {
		log.info("name :" + name);
		log.info("age : " + age);
		
		return "ex02";
	}
	
	// 132쪽 : 리스트, 배열 처리
	// 동일한 이름의 파라미터가 여러 개 전달되는 경우 ArrayList를 사용하여 처리할 수 있다.
	@GetMapping("/ex02List")
	public String ex02List(@RequestParam ArrayList<String> ids) {
		
		log.info("ids :" + ids);
		
		return "ex02List";
	}
	
	//133쪽 : 배열도 동일하게 처리 가능
	
	@GetMapping("/ex02Array")
	public String ex02Array(@RequestParam String[] ids) {
		
		log.info("Array ids :" + Arrays.toString(ids));
		
		return "ex02Array";
	}
	
	//130쪽 :
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		
		log.info("" + dto);
		
		return "ex01";
		
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	
	// 137쪽 ex03
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		log.info("tode :" + todo);
		return "ex03";
	}
	
}
