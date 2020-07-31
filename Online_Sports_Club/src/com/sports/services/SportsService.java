package com.sports.services;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.SportsDao;
import com.sports.entities.Sports;

@Service
public class SportsService
{
	@Autowired
	SportsDao sportDaoRef;
	
	public List<Sports> getAllSports()
	{
		return this.sportDaoRef.getAllSports();
	}

	public Sports getSports(int id)
	{
		return this.sportDaoRef.getSports(id);
	}
	
	public int AddSports(Sports sports)
	{
		return sportDaoRef.AddSports(sports);
	}
	
}
