package com.sports.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.LocationDao;
import com.sports.entities.Location;

@Service
public class LocationServices
{
	@Autowired
	LocationDao locDaoRef;
	public void updateLocation(Location loc)
	{
		locDaoRef.updateLocation(loc);
	}
	public Location getLocation(int id)
	{
		return locDaoRef.getLocation(id);
	}
	public int addLocation(Location loc)
	{
		return locDaoRef.AddLocation(loc);
	}
}
