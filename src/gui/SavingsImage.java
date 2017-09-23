package gui;
import javax.swing.*;
import java.awt.*;
/**
	Savings image class keeps and sets the images according to the values given
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/
public class SavingsImage extends JPanel
{
	//class variables
	private static final long serialVersionUID = 1L;
	private double state;
	private ImageIcon zero, ten, twenty, forty, sixty, eighty, hundred, thirty, fifty, seventy,ninty;
	private JLabel imageLabel;
	
	/**
	  	Constructs the images for savings
	 */
	public SavingsImage() 
	{
		zero = new ImageIcon("images//0.jpg");
		twenty = new ImageIcon("images//20.jpg");
		forty = new ImageIcon("images//40.jpg");
		sixty = new ImageIcon("images//60.jpg");
		eighty = new ImageIcon("images//80.jpg");
		hundred = new ImageIcon("images//100.jpg");
		ten = new ImageIcon("images//10.jpg");
		thirty= new ImageIcon("images//30.jpg");
		fifty = new ImageIcon("images//50.jpg");
		seventy=new ImageIcon("images//70.jpg");
		ninty=new ImageIcon("images//90.jpg");
		
		state = 0;
		imageLabel = new JLabel(twenty);
		add(imageLabel);
	}
	
	/**
	 	sets the state
	 	@param val - new state
	 */
	public void setState(double val)
	{
		this.state = val;
	}
	
	/**
	 	Paints the images - sets it according to the achievement level
	 */
	public void paintComponent(Graphics page)
	{
		super.paintComponent(page);
		
		if(state==0)
		{
			imageLabel.setIcon(zero);
		}
		else if(state==10)
		{
			imageLabel.setIcon(ten);
		}
		else if(state==20)
		{
			imageLabel.setIcon(twenty);
		}
		else if(state==30)
		{
			imageLabel.setIcon(thirty);
		}
		else if(state==40)
		{
			imageLabel.setIcon(forty);
		}
		else if(state==50)
		{
			imageLabel.setIcon(fifty);
		}
		else if(state==60)
		{
			imageLabel.setIcon(sixty);
		}
		else if(state==70)
		{
			imageLabel.setIcon(seventy);
		}
		else if(state==80)
		{
			imageLabel.setIcon(eighty);
		}
		else if(state==90)
		{
			imageLabel.setIcon(ninty);
		}
		else 
		{
			imageLabel.setIcon(hundred);	
		}
	}
}
