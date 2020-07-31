package com.sports.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.CoachesDao;
import com.sports.entities.Coaches;

@Service
public class CoachesServices
{
	@Autowired
	CoachesDao coachesDaoRef;
	
	public int addCoaches(Coaches ch)
	{
		return coachesDaoRef.addCoaches(ch); 
	}
}
