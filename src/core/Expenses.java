package core;

import java.util.ArrayList;

/**
  	Expenses keeps the list of data 
  			 singleton - keeps also the instance of itself 
 
 	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
 */

public class Expenses 
{

	//class variables
	private static ArrayList<Data> expenses;
	private static Expenses expense;
    
	/**
	 	Constructing an expense object keeping the list of the data
	 	@param expenses - list of the data
	 */
	public Expenses()
	{
		expenses = new ArrayList<Data>();
	}
	
	/**
	  	getObject - gets the static object of expense itself
	 */
	public static Expenses getObject()
	{
		if (expense == null)
		{
			expense = new Expenses();
			return expense;
		}
		else
		{
            return expense;
		}
	}
        
	/**
	 	Calculates yearly total expense by iterating the list of the expenses
	 	@param year - given year
	 */
	public double yearlyTotalExpenses(int year)
	{
		double sum = 0;
		
		for(int i = 0; i < expenses.size(); i++)
		{
			if(expenses.get(i).getTime().getYear() == year)
			{
				sum += expenses.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Calculates monthly total expense by iterating the list of the expenses
	 	@param month - given month
	 */
	public double monthlyTotalExpenses(int month, int year)
	{
		double sum = 0;
		
		for(int i = 0; i < expenses.size(); i++)
		{
			if(expenses.get(i).getTime().getMonth() == month && expenses.get(i).getTime().getYear() == year)
			{
				sum += expenses.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Calculates daily total expense by iterating the list of the expenses
	 	@param day - given day
	 */
	public double dailyTotalExpenses(int day, int month, int year)
	{
		double sum = 0;
		
		for(int i = 0; i < expenses.size(); i++)
		{
			if(expenses.get(i).getTime().getYear() == year && expenses.get(i).getTime().getMonth() == month
														   && expenses.get(i).getTime().getDay() == day)
			{
				sum += expenses.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Add expense by checking : if the data does not contain category of the given data - adds as a new element to the list
	 							  if the data contains the category it is setted to the data in the given time 
	 */
	public void addExpense(Data data)
	{
		int count = 0;
		
		if(expenses.size() >= 1)
		{
			for(int i = 0; i < expenses.size(); i++)
			{
				if(this.getExpense(i).getCategory().equals(data.getCategory()) && this.getExpense(i).getTime().getMonth() == data.getTime().getMonth()
																			   && this.getExpense(i).getTime().getDay() == data.getTime().getDay()
																			   && this.getExpense(i).getTime().getYear() == data.getTime().getYear())
				{		
					this.getExpense(i).setAmount(data.getAmount() + this.getExpense(i).getAmount());	
				}
				else
					count++;
			}
		}
		else
		{
			expenses.add(data);
		}
		if(count == expenses.size())
		{
			expenses.add(data);
		}
	}

	/**
	 	Deletes the expense according to the category and the month given 
	 	@param category - the given category
	 	@param month - the given month
	 */
	public void deleteExpense(String category, int month)
	{
		for(int i = 0; i < expenses.size(); i++)
		{
			if(expenses.get(i).getCategory().equals(category))
			{
				if(expenses.get(i).getTime().getMonth() == month)
				{
					expenses.remove(i);
					
				}
			}
		}
	}
	
	/**
	  	Gets the amount of the existing data according to the given time
	  	@param time - the given time 
	  	@param category - the given category 
	  	@param amount - the given amount
	 */
	public double getAmount(Time t, String category)
	{
		double amount = 0;
		
		for(int i = 0; i < expenses.size(); i++)
		{
			if(category.equals(expenses.get(i).getCategory()) && expenses.get(i).getTime().getMonth() == t.getMonth())
			{
				amount += expenses.get(i).getAmount();
			}
		}
		
		return amount;
	}
	
	/**
	  	Sets the amount of the existing data according to the given time
	  	@param time - the given time 
	  	@param category - the given category 
	  	@param amount - the given amount
	 */
	public void setAmount(Time t, String category, double amount)
	{
		for(int i = 0; i < expenses.size(); i++)
		{
			if(category.equals(expenses.get(i).getCategory()) && expenses.get(i).getTime().getMonth() == t.getMonth())
			{
				expenses.get(i).setAmount(amount);
			}
		}
	}
	
	/**
	 	Checks whether the list is containing the given data
	 	@return true || false
	 */
	public boolean contains(Data d)
	{
		for(int i = 0; i < expenses.size(); i++)
		{
			if(expenses.get(i).getCategory().equals(d.getCategory()) && expenses.get(i).getTime().getMonth() == d.getTime().getMonth())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	  	Calculates and returns the total amount of the expense by iterating over the list
	  	@return total amount
	 */
	public double getTotalExpense()
	{
		double total = 0;
		
		for(int i = 0; i < expenses.size(); i++)
		{
			total += expenses.get(i).getAmount();
		}
		return total;
	}
	
	/**
	  	Accesses the list
	  	@return the list
	 */
	public ArrayList<Data> getExpenses()
	{
		return expenses;
	}
	
	/**
	 	Checks the whether the list is Empty or not
	 	@return true || false
	 */
	public boolean isEmpty()
	{
		return expenses.size() == 0;
	}
	
	/**
	  	Accesses the Data in the given index of the list
	 */
	public Data getExpense(int index)
	{
		return expenses.get(index);
	}
	
	/**
	 	@return the expense list in the String format
	 */
	@Override
	public String toString()
	{
		String result = "";
		
		for(Data d : expenses)
		{
			result += d + "\n";
		}
		return result;
	}
	
	/**
	  	Find the index of the data, where it was firstly added
	  	@param category - category of the data
	 */
	public int getIndex(String category)
	{
		ArrayList<String> categories = new ArrayList<>();
		
		for(int i = 0; i < expenses.size(); i++)
		{
			categories.add(expenses.get(i).getCategory());
		}
		
		System.out.println("*********");
		System.out.println(categories);
		
		for(int i = 0; i < categories.size(); i++)
		{
			for(int j = i + 1; j < categories.size();)
			{
				if(categories.get(i).equals(categories.get(j)))
				{
					categories.remove(j);
				}
				else
				{
					j++;
				}
			}
		}
		System.out.println("+++++++++");
		System.out.println(categories);
		
		for(int i = 0; i < categories.size(); i++)
		{
			if(categories.get(i).equals(category))
			{
				return i;
			}
		}
		
		return -1;
	}
	
	
}
