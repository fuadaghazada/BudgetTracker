package core;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/** 
  	Class TimeToSeconds with a method converts some given time to the seconds
  	
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class DateToMilliSeconds 
{
	//class variables 
	private Time time;
	private int hours, minutes, seconds;
	private Calendar cal;
	
	
	/**
	  	Constructs a new TimeToSeconds object
	  	@param time - Time object (core.Time)
	 */
	public DateToMilliSeconds(Time time, int hours, int minutes)
	{
		this.time = time;
		this.hours = hours;
		this.minutes = minutes;
		cal = new GregorianCalendar();
	}
	
	/**
	  	Converts time interval to the seconds
	 */
	public long convert()
	{
		//Sets the date format
		SimpleDateFormat myFormat = new SimpleDateFormat("dd MM yyyy HH:mm:ss");
		
		//Gets the current date in String
		String current = "" + this.getCurrentDay() + " " + this.getCurrentMonth() + " " + this.getCurrentYear() + " "
							+ this.getCurrentHour() + ":" + this.getCurrentMinute() + ":" + this.getCurrentSecond();
		
		//Gets the given date in the String
		String given = "" + this.getTime().getDay() + " " + this.getTime().getMonth() + " " + this.getTime().getYear()+ " "
							+ this.hours + ":" + this.minutes + ":" + this.seconds;

		long diff = 0;
		
		try 
		{
		    Date date1 = myFormat.parse(current);
		    Date date2 = myFormat.parse(given);
		    diff = date2.getTime() - date1.getTime();
		    System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		}
		catch (ParseException e)
		{
		    e.printStackTrace();
		}
		
		return diff;
	}
	
	/**
	  	Access to the current time and date (Getter and setters)
	 */
	public int getCurrentHour()
	{
		return cal.get(Calendar.HOUR);
	}
	
	public int getCurrentMinute()
	{
		return cal.get(Calendar.MINUTE);
	}
	
	public int getCurrentSecond()
	{
		return cal.get(Calendar.SECOND);
	}
	
	public int getCurrentDay()
	{
		return cal.get(Calendar.DAY_OF_MONTH);
	}
	
	public int getCurrentMonth()
	{
		return cal.get(Calendar.MONTH) + 1;
	}
	
	public int getCurrentYear()
	{
		return cal.get(Calendar.YEAR);
	}

	public Time getTime() 
	{
		return time;
	}

	public void setTime(Time time) 
	{
		this.time = time;
	}
}
