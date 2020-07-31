package com.sports.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Charges;
import com.sports.entities.Coaches;
import com.sports.entities.Sports;
@Repository
public class ChargesDao
{
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public List<Charges> getAllCharges()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Charges.class);
		return (List<Charges>)cr.list();
	}
	
	@Transactional
	public Charges getCharge(int id)
	{
		Session session=factory.getCurrentSession();
		return (Charges)session.get(Charges.class,id);
	}
	
	@Transactional
	public List<Charges> getChargesListForSport(int sportId)
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Charges.class);
		cr.add(Restrictions.eq("sports_id",sportId));
		return (List<Charges>)cr.list();
	}
	@Transactional
	public Charges getCurrentlyActiveCharges(int sportId)
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Charges.class);
		cr.add(Restrictions.eq("sports_id",sportId));
		cr.add(Restrictions.eq("isActive","yes"));
		return (Charges)cr.uniqueResult();
	}
	@Transactional
	public void updateCharges(Charges charge)
	{
		Session session=factory.getCurrentSession();
		session.update(charge);
	}
	@Transactional
	public int AddCharges(Charges charge)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(charge);
	}
}

