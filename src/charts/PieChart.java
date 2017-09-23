package charts;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JComponent;

/**
  	Piechart (component) - paints a piechart in the frame with its methods.
  	
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class PieChart extends JComponent 
{

	//class variables
	private static final long serialVersionUID = 1L;
	private ArrayList<Slice> slices;

	   
	/**
		  Constructs a default piechart
	*/
	public PieChart(ArrayList<Slice> slices) 
	{
		this.slices = slices;
	}
	
	/**
	  	Access to the slices
	 */
	public ArrayList<Slice> getSlices()
	{
		return slices;
	}
	
	/**
	  	Method addSlice will add slice to the piechart
	 */
	public void addSlice(double d, Color color)
	{
		slices.add(new Slice(d, color));
		repaint();
	}
	
	/**
	  	Method addSlice will add slice to the piechart
	 */
	public void removeSlice(int i)
	{
		slices.remove(i);
		repaint();
	}
	
	/**
  	To clear the pie chart itself 
	 */
	public void clear()
	{
		slices.clear();
		repaint();
	}
	
	/**
	  	Check whether the bar chart is empty or not
	  	@return boolean
	 */
	public boolean isEmpty()
	{
		return slices.size() == 0;
	}
	
	/**
	  	Access to the slice
	  	@param i - index of the slice
	 */
	public Slice getSlice(int i)
	{
		return slices.get(i);
	}
	   
	/**
	  	Method paint - paints the chart
	  	@param g - paint tool
	 */
	public void paint(Graphics g) 
	{
		drawPie((Graphics2D) g, this.getBounds(), slices);
	}
	  
	/**
	  	Method drawPie - draw the pie
	  	@param g - paint tool
	  	@param area - rectangle
	  	@param slices - slices of the pie chart 
	 */
	public void drawPie(Graphics2D g, Rectangle area, ArrayList<Slice> slices) 
	{
		double total = 0.0;
	    
		for (int i = 0; i < slices.size(); i++) 
		{
			total += slices.get(i).getValue();
	    }
	     
		double curValue = 0.0;
	    int startAngle = 0;
	      
	    for (int i = 0; i < slices.size(); i++) 
	    {
	    	startAngle = (int) (curValue * 360 / total);
	    	int arcAngle = (int) (slices.get(i).getValue() * 360 / total);
	    	
	    	g.drawArc(area.x, area.y, area.width, area.height, startAngle, 360);
	    	
	    	g.setColor(slices.get(i).getColor());
	    	g.fillArc(area.x, area.y, area.width, area.height, startAngle, arcAngle);
	    	curValue += slices.get(i).getValue();
	    }
	} 
}