package com.sports.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.daos.MembersDao;
import com.sports.entities.Members;
import com.sports.entities.UserRoles;

@Service
public class MemberService
{
	@Autowired
	MembersDao memberDaoRef;
	
	public Members validate(String email,String pass)
	{
		return memberDaoRef.validate(email, pass);
	}
	public int addUserRole(UserRoles uRoles)
	{
		return memberDaoRef.addUserRole(uRoles);
	}
	public int addMember(Members member)
	{
		return memberDaoRef.addUser(member);
	}
	public Members getUser(String email)
	{
		return memberDaoRef.getUser(email);
	}
	public void UpdateUser(Members mem)
	{
		memberDaoRef.UpdateUser(mem);
	}
	
}
