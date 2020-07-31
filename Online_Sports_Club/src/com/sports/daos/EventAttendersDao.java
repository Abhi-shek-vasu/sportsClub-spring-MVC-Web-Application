package com.sports.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.EventAttenders;

@Repository
public class EventAttendersDao
{
	@Autowired
	SessionFactory factory;
	@Transactional
	public int addEventAttenders(EventAttenders attender)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(attender);
	}
	@Transactional
	public List<EventAttenders> getAllEventAttenders()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(EventAttenders.class);
		return cr.list();
	}

}
