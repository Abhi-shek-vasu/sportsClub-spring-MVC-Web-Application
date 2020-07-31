package com.sports.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class EventCharges
{
	@Id
	@SequenceGenerator(name="idGen",sequenceName="eve_charge",allocationSize=1,initialValue=4)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="EVE_CHARGE_ID") //                             NOT NULL NUMBER(4)
	int id; 
	@Column(name="EVENT_ID") //                                           NUMBER(4)
	int eventId; 
	@Column(name="CHARGE_FOR_MEMBER")   //                               NUMBER(6)
	double chargeForMember;
	@Column(name="CHARGE_NON_MEMBER") //                                  NUMBER(6)
	double chargeForNonMember;
	public EventCharges(int id, int eventId, double chargeForMember,
			double chargeForNonMember)
	{
		this.id = id;
		this.eventId = eventId;
		this.chargeForMember = chargeForMember;
		this.chargeForNonMember = chargeForNonMember;
	}
	public EventCharges()
	{
		this(0,0,0.0,0.0);
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getEventId()
	{
		return eventId;
	}
	public void setEventId(int eventId)
	{
		this.eventId = eventId;
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
	@Override
	public String toString()
	{
		return "EventCharges [id=" + id + ", eventId=" + eventId
				+ ", chargeForMember=" + chargeForMember
				+ ", chargeForNonMember=" + chargeForNonMember + "]";
	}
	
	
}
