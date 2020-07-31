package com.sports.entities;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="SPORTS")
@Entity
public class Sports
{
	@SequenceGenerator(name="idGen",sequenceName="sport_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Id
	@Column(name="SPORT_ID")
	int id;
	@Column(name="SPORT_NAME")
	String sportName;
	@Column(name="SPORT_TYPE")
	String sportType;
	@Column(name="SPORT_DESC")
	String sportDesc;
	@Column(name="CHARGES_ID")
	int chargesId;
	@Column(name="CAPACITY")
	int capacity;
	@Column(name="SPORT_IMAGE")
	String sportImage;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sportId")
	List<Location> locationList;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "sports_id")
	List<Charges> chargesList;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sport_id")
	List<Coaches> coachList;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sport")
	List<Subscriptions> subscriptionList;
	@OneToMany(fetch=FetchType.LAZY,mappedBy="sportId")
	List<Slots> slotList;
	
	public Sports()
	{
		this(0,"","","",0,0,"");
		this.locationList=new ArrayList<Location>();
		this.chargesList=new ArrayList<Charges>();
		this.coachList=new ArrayList<Coaches>();
		this.subscriptionList=new ArrayList<Subscriptions>();
		this.slotList=new ArrayList<Slots>();
	}
	public Sports(int id, String sportName, String sportType, String sportDesc,
			int chargesId,int capacity,String sportImage)
	{
		this.id = id;
		this.sportName = sportName;
		this.sportType = sportType;
		this.sportDesc = sportDesc;
		this.chargesId = chargesId;
		this.capacity=capacity;
		this.sportImage=sportImage;
		this.locationList=new ArrayList<Location>();
		this.chargesList=new ArrayList<Charges>();
		this.coachList=new ArrayList<Coaches>();
		this.subscriptionList=new ArrayList<Subscriptions>();
		this.slotList=new ArrayList<Slots>();
	}
	public List<Slots> getSlotList()
	{
		return slotList;
	}
	public void setSlotList(List<Slots> slotList)
	{
		this.slotList = slotList;
	}
	public List<Subscriptions> getSubscriptionList()
	{
		return subscriptionList;
	}
	public void setSubscriptionList(List<Subscriptions> subscriptionList)
	{
		this.subscriptionList = subscriptionList;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getSportName()
	{
		return sportName;
	}
	public void setSportName(String sportName)
	{
		this.sportName = sportName;
	}
	public String getSportType()
	{
		return sportType;
	}
	public void setSportType(String sportType)
	{
		this.sportType = sportType;
	}
	public String getSportDesc()
	{
		return sportDesc;
	}
	public void setSportDesc(String sportDesc)
	{
		this.sportDesc = sportDesc;
	}
	public int getChargesId()
	{
		return chargesId;
	}
	public void setChargesId(int chargesId)
	{
		this.chargesId = chargesId;
	}
	public int getCapacity()
	{
		return capacity;
	}
	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
	public List<Location> getLocationList()
	{
		return locationList;
	}
	public void setLocationList(List<Location> locationList)
	{
		this.locationList = locationList;
	}
	public List<Charges> getChargesList()
	{
		return chargesList;
	}
	public void setChargesList(List<Charges> chargesList)
	{
		this.chargesList = chargesList;
	}
	public List<Coaches> getCoachList()
	{
		return coachList;
	}
	public void setCoachList(List<Coaches> coachList)
	{
		this.coachList = coachList;
	}
	public String getSportImage()
	{
		return sportImage;
	}
	public void setSportImage(String sportImage)
	{
		this.sportImage = sportImage;
	}
	@Override
	public String toString()
	{
		return "Sports [id=" + id + ", sportName=" + sportName + ", sportType="
				+ sportType + ", sportDesc=" + sportDesc + ", chargesId="
				+ chargesId + "]";
	}
}
