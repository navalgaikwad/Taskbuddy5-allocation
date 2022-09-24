package com.taskbuddy.clts;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taskbuddy.entities.Logininfo;
import com.taskbuddy.entities.Userinfo;
import com.taskbuddy.services.LoginService;

@Controller
public class RegisterController 
{
	@Autowired LoginService loginService;
	
	@RequestMapping("/reg")
	public String registerPage(/*Map<String , Object> map*/ Model model)
	{
		Logininfo person=new Logininfo();
		/*map.put("person",person);*/
		model.addAttribute("person", person);
		//System.out.println(person);
		
		Userinfo userinfo=new Userinfo();
		/*map.put("userinfo", userinfo);*/
		model.addAttribute("userinfo", userinfo);
		//System.out.println(userinfo);
		
		return "registration";
	}
	
	@RequestMapping("/registration")
	public String Registration( @ModelAttribute("person") Logininfo person,@ModelAttribute("userinfo") Userinfo userinfo,Model model,HttpSession session)
	{	
		
		System.out.println(userinfo);
		
		//System.out.println(session.getAttribute("username"));
		person.getUserinfos().add(userinfo);
		userinfo.setLogininfo(person);
		//System.out.println("username: " + person.getUsername());
		
		loginService.register(person);
		loginService.addUserToUserinfo(userinfo);
		model.addAttribute("logininfo", person);
		session.setAttribute("user", loginService.getUser(person.getUsername()));
		session.setAttribute("username", person.getUsername());
		session.setAttribute("bookings", new ArrayList<Integer>());
		//System.out.println(person);
		
		return "redirect:login";
	}
}
