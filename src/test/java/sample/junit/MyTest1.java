package sample.junit;

import static org.junit.Assert.*;

import org.junit.Test;

public class MyTest1 {

	@Test
	public void test() {
//		fail("Not yet implemented");  무조건 실패하는 메소드
		int i = 3;
		if(i != 3) {
			fail("i는 3이 아닙니다");
		}
	}
	@Test
	public void equals() {
		int i =3;
		boolean b = true;
		Object c = null;
		
		assertEquals(i, 3);
		assertEquals(b, true);
		assertNull(c);
		assertNotNull(c); // false
		
		// 테스트가 성공하도록 코드를 짜면된다
	}
	
	@Test
	public void notEquals() {
		int i =5;
		boolean b = false;
		assertNotEquals(i, 3);
		assertFalse(b);
	}
}
