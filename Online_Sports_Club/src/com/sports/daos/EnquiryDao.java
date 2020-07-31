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
import com.sports.entities.Enquiry;
import com.sports.entities.Sports;
@Repository
public class EnquiryDao
{
	@Autowired
	SessionFactory factory;
	@Transactional
	public List<Enquiry> getAllEnquiry()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Enquiry.class);
		return cr.list();
	}
	@Transactional
	public int SaveEnquiry(Enquiry enq)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(enq);
	}
	@Transactional
	public List<Enquiry> getNonAnsweredEnquiry()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Enquiry.class);
		String str="NOT_ANSWERED";
		cr.add(Restrictions.eq("answer", str));
		return cr.list();
	}
	@Transactional
	public List<Enquiry> getAllAnsweredEnquiry()
	{
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Enquiry.class);
		String str="NOT_ANSWERED";
		cr.add(Restrictions.ne("answer", str));
		return cr.list();
	}
	@Transactional
	public Enquiry getEnquiryForId(int id)
	{
		Session session=factory.getCurrentSession();
		return (Enquiry)session.get(Enquiry.class, id);	
	}
	@Transactional
	public void UpdateEnquiry(Enquiry enq)
	{
		Session session=factory.getCurrentSession();
		session.update(enq);;	
	}
}
