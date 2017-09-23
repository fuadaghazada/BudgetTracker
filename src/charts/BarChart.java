package charts;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JComponent;

/**
  	Bar chart component which helps to draw and paint bar charts
  	
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class BarChart extends JComponent
{
	//Class serial ID
	private static final long serialVersionUID = 1L;
	
	//class variables
	private ArrayList<Double> values;
	private ArrayList<String> names;
	private double maxValue;
	
	/**
	  	Constructs a bar Chart with its maximum element
	  	@param max - max element
	 */
	public BarChart(double max)
	{
		values = new ArrayList<>();
		names = new ArrayList<>();
		maxValue = max;
	}
	
	/**
	  	Method append - add an element to the collection 
	  	and repaint the chart again
	  	
	  	@param value - entered value for the collections
	 */
	public void append(double value, String name)
	{
		values.add(value);
		names.add(name);
		repaint();
	}
	
	/**
	 	Method remove - removes an element from the bar chart
	 	@param i - index
	 */
	public void remove(int i) 
	{
		values.remove(i);
		names.remove(i);
		repaint();
	}
	
	/**
	 	Access to the valus of the bar chart
	 	@return values
	 */
	public ArrayList<Double> getValues()
	{
		return values;
	}
	
	/**
	  	To clear the bar chart itself 
	 */
	public void clear()
	{
		values.clear();
		names.clear();
		repaint();
	}
	
	/**
	  	Check whether the bar chart is empty or not
	  	@return boolean
	 */
	public boolean isEmpty()
	{
		return values.size() == 0 && names.size() == 0;
	}
	
	/**
	 	Method paintComponent - paints the chart with its properties
	 	@param g - Graphics to paint
	 */
	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		
		final int GAP = 10;
		final int BAR_WIDTH = 20;
		
		int x = GAP;
		
		g.setColor(Color.BLACK);
		
		int a = 0;
		
		for(double value : values)
		{
			int barHeight = (int) (getHeight() * value / maxValue);
			g.fillRect(x, 230 - barHeight, BAR_WIDTH, barHeight);
			g.drawString(names.get(a), x, 250);
			x += BAR_WIDTH + GAP;
			
			a++;
		}
	}
	
	
}
