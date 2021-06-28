package org.zerock.controller.lecture;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.SampleVO;

import lombok.extern.log4j.Log4j;

@RestController
@RequestMapping("/sample/*")
@Log4j
//책 358
public class SampleRestController {

	//책 359
	@GetMapping(value="/getText", produces = "text/plain; charset=UTF-8")
	public String getText() {
		
		return "안녕";
	}
	
	// 책 361
	@GetMapping(value="/getSample", produces = {MediaType.APPLICATION_JSON_UTF8_VALUE
			})
	public SampleVO getSample() {
		
		return new SampleVO(112, "스타", "로드");
	}
	
	//책 363
	@GetMapping("/getList")
	public List<SampleVO> getList(){
		List<SampleVO> list = new ArrayList<SampleVO>();
		
		for(int i = 1; i < 10; i++) {
			list.add(new SampleVO(i, i + "First", i + "Last"));
		}
		
		return list;
	}
	
	// 책 364
	@GetMapping(value="/getMap")
	public Map<String, SampleVO> getMap(){
		
		Map<String, SampleVO> map = new HashMap<String, SampleVO>();
		map.put("First", new SampleVO(111, "그루트", "주니어"));
		
		return map;
	}
	
	//책 365
	// HTTP 상태코드와 에러메세지를 함께 전달받아 확실한 결과를 알수 있음.
	@GetMapping(value="/check", params = {"height", "weight" })
	public ResponseEntity<SampleVO> check(Double height, Double weight){
		SampleVO vo = new SampleVO(0, "" + height, ""+weight);
		
		ResponseEntity<SampleVO> result = null; // 초기 값 설정
		
		if(height < 150) {
			result = ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(vo);
		} else {
			result = ResponseEntity.status(HttpStatus.OK).body(vo);
		}
		
		return result;
	}
	
	//책 366
	@GetMapping("/product/{cat}/{pid}")
	public String[] getPath(@PathVariable String cat, @PathVariable int pid) {
		return new String[] {"category" + cat, "productid" + pid};
	}
}
