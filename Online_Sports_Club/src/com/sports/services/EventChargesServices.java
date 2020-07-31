package com.sports.services;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.EventDao;
import com.sports.entities.EventCharges;

@Service
public class EventChargesServices
{
	@Autowired
	EventDao eventDaoRef;
	public int saveEventCharges(EventCharges eveCharges)
	{
		return eventDaoRef.saveEventCharges(eveCharges);
	}
	public EventCharges getEventCharges(int eventid)
	{
		return eventDaoRef.getEventCharges(eventid);
	}

}
