package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;

@AllArgsConstructor // 생성자 자동생성
@Service // @Component 포함
public class BoardServiceImpl implements BoardService {
	
	private BoardMapper mapper;
	private ReplyMapper replyMapper;
	
	@Override
	public void register(BoardVO board) {
		mapper.insertSelectKey(board);
		
	}

	@Override
	public BoardVO get(Long bno) {
		
		return mapper.read(bno);
	}

	@Override
	public boolean modify(BoardVO board) {
		
		// update 성공시 하나의 레코드가 잘들어간거이기때문에 1을 리턴한다
		// update 타입이 Integer 이다. 
		return mapper.update(board) == 1;
	}

	@Override
	@Transactional
	public boolean remove(long bno) {
		// 댓글 삭제
		replyMapper.deleteByBno(bno);
		
		// 게시물 삭제
		int cnt = mapper.delete(bno);
		return cnt == 1;
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return mapper.getListWithPaging(cri);
	}

	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}
	
	
	
	
	
	
	
	
}
