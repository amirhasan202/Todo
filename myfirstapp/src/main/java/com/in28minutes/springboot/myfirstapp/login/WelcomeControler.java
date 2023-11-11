package com.in28minutes.springboot.myfirstapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeControler 
{
		
	@RequestMapping(value="/" , method = RequestMethod.GET)
	public String gotoWelcomePage(ModelMap model){
		
		model.put("name", getLoggedinUsername());
		return "welcome";
	}
	
	private String getLoggedinUsername()
	{
		Authentication AA=
		SecurityContextHolder.getContext().getAuthentication();
		
		return AA.getName();
	}

}
