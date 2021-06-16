package core.test2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.Setter;
 @Component //== @Component("bag") <- (다른 패키지에 있을시 이름 명시해주는게 좋음)	 
 			//다른 Application에 힌트를 주는 어노테이션(Annotation)
			//Bean 에 적용
					
public class Bag {
	
	 private Book book;
	
	public Bag() {
		
	}
	
	@Autowired  // 생성자를 통한 자동으로 의존성 주입
	public Bag(Book book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Bag [book=" + book + "]";
	}
	
//	@Autowired // Setter 메소드를 통한 자동으로 의존성 주입
	public void setBook(Book book) {
		this.book = book;
	}
	
	
	
}
