package com.kh.board.model.service;

<<<<<<< HEAD
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;
=======
import static com.kh.common.JDBCTemplate.*;

>>>>>>> origin/main

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.board.model.dao.BoardDao;
<<<<<<< HEAD
import com.kh.board.model.vo.Board;
=======
import com.kh.board.model.vo.Attachment;
import com.kh.board.model.vo.Board;
import com.kh.board.model.vo.Category;
>>>>>>> origin/main
import com.kh.common.vo.PageInfo;

public class BoardService {

	public int selectListCount() {
		Connection conn = getConnection();
		
		int listCount = new BoardDao().selelctListCount(conn);
		
		close(conn);
		return listCount;
	}

	public ArrayList<Board> selectList(PageInfo pi) {
		Connection conn = getConnection();
		ArrayList<Board> List = new BoardDao().selectList(conn,pi);
		
		close(conn);
		
		return List;
		
	}

<<<<<<< HEAD
=======
	public ArrayList<Category> selectCategory() {
		Connection conn = getConnection();
		ArrayList<Category> List = new BoardDao().selectCategory(conn);
		
		close(conn);
		
		return List;
	}

	public int insertBoard(Board b, Attachment at) {
		Connection conn = getConnection();
		
		BoardDao bDao = new BoardDao();
		
		int result = new BoardDao().insertBoard(conn,b);
		
		int result2 = bDao.insertAttachment(conn,at);
		
		if(result * result2 > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		
		
		close(conn);
		
		return result;
	}

>>>>>>> origin/main
}
