package gui;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.NoSuchTimeException;

/**
	JOptionPaneMultiInput - when the user clicks add expense/income/reminder
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/

public class JOptionPaneMultiInput 
{
	//class variables
	private JLabel lbl1, lbl2, lbl3, lbl4;
	private JTextField txtf1, txtf2, txtf3, txtf4;
	private JPanel pnl1, pnl2, pnl3, pnl4, main_panel;
	private int day, month, year, countTxtf, hour, minute;
	
	/**
	  	Constructs multi input prompt window
	  	@param title - title of the window 
	  	@countTxtf - count of the text fields accoring to the type of the window
	 */
	public JOptionPaneMultiInput(String title, int countTxtf)
	{
		//initilizing 
		this.countTxtf = countTxtf;
		
		this.init();
		this.add();
		
		JOptionPane.showConfirmDialog(MainFrame.getFrame(), main_panel,  title, JOptionPane.OK_CANCEL_OPTION);
		
		if(countTxtf == 3 || countTxtf == 4)
			this.date_seperate();
		
		if(countTxtf == 4)
			this.time_seperate();
		
	}
	
	/**
	 	Initializing of the clas variables in the method
	 */
	private void init()
	{
		if(countTxtf == 3 || countTxtf == 4)
			txtf1 = new JTextField(10);
		
		txtf2 = new JTextField(10);
		txtf3 = new JTextField(10);
		txtf4 = new JTextField(10);
		
		
		lbl1 = new JLabel("Amount: ");
		lbl2 = new JLabel("Category: ");
		lbl4 = new JLabel("Time: ");
		
		if(countTxtf == 3 || countTxtf == 4)
			lbl3 = new JLabel("Date: ");
		else if(countTxtf == 2)
			lbl3 = new JLabel("Month: ");
		
		pnl1 = new JPanel();
		pnl2 = new JPanel();
		pnl3 = new JPanel();
		pnl4 = new JPanel();
		main_panel = new JPanel();
		
	}
	
	/**
 		Adding the components to the panel
	 */
	private void add()
	{
		if(countTxtf == 3 || countTxtf == 4)
		{
			pnl1.add(lbl1);
			pnl1.add(txtf1);
		}	
		
		pnl2.add(lbl2);
		pnl2.add(txtf2);
		
		pnl3.add(lbl3);
		pnl3.add(txtf3);
		
		pnl4.add(lbl4);
		pnl4.add(txtf4);
		
		
		
		if(countTxtf == 4)
		{
			main_panel.setLayout(new GridLayout(4,1));
			main_panel.add(pnl1);
			main_panel.add(pnl2);
			main_panel.add(pnl3);
			main_panel.add(pnl4);
		}
		else if(countTxtf == 3)
		{
			main_panel.setLayout(new GridLayout(3,1));
			main_panel.add(pnl1);
			main_panel.add(pnl2);
			main_panel.add(pnl3);
		}
		else if(countTxtf == 2)
		{
			main_panel.setLayout(new GridLayout(2,1));
			main_panel.add(pnl2);
			main_panel.add(pnl3);
		}
	}
	
	/**
	  	seperates date to the day month and year
	 */
	private void date_seperate()
	{
		String date = this.txtf3.getText();
		
		String dayTxt = "";
		String monthTxt = "";
		String yearTxt = "";
		
		for(int i = 0; i < date.length(); i++)
		{
			if(date.charAt(i) == '/')
			{
				dayTxt += date.substring(0, i);
				
				i++;
				
				while(date.charAt(i) != '/')
				{
					monthTxt += date.charAt(i);
					i++;
				}
				yearTxt += date.substring(i+1);
			}
		}
		
		this.setDay(Integer.parseInt(dayTxt));
		this.setMonth(Integer.parseInt(monthTxt));
		this.setYear(Integer.parseInt(yearTxt));
	}
	
	/**
	  	Seperates time to hour and minute
	 */
	private void time_seperate()
	{
		String time = this.txtf4.getText();
		
		String hourTxt = "";
		String minuteTxt = "";
		
		for(int i = 0; i < time.length(); i++)
		{
			if(time.charAt(i) != ':')
			{
				hourTxt += time.charAt(i);
			}
			else
			{
				minuteTxt += time.substring(i+1);
				break;
			}
		}
		
		this.setHour(Integer.parseInt(hourTxt));
		this.setMinute(Integer.parseInt(minuteTxt));
	}

	/**
	  	Getter and setters
	 */
	public void setHour(int hour) 
	{
		this.hour = hour;
		
	}

	public void setMinute(int minute) 
	{
		this.minute = minute;	
	}

	public int getHour() throws NoSuchTimeException
	{
		if(hour > 25 || hour < 0)
		{
			throw new NoSuchTimeException("No such time!");
		}
		return hour;
	}
	
	public int getMinute() throws NoSuchTimeException
	{
		if(minute >= 60 || minute < 0)
		{
			throw new NoSuchTimeException("No such time!");
		}
		return minute;
	}
	/**
		Access to the text fields
		
	 **/
	
	public JTextField getTxtf1() 
	{
		return txtf1;
	}

	public void setTxtf1(JTextField txtf1) 
	{
		this.txtf1 = txtf1;
	}

	public JTextField getTxtf2() 
	{
		return txtf2;
	}

	public void setTxtf2(JTextField txtf2) 
	{
		this.txtf2 = txtf2;
	}

	public JTextField getTxtf3() 
	{
		return txtf3;
	}

	public void setTxtf3(JTextField txtf3) 
	{
		this.txtf3 = txtf3;
	}
	
	public JTextField getTxtf4() 
	{
		return txtf4;
	}

	public void setTxtf4(JTextField txtf4) 
	{
		this.txtf4 = txtf4;
	}

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
}
