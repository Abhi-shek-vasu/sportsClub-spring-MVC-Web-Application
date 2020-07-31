package com.sports.models;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class SubData
{
	int slotId;
	String pack;
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	DateTime dateTime;
	public SubData()
	{
		this.slotId=0;
		this.pack="";
		this.dateTime=new DateTime();
	}
	public int getSlotId()
	{
		return slotId;
	}
	public void setSlotId(int slotId)
	{
		this.slotId = slotId;
	}
	public String getPack()
	{
		return pack;
	}
	public void setPack(String pack)
	{
		this.pack = pack;
	}
	public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }
	@Override
	public String toString()
	{
		return "SubData [slot=" + slotId + ", pack=" + pack + " ]";
	}
	

}
