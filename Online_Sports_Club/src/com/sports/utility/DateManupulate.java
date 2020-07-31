package com.sports.utility;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.joda.time.DateTime;

public class DateManupulate
{
	
	public static String getNewMonthDate(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		Calendar cal=Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		cal.add(Calendar.MONTH, 0);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = cal.getTime();
		return dateFormat.format(date1);
	}
	public static String getNewMonthDateNextQuarter(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		Calendar cal=Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		cal.add(Calendar.MONTH, 3);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = cal.getTime();
		return dateFormat.format(date1);
	}
	public static String getNextDay(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		Calendar cal=Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		cal.add(Calendar.DAY_OF_MONTH, 1);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = cal.getTime();
		return dateFormat.format(date1);
	}
	public static String getNextHalfYear(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		Calendar cal=Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		cal.add(Calendar.MONTH, 5);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = cal.getTime();
		return dateFormat.format(date1);
	}
	public static String getNextYear(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		Calendar cal=Calendar.getInstance();
		cal.set(Integer.parseInt(year),Integer.parseInt(month), Integer.parseInt(day));
		cal.add(Calendar.MONTH, 11);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date date1 = cal.getTime();
		return dateFormat.format(date1);
	}
	public static String getStringDate(DateTime date)
	{
		String Date=date.toString();
		System.out.println(Date);
		String year=Date.substring(0, 4);
		String month=Date.substring(5,7);
		System.out.println(month);
		String day=Date.substring(8,10);
		System.out.println(day);
		System.out.println(year);
		String finalDate=day+"-"+month+"-"+year;
		System.out.println("fianl date "+finalDate);
		return finalDate;
	}
	
	public static String getReadableDate(String date)
	{
		String newDate=date.substring(0, 10);
		String year=newDate.substring(0,4);
		String month=newDate.substring(5,7);
		String day=newDate.substring(8,10);
		String newMonth="";
		switch(month)
		{
		case "01": newMonth="jan";
		break;
		case "02": newMonth="feb";
		break;
		case "03": newMonth="mar";
		break;
		case "04": newMonth="apr";
		break;
		case "05": newMonth="may";
		break;
		case "06": newMonth="jun";
		break;
		case "07": newMonth="jul";
		break;
		case "08": newMonth="aug";
		break;
		case "09": newMonth="sep";
		break;
		case "10": newMonth="oct";
		break;
		case "11": newMonth="nov";
		break;
		case "12": newMonth="dec";
		break;
		}
		String finalDate=day+"-"+newMonth+"-"+year;
		return finalDate;
	}
}
