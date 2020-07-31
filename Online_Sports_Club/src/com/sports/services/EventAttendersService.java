package com.sports.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.daos.EventAttendersDao;
import com.sports.entities.EventAttenders;

@Service
public class EventAttendersService
{
	@Autowired
	EventAttendersDao eveAttenDao;
	public int addEventAttenders(EventAttenders attender)
	{
		return eveAttenDao.addEventAttenders(attender);
	}
	public List<EventAttenders> getAllEventAttenders()
	{
		return eveAttenDao.getAllEventAttenders();
	}

}
