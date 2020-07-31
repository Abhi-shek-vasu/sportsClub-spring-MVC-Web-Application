package com.sports.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.sports.entities.Events;
import com.sports.services.EventsService;
import com.sports.utility.DateManupulate;

@ControllerAdvice
public class GlobalControllerAdvice
{
	
	@Autowired
	EventsService eventServiceRef1;
	
  @ModelAttribute
  public void myMethod(Model model) 
  {
	  System.out.println("mymethod invoked");
	 List<Events>mainevents= eventServiceRef1.getAllEventsToShow();
	for (Events events : mainevents)
 	{
		String date=DateManupulate.getReadableDate(events.getDate());
		events.setDate(date);
	}
	 model.addAttribute("MainEvents", mainevents);
  }
}
