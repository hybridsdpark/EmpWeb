package com.webapp.controller;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.webapp.model.User;


@Controller
@RequestMapping("/login")
public class LoginController {

	static Log log = LogFactory.getLog(LoginController.class);
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(){
		log.info("####################################");
		log.info("#########GET#####");
		log.info("####################################");
		
		return "login/loginform";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(User user, HttpSession seeion){
		
		log.info("####################################");
		log.info("#########POST##### id = "+user.getId()+" password = "+user.getPassword());
		log.info("####################################");
		
		if ("webapp".equals(user.getId()) && "1234".equals(user.getPassword())){
			//login Seccess
			seeion.setAttribute("user", user);
			return "login/success";
		}else {
			//login Fail
			return "redirect:login";
		}
		

	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String logout(HttpSession seeion){
		
		seeion.invalidate();
		return "login/logoutsuccess";
	}
}
