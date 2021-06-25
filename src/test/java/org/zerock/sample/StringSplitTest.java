package org.zerock.sample;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringSplitTest {

	@Test
	public void test() {
		String str1 = "java,spring,css";
		
		String[] arr1 = str1.split(","); // , 를 기준으로 분리해줌
		// "{"java","spring","css"}"
		
		assertEquals("java", arr1[0]);
		assertEquals("spring", arr1[1]);
		assertEquals("css", arr1[2]);
	}

	@Test
	public void test2() {
		String str1 = "TWC";
		String[] arr1 = str1.split(""); // 글자 하나씩 분리가 됌
		// {"T","W","C"}
		assertEquals("T", arr1[0]);
		assertEquals("W", arr1[1]);
		assertEquals("C", arr1[2]);
		assertEquals(3, arr1.length);
	}
}
