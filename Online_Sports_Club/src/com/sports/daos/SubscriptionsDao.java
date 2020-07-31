package com.sports.daos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Subscriptions;

@Repository
public class SubscriptionsDao
{
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public int addSubscription(Subscriptions sub)
	{
		Session session= factory.getCurrentSession();
		int id=(int)session.save(sub);
		return id;
	}
	@Transactional
	public List<Subscriptions> getSubscriptions()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Subscriptions.class);
		return (List<Subscriptions>)cr.list();
	}
	@Transactional
	public Subscriptions getSubscriptionsForSubID(int id)
	{
		Session session=factory.getCurrentSession();
		Subscriptions subscriptions=(Subscriptions)session.get(Subscriptions.class, id);
		return subscriptions;
	}
	@Transactional
	public List<Subscriptions> getSubscriptionsForGivenSport(int sportId)
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Subscriptions.class);
		cr.add(Restrictions.eq("sportsId", sportId));
		return (List<Subscriptions>)cr.list();
	
	}
	@Transactional
	public List<Subscriptions> GetEndingSubscriptions()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Subscriptions.class);
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		cal.add(Calendar.DAY_OF_MONTH, 2);
		Date date1 = cal.getTime();
		String today =dateFormat.format(date1);
		System.out.println("date to check is"+today);
		cr.add(Restrictions.eq("endDate", today));
		return (List<Subscriptions>)cr.list();
	}
	
}
