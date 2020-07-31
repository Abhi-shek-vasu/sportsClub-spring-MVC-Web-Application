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
import com.sports.entities.Slots;
import com.sports.entities.Sports;
@Repository
public class SlotDao
{
	@Autowired
	SessionFactory factory;
	@Transactional
	public void updateSlots(Slots slot)
	{
		Session session=factory.getCurrentSession();
		session.update(slot);
	}
	@Transactional
	public Slots getSlot(int id)
	{
		Session session=factory.getCurrentSession();
		return (Slots)session.get(Slots.class, id);
	}
	@Transactional
	public int AddSlot(Slots slot)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(slot);
	}

}
