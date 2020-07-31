package com.sports.controllers;

import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import antlr.debug.Event;

import com.sports.entities.Charges;
import com.sports.entities.Coaches;
import com.sports.entities.Enquiry;
import com.sports.entities.EventAttenders;
import com.sports.entities.Events;
import com.sports.entities.Location;
import com.sports.entities.Slots;
import com.sports.entities.Sports;
import com.sports.entities.Subscriptions;
import com.sports.services.ChargesService;
import com.sports.services.CoachesServices;
import com.sports.services.EnquiryService;
import com.sports.services.EventsService;
import com.sports.services.LocationServices;
import com.sports.services.SlotServices;
import com.sports.services.SportsService;
import com.sports.services.SubscriptionsService;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Controller
@RequestMapping("/admin")
public class AdminController
{
	@Autowired
	EventsService eventServiceRef;
	
	@Autowired
	SportsService sportServiceRef;

	@Autowired
	SubscriptionsService subscriptionServiceRef;
	
	@Autowired
	EnquiryService enqServiceRef;
	
	@Autowired
	LocationServices locServiceRef;
	
	@Autowired
	ChargesService chargeServiceRef;
	
	@Autowired
	SlotServices slotServiceRef;
	
	@Autowired
	CoachesServices coachServiceRef;
	@RequestMapping("/adminpanel")
	public String showAdminPanel()
	{
		return "t_adminpanel";
	}
	@RequestMapping("/addEvent")
	public String addEvent(Model model,@ModelAttribute("eventModel") Events events,HttpSession session)
	{
		System.out.println("addEvents Request Mapped");
		List<Sports> sportsList= sportServiceRef.getAllSports();
		model.addAttribute("SportList", sportsList);
		return "t_addEvent";
	}
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
	@RequestMapping("/addNewCoaches")
	public String addNewCoaches(@ModelAttribute("coachModel") Coaches coach,HttpSession session)
	{
		System.out.println("addCoach Request Mapped");
		System.out.println(coach.toString());
		return "adminpanel";
	}
	@RequestMapping("/addCoaches")
	public String addCoachesShowForm(@ModelAttribute("coachModel") Coaches coach,HttpSession session)
	{
		return "t_addNewCoaches";
	}
	@RequestMapping("/ShowManageEvents")
	public String ShowManageEventsPage(Model model)
	{
		List<Events> eventList=new ArrayList<Events>();
		eventList=eventServiceRef.getAllEvents();
		model.addAttribute("AllEventList", eventList);
		return "t_manageevents";
		
	}
	@RequestMapping("/showOnMainPage")
	public String showOnMainPage(Model model, @RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		System.out.println("show On my page mapped");
		int id=Integer.parseInt(eventid);
		System.out.println("id is "+id);
		Events event=eventServiceRef.getEvent(id);
		event.setIsOnMainPage("y");
		eventServiceRef.updateEventsShow(event);
		List<Events> eventList=new ArrayList<Events>();
		eventList=eventServiceRef.getAllEventsToShow();
		model.addAttribute("updatedEvents",eventList);
		return "t_default";
	}
	//managing events 
	
	@RequestMapping("/deleteEvent")
	public String deleteEvent(Model model, @RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		System.out.println("got id"+eventid);
		int id=Integer.parseInt(eventid);
		Events eve=eventServiceRef.getEvent(id);
		eventServiceRef.DeleteEvent(eve);
		return "redirect:/admin/ShowManageEvents";
	}
	@RequestMapping("/editEvent")
	public String EditEvent(Model model,@ModelAttribute("E_MODEL")Events event,@RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		System.out.println("got id"+eventid);
		List<Sports> sportsList= sportServiceRef.getAllSports();
		model.addAttribute("SportList", sportsList);
		int id=Integer.parseInt(eventid);
		event=eventServiceRef.getEvent(id);
		model.addAttribute("Event",event);
		return "t_editevent";
	}
	@RequestMapping("/updateEvent")
	public String UpdateEvent(Model model,@ModelAttribute("E_MODEL")Events event,HttpSession session)
	{
		System.out.println(event);
		String date=event.getDate();
		String newDate=date.substring(0, 10);
		System.out.println("new Date is"+newDate);
		String year=newDate.substring(0,4);
		System.out.println("year "+year);
		String month=newDate.substring(5,7);
		System.out.println("month "+month);
		String day=newDate.substring(8,10);
		System.out.println("day "+day);
		event.setDate(newDate);
		String finalDate=day.concat(month).concat(year);
		System.out.println("final Date is "+finalDate);
		event.setDate(finalDate);
		eventServiceRef.updateCurrentEvent(event);
		return "redirect:/admin/ShowManageEvents";
	}
	@RequestMapping("/showEventOnMainPage")
	public String showEventOnMainPage(Model model, @RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		System.out.println("got id"+eventid);
		int id=Integer.parseInt(eventid);
		Events eve=new Events();
		eve.setId(id);
		eventServiceRef.updateEventsShow(eve);
		return "redirect:/admin/ShowManageEvents";
	}
	@RequestMapping("/hideOnMainPage")
	public String HideEventOnMainPage(Model model, @RequestParam(value="eventId", required=false) String eventid,HttpSession session)
	{
		int id=Integer.parseInt(eventid);
		Events eve=new Events();
		eve.setId(id);
		eventServiceRef.updateEventsHide(eve);
		System.out.println("got id"+eventid);
		return "redirect:/admin/ShowManageEvents";
	}
	@RequestMapping("/index")
	public String ShowHomePage()
	{
		return "t_index";
	}
	@RequestMapping("/SubToSendMail")
	public String SubToSendMail(Model model)
	{
		List<Subscriptions>endingsubList=subscriptionServiceRef.GetEndingSubscriptions();
		System.out.println("Ending Subs");
		for (Subscriptions subscriptions : endingsubList)
		{
			System.out.println(subscriptions.toString());
			System.out.println(subscriptions.getEndDate());
		}
		model.addAttribute("EndingSubscriptions", endingsubList);
		return "t_endingsubscriptions";
	}
	
	@RequestMapping("/postEnquiryAnswers")
	public String PostEnquiryAnswers(Model model)
	{
		List<Enquiry>enqList=enqServiceRef.getNonAnsweredEnquiry();
		model.addAttribute("EnqList",enqList);
		for (Enquiry enquiry : enqList)
		{
			System.out.println(enquiry);
		}
		return "t_postenqanswers";
	}
	@RequestMapping("/answerthis")
	public String EnterEnquiryAnswers(Model model,@RequestParam("enqId")String enqId,@ModelAttribute("ENQMODEL")Enquiry enqmodel)
	{
		int id=Integer.parseInt(enqId);
		Enquiry enq=enqServiceRef.getEnquiryForId(id);
		model.addAttribute("Enquiry", enq);
		return "t_showenteranswerform";
	}
	@RequestMapping("/saveAnswer")
	public String SaveEnquiryAnswers(Model model,@ModelAttribute("ENQMODEL")Enquiry enqmodel)
	{
		System.out.println("what we have");
		System.out.println(enqmodel);
		enqServiceRef.UpdateEnquiry(enqmodel);
		return "redirect:/admin/postEnquiryAnswers";
	} 
	@RequestMapping("/addSlotforSport")
	public String AddSlotForSport(Model model,@ModelAttribute("CHARGEMODEL") Charges charge)
	{
		List<Sports> sportList=sportServiceRef.getAllSports();
		model.addAttribute("SportList", sportList);
		return "t_addSlotforSport";
	}
	@RequestMapping("/enterslotdetails")
	public String EnterSlotDetails(Model model,@ModelAttribute("CHARGEMODEL") Charges charge)
	{
		charge.setIsActive("No");
		System.out.println(charge.toString());
		chargeServiceRef.AddCharges(charge);
		return "redirect:/admin/adminpanel";
	}
	@RequestMapping("/editSportsInfo")
	public String MakePackageActive(Model model,@ModelAttribute("CHARGEMODEL") Charges charge)
	{
		List<Sports> sportsList=new ArrayList<Sports>();
		List<Sports> outdoorsportsList=new ArrayList<Sports>();
		List<Sports> indoorsportsList=new ArrayList<Sports>();
		sportsList=sportServiceRef.getAllSports();
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
		return "t_selectsport";
	}
	@RequestMapping("/selectsport")
	public String EnterSlotDetails(Model model,@RequestParam("sportId")String sportId)
	{
		int id=Integer.parseInt(sportId);
		Sports sport=sportServiceRef.getSports(id);
		for (Charges charg : sport.getChargesList())
		{
			System.out.println(charg);
		}
		List<Charges> chargeList=sport.getChargesList();
		model.addAttribute("SelectedSport", sport);
		model.addAttribute("ChargeList", chargeList);
		return "t_editsport";
	}
	
	@RequestMapping("/editlocations")
	public String ShowEditLocationForm(Model model,@RequestParam("locationId")String LocationId,@ModelAttribute("LOCMODEL") Location loc)
	{
		int locId=Integer.parseInt(LocationId);
		Location location=locServiceRef.getLocation(locId);
		model.addAttribute("Location",location);
		return "t_editlocation";
	}
	@RequestMapping("/updateLocation")
	public String UpdateLocationForm(Model model,@ModelAttribute("LOCMODEL") Location loc)
	{
		System.out.println(loc.toString());
		locServiceRef.updateLocation(loc);
		return "redirect:/admin/editSportsInfo";
	}
	
	@RequestMapping("/editCharges")
	public String ShowEditChargesForm(Model model,@RequestParam("ChargesId")String ChargeId,@ModelAttribute("CHARGEMODEL") Charges Chargemodel)
	{
		int chargeId=Integer.parseInt(ChargeId);
		Charges charge=chargeServiceRef.getCharge(chargeId);
		model.addAttribute("Charge",charge);
		return "t_editCharge";
	}
	@RequestMapping("/updateCharges")
	public String UpdateChargesForm(Model model,@ModelAttribute("CHARGEMODEL") Charges Chargemodel)
	{
		
		System.out.println(Chargemodel.toString());
		chargeServiceRef.updateCharges(Chargemodel);
		return "redirect:/admin/editSportsInfo";
	}
	@RequestMapping("/editSlots")
	public String ShowEditSlotsForm(Model model,@RequestParam("SlotId")String slotId,@ModelAttribute("SLLOTMODEL") Slots slotmodel)
	{
		int Id=Integer.parseInt(slotId);
		Slots slot=slotServiceRef.getSlot(Id);
		model.addAttribute("Slot",slot);
		return "t_editSlot";
	}
	@RequestMapping("/updateSlot")
	public String UpdateSlot(Model model,@ModelAttribute("SLLOTMODEL") Slots slotmodel)
	{
		
		System.out.println(slotmodel.toString());
		slotServiceRef.updateSlots(slotmodel);
		return "redirect:/admin/editSportsInfo";
	}
	
	@RequestMapping("/addNewSlot")
	public String ShowAddNewSlotForm(Model model,@RequestParam("sportId")String sportId,@ModelAttribute("SLOTMODEL") Slots slotmodel)
	{
		System.out.println("Got Sport Id"+sportId);
		model.addAttribute("sportId", sportId);
		return "t_addNewSlot";
	}
	@RequestMapping("/AddSlot")
	public String addNewSLot(Model model,@ModelAttribute("SLOTMODEL") Slots slotmodel)
	{
		System.out.println(slotmodel);
		slotServiceRef.AddSlot(slotmodel);
		return "redirect:/admin/editSportsInfo";
	}
	@RequestMapping("/getEventAttenders")
	public String ShowEventAttenders(Model model,@RequestParam("eventId") String eventId)
	{
		int id=Integer.parseInt(eventId);
		Events event=eventServiceRef.getEvent(id);
		double totalCollection=0;
				for (EventAttenders attender : event.getAttenderList())
				{
					totalCollection=totalCollection+attender.getWillpay();
				}
		model.addAttribute("Events",event);
		model.addAttribute("TotalCollection",totalCollection);
		return "t_showeventAttenders";
		
	}
	@RequestMapping("/addsport")
	public String AddSport(Model model,@ModelAttribute("SPORT") Sports sport)
	{
		System.out.println(sport);
		sportServiceRef.AddSports(sport);
		return "t_adminpanel";
	}
	@RequestMapping("/addnewsport")
	public String AddNewSport(Model model,@ModelAttribute("SPORT") Sports sport)
	{
		return "t_showaddnewsport";
	}
	
	
	
	@RequestMapping("/addCharges")
	public String AddCharges(Model model,@RequestParam("SportId") String SportId,@ModelAttribute("CHARGEMODEL")Charges charges)
	{
		Sports sport=sportServiceRef.getSports(Integer.parseInt(SportId));
		model.addAttribute("Sport",sport);
		return "t_addChargesForSport";
	}
	@RequestMapping("/addNewCharges")
	public String AddCharges(Model model,@ModelAttribute("CHARGEMODEL")Charges charges)
	{
		System.out.println(charges);
		chargeServiceRef.AddCharges(charges);
		return "t_addChargesForSport";
	}
	@RequestMapping("/addtheNewCoaches")
	public String ShowAddCoaches(Model model,@RequestParam("sportId") String SportId,@ModelAttribute("COACHMODEL")Coaches coach)
	{
		Sports sport=sportServiceRef.getSports(Integer.parseInt(SportId));
		model.addAttribute("Sport",sport);
		return "t_addCoaches";
	}
	@RequestMapping("/addcoachtosport")
	public String AddCoachesToSport(Model model,@ModelAttribute("COACHMODEL")Coaches coach)
	{
		System.out.println(coach);
		coachServiceRef.addCoaches(coach);
		return "t_addCoaches";
	}
	@RequestMapping("/addLocations")
	public String ShowAddNewLocation(Model model,@RequestParam("sportId")String SportId,@ModelAttribute("LOCMODEL")Location loc)
	{
		Sports sport=sportServiceRef.getSports(Integer.parseInt(SportId));
		model.addAttribute("Sport",sport);
		return "t_showaddLocation";
	}
	@RequestMapping("/addLocation")
	public String AddNewLocation(Model model,@ModelAttribute("LOCMODEL")Location loc)
	{
		locServiceRef.addLocation(loc);
		return "t_adminpanel";
	}
	////Nevigation Links
	@RequestMapping("/allsports")
	public String showAllSports()
	{
		return "t_allsports";
	}
	@RequestMapping("/sendmail")
	public String showAllSports(@RequestParam("emailId")String emailId,@RequestParam("sportname")String sportName,@RequestParam("name")String recName)
	{
		 class SMTPAuthenticator extends javax.mail.Authenticator {
		    @Override
		    public PasswordAuthentication getPasswordAuthentication() 
		    {
		        String username =  "onlinesportsclubsid@gmail.com";           // your email id (sender's email id)
		        String password = "onlinesportsclub";            // your password here
		        return new PasswordAuthentication(username, password);
		    }
		}

		try
	    {
	        Properties props = System.getProperties();
	        
	          props.put("mail.transport.protocol", "smtp" );
	          props.put("mail.smtp.starttls.enable","true" );
	          props.put("mail.smtp.host","smtp.gmail.com");
	          props.put("mail.smtp.auth", "true" );
	          props.put("mail.smtp.port", "587");
	          props.put("mail.smtp.auth", "true");
	  		 props.put("mail.smtp.starttls.enable", "true");
	  		 
	  		 Authenticator auth = new SMTPAuthenticator();
	          Session session = Session.getInstance(props, auth);
	        
	          Message msg = new MimeMessage(session);
	          String message="Your Subscription for sport "+sportName+" will be over in next two days";
	          System.out.println(msg);
	          msg.setFrom(new InternetAddress("onlinesportsclubsid@gmail.com"));   // Your mail id
	          msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailId, false));  // recipients mail id
	          msg.setSubject("CITY-SPORTS-CLUB");  //subbject of mail
	          msg.setText(message);  // message body
	          //Calendar cal=Calendar.getInstance();
	          //cal.add(cal.DAY_OF_MONTH, 1);
	         
	          msg.setHeader("MyMail", "Mr. XYZ");  // headers
	          msg.setSentDate(new Date());
	        
	          Transport.send(msg);
	          System.out.println("Mail Sent :)");
	    }
	     catch (Exception ex)
	    {
	      ex.printStackTrace();
	      System.out.println("Exception "+ex);
	    }		
		
		return "t_adminpanel";
	}
	
}
