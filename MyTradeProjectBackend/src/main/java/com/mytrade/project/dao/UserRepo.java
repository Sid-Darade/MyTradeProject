package com.mytrade.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.mytrade.project.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.email = ?1 and u.password = ?2")
	User findByEmailAndPassword(String email, String password);

	@Query("select u from User u where u.email= :email")
	User findByEmail(String email);

}
