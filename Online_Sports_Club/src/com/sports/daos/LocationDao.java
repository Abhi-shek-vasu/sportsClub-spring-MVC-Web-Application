package com.sports.daos;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Location;
@Repository
public class LocationDao
{
	@Autowired
	SessionFactory factory;
	@Transactional
	public void updateLocation(Location loc)
	{
		Session session=factory.getCurrentSession();
		session.update(loc);
	}
	
	@Transactional
	public Location getLocation(int id)
	{
		Session session=factory.getCurrentSession();
		return (Location)session.get(Location.class, id);
	}
	@Transactional
	public int AddLocation(Location loc)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(loc);
	}

}
