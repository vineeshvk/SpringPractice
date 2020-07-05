package com.cts.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.cts.models.UserModel;
import com.cts.repositories.UserRepository;
import org.springframework.security.core.userdetails.User;

@Service
public class MyUserDetailService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
    
	@Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserModel userDB = userRepository.findByUserName(name);
		return new User(userDB.getUserName(),userDB.getPassword(),new ArrayList<>());
    }
	
	public void registerUser(UserModel user) {
		userRepository.save(user);
	}
}
