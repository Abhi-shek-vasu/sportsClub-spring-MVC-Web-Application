package com.sports.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table
public class Events
{
	@Id
	@SequenceGenerator(name="idGen",sequenceName="event_seq",allocationSize=1,initialValue=4)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="EVENT_ID")
	int id;
	@Column(name="RELATED_SPORT_ID")
	int relatedSportid;
	@Column(name="SPORT_NAME")
	String sportName;
	@Column(name="EVENT_DATE")
	String date;
	@Column(name="EVENT_DESC")
	String eventDesc;
	@Column(name="IS_ON_MAIN_PAGE")
	String isOnMainPage;
	 @Column(name="EVENT_TITLE") //                                        VARCHAR2(50)
	 String title;
	 @Column(name="EVENT_IMAGE") //                                        VARCHAR2(25)
	 String image; 
	@Column(name="capacity")
	int capacity;
	@Column(name="CHARGE_FOR_MEMBER")   //                               NUMBER(6)
	double chargeForMember;
	@Column(name="CHARGE_NON_MEMBER") //                                  NUMBER(6)
	double chargeForNonMember;
	@OneToMany(mappedBy="eventId",fetch=FetchType.LAZY)
	List<EventAttenders> attenderList;
	public Events()
	{
		this(0,0,"","","","","","",0,0,0);
		this.attenderList=new ArrayList<EventAttenders>();
	}
	public Events(int id, int relatedSportid, String sportName, String date,
			String eventDesc,String isOnMainPage,String title,String image,int cap,double memCharge,double nonmemcharge)
	{
		this.id = id;
		this.relatedSportid = relatedSportid;
		this.sportName = sportName;
		this.date = date;
		this.eventDesc = eventDesc;
		this.isOnMainPage=isOnMainPage;
		this.title=title;
		this.image=image;
		this.capacity=cap;
		this.chargeForMember=memCharge;
		this.chargeForNonMember=nonmemcharge;
		this.attenderList=new ArrayList<EventAttenders>();
	}
	public List<EventAttenders> getAttenderList()
	{
		return attenderList;
	}
	public void setAttenderList(List<EventAttenders> attenderList)
	{
		this.attenderList = attenderList;
	}
	public double getChargeForMember()
	{
		return chargeForMember;
	}
	public void setChargeForMember(double chargeForMember)
	{
		this.chargeForMember = chargeForMember;
	}
	public double getChargeForNonMember()
	{
		return chargeForNonMember;
	}
	public void setChargeForNonMember(double chargeForNonMember)
	{
		this.chargeForNonMember = chargeForNonMember;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	public String getImage()
	{
		return image;
	}
	public void setImage(String image)
	{
		this.image = image;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getRelatedSportid()
	{
		return relatedSportid;
	}
	public void setRelatedSportid(int relatedSportid)
	{
		this.relatedSportid = relatedSportid;
	}
	public String getSportName()
	{
		return sportName;
	}
	public void setSportName(String sportName)
	{
		this.sportName = sportName;
	}
	public String getDate()
	{
		return date;
	}
	public void setDate(String date)
	{
		this.date = date;
	}
	public String getEventDesc()
	{
		return eventDesc;
	}
	public void setEventDesc(String eventDesc)
	{
		this.eventDesc = eventDesc;
	}
	public void setIsOnMainPage(String isOnMainPage)
	{
		this.isOnMainPage = isOnMainPage;
	}
	public String getIsOnMainPage()
	{
		return isOnMainPage;
	}
	@Override
	public String toString()
	{
		return "Events [id=" + id + ", relatedSportid=" + relatedSportid
				+ ", sportName=" + sportName + ", date=" + date
				+ ", eventDesc=" + eventDesc + ", isOnMainPage=" + isOnMainPage
				+ ", title=" + title + ", image=" + image + ", capacity="
				+ capacity + ", chargeForMember=" + chargeForMember
				+ ", chargeForNonMember=" + chargeForNonMember + "]";
	}
	
	
}
