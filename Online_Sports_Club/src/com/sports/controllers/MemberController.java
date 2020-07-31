package com.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysql.fabric.xmlrpc.base.Member;
import com.sports.entities.Members;
import com.sports.entities.Sports;
import com.sports.entities.Subscriptions;
import com.sports.services.MemberService;
import com.sports.services.SportsService;
import com.sports.services.SubscriptionsService;

@Controller
public class MemberController
{
	@Autowired
	MemberService memberServiceRef;
	
	@Autowired
	SportsService sportsServiceRef;
	
	@Autowired
	SubscriptionsService subscriptionServiceRef;
	
	/*
	 * method moved to loginControler
	 *  @RequestMapping("/loginValidate")
	 public String ValidateUser(Model model, @RequestParam(value="email") String email,@RequestParam(value="password") String password ,HttpSession session)
	 {
		 if(email.equals("admin")&& password.equals("admin"))
			 return "adminpanel";
		 
		 Members mem=memberServiceRef.validate(email,password);
		 System.out.println(mem.toString());
		 return "t_default";
	 }
	 */
	 @RequestMapping("login123")
	 public String login()
	 {
		 
		 return "t_login";
	 }
	 @RequestMapping("/myprofile")
	 public String showMyProfile(Model model,HttpSession session)
	 {Members member=memberServiceRef.getUser((String)session.getAttribute("email"));
	 model.addAttribute("UserInfo",member);
	 for (Subscriptions sub : member.getSubscriptionList())
	{
		System.out.println(sub.getSport().getSportName());
	}
		 
		 return "t_myprofile";
	 }
	 
	 @RequestMapping("/register")
	 public String RegisterForm(Model model,@ModelAttribute("command") Members member)
	 {
		 return "t_register";
	 }
	 @RequestMapping("/registerUser")
	 public String Register(Model model,@ModelAttribute("command") Members member)
	 {
		 member.setRole("ROLE_USER");
		 member.getUserRoles().setEmail(member.getEmail());
		 member.getUserRoles().setRole("ROLE_USER");
		 member.setIsMember("false");
		 System.out.println(member);
		 System.out.println(member.getUserRoles());
		 System.out.println("member mapped");
		 memberServiceRef.addMember(member);
		 memberServiceRef.addUserRole(member.getUserRoles());
		
		 return "t_default";
	 }
	 @RequestMapping("/gotosubscriptions")
	 public String GotoSubscriptions(Model model,@ModelAttribute("command")Subscriptions subscription,HttpSession session)
	 {
		 if(session.getAttribute("username")==null)
			 return "t_index";
		 else
		 {
			Members member= memberServiceRef.getUser(session.getAttribute("email").toString());
			List<Subscriptions> mySubscriptionsList=member.getSubscriptionList();
			System.out.println(member.toString());
			System.out.println("Printing my subs");
			for (Subscriptions subscriptions :mySubscriptionsList)
			{
				System.out.println(subscriptions);
			}		
			List<Sports>sportList= sportsServiceRef.getAllSports();
			model.addAttribute("SportList",sportList);
			model.addAttribute("MySubscriptionList", mySubscriptionsList);
			//newcode
			List<Sports> sportsList=new ArrayList<Sports>();
			List<Sports> outdoorsportsList=new ArrayList<Sports>();
			List<Sports> indoorsportsList=new ArrayList<Sports>();
			sportsList=sportsServiceRef.getAllSports();
			for (Sports sports : sportsList)
			{
				if(sports.getSportType().equals("Indoor"))
					indoorsportsList.add(sports);
					else
						outdoorsportsList.add(sports);
			}
			for (Sports sports : indoorsportsList)
			{
				System.out.println(sports);
			}
			for (Sports sports : outdoorsportsList)
			{
				System.out.println(sports);	
			}
			model.addAttribute("AllSportList", sportsList);
			model.addAttribute("IndoorSportList", indoorsportsList);
			model.addAttribute("OutdoorSportList", outdoorsportsList);
			 return "t_subscriptions";
		 }
	 }
}
