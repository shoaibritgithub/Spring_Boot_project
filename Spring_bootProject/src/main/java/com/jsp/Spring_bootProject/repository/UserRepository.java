package com.jsp.Spring_bootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.Spring_bootProject.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
	


}


