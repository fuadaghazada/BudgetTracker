package core;
/**
 	Data - an object holds some properties such as category, amount and time 
 
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class Data 
{
	//class variables
	private String category;
	private double amount;
	private Time time;

	/**
	  	Constructs a data with given properties
	  	@param category - category of the data
	  	@param amount - amount of the money
	  	@param time - time of the Data
	 */
	public Data(String category, double amount, Time time)
	{
		this.setCategory(category);
		this.setAmount(amount);
		this.setTime(time);
	}
	
	/**
	  	Set and get methods for the properties
	 */
	public String getCategory() 
	{
		return category;
	}
	
	public void setCategory(String category) 
	{
		this.category = category;
	}
	
	public double getAmount() 
	{
		return amount;
	}
	
	public void setAmount(double amount) 
	{
		this.amount = amount;
	}
	
	public Time getTime() 
	{
		return time;
	}
	
	public void setTime(Time time) 
	{
		this.time = time;
	}
	
	/**
	  	Accessor method toString - to return the data in the String format
	  	@return properties
	 */
    @Override
	public String toString()
	{
		return category + " " + amount + " " + time;
	}
}
