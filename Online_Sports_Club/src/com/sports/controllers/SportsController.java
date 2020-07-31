package com.sports.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sports.entities.Charges;
import com.sports.entities.Coaches;
import com.sports.entities.Location;
import com.sports.entities.Sports;
import com.sports.services.ChargesService;
import com.sports.services.SportsService;

@Controller
public class SportsController
{
	@Autowired
	SportsService sportsServiceRef;

	@Autowired
	ChargesService chargesServiceRef;
	
	@RequestMapping("allsports")
	public String ShowAllSports(Model model)
	{
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
		
		return "t_allsports";
	}
	@RequestMapping("/showSport")
	public String ShowSportDetails(Model model, @RequestParam(value="sportType", required=false) String sportType)
	{
		System.out.println("We have Request Parameter "+sportType);
		int sportId=Integer.parseInt(sportType);
		Sports sport=sportsServiceRef.getSports(sportId);
		Charges activeCharges=chargesServiceRef.getCurrentlyActiveCharges(sportId);
		
		System.out.println(sport.toString());
		for (Location loc : sport.getLocationList())
		{
			System.out.println(loc);
		}
		System.out.println("Printing Coaches");
		for (Coaches coach : sport.getCoachList())
		{
			System.out.println(coach);
		}
		model.addAttribute("SelectedSport", sport);
		model.addAttribute("selectedCharges", activeCharges);
		return "t_sportDetails";
	}
	
	
}
