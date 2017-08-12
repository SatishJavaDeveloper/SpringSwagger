package com.satish.vo;

import javax.validation.constraints.Pattern;

import io.swagger.annotations.ApiModelProperty;

public class Users {
	 @ApiModelProperty(value= "cat-100001",required=true)
	    @Pattern(regexp = "[A-Za-z0-9-]*", message = "Category id should contains alphanumerics and (-) only")
	private String username;
	 @ApiModelProperty(value= "cat-154353",required=true)
	    @Pattern(regexp = "[A-Za-z0-9-]*", message = "Category id should contains alphanumerics and (-) only")
	 private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "Users [username=" + username + ", password=" + password + "]";
	}
	

}
