package core.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App1 {
	public static void main(String[] args) {
		System.out.println("프로그램 실행1");
		
	//	Desk desk = new Desk(); 예전에는 이렇게 객체생성
		
		
		String path = "core/test1/core-test1.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(path);
		
		//getBean이  Object를 return함
		
		Object o = context.getBean("desk");
		System.out.println(o);
		
		Object o2 = context.getBean("leg");
		System.out.println(o2);
		
		Object o3 = context.getBean("chair");
		System.out.println(o3);
		
		
	}
}
