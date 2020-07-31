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

import com.sports.entities.EventAttenders;
import com.sports.entities.EventCharges;
import com.sports.entities.Events;
import com.sports.entities.Members;
import com.sports.entities.Sports;
import com.sports.services.EventAttendersService;
import com.sports.services.EventChargesServices;
import com.sports.services.EventsService;
import com.sports.services.MemberService;
import com.sports.services.SportsService;

@Controller
public class EventsController
{
	@Autowired
	EventsService eventServiceRef;
	
	@Autowired
	SportsService sportServiceRef;
	
	@Autowired
	MemberService memberServiceRef;
	
	@Autowired
	EventChargesServices eveChargeSerRef;
	
	@Autowired
	EventAttendersService eventAttendServiceRef;
	/*this moved to admin controller
	@RequestMapping("/getAllEvents")
	public String getAllEvents(Model model)
	{
		System.out.println("getEvents Request Mapped");
		List<Events> eventList=new ArrayList<Events>();
		eventList=eventServiceRef.getAllEvents();
		for (Events events : eventList)
		{
			System.out.println(events.toString());
		}
		model.addAttribute("EventList", eventList);
		return "t_events";
	}
	
	@RequestMapping("/addEvent")
	public String addEvent(Model model,@ModelAttribute("eventModel") Events events,HttpSession session)
	{
		System.out.println("addEvents Request Mapped");
		List<Sports> sportsList= sportServiceRef.getAllSports();
		model.addAttribute("SportList", sportsList);
		return "t_addEvent";
	}
	
	@RequestMapping("/addNewEvent")
	public String addNewEvent(@ModelAttribute("eventModel") Events events,HttpSession session)
	{
		System.out.println("addEvents Request Mapped");
		System.out.println(events.toString());
		List<Sports> sportsList= sportServiceRef.getAllSports();
		for (Sports sports : sportsList)
		{
			if(sports.getSportName().equals(events.getSportName()))
				events.setRelatedSportid(sports.getId());
		}
		eventServiceRef.addEvent(events);
		return "forward:getAllEvents";
	}
	*/
	
	@RequestMapping("/geteventdetails")
	public String ShowEventDetails(Model model,@RequestParam("eventId")String eventId)
	{
		int id=Integer.parseInt(eventId);
		Events event=eventServiceRef.getEvent(id);
		model.addAttribute("EventDetails", event);
		return "t_eventDetails";
	}
	@RequestMapping("/index")
	public String ShowHomePage()
	{
		return "t_index";
	}
	@RequestMapping("/hello")
	public String hello()
	{
		return "hello";
	}/*
	moved to admin controller
	@RequestMapping("/showOnMainPage")
	public String showOnMainPage(Model model, @RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		System.out.println("show On my page mapped");
		int id=Integer.parseInt(eventid);
		System.out.println("id is "+id);
		Events event=eventServiceRef.getEvent(id);
		event.setIsOnMainPage("y");
		eventServiceRef.updateEvents(event);
		List<Events> eventList=new ArrayList<Events>();
		eventList=eventServiceRef.getAllEventsToShow();
		model.addAttribute("updatedEvents",eventList);
		return "t_default";
	}
	*/
	
	@RequestMapping("/Registertoevent")
	public String ShowEventForm(Model model,@RequestParam("eventId") String eventId,@ModelAttribute("EVENTATTMODEL") EventAttenders attenders)
	{
		Events event=eventServiceRef.getEvent(Integer.parseInt(eventId));
		model.addAttribute("Events", event);
		return "t_showRegForm";
	}
	@RequestMapping("/geteventcharge")
	public String ShowPaymentForm(Model model,@RequestParam("eventId") String eventId,@ModelAttribute("EVENTATTMODEL") EventAttenders attenders)
	{
		Events event=eventServiceRef.getEvent(Integer.parseInt(eventId));
		Members member=memberServiceRef.getUser(attenders.getEmail());
		if(member!=null)
		{
		if(member.getIsMember().equals("true"))
			attenders.setWillpay(event.getChargeForMember());
		else
			attenders.setWillpay(event.getChargeForNonMember());
		}
		else
		{
			attenders.setWillpay(event.getChargeForNonMember());
		}
		System.out.println(attenders);
		model.addAttribute("Events", event);
		model.addAttribute("EventAttenders", attenders);
		return "t_eventpaymant";
	}
	@RequestMapping("/doneEventPayment")
	public String DonePayment(@ModelAttribute("EVENTATTMODEL") EventAttenders attenders)
	{
		System.out.println(attenders);
		eventAttendServiceRef.addEventAttenders(attenders);
		return "t_index";
	}

}
