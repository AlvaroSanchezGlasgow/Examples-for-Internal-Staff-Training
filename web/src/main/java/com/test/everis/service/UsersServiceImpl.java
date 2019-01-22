package com.test.everis.service;

import com.test.everis.dao.UsersMapper;
import com.test.everis.dto.UsersDTO;
import com.test.everis.service.interfaces.UsersService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {
	
  @Autowired
	   UsersMapper usersMapper;
 
  	
	@Override
	public List<UsersDTO> getAllUsers(){
		
			List<UsersDTO> oListUsers = new ArrayList<UsersDTO>();
			oListUsers = usersMapper.getAllUsers();

			return oListUsers;
		
		
	}

	@Override
	public void deleteUsers(String id) {
		
		usersMapper.deleteUsers(id);
		
	}

	@Override
	public void createNewUser(String userId, String userName, String userSurname, String userRole) {
		// TODO Auto-generated method stub
		usersMapper.createNewUser(userId,userName,userSurname,userRole);
	}
	
}
