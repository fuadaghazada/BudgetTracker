package core;

import java.util.ArrayList;

/**
	Incomes keeps the list of data 
			 singleton - keeps also the instance of itself 

	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
@version 1.00 
*/

public class Income 
{
	//class variables
	protected static ArrayList<Data> incomes;
	private static Income income;
    
	/**
	 	Constructing an expense object keeping the list of the data
	 	@param expenses - list of the data
	 */
	public Income()
	{
		incomes = new ArrayList<Data>();
	}
	
	/**
	  	getObject - gets the static object of income itself
	 */
	public static Income getObject()
	{
		if (income == null)
		{
			income = new Income();
			return income;
		}
		else
		{
            return income;
		}
	}
      
	/**
	 	Calculates yearly total income by iterating the list of the incomes
	 	@param year - given year
	 */
	public double yearlyTotalIncomes(int year)
	{
		double sum = 0;
		
		for(int i = 0; i < incomes.size(); i++)
		{
			if(incomes.get(i).getTime().getYear() == year)
			{
				sum += incomes.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Calculates monthly total income by iterating the list of the incomes
	 	@param month - given month
	 */
	public double monthlyTotalIncomes(int month, int year)
	{
		double sum = 0;
		
		for(int i = 0; i < incomes.size(); i++)
		{
			if(incomes.get(i).getTime().getMonth() == month && incomes.get(i).getTime().getYear() == year)
			{
				sum += incomes.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Calculates daily total income by iterating the list of the incomes
	 	@param day - given day
	 */
	public double dailyTotalIncomes(int day, int month, int year)
	{
		double sum = 0;
		
		for(int i = 0; i < incomes.size(); i++)
		{
			if(incomes.get(i).getTime().getYear() == year && incomes.get(i).getTime().getMonth() == month
														   && incomes.get(i).getTime().getDay() == day)
			{
				sum += incomes.get(i).getAmount();
			}
		}
		
		return sum;
	}
	
	/**
	 	Add income by checking : if the data does not contain category of the given data - adds as a new element to the list
	 							  if the data contains the category it is setted to the data in the given time 
	 */
	public void addIncome(Data data)
	{
		int count = 0;
		
		if(incomes.size() >= 1)
		{
			for(int i = 0; i < incomes.size(); i++)
			{
				if(this.getIncome(i).getCategory().equals(data.getCategory()) && this.getIncome(i).getTime().getMonth() == data.getTime().getMonth()
																			   && this.getIncome(i).getTime().getDay() == data.getTime().getDay()
																			   && this.getIncome(i).getTime().getYear() == data.getTime().getYear())
				{		
					this.getIncome(i).setAmount(data.getAmount() + this.getIncome(i).getAmount());	
				}
				else
					count++;
			}
		}
		else
		{
			incomes.add(data);
		}
		if(count == incomes.size())
		{
			incomes.add(data);
		}
	}

	/**
	 	Deletes the income according to the category and the month given 
	 	@param category - the given category
	 	@param month - the given month
	 */
	public void deleteIncome(String category, int month)
	{
		for(int i = 0; i < incomes.size(); i++)
		{
			if(incomes.get(i).getCategory().equals(category))
			{
				if(incomes.get(i).getTime().getMonth() == month)
				{
					incomes.remove(i);
					
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
		
		for(int i = 0; i < incomes.size(); i++)
		{
			if(category.equals(incomes.get(i).getCategory()) && incomes.get(i).getTime().getMonth() == t.getMonth())
			{
				amount += incomes.get(i).getAmount();
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
		for(int i = 0; i < incomes.size(); i++)
		{
			if(category.equals(incomes.get(i).getCategory()) && incomes.get(i).getTime().getMonth() == t.getMonth())
			{
				incomes.get(i).setAmount(amount);
			}
		}
	}
	
	/**
	 	Checks whether the list is containing the given data
	 	@return true || false
	 */
	public boolean contains(Data d)
	{
		for(int i = 0; i < incomes.size(); i++)
		{
			if(incomes.get(i).getCategory().equals(d.getCategory()) && incomes.get(i).getTime().getMonth() == d.getTime().getMonth())
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	  	Calculates and returns the total amount of the income by iterating over the list
	  	@return total amount
	 */
	public double getTotalIncome()
	{
		double total = 0;
		
		for(int i = 0; i < incomes.size(); i++)
		{
			total += incomes.get(i).getAmount();
		}
		return total;
	}
	
	/**
	  	Accesses the list
	  	@return the list
	 */
	public ArrayList<Data> getIncomes()
	{
		return incomes;
	}
	
	/**
	 	Checks the whether the list is Empty or not
	 	@return true || false
	 */
	public boolean isEmpty()
	{
		return incomes.size() == 0;
	}
	
	/**
	  	Accesses the Data in the given index of the list
	 */
	public Data getIncome(int index)
	{
		return incomes.get(index);
	}
	
	/**
	 	@return the income list in the String format
	 */
	@Override
	public String toString()
	{
		String result = "";
		
		for(Data d : incomes)
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
		
		for(int i = 0; i < incomes.size(); i++)
		{
			categories.add(incomes.get(i).getCategory());
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
