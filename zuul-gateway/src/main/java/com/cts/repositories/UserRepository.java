package com.cts.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cts.models.UserModel;

public interface UserRepository  extends JpaRepository<UserModel, Integer>{

	UserModel findByUserName(String userName);
}
