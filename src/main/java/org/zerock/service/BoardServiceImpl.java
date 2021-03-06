package org.zerock.service;

import java.io.InputStream;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.FileVO;
import org.zerock.mapper.BoardMapper;
import org.zerock.mapper.FileMapper;
import org.zerock.mapper.ReplyMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

// @AllArgsConstructor // 생성자 자동생성
@Service // @Component 포함
public class BoardServiceImpl implements BoardService {
	
	private String bucketName;
	private String profileName;
	private S3Client s3;
	
	
	public BoardServiceImpl() {
		this.bucketName = "choongang-dmin";
		this.profileName = "spring1";
		this.s3 = S3Client.builder().credentialsProvider(ProfileCredentialsProvider.create(profileName))
				.build();
	}
	
	@Setter(onMethod_ = @Autowired)
	private BoardMapper mapper;
	
	@Setter(onMethod_ = @Autowired)
	private ReplyMapper replyMapper;
	
	@Setter(onMethod_ = @Autowired)
	private FileMapper fileMapper;
	
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
	public boolean modify(BoardVO board, MultipartFile file) {
		
		if(file != null && file.getSize() > 0) {
			// s3는 삭제 후 재업로드
			BoardVO oldBoard = mapper.read(board.getBno());
			removeFile(oldBoard);
			upload(board, file);
			// tbl_board_file은 삭제 후 INSERT
			fileMapper.deleteByBno(board.getBno());
			FileVO vo = new FileVO();
			vo.setBno(board.getBno());
			vo.setFileName(file.getOriginalFilename());
			fileMapper.insert(vo);
			
			
		}
		return modify(board);
		
		
		
		
	}
	
	
	

	@Override
	@Transactional
	public boolean remove(long bno) {
		// 댓글 삭제
		replyMapper.deleteByBno(bno);
		
		// 파일 삭제(s3)
		BoardVO vo = mapper.read(bno); // 파일명 먼저 얻어오기
		removeFile(vo);
		
		// 파일 삭제(db)
		fileMapper.deleteByBno(bno);
		
		// 게시물 삭제
		int cnt = mapper.delete(bno);
		return cnt == 1;
	}

	private void removeFile(BoardVO vo) {
		
		String key =vo.getBno() + "/" + vo.getFileName();
		
		DeleteObjectRequest deleteObjectRequest = DeleteObjectRequest.builder()
				.bucket(bucketName)
				.key(key)
				.build();
		
		s3.deleteObject(deleteObjectRequest);
		
	}

	@Override
	public List<BoardVO> getList(Criteria cri) {
		
		return mapper.getListWithPaging(cri);
	}

	
	@Override
	public int getTotal(Criteria cri) {
		
		return mapper.getTotalCount(cri);
	}

	@Override
	@Transactional
	public void register(BoardVO board, MultipartFile file) {
		register(board);
		
		if(file != null && file.getSize() > 0) {
			FileVO vo = new FileVO();
			vo.setBno(board.getBno());
			vo.setFileName(file.getOriginalFilename());
			
			fileMapper.insert(vo);
			
			upload(board, file);
			
		}
		
	}

	private void upload(BoardVO board, MultipartFile file) {
		
		
		try(InputStream is = file.getInputStream()) 
		{
			PutObjectRequest objectRequest = PutObjectRequest.builder()
					.bucket(bucketName)
					.key(board.getBno() + "/" +file.getOriginalFilename()).contentType(file.getContentType())
					.acl(ObjectCannedACL.PUBLIC_READ)
					.build();
			
			s3.putObject(objectRequest, RequestBody.fromInputStream(is, file.getSize()));
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	
	
	
	
	
}
