package com.sports.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="LOCATION")
public class Location
{
	 @Id
	 @SequenceGenerator(name="idGen",sequenceName="loc_seq",allocationSize=1,initialValue=4)
	 @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	 @Column(name="LOC_ID")
	 int locId;
	 @Column(name="GROUND_NO")
	 String groundNo;
	 @Column(name="LOC_IN_CLUB")
	 String locInClub;
	 @Column(name="SPORT_ID")
	 int sportId;
	 public Location()
	{
		 this(0,"","",0);
	}	
	public Location(int locId, String groundNo, String locInClub, int sportId)
	{
		this.locId = locId;
		this.groundNo = groundNo;
		this.locInClub = locInClub;
		this.sportId = sportId;
	}
	public int getLocId()
	{
		return locId;
	}
	public void setLocId(int locId)
	{
		this.locId = locId;
	}
	public String getGroundNo()
	{
		return groundNo;
	}
	public void setGroundNo(String groundNo)
	{
		this.groundNo = groundNo;
	}
	public String getLocInClub()
	{
		return locInClub;
	}
	public void setLocInClub(String locInClub)
	{
		this.locInClub = locInClub;
	}
	public int getSportId()
	{
		return sportId;
	}
	public void setSportId(int sportId)
	{
		this.sportId = sportId;
	}
	
	@Override
	public String toString()
	{
		return "Location [locId=" + locId + ", groundNo=" + groundNo
				+ ", locInClub=" + locInClub + ", sportId=" + sportId + "]";
	}

}
