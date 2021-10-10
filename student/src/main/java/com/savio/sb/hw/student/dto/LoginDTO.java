package com.savio.sb.hw.student.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class LoginDTO {

	
	@NotBlank(message = "Invalid BUserName")
	@NotNull(message = "Invalid UserName")
	private String username;
	
	@NotBlank(message = "Invalid BName")
	@NotNull(message = "Invalid Password")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginDTO [username=" + username + ", password=" + password + "]";
	}
	
	
	
}
