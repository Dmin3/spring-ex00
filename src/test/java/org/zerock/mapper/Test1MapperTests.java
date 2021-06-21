package org.zerock.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.Test1VO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class Test1MapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private Test1Mapper mapper;
	
	@Test
	public void testGetList() {
		assertNotNull(mapper);
		
		List<Test1VO> list = mapper.getList();
		
		assertTrue(list.size() > 0);
		
	}

	@Test
	public void testInsert() {
		Test1VO test = new Test1VO();
		test.setName("donald");
		test.setAge(99);
		
		int cnt = mapper.insert(test);
		
		assertEquals(1, cnt);
	}
	
	@Test
	public void testInsertSelectKey() {
		Test1VO test = new Test1VO();
		test.setName("trump");
		test.setAge(95);
		
		assertEquals(0, test.getId());
		
		int cnt = mapper.insertSelectKey(test);
		
		assertNotEquals(0, test.getId());
		
	}
	
	@Test
	public void testRead() {
		Test1VO test = mapper.read(1);
		
		assertEquals("jimin", test.getName());
		assertEquals(22, test.getAge());
		
	}
	
	@Test
	public void testDelete() {
		mapper.delete(2);
		
		Test1VO test = mapper.read(2);
		
		assertNull(test);
	}
	
	@Test
	public void testUpdate() {
		long id = 3;
		
		Test1VO test = new Test1VO();
		
		test.setId(id);
		test.setName("HIHI");
		test.setAge(25);
		
		int cnt = mapper.update(test);
		
		assertEquals(1, cnt);
		
		Test1VO vo = mapper.read(id);
		
		assertEquals(test.getName(), vo.getName());
		assertEquals(test.getAge(), vo.getAge());
		
	}
}
