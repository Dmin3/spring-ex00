package org.zerock.controller.lecture;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RestController // 데이터 자체를 받도록한다.
@Log4j
@RequestMapping("/replies/*")
@AllArgsConstructor
public class ReplyController {
	
	private ReplyService service;
	
	@PostMapping("/new") 
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		// @RequestBody는 HTTP본문 요청이 그대로 전달된다 (데이터 자체가 전달)
		int cnt = service.register(vo);
		
		if(cnt==1) {
			return new ResponseEntity<String> ("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String> (HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@GetMapping("/pages/{bno}")
	public List<ReplyVO> getList(@PathVariable("bno") Long bno){
		
		return service.getList(bno);	
	}
	
	@GetMapping("/{rno}")
	public ReplyVO get(@PathVariable("rno") Long rno) {
		return service.get(rno);
	}
	
	// @RequestMapping(value= "/{rno}", method=RequestMethod.DELETE)
	@DeleteMapping("/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno){
		
		int cnt = service.remove(rno);
		
		if(cnt == 1) {
			return new ResponseEntity<String> ("sucess", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/{rno}", method = {RequestMethod.PUT, RequestMethod.PATCH})
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable Long rno){
		
		int cnt = service.modify(vo);
		
		if(cnt == 1) {
			return new ResponseEntity<String> ("success", HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
}











