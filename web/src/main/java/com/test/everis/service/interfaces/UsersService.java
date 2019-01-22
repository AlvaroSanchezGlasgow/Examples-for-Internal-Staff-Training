package com.test.everis.service.interfaces;

import java.util.List;

import com.test.everis.dto.UsersDTO;

public interface UsersService {

	public List<UsersDTO> getAllUsers();

	public void deleteUsers(String id);

	public void createNewUser(String userId, String userName, String userSurname, String userRole);
}
