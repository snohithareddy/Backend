package com.spring.dao;



import com.spring.model.User;



public interface UserDAO 

{

public boolean insertUser(User user);



public User getUserId(String email);

	

}