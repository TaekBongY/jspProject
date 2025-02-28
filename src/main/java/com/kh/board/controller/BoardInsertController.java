package com.kh.board.controller;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;

import org.apache.commons.fileupload2.jakarta.JakartaServletFileUpload;
import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;

import com.kh.board.model.service.BoardService;
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardInsertController
 */
@WebServlet("/insert.bo")
public class BoardInsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertController() {
        super();
        /*
         * 파일업로드를 위해서
         *  commons-fileupload2-core2.0.0.MZ.jar
         *  commons-fileupload2-jakarta =2.0.0-M1.jar
         *  commons-io-2.16.1.jar 라이브러리를 사용하겠다.
         *  
         *  commons=fileupload2.core : 주요 기능을 구현하는 라이브러리(멀타피트 요청에 대한 처리 가능)
         *  commons-fileuploadd2-jakarta : javaax.servlet -> jakarta.servlect 패키지를 사용하게 되는 객체
         *  commons-io : 파일 읽기/쓰기에 대한 스트림을(입출력 기능)을 구현하고 있는 라이브러리
         *  
         */  
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//enctype이 multipart/form0data일 때 request로 값 추출이 불가
		
		//enctype이 multipart/form-data로 전송이 되었는지 체크
		JakartaServletFileUpload.isMultipartContent(request);
		
		if(JakartaServletFileUpload.isMultipartContent(request)) {
			//1. 파일용량제한(byte)
			int fileMaxSize = 1024* 1024 * 50; //50MB
			int requestMaxSize = 1024* 1024 * 60; //전체 요청 크기제한
			
			//2. 전달된 파일을 저장할 폴더 경로 가져오기
			String savePath = request.getServletContext().getRealPath("/resources/board-upfile");
			
			//3. DiskFileItemFactory(파일을 임시로 저장) 객체 생성
			DiskFileItemFactory factory = DiskFileItemFactory.builder().get();
			
			//4.JakartaServletFileUpload http요청으로 들어온 파일데이터 파싱 -> 개별 FileItem 객체로 변환
//			JakartaServletFileUpload upload = new JakartaServletFileUpload(factory);
//			upload.setFileSizeMax(fileMaxSize);
//			upload.setSizeMax(requestMaxSize);
//			
//			//요청(request)로부터 파일아이템(요청정보) 파싱
			List<FileItem> formItems = upload.parseRequest(request);
			
			Board b = new Board();
			Attachment at = null;
			
			for(FileItem item : formItems) {
				System.out.println(item);
				if(item.isFormField()) { //일반 파라미터
					//업로드된 데이터가 일반 폼 필드인지, 파일인지를 구분할 수 있음
					switch(item.getFieldName()) {
					case "category":
						int categoryNO = Integer.parseInt(item.getString(Charset.forName("UTF-8")));
						b.setCategoryNo(categoryNO);
						break;
					case "title":
						b.setBoardTitle(item.getString(Charset.forName("UTF-8")));
						break;
					case "content":
						b.setBoardContent(item.getString(Charset.forName("UTF-8")));
						break;
					}
				} else { //파일
					String originName = item.getName();
					
					if(originName.length()>0) { //파일 업도르를 했을 때
						//파일명이 겹치면 덮어씌우기 때문에 고유한 파일명 만듦
						String tmpName = "kh"+ System.currentTimeMillis() + ((int)(Math.random()*100000) +1);
						String type = originName.substring(originName.lastIndexOf("."));
						String changeName = tmpName + type; //서버에 저장할 파일명
						
						File f = new File(savePath, changeName);
						item.write(f.toPath()); //지정한 경로에 파일 업로드
						
						at = new Attachment();
						at.setOriginName(originName);
						at.setChangeName(changeName);
						at.setFilePath("resources/board-upfile/");
					}
				}
			}
			
			//저장정보를 request객체에서 가져온 상태
			
			int result = new BoardService().insertBoard(b,at);
			if(result>0) {
				request.getSession().setAttribute("alertMsg", "일반게시글 작성 성공");
				response.sendRedirect(request.getContextPath() + "/list.bo?cpage=1");
			} else {
				if(at != null) {
					new File(savePath + at.getChangeName()).delete();
				}
				//에러페이지로 보내기
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
