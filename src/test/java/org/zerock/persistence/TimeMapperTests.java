package org.zerock.persistence;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.mapper.TimeMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private TimeMapper timeMapeer;
	
	@Test
	public void testGetTime() {
		log.info(timeMapeer.getClass().getName());
		log.info(timeMapeer.getTime());
		
	}
	
	public void getTime2() {
		assertNotNull(timeMapeer);
		assertNotNull(timeMapeer.getTime2());
		
		log.info(timeMapeer.getTime2());
	}
	
}
