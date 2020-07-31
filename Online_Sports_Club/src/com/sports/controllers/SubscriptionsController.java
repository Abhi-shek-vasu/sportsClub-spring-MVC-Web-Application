package com.sports.controllers;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import oracle.sql.DATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.entities.Charges;
import com.sports.entities.Events;
import com.sports.entities.Members;
import com.sports.entities.Slots;
import com.sports.entities.Sports;
import com.sports.entities.Subscriptions;
import com.sports.models.Payment;
import com.sports.models.SubData;
import com.sports.services.ChargesService;
import com.sports.services.MemberService;
import com.sports.services.SlotServices;
import com.sports.services.SportsService;
import com.sports.services.SubscriptionsService;
import com.sports.utility.DateManupulate;

@Controller
public class SubscriptionsController
{
	@Autowired
	SubscriptionsService subscriptionServiceRef;
	
	@Autowired
	MemberService memberServiceRef;
	
	@Autowired
	SportsService sportsServiceRef;
	
	@Autowired
	ChargesService chargesServiceRef;
	
	@Autowired
	SlotServices slotServiceRef;
	
	@RequestMapping("/getSlots")
	 public String GotoSubscriptions(Model model,@RequestParam(value="sportId")String sportId,@ModelAttribute("command")SubData data, HttpSession session)
	 {
		 if(session.getAttribute("username")==null)
			 return "t_index";
		 else
		 {
			System.out.println("got sport id"+sportId);
			int id=Integer.parseInt(sportId);
			Sports sport=sportsServiceRef.getSports(id);
			Charges charges=chargesServiceRef.getCurrentlyActiveCharges(id);
			
			model.addAttribute("SelectedSport",sport);
			model.addAttribute("selectedCharges",charges);
			session.setAttribute("SelectedSportId",id);
			//List<Subscriptions>subscriptionList=subscriptionServiceRef.getSubscriptionForSport(id);
			List<Subscriptions>subscriptionList=sport.getSubscriptionList();
			model.addAttribute("SportForSubscription",subscriptionList);
			model.addAttribute("SubscriptionList",subscriptionList);
			return "t_getSlots";
		 }
	 }
 
	@RequestMapping("/mapselectedslot")
	 public String MapSelectedSlot(Model model,@ModelAttribute("command") SubData data,HttpSession session)
	 {
		System.out.println(data);
		int sportId=(int)session.getAttribute("SelectedSportId");
		Sports sport=sportsServiceRef.getSports(sportId);
		Charges charges=chargesServiceRef.getCurrentlyActiveCharges(sportId);
		System.out.println(charges);
		Subscriptions subscriptions=new Subscriptions();
		Members member=memberServiceRef.getUser((String)session.getAttribute("email"));
		//subscriptions.setMemberId(member.getId());
		subscriptions.setMember(member);
		subscriptions.setStartDate(DateManupulate.getStringDate(data.getDateTime()));
		subscriptions.setSport(sport);
		subscriptions.setSubType(data.getPack());
		
		
			subscriptions.setSlotId(data.getSlotId());
			if(data.getPack().equals("monthly"))
			{
				member.setIsMember("true");
				subscriptions.setPaidAmount(charges.getMemberMonthly());
				subscriptions.setEndDate(DateManupulate.getNewMonthDate(data.getDateTime()));
			}
			else if(data.getPack().equals("yearly"))
			{
				member.setIsMember("true");
				subscriptions.setPaidAmount(charges.getMemberYearly());
				subscriptions.setEndDate(DateManupulate.getNextYear(data.getDateTime()));
			}
			else if(data.getPack().equals("quarterYearly"))
			{
				member.setIsMember("true");
				subscriptions.setPaidAmount(charges.getMemberQuarterly());
				subscriptions.setEndDate(DateManupulate.getNewMonthDateNextQuarter(data.getDateTime()));
			}
			else if(data.getPack().equals("halfyearly"))
			{
				member.setIsMember("true");
				subscriptions.setPaidAmount(charges.getMemberHalfYearly());
				subscriptions.setEndDate(DateManupulate.getNextHalfYear(data.getDateTime()));
			}
			else if(data.getPack().equals("daily"))
			{
				member.setIsMember("false");
				for (Subscriptions sub : member.getSubscriptionList())
				{
					if(sub.getSubType().equals("monthly")||sub.getSubType().equals("quarterYearly")||sub.getSubType().equals("halfyearly")||sub.getSubType().equals("yearly"))
					{
						member.setIsMember("true");
					}
				}
				
				subscriptions.setPaidAmount(charges.getNonMemberDaily());
				subscriptions.setEndDate(DateManupulate.getNextDay(data.getDateTime()));
			}
		System.out.println(member);
		System.out.println(subscriptions);
		session.setAttribute("SubscriptionData", subscriptions);
		session.setAttribute("MemberDetails", member);
		 return "t_fillpayment";
	 }
	
	@RequestMapping("/donepayment")
	 public String DonePayment(Model model,HttpSession session)
	 {
		Subscriptions subscriptions=(Subscriptions)session.getAttribute("SubscriptionData");
		Members member=(Members)session.getAttribute("MemberDetails");
		System.out.println("Inside done payment");
		System.out.println(subscriptions);
		int slotId=subscriptions.getSlotId();
		Slots slot=slotServiceRef.getSlot(slotId);
		//int occupiedslots=slot.getOccupiedSlots();
		//int capacity=slot.getSlotCapacity();
		//int available=slot.getAvailabeSlots();
		slot.setAvailabeSlots(slot.getAvailabeSlots()-1);
		slot.setOccupiedSlots(slot.getOccupiedSlots()+1);
		slotServiceRef.updateSlots(slot);
		System.out.println(subscriptions);
		int i=subscriptionServiceRef.addSubscriptions(subscriptions);
		memberServiceRef.UpdateUser(member);
		return "t_subscriptions";
	 }
	
}
