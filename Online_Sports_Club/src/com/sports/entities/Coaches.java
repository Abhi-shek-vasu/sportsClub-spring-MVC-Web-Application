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
public class Coaches
{
	@SequenceGenerator(name="idGen",sequenceName="coach_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="COACH_ID")               //                   NOT NULL NUMBER(3)
	@Id
	int id;
	@Column(name="SPORTS_ID")            //                              NUMBER(3)
	int sport_id;
	@Column(name="COACH_NAME")         //                                VARCHAR2(50)
	String name;
	@Column(name="AGE")              //                                  NUMBER(3)
	int age;
	@Column(name="EXPERIANCE")     //                                    NUMBER(3)
	int experiance;
	@Column(name="QUALIFICATION")//                                      VARCHAR2(1200)
	String qualification;
	public Coaches()
	{
		this(0,0,"",0,0,"");
	}
	public Coaches(int id, int sport_id, String name, int age, int experiance,
			String qualification)
	{
		this.id = id;
		this.sport_id = sport_id;
		this.name = name;
		this.age = age;
		this.experiance = experiance;
		this.qualification = qualification;
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public int getSport_id()
	{
		return sport_id;
	}
	public void setSport_id(int sport_id)
	{
		this.sport_id = sport_id;
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
	public int getExperiance()
	{
		return experiance;
	}
	public void setExperiance(int experiance)
	{
		this.experiance = experiance;
	}
	public String getQualification()
	{
		return qualification;
	}
	public void setQualification(String qualification)
	{
		this.qualification = qualification;
	}
	@Override
	public String toString()
	{
		return "Coaches [id=" + id + ", sport_id=" + sport_id + ", name="
				+ name + ", age=" + age + ", experiance=" + experiance
				+ ", qualification=" + qualification + "]";
	}
	
	
}
