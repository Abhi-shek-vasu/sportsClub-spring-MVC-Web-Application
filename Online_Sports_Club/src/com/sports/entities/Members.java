package com.sports.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="users")
@Entity
public class Members
{
    @Id
 	@SequenceGenerator(name="idGen",sequenceName="user_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="USER_ID")//                                   NOT NULL NUMBER(5)
	 int id;
	 @Column(name="NAME")     //                                          VARCHAR2(50)
	 String name;
	 @Column(name="AGE")        //                                        NUMBER(3)
	 int age;
	 @Column(name="GENDER")       //                                      VARCHAR2(10)
	 String gender;
	 @Column(name="EMAIL")          //                                    VARCHAR2(256)
	 String email;
	 @Column(name="ADDRESS")          //                                  VARCHAR2(200)
	 String address;
	 @Column(name="ROLE")               //                                VARCHAR2(15)
	 String role;
	@Column(name="PASSWORD")
	String password;
	@Column(name="USER_IMAGE")
	String userImage;
	@Column(name="IS_MEMBER")
	String isMember;
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "member")
	UserRoles userRoles;
	@OneToMany(fetch=FetchType.EAGER,mappedBy="member")
	List<Subscriptions> subscriptionList;
	
	 public Members()
	 {
		 this(0,"",0,"","","","","","","");
		 this.userRoles=new UserRoles();
		 this.subscriptionList=new ArrayList<Subscriptions>();
	 }
	public Members(int id, String name, int age, String gender,
			String email, String address, String role,String password,String userImage,String isMember)
	{
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.address = address;
		this.role = role;
		this.password=password;
		 this.userRoles=new UserRoles();
		 this.userImage=userImage;
		 this.subscriptionList=new ArrayList<Subscriptions>();
		 this.isMember=isMember;
	}
	public String getIsMember()
	{
		return isMember;
	}
	public void setIsMember(String isMember)
	{
		this.isMember = isMember;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getAge()
	{
		return age;
	}
	public void setAge(int age)
	{
		this.age = age;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public String getRole()
	{
		return role;
	}
	public void setRole(String role)
	{
		this.role = role;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public UserRoles getUserRoles()
	{
		return userRoles;
	}
	public void setUserRoles(UserRoles userRoles)
	{
		this.userRoles = userRoles;
	}
	public String getUserImage()
	{
		return userImage;
	}
	public void setUserImage(String userImage)
	{
		this.userImage = userImage;
	}
	public List<Subscriptions> getSubscriptionList()
	{
		return subscriptionList;
	}
	public void setSubscriptionList(List<Subscriptions> subscriptionList)
	{
		this.subscriptionList = subscriptionList;
	}
	@Override
	public String toString()
	{
		return "MemberController [id=" + id + ", name=" + name + ", age=" + age
				+ ", gender=" + gender + ", email=" + email + ", address="
				+ address + ", role=" + role + "]";
	}
	 
}
