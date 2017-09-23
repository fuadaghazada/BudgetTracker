package core;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import exceptions.NegativeSecondsException;
import gui.HomePanel;
import gui.MainFrame;

/**
 	Reminder - starts and cancels(when finished) timer according to the given seconds
 	
  	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
 */
public class Reminder 
{
    private Timer timer;
    private int index;
    private String category;
    private double amount;
    private Time time;
    private int hour, minute;

    /**
      	Constructs a reminder with the given properties
      	@param seconds - seconds converted from the difference between the dates
      	@param index
      	@param category - category of the data
      	@param amount - amount of the data
      	@param time - time of the data
      	@param hour - hour of the reminder
      	@param minute - minute for the reminder
      	@throws NegativeSecondsException - in case there is a negative seconds (passed time)
     */
    public Reminder(long seconds, int index, String category, double amount, Time time, int hour, int minute) throws NegativeSecondsException
    {
    	if(seconds < 0)
    		throw new NegativeSecondsException("The time has been passed!");  //throws the exception here
    	
    	this.setCategory(category);
    	this.setAmount(amount);
    	this.setTime(time);
    	this.setHour(hour);
    	this.setMinute(minute);
    	this.index = index;
        timer = new Timer();
        timer.schedule(new RemindTask(category + " - " + amount), seconds);
	}

    /**
      	Getter and setters for the properties of Reminders
     */
    public int getIndex()
    {
    	return index;
    }
    
    public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}
	
	/**
	  	accessor method toString returns the data in String format
	  	@return properties of the Reminder object
	 */
	@Override
	public String toString()
	{
		return "*" + "\t\tCategory: " + category + "\t\tAmount: " + amount + "\t\tDate: " + time + "\t\tTime: " + hour + ":" + minute;
	}

	/**
	 	Inner class for counting the time
	 */
	private class RemindTask extends TimerTask 
    {
		//inner clss variable(s)
    	private String message;
    	
    	/**
    	  	Constructs a task
    	  	@param message - message for the task
    	 */
    	public RemindTask(String message)
    	{
    		this.message = message;
    	}
    	
    	/**
    	  	Runs the timer - cancels - prompts when finishes
    	 */
        public void run() 
        {
            System.out.println("Time's up!");
            SoundUtils.makeSound();
            JOptionPane.showMessageDialog(MainFrame.getFrame(), message, "REMINDER", 1);
            System.out.println("~~~~~~~~" + index);
            
            for(int i = 0; i < HomePanel.getReminders().size(); i++)
            {
            	if(HomePanel.getReminders().get(i).index == index)
            	{
            		  HomePanel.getReminders().remove(HomePanel.getReminders().get(i));
                      HomePanel.getListModel().remove(i);
            	}
            }
          
            timer.cancel(); //Terminate the timer thread
        }
    }
    
}