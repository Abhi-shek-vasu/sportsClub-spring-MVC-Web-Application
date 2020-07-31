package com.sports.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.entities.Members;
import com.sports.services.MemberService;

@Controller
public class LoginController
{
	@Autowired
	MemberService memberServiceRef;
	
	@RequestMapping("/loginValidate")
	 public String ValidateUser(Model model, @RequestParam(value="email") String email,@RequestParam(value="password") String password ,HttpSession session)
	 {
		System.out.println("loginvalidate called");
		 if(email.equals("admin")&& password.equals("admin"))
			 return "forward:/admin/adminpanel";
		 
		 Members mem=memberServiceRef.validate(email,password);
		 System.out.println(mem.toString());
		 return "forward:/getAllEvents";
	 }
	 
	@RequestMapping("/login")
	public String authorizeUser(HttpServletRequest req,HttpSession session)
	{

		Authentication authe=SecurityContextHolder.getContext().getAuthentication();
		String name=authe.getName();
		System.out.println(name);
		
		System.out.println("authorization called");
		if(req.isUserInRole("ROLE_USER"))
		{
			System.out.println("ROLE_USER");
			Members member=memberServiceRef.getUser(name);
			
			System.out.println("IMAGE IS "+member.getUserImage());
			session.setAttribute("USERIMAGE",member.getUserImage());
			session.setAttribute("username",member.getName());
			session.setAttribute("email",member.getEmail());
			return "forward:/index";
		}
		else if(req.isUserInRole("ROLE_ADMIN"))
			{
				Members member=memberServiceRef.getUser(name);
				
				System.out.println("IMAGE IS "+member.getUserImage());
				session.setAttribute("USERIMAGE",member.getUserImage());
				session.setAttribute("username",member.getName());
				System.out.println("ROLE_ADMIN");
				return "forward:/admin/adminpanel";
			}
		else
			return "t_login";
	}
	@RequestMapping("/logout")
	public String logout(HttpServletRequest req)
	{
		HttpSession session=req.getSession();
		session.invalidate();
		return "t_index";
	}
}
