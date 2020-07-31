package com.sports.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="ENQUIRY")
public class Enquiry
{
	@Id
	@SequenceGenerator(name="idGen",sequenceName="enq_seq",allocationSize=1,initialValue=4)
 	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="idGen")
	@Column(name="ENQ_ID") //                                             NUMBER(3)
	int enq_id;
	@Column(name="QUESTION") //                                          VARCHAR2(2000)
	String question;
	@Column(name="NAME")       //                                        VARCHAR2(50)
	String name;
	@Column(name="EMAIL")        //                                      VARCHAR2(100)
	String email;
	@Column(name="ANSWER")          //                                   VARCHAR2(2000)
	String answer;
	@Column(name="ENQ_DATE")
	String enqDate;
	
	public Enquiry()
	{
		this(0,"","","","","");
	}
	@Override
	public String toString()
	{
		return "Enquiry [enq_id=" + enq_id + ", question=" + question
				+ ", name=" + name + ", email=" + email + ", answer=" + answer
				+ "]";
	}
	public Enquiry(int enq_id, String question, String name, String email,
			String answer,String enqDate)
	{
		this.enq_id = enq_id;
		this.question = question;
		this.name = name;
		this.email = email;
		this.answer = answer;
		this.enqDate=enqDate;
	}
	public String getEnqDate()
	{
		return enqDate;
	}
	public void setEnqDate(String enqDate)
	{
		this.enqDate = enqDate;
	}
	public int getEnq_id()
	{
		return enq_id;
	}
	public void setEnq_id(int enq_id)
	{
		this.enq_id = enq_id;
	}
	public String getQuestion()
	{
		return question;
	}
	public void setQuestion(String question)
	{
		this.question = question;
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
	public String getAnswer()
	{
		return answer;
	}
	public void setAnswer(String answer)
	{
		this.answer = answer;
	}
	
	
}
