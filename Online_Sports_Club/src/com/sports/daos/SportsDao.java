package com.sports.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Coaches;
import com.sports.entities.Sports;

@Repository
public class SportsDao
{
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public List<Sports> getAllSports()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Sports.class);
		return cr.list();
	}
	@Transactional
	public int AddSports(Sports sports)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(sports);
	}
	
	@Transactional
	public Sports getSports(int id)
	{
		Session session=factory.getCurrentSession();
		Sports item=(Sports) session.get(Sports.class, id);
		Hibernate.initialize(item.getCoachList());
		Hibernate.initialize(item.getLocationList());
		Hibernate.initialize(item.getChargesList());
		Hibernate.initialize(item.getSlotList());
		return item;
	}
	
	
}
