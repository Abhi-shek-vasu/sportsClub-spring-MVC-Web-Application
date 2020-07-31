package com.sports.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.daos.SlotDao;
import com.sports.entities.Slots;

@Repository
public class SlotServices
{
	@Autowired
	SlotDao slotDaoRef;
	
	public void updateSlots(Slots slot)
	{
		slotDaoRef.updateSlots(slot);
	}
	
	public Slots getSlot(int id)
	{
		return slotDaoRef.getSlot(id);
	}
	public int AddSlot(Slots slot)
	{
		return slotDaoRef.AddSlot(slot);
	}
}
