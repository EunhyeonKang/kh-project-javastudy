package kr.or.board.model.vo;

import lombok.Data;

@Data	//기본생성자 게터세터 생성
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardWriter;
	private String boardContent;
	private String boardDate;
	
}
