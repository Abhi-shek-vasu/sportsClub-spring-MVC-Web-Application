package com.sports.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.daos.ChargesDao;
import com.sports.daos.SportsDao;
import com.sports.entities.Charges;
import com.sports.entities.Sports;

@Service
public class ChargesService
{
		@Autowired
		ChargesDao chargesDaoRef;
		
		public List<Charges> getAllCharges()
		{
			return chargesDaoRef.getAllCharges();
		}
		
		public Charges getCharge(int id)
		{
			return chargesDaoRef.getCharge(id);
		}	
		public List<Charges> getChargesListForSport(int sportId)
		{
			return chargesDaoRef.getChargesListForSport(sportId);
		}
		public Charges getCurrentlyActiveCharges(int sportId)
		{
			return chargesDaoRef.getCurrentlyActiveCharges(sportId);
		}
		public void updateCharges(Charges charge)
		{
			chargesDaoRef.updateCharges(charge);
		}
		public int AddCharges(Charges charge)
		{
			return chargesDaoRef.AddCharges(charge);
		}
	
}
