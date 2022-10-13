package com.jsp.Spring_bootProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.Spring_bootProject.dao.UserDao;
import com.jsp.Spring_bootProject.dto.User;

@RestController
public class UserController 
{
	@Autowired
	UserDao dao;
	
	@PostMapping("/user")
	public User saveUser(@RequestBody User user)
	{
		return dao.saveUser(user);
	}
	@GetMapping("/user")
	public User findUser(@RequestParam int id) 
	{
		return dao.findUserById(id);//null or user object	
	}
	@DeleteMapping("/user")
	public String deletUser(@RequestParam int id) 
	{
		boolean istrue=dao.delete(id);
		if (istrue) 
		{
			return "Delete successfull";
			
		}
		else {
			return "ID mismatch";
		}	
	}

	@PutMapping("/user")
	public User updated(@RequestParam int id,@RequestBody User u) 
	{
		return dao.updateUser(id, u);
		
	}
	
	@GetMapping("/getall")
	public List<User> dispAll() 
	{
		return dao.getall();
		
	}
}
