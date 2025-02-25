package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	public Member loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		System.out.println("확인용 : M.S.1");
		Member m = new MemberDao().loginMember(conn,userId,userPwd);
		System.out.println("확인용 : M.S.2");
		
		if (m != null) {
            System.out.println(m);
        } else {
            System.out.println("No member found.");
        }
		
		close(conn);
		return m;
		
	}
}
