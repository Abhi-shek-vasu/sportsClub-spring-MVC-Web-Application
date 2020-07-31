package com.sports.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="event_attenders")
public class EventAttenders
{
 @SequenceGenerator(name="idGen",sequenceName="attend_seq",allocationSize=1,initialValue=4)
 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
 @Id
 @Column(name="ID")      //                                  NOT NULL NUMBER(5)
 int id;
 @Column(name="NAME")      //                                         VARCHAR2(50)
 String name;
 @Column(name="EMAIL")       //                                       VARCHAR2(50)
 String email;
 @Column(name="WILLPAY")       //                                     NUMBER(5)
 double willpay;
 @Column(name="event_id") 
 int eventId;  
 @Column(name="mobile")
 String mobile;
 public EventAttenders()
 {
this(0, "","",0.0, 0,"");	 
 }
 public String getMobile()
{
	return mobile;
}
 public void setMobile(String mobile)
{
	this.mobile = mobile;
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
public String getEmail()
{
	return email;
}
public void setEmail(String email)
{
	this.email = email;
}
public double getWillpay()
{
	return willpay;
}
public void setWillpay(double willpay)
{
	this.willpay = willpay;
}
public int getEventId()
{
	return eventId;
}
public void setEventId(int eventId)
{
	this.eventId = eventId;
}
public EventAttenders(int id, String name, String email, double willpay,
		int eventId,String mobile)
{
	this.id = id;
	this.name = name;
	this.email = email;
	this.willpay = willpay;
	this.eventId = eventId;
	this.mobile=mobile;
}
@Override
public String toString()
{
	return "EventAttenders [id=" + id + ", name=" + name + ", email=" + email
			+ ", willpay=" + willpay + ", eventId=" + eventId + ", mobile="
			+ mobile + "]";
}

 
}
