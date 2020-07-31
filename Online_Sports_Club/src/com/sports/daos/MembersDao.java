package com.sports.daos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sports.entities.Members;
import com.sports.entities.UserRoles;

@Repository
public class MembersDao
{
	@Autowired
	SessionFactory factory;
	
	@Transactional
	public Members validate(String email,String pass)
	{
		System.out.println("user"+email+"pass"+pass);
		Session session=factory.getCurrentSession();
		Criteria cr=session.createCriteria(Members.class);
		cr.add(Restrictions.eq("email",email));
		cr.add(Restrictions.eq("password",pass));
		List<Members>memberList= new ArrayList<Members>();
		memberList=cr.list();
		int count=0;
		for (Members members : memberList)
		{
			if(members!=null)
				count++;
		}
		if(count==1)
			return memberList.get(0);
		else
			return null;
	}
	@Transactional
	public int addUserRole(UserRoles uRoles)
	{
		Session session=factory.getCurrentSession();
		return (int)session.save(uRoles);
	}
	@Transactional
	public int addUser(Members mem)
	{
		Session session=factory.getCurrentSession();
		int id=(int)session.save(mem);
		return id;
	}
	@Transactional
	public void UpdateUser(Members mem)
	{
		Session session=factory.getCurrentSession();
		session.saveOrUpdate(mem);
	}
	@Transactional
	public Members getUser(String email)
	{
		Session session=factory.getCurrentSession();
		Criteria criteria=session.createCriteria(Members.class);
		criteria.add(Restrictions.eq("email",email));
		return (Members) criteria.uniqueResult();
	}
}
