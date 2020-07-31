package com.sports.models;

public class Payment
{
	String bankName;
	String creditCardNumber;
	String cvcCode;
	String expDate;
	String password;

	public Payment()
	{
		this.bankName="";
		this.creditCardNumber="";
		this.cvcCode="";
		this.expDate="";
		this.password="";
	}

	public String getBankName()
	{
		return bankName;
	}

	public void setBankName(String bankName)
	{
		this.bankName = bankName;
	}

	public String getCreditCardNumber()
	{
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber)
	{
		this.creditCardNumber = creditCardNumber;
	}

	public String getCvcCode()
	{
		return cvcCode;
	}

	public void setCvcCode(String cvcCode)
	{
		this.cvcCode = cvcCode;
	}

	public String getExpDate()
	{
		return expDate;
	}

	public void setExpDate(String expDate)
	{
		this.expDate = expDate;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	@Override
	public String toString()
	{
		return "Payment [bankName=" + bankName + ", creditCardNumber="
				+ creditCardNumber + ", cvcCode=" + cvcCode + ", expDate="
				+ expDate + ", password=" + password + "]";
	}
	
}
