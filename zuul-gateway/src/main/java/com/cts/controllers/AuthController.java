package com.cts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cts.config.JwtTokenUtil;
import com.cts.models.AuthStatusResponse;
import com.cts.models.UserModel;
import com.cts.services.MyUserDetailService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	
	@Autowired
	private MyUserDetailService userDetailsService;
	
	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public AuthStatusResponse createAuthenticationToken(@RequestBody UserModel user)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getUserName(), user.getPassword()));
		} catch (BadCredentialsException e) {
			return new AuthStatusResponse(null, e.getMessage());
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new AuthStatusResponse(jwt,"Successful");
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public AuthStatusResponse registerUser(@RequestBody UserModel user)
			throws Exception {
		userDetailsService.registerUser(user);
		try {
			
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					user.getUserName(), user.getPassword()));
		} catch (BadCredentialsException e) {
			return new AuthStatusResponse(null, e.getMessage());
		}

		final UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUserName());

		final String jwt = jwtTokenUtil.generateToken(userDetails);

		return new AuthStatusResponse(jwt,"Successful");
	}

}
