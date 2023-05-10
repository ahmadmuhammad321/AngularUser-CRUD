package com.uog.user.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBLUSER")
public class User {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long USER_ID;
	@Column(name = "FIRST_NAME")
	private String FIRST_NAME;
	@Column(name = "LAST_NAME")
	private String LAST_NAME;
	@Column(name = "EMAIL")
	private String EMAIL;
	public long getUSER_ID() {
		return USER_ID;
	}
	public void setUSER_ID(long uSER_ID) {
		USER_ID = uSER_ID;
	}
	public String getFIRST_NAME() {
		return FIRST_NAME;
	}
	public void setFIRST_NAME(String fIRST_NAME) {
		FIRST_NAME = fIRST_NAME;
	}
	public String getLAST_NAME() {
		return LAST_NAME;
	}
	public void setLAST_NAME(String lAST_NAME) {
		LAST_NAME = lAST_NAME;
	}
	public String getEMAIL() {
		return EMAIL;
	}
	public void setEMAIL(String eMAIL) {
		EMAIL = eMAIL;
	}
	
	

}
