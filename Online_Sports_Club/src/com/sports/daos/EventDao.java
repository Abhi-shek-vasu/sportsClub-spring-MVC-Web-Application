package com.sports.daos;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.EventCharges;

@Repository
public class EventDao
{
	@Autowired
	SessionFactory factory;
	@Transactional
	public int saveEventCharges(EventCharges eveCharges)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(eveCharges);
	}
	@Transactional
	public EventCharges getEventCharges(int eventid)
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(EventCharges.class);
		cr.add(Restrictions.eq("eventId", eventid));
		return (EventCharges)cr.uniqueResult();
	}


}
