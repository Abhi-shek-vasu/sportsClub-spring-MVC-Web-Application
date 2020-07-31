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
@Table(name="SLOTS")
public class Slots
{
	@Id
	@SequenceGenerator(name="idGen",sequenceName="slot_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="SLOT_ID")                  //                 NOT NULL NUMBER(4)
	int slotId;
	@Column(name="SPORT_ID")              //                             NUMBER(5)
	int sportId;
	@Column(name="SLOT_DESC")           //                               VARCHAR2(50)
	String slotDesc; 
	@Column(name="SLOT_CAPACITY")     //                                 NUMBER(5)
	int slotCapacity; 
	@Column(name="OCCUPIED_SLOTS")  //                                   NUMBER(5)
	int occupiedSlots; 
	@Column(name="AVAILABE_SLOTS") //                                     NUMBER(5)
	int availabeSlots;
	public Slots()
	{
		this(0,0,"",0,0,0);
	}
	public Slots(int slotId, int sportId, String slotDesc, int slotCapacity,
			int occupiedSlots, int availabeSlots)
	{
		this.slotId = slotId;
		this.sportId = sportId;
		this.slotDesc = slotDesc;
		this.slotCapacity = slotCapacity;
		this.occupiedSlots = occupiedSlots;
		this.availabeSlots = availabeSlots;
	}
	public int getSlotId()
	{
		return slotId;
	}
	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}
	public int getSportId()
	{
		return sportId;
	}
	public void setSportId(int sportId)
	{
		this.sportId = sportId;
	}
	public String getSlotDesc()
	{
		return slotDesc;
	}
	public void setSlotDesc(String slotDesc)
	{
		this.slotDesc = slotDesc;
	}
	public int getSlotCapacity()
	{
		return slotCapacity;
	}
	public void setSlotCapacity(int slotCapacity)
	{
		this.slotCapacity = slotCapacity;
	}
	public int getOccupiedSlots()
	{
		return occupiedSlots;
	}
	public void setOccupiedSlots(int occupiedSlots)
	{
		this.occupiedSlots = occupiedSlots;
	}
	public int getAvailabeSlots()
	{
		return availabeSlots;
	}
	public void setAvailabeSlots(int availabeSlots)
	{
		this.availabeSlots = availabeSlots;
	}
	@Override
	public String toString()
	{
		return "Slots [slotId=" + slotId + ", sportId=" + sportId
				+ ", slotDesc=" + slotDesc + ", slotCapacity=" + slotCapacity
				+ ", occupiedSlots=" + occupiedSlots + ", availabeSlots="
				+ availabeSlots + "]";
	}
	
}
