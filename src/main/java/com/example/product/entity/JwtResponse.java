package com.example.product.entity;

import java.io.Serializable;

public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private UserDTO user;
	
	public JwtResponse(String jwttoken, UserDTO user) {
		super();
		this.jwttoken = jwttoken;
		this.user = user;
	}


	public String getToken() {
		return this.jwttoken;
	}


	public UserDTO getUser() {
		return user;
	}


	public void setUser(UserDTO user) {
		this.user = user;
	}


	public String getJwttoken() {
		return jwttoken;
	}
	
	
}