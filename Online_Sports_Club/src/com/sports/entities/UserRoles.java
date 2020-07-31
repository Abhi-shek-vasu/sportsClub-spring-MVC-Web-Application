package com.sports.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="USER_ROLES")
public class UserRoles
{
	
	@Id
	@SequenceGenerator(name="idGen",sequenceName="user_roles_seq",allocationSize=1,initialValue=3)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="USER_ROLE_ID")
	int userRoleId;
	@Column(name="EMAIL")
	String email;
	@Column(name="ROLE")
	String role;
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	Members member;

	public UserRoles()
	{
		this.userRoleId=0;
		this.email="";
		this.role="ROLE_USER";
	}
	public UserRoles(int userRoleId, String email, String role)
	{
		this.userRoleId = userRoleId;
		this.email = email;
		this.role = role;
	}
	public int getUserRoleId()
	{
		return userRoleId;
	}
	public void setUserRoleId(int userRoleId)
	{
		this.userRoleId = userRoleId;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	@Override
	public String toString()
	{
		return "UserRoles [userRoleId=" + userRoleId + ", email=" + email
				+ ", role=" + role + "]";
	}
	
	
}
