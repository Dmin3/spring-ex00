package org.zerock.persistence;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTests {

	@Test
	public void test() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			// 위 코드가 있는지 확인하는법
			// 없으면 catch문으로 가서 fail 리턴
		} catch(Exception e){
			fail(); 
		}
		
		String url = "jdbc:mysql://13.124.182.7/test";
		String user = "root";
		String password = "wnddkdwjdqhcjfl1";
		
		try(
		Connection con = DriverManager.getConnection(url, user, password)
				
				){
			assertNotNull(con);	
			
		} catch (Exception e) {
			fail();
		}
	}

}
