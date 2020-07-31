package com.sports.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Events;
@Repository
public class EventsDao
{
	@Autowired
	public SessionFactory factory;
	

	@Transactional
	public int addEvent(Events e)
	{
		Session session=factory.getCurrentSession();
		int id=(int) session.save(e);
		System.out.println("Event Added with id="+id);
		return id;
	}
	
	@Transactional
	public List<Events> getAllEvents()
	{
		Session session=factory.getCurrentSession();
		List<Events> eventList=new ArrayList<Events>();
		Criteria cr=session.createCriteria(Events.class);
		eventList= cr.list();
		return eventList;
	}
	@Transactional
	public List<Events> getAllEventsToShow()
	{
		Session session=factory.getCurrentSession();
		List<Events> eventList=new ArrayList<Events>();
		Criteria cr=session.createCriteria(Events.class);
		cr.add(Restrictions.eq("isOnMainPage","ya"));
		eventList= cr.list();
		return eventList;
	}
	@Transactional
	public Events getEvent(int id)
	{
		Session session=factory.getCurrentSession();
		Events eve=(Events)session.get(Events.class,id);
		Hibernate.initialize(eve.getAttenderList());
		return eve;
	}
	@Transactional
	public void UpdateEventShow(Events eve)
	{
		Session session=factory.getCurrentSession();
		String query="update events set is_on_main_page=:p_res where event_id=:p_id";
		Query q=session.createSQLQuery(query);
		q.setInteger("p_id", eve.getId());
		q.setString("p_res", "ya");
		q.executeUpdate();
	}
	@Transactional
	public void UpdateEventHide(Events eve)
	{
		Session session=factory.getCurrentSession();
		String query="update events set is_on_main_page=:p_res where event_id=:p_id";
		Query q=session.createSQLQuery(query);
		q.setInteger("p_id", eve.getId());
		q.setString("p_res", "no");
		q.executeUpdate();
	}
	@Transactional
	public void UpdateCurrentEvent(Events eve)
	{
		Session session=factory.getCurrentSession();
		session.update(eve);
	}	
	@Transactional
	public void DeleteEvent(Events eve)
	{
		Session session=factory.getCurrentSession();
		session.delete(eve);
	}	

}
