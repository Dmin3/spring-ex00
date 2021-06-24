package org.zerock.domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class pageDTOTests {

	@Test
	public void test() {
		Criteria cri = new Criteria(1, 10);
		
		PageDTO p1 = new PageDTO(cri);
		
		assertEquals(10, p1.getEndPage());
		
		assertEquals(10, new PageDTO(new Criteria(2, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(3, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(4, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(5, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(6, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(7, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(8, 10)).getEndPage());
		assertEquals(10, new PageDTO(new Criteria(9, 10)).getEndPage());
		
	}

}
