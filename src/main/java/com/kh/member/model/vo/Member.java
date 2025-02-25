package com.kh.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	   private int userNo;
	    private String userId;
	    private String userPwd;
	    private String userName;
	    private String phone;
	    private String email;
	    private String address;
	    private String interest;
	    private Date enrollDate;
	    private Date modifyDate;
	    private String status;
	
	
	
}
