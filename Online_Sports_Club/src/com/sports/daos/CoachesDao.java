package com.sports.daos;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Coaches;

@Repository
public class CoachesDao
{
	@Autowired
	SessionFactory factory; 
	
	@Transactional
	public int addCoaches(Coaches ch)
	{
		Session session=factory.getCurrentSession();
		int id=(int)session.save(ch);
		return id;
	}
}
