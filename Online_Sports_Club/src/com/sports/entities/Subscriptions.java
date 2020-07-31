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

@Table(name="subscriptions")
@Entity
public class Subscriptions
{
	@Id
	@SequenceGenerator(name="idGen",sequenceName="sub_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="SUB_ID")//                                    NOT NULL NUMBER(5)
	int id;
	//@Column(name="MEMBER_ID") //
	//int memberId;                                           //                            NUMBER(5)
	//@Column(name="SPORT_ID")
	//int sportsId;                     //
	@Column(name="SLOT_ID")
	int slotId;
	 @Column(name="START_DATE")     //                                                            DATE
	 String startDate;
	 @Column(name="END_DATE")     //                                                              DATE
	 String endDate;
	@Column(name="PAID_AMOUNT")   //                                                               NUMBER(9,2)
	Double paidAmount; 
	@Column(name="SUB_TYPE")
	String subType;
	@Column(name="isActive")
	String isActive;
	@ManyToOne
	@JoinColumn(name="SPORT_ID")
	private Sports sport;
	@ManyToOne
	@JoinColumn(name="MEMBER_ID")
	private Members member;
	
	public Subscriptions()
	{
		this(0,0,"","",0.0,"","");
	}
	public Subscriptions(int id,int SlotId,String startDate,String endDate,Double paidAmount,String subType,String isActive)
	{
		this.id = id;
		this.slotId=SlotId;
		this.startDate=startDate;
		this.endDate=endDate;
		this.paidAmount=paidAmount;
		this.subType=subType;
		this.isActive=isActive;
		
	}
	public String getIsActive()
	{
		return isActive;
	}
	public void setIsActive(String isActive)
	{
		this.isActive = isActive;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public void setMember(Members member)
	{
		this.member = member;
	}
	public Members getMember()
	{
		return member;
	}
	
	public int getSlotId()
	{
		return slotId;
	}
	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	public Double getPaidAmount()
	{
		return paidAmount;
	}
	public void setPaidAmount(Double paidAmount)
	{
		this.paidAmount = paidAmount;
	}
	public String getSubType()
	{
		return subType;
	}
	public void setSubType(String subType)
	{
		this.subType = subType;
	}
	public Sports getSport()
	{
		return sport;
	}
	public void setSport(Sports sport)
	{
		this.sport = sport;
	}
	@Override
	public String toString()
	{
		return "Subscriptions [id=" + id + ", slotId=" + slotId
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", paidAmount=" + paidAmount + ", subType=" + subType
				+ ", isActive=" + isActive + ", sport=" + sport + ", member="
				+ member + "]";
	}
	
	

	
}
