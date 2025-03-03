package com.kh.common.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageInfo {
	//views/board/boardListView.jsp 포워딩
	//board데이터를 전달
	
	//---------------- 페이징 처리 -----------------
	private int listCount; //현재 총 게시글 수
	private int currentPage; //현재 페이지(사용자가 요청한 페이지)
	private int pageLimit=10; //하단에 ㅗ여질 페이징 바의 수
	private int boardLimit=10; //한 페이지에 보여줄 게시글 최대 수
	//위 4개의 값을 기준으로 아래 3개의 값을 계산
	
	private int maxPage;//가장 마지막 페이지(총 페이지 수)
	private int startPage; //하단의 보여질 페이징 바의 시작수
	private int endPage; //하단에 보여질 페이징바의 끝수
	
	public PageInfo(int listCount, int currentPage, int pageLimit, int boardLimit) {
		super();
		this.listCount = listCount;
		this.currentPage = currentPage;
		this.pageLimit = pageLimit;
		this.boardLimit = boardLimit;
		
		
		/*
		 * maxPage : 제일 마지막 페이지 수
		 * 
		 * listCount	boardLimit
		 * 	  100			10		->10
		 * 	  107			10		->11
		 * 
		 * 총 게시글 수 / 한페이지에 보여줄 게시글 수 -> 올림
		 */
		this.maxPage = (int)Math.ceil((double)listCount/boardLimit);
		
		
		/*
		 * startPage : 페이징바 시작 수
		 * 
		 * currentPage	pageLimit startPage
		 * 	    1			10		  1
		 * 	    5			10		  1
		 * 	    11			10		  11
		 * startPage = (((currentPage-1)/pageLimit)*pageLimit +1)
		 */
		
		this.startPage = (((currentPage-1)/pageLimit)*pageLimit +1);
		
		/*
		 * endPage : 페이징바의 끝 수
		 * startPage : 1-> 10
		 * startPage : 11-> 20
		 * startPage : 21-> 30
		 */
		this.endPage = this.startPage + pageLimit -1;
		
		//startPage가 11이면 endPage가 20이다. (maxPage가 13이면?)
		this.endPage = this.endPage > this.maxPage ? this.maxPage : this.endPage;
		
	}
	
	
}
