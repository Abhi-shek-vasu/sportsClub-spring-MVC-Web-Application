package com.sports.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.EventsDao;
import com.sports.entities.Events;

@Service
public class EventsService
{
	@Autowired
	EventsDao eventsDaoRef;
	
	public int addEvent(Events e)
	{
		return eventsDaoRef.addEvent(e);
	}
	public List<Events>getAllEvents()
	{
		return eventsDaoRef.getAllEvents();
	}
	public List<Events>getAllEventsToShow()
	{
		return eventsDaoRef.getAllEventsToShow();
	}
	public void updateEventsShow(Events eve)
	{
		eventsDaoRef.UpdateEventShow(eve);
	}
	public void updateEventsHide(Events eve)
	{
		eventsDaoRef.UpdateEventHide(eve);
	}
	public Events getEvent(int id)
	{
		return eventsDaoRef.getEvent(id);
	}
	public void updateCurrentEvent(Events eve)
	{
		eventsDaoRef.UpdateCurrentEvent(eve);
	}
	public void DeleteEvent(Events eve)
	{
		eventsDaoRef.DeleteEvent(eve);;
	}
}
