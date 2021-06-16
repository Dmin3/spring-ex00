package core.test1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // 기본 생성자 생성 
				   //why? 파라미터 있는 생성자 생성시 기본생성자 안만들어짐
@AllArgsConstructor // Leg 객체를 파라미터 받는 생성자 생성
@ToString
public class Chair {
	private Leg leg;
}
