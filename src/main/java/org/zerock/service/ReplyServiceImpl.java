package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service // 서비스 일을 하다는것을 스프링한테 알려줌
@Log4j
public class ReplyServiceImpl implements ReplyService {

	@Setter(onMethod_ = @Autowired ) // 의존성 주입
	private ReplyMapper mapper;
	
//	@Autowired
//	public void setMapper(ReplyMapper mapper) {
//		this.mapper = mapper;
//	}
	
	@Override
	public int register(ReplyVO vo) {
		
		return mapper.insert(vo);
	}
	
	@Override
	public ReplyVO get(Long rno) {
		
		return mapper.read(rno);
	}
	
	@Override
	public int modify(ReplyVO vo) {
		
		return mapper.update(vo);
	}
	
	@Override
	public int remove(Long rno) {
		
		return mapper.delete(rno);
	}
	
	@Override
	public List<ReplyVO> getList(Long bno) {
		
		return mapper.getList(bno);
	}
	
}
