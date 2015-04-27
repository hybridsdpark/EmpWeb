package com.webapp.controller;

public class LoginController {

	public String login(){
		return "login/loginform";
	}
	
	public String login(User user){
		return "login/success";
	}
}
