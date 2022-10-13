package com.jsp.Spring_bootProject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.Spring_bootProject.dto.User;
import com.jsp.Spring_bootProject.repository.UserRepository;

@Repository
public class UserDao 
{
	@Autowired
	UserRepository userRepository;
	
	public User saveUser(User user) 
	{
		return userRepository.save(user);
		
	}
	public User findUserById(int id) 
	{
		Optional<User> optional=userRepository.findById(id);
		if (optional.isPresent()) 
		{
			return optional.get();
			
		}
		return null;
	}
	
	public boolean delete(int id) 
	{
		User u=findUserById(id);
		
		if (u!=null) 
		{
			userRepository.delete(u);
			return true;
			
		}
		else {
			 return false;
		}
		
		
	}
	public List<User> getall() {
		
		return userRepository.findAll();
	}
	
	public User updateUser(int id,User u) 
	{
		User exist=findUserById(id);
		if (exist!=null) 
		{
//			delete(id);
//			u.setId(id);
//			userRepository.save(u);
//			return u;
			exist.setAge(u.getAge());
			exist.setName(u.getName());
			userRepository.save(exist);
			return exist;
		}
		return null;
		
	}

}
