package org.zerock.controller;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.ModelAndView;
import org.zerock.service.BoardServiceTests;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

// 관용표현을 알자
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(
		{
			"file:src/main/webapp/WEB-INF/spring/root-context.xml",
			"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"
			})
@Log4j
public class BoardControllerTests {
	
	// 관용표현을 알고있자
	
	@Setter(onMethod_ = @Autowired )
	private WebApplicationContext ctx;
	private MockMvc mockMvc;
	
	 // Test가 실행하기전에 무조건 한번은 실행하는 어노테이션
	@Before
	public void setup() {
		// 테스트를 위해 가짜서버를 만들어줌
		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void testList() throws Exception {
		ModelAndView mav = mockMvc.perform(MockMvcRequestBuilders.get("/board/list"))
		.andReturn().getModelAndView();
		
		assertEquals("board/list", mav.getViewName());
		
		Map<String, Object> map = mav.getModel();
		
		Object o = map.get("list");
		
		assertNotNull(o);
		assertTrue(o instanceof List<?>);
		
		
		// fail("fail");
	}
	
	@Test
	public void testRegister() throws Exception {
		FlashMap fm = mockMvc.perform(MockMvcRequestBuilders.post("/board/register")
				.param("title", "테스트 새글 제목")
				.param("content", "테스트 새글 내용")
				.param("writer", "user00")).andReturn().getFlashMap();
		
				assertNotNull(fm.get("result"));	
		
		
	}
}