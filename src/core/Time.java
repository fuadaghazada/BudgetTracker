package core;
/**
 	Time class - to keep the time for the data
 	
 	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
 */
import exceptions.NoSuchDateException;

public class Time 
{
	//class variables
	private int day;
	private int month;
	private int year;
	
	/**
	  	Constructs a time object
	  	@throws NoSuchDataException in case there are some wrong inputs for time properties
	  	@param day - day of that time
	  	@param month - month of that time
	  	@param year - year of that time
	 */
	public Time(int day, int month, int year) throws NoSuchDateException
	{
		if(month > 12 || month <= 0 || day <= 0 || day > 31)
		{
			throw new NoSuchDateException("[ERROR] No Such Date!");  //in case an error throw the exception
		}
		
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	}
	
	/**
	  	Setter and getters for the time properties
	 */
	public int getMonth() 
	{
		return month;
	}
	
	public void setMonth(int month) 
	{
		this.month = month;
	}
	
	public int getDay() 
	{
		return day;
	}
	
	public void setDay(int day) 
	{
		this.day = day;
	}
	
	public int getYear() 
	{
		return year;
	}
	
	public void setYear(int year) 
	{
		this.year = year;
	}
	
	/**
	  	Method toString - to return the data in String format
	  	@return properties of the time
	 */
	@Override
	public String toString()
	{
		return day + " " + month + " " + year;
	}
	
}
