package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface Test2Mapper {
	// String type을 Bean으로 의식함 Bean에서 getType을 자동으로 완성해줌
	public int sql1(@Param("t") String type);
	
	public int sql2(@Param("type") String t);
	
	public int sql3(@Param("type") String t);
	
	public int sql4(@Param("type") String t);
	
	public int sql5(@Param("type") String t);
	
	public int sql6(@Param("list") List<String> types);
	
	public int sql7(@Param("list") List<String> types);
	
}
