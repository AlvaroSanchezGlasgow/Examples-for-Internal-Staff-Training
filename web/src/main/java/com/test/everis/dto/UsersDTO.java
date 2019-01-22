package com.test.everis.dto;

/**
 * Class to store the users information
 * @author asanchga
 *
 */
public class UsersDTO {

	//Class variables declaration
	private String userId = "";
	private String userName = "";
	private String userSurname = "";
	private String userRole = "";
	
	
	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getUserSurname() {
		return userSurname;
	}


	public void setUserSurname(String userSurname) {
		this.userSurname = userSurname;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	/**
	 * Constructor Class 
	 */
	public UsersDTO() {
		// null constructor keeps mybatis happy
	}
	
		
}
