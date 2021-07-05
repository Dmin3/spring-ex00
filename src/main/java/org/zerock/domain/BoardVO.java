package org.zerock.domain;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
// 자바 Bean 작성
@Data
public class BoardVO {

//보통 데이터베이스가 갖고 있는 이름과 일치한다
private long bno;
private String title;
private String content;
private String writer;
private Date regdate;
private Date updatedate;
private int replyCnt;

private String fileName;
// private MultipartFile file;

	
}
