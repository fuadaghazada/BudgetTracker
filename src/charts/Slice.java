package charts;

import java.awt.Color;

/**
 	Describes the slices
 	
 	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class Slice {
	
	//class varibales
	private double value;
	private Color color;
	
	/**
	  	Constructs a slice
	  	@param value
	  	@param color
	 */
	public Slice(double value, Color color) 
	{  
	      this.setValue(value);
	      this.setColor(color);
	}
	
	/**
	 	Access to the value and the color of the slice
	 */
	public Color getColor() 
	{
		return color;
	}

	public void setColor(Color color) 
	{
		this.color = color;
	}

	public double getValue()
	{
		return value;
	}

	public void setValue(double value) 
	{
		this.value = value;
	}
	
	public String toString()
	{
		return value + "  " + color.toString();
	}
	
	
}

	