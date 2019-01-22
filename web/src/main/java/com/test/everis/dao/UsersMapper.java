package com.test.everis.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;

import com.test.everis.dto.UsersDTO;

 
@Mapper
public interface UsersMapper {

	@Results({
	  @Result(property = "userId", column = "ID"),
	  @Result(property = "userName", column = "NAME"),
	  @Result(property = "userSurname", column = "SURNAME"),
	  @Result(property = "userRole", column = "ROLE")
	  })
	    
		@Select("select * from T_USERS")
		List<UsersDTO> getAllUsers();

	@Delete("DELETE FROM T_USERS WHERE ID=#{id}")
	void deleteUsers(String id);
	
	@Insert("INSERT INTO T_USERS (ID, NAME,SURNAME,ROLE) VALUES(#{userId},#{userName},#{userSurname},#{userRole})")
	void createNewUser(String userId, String userName, String userSurname, String userRole);
	
		
}
