package com.sports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sports.entities.Enquiry;
import com.sports.services.EnquiryService;

@Controller
public class EnquiryController
{
	@Autowired
	EnquiryService enqServiceRef;
	
	@RequestMapping("/postEnquiry")
	public String GoToEnquiry(@ModelAttribute("ENQMODEL") Enquiry enq)
	{
		return "t_enquiry";
	}
	@RequestMapping("/addEnquiry")
	public String AddEnquiry(@ModelAttribute("ENQMODEL") Enquiry enq)
	{
		System.out.println("enqReq matched");
		System.out.println(enq);
		enq.setAnswer("NOT_ANSWERED");
		enqServiceRef.SaveEnquiry(enq);
		return "t_index";
	}
	@RequestMapping("/getAnswers")
	public String GetQuestionAndAnswers(Model model)
	{
		List<Enquiry> enqList=enqServiceRef.getAllAnsweredEnquiry();
		model.addAttribute("EnquiryList", enqList);
		return "t_getanswers";
	}
	

}
