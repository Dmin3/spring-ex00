package org.zerock.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.zerock.domain.BoardVO;

public interface BoardMapper {
// 코드가 길면 관리가 어렵기때문에 따로 만들어서 관리하기는게 유용하다
//	@Select("SELECT * FROM tbl_board")
	public List<BoardVO> getList();
	
	// INSERT INTO tbl_board (title, content, writer) VALUES (#{title}, #{content}, #{writer})
	public int insert(BoardVO board);
	
	
	public int insertSelectKey(BoardVO board);
	
	
	public BoardVO read(long bno);
	
	public int delete(long bno);
	
	public int update(BoardVO board);
}
