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
@Table
public class Charges
{
	@SequenceGenerator(name="idGen",sequenceName="charge_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="CHARGE_ID")//                                          NUMBER(3)
	@Id
	int id;
	@Column(name="SPORT_ID")//                                           NUMBER(3)
	int sports_id;
	@Column(name="MAX_TIME")//                                           VARCHAR2(30)
	String maxTime;
	@Column(name="AVAILABLE_TIME")//                                     VARCHAR2(30)
	String availableTime;
	@Column(name="MEMBER_DAILY")//                                       NUMBER(8,2)
	double memberDaily;
	@Column(name="MEMBER_MONTHLY")//                                     NUMBER(8,2)
	double memberMonthly;
	@Column(name="NON_MEMBER_DAILY")//                                   NUMBER(8,2)
	double nonMemberDaily;
	@Column(name="NON_MEMBER_MONTHLY")//                                 NUMBER(8,2)
	double nonMemberMonthly;
	@Column(name="MEMBER_YEARLY")//                                      NUMBER(10,2)
	double memberYearly;
	@Column(name="MEMBER_QUARTERLY")//                                   NUMBER(10,2)
	double memberQuarterly;
	@Column(name="MEMBER_HALF_YEARLY")       //                                 NUMBER(10,2)
	double memberHalfYearly;		
	@Column(name="IS_ACTIVE") //                                          VARCHAR2(4)
	String isActive;
	@Column(name="SPACIALITY")//                                         VARCHAR2(50)
	String Spaciality;
	public Charges()
	{
		this(0,0,"","",0.0,0.0,0.0,0.0,0.0,0.0,0.0,"","");
	}
	public Charges(int id, int sports_id, String maxTime, String availableTime,
			double memberDaily, double memberMonthly, double nonMemberDaily,
			double nonMemberMonthly, double memberYearly,
			double memberQuarterly, double memberHalfYearly, String isActive,String spaciality)
	{
		this.id = id;
		this.sports_id = sports_id;
		this.maxTime = maxTime;
		this.availableTime = availableTime;
		this.memberDaily = memberDaily;
		this.memberMonthly = memberMonthly;
		this.nonMemberDaily = nonMemberDaily;
		this.nonMemberMonthly = nonMemberMonthly;
		this.memberYearly = memberYearly;
		this.memberQuarterly = memberQuarterly;
		this.memberHalfYearly = memberHalfYearly;
		this.isActive = isActive;
		this.Spaciality=spaciality;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getSports_id()
	{
		return sports_id;
	}
	public void setSports_id(int sports_id)
	{
		this.sports_id = sports_id;
	}
	public String getSpaciality()
	{
		return Spaciality;
	}
	public void setSpaciality(String spaciality)
	{
		Spaciality = spaciality;
	}
	public String getMaxTime()
	{
		return maxTime;
	}
	public void setMaxTime(String maxTime)
	{
		this.maxTime = maxTime;
	}
	public String getAvailableTime()
	{
		return availableTime;
	}
	public void setAvailableTime(String availableTime)
	{
		this.availableTime = availableTime;
	}
	public double getMemberDaily()
	{
		return memberDaily;
	}
	public void setMemberDaily(double memberDaily)
	{
		this.memberDaily = memberDaily;
	}
	public double getMemberMonthly()
	{
		return memberMonthly;
	}
	public void setMemberMonthly(double memberMonthly)
	{
		this.memberMonthly = memberMonthly;
	}
	public double getNonMemberDaily()
	{
		return nonMemberDaily;
	}
	public void setNonMemberDaily(double nonMemberDaily)
	{
		this.nonMemberDaily = nonMemberDaily;
	}
	public double getNonMemberMonthly()
	{
		return nonMemberMonthly;
	}
	public void setNonMemberMonthly(double nonMemberMonthly)
	{
		this.nonMemberMonthly = nonMemberMonthly;
	}
	public double getMemberYearly()
	{
		return memberYearly;
	}
	public void setMemberYearly(double memberYearly)
	{
		this.memberYearly = memberYearly;
	}
	public double getMemberQuarterly()
	{
		return memberQuarterly;
	}
	public void setMemberQuarterly(double memberQuarterly)
	{
		this.memberQuarterly = memberQuarterly;
	}
	public double getMemberHalfYearly()
	{
		return memberHalfYearly;
	}
	public void setMemberHalfYearly(double memberHalfYearly)
	{
		this.memberHalfYearly = memberHalfYearly;
	}
	public String getIsActive()
	{
		return isActive;
	}
	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}
	@Override
	public String toString()
	{
		return "Charges [id=" + id + ", sports_id=" + sports_id + ", maxTime="
				+ maxTime + ", availableTime=" + availableTime
				+ ", memberDaily=" + memberDaily + ", memberMonthly="
				+ memberMonthly + ", nonMemberDaily=" + nonMemberDaily
				+ ", nonMemberMonthly=" + nonMemberMonthly + ", memberYearly="
				+ memberYearly + ", memberQuarterly=" + memberQuarterly
				+ ", memberHalfYearly=" + memberHalfYearly + ", isActive="
				+ isActive + "]";
	}
	
	
}
