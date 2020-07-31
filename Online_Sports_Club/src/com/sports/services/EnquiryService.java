package com.sports.services;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sports.daos.EnquiryDao;
import com.sports.entities.Enquiry;

@Service
public class EnquiryService
{
	@Autowired
	EnquiryDao enquiryDaoRef;
	
	public List<Enquiry> getAllEnquiry()
	{
		return enquiryDaoRef.getAllEnquiry();
	}
	public int SaveEnquiry(Enquiry enq)
	{
		return enquiryDaoRef.SaveEnquiry(enq);
	}
	public List<Enquiry> getNonAnsweredEnquiry()
	{
		return enquiryDaoRef.getNonAnsweredEnquiry();
	}
	public Enquiry getEnquiryForId(int id)
	{
		return enquiryDaoRef.getEnquiryForId(id);	
	}
	public void UpdateEnquiry(Enquiry enq)
	{
		enquiryDaoRef.UpdateEnquiry(enq);
	}
	public List<Enquiry> getAllAnsweredEnquiry()
	{
		return enquiryDaoRef.getAllAnsweredEnquiry();
	}
}
