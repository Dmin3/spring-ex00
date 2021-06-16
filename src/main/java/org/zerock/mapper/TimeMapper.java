package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {
	
	// 추상메소드를 만들때 위에 어노테이션을 사용하여 완성해라
	
	@Select("SELECT now()")
	public String getTime();
	
	
	//TimeMapper.xml로 빼줌
	//@Select("SELECT now()) 가 있는거와 같음
	public String getTime2();
}
