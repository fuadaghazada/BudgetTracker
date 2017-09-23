package core;

/**
	Savings - keeps the data for savings  

	@authors	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00
*/
public class Saving 
{
	//class variables
	private static Saving saving;
	private static double goal=0;
	
	/**
	  	getObject - gets the static object of saving itself
	 */
	public static Saving getObject()
	{
		if (saving == null)
		{
			saving = new Saving();
			return saving;
		}
		else
		{
			return saving;
		}
	}

	/**
	  	Sets the goal to the given goal
	  	@param goal - given goal
	 */
	public void setGoal(double goal1) 
	{	
		goal = goal1;
	}
	
	/**
	 	Calculates daily total saving by iterating the list of the expenses
	 	@param day - given day
	 */
	public double dailyTotalSaving(int day, int month, int year)
	{
		double sum = Income.getObject().dailyTotalIncomes(day, month, year) - Expenses.getObject().dailyTotalExpenses(day, month, year);
		return sum;
	}
	
	/**
	 	Calculates monthly total expense by iterating the list of the expenses
	 	@param month - given month
	 */
	public double monthlyTotalSaving(int month, int year)
	{
		double sum = Income.getObject().monthlyTotalIncomes(month, year) - Expenses.getObject().monthlyTotalExpenses(month, year);
		return sum;
	}
	
	/**
	 	Calculates yearly total saving by iterating the list of the expenses
	 	@param year - given year
	 */
	public double yearlyTotalSaving(int year)
	{
		double sum = Income.getObject().yearlyTotalIncomes(year) - Expenses.getObject().yearlyTotalExpenses(year);
		return sum;
	}
	
	/**
	  	Calculates th percentage of total savings to the savings goal
	  	@param total - total savings
	 */
    public double getpercentage(double total)
    {
		return (total/goal)*100.0;
	}
	
    /**
     	Rounds the percentage off - (to display on the house images)
     */
    public double roundoff(double perc) 
	{
		int per = (int)this.getpercentage(perc);
		
		if(per>=0 && per <10)
        {
			return 0;
		}
		if(per>=10 && per <20)
        {
			return 10;
		}
		if(per>=20 && per <30)
        {
            return 20;
		}
		if(per>=30 && per <40){
			return 30;
		}
		if(per>=40 && per <50){
			return 40;
		}
		if(per>=50 && per <60){
			return 50;
		}
		if(per>=60 && per <70){
			return 60;
		}
		if(per>=70 && per <80){
			return 70;
		}
		if(per>=80 && per <90){
			return 80;
		}
		if(per>=90 && per <100){
			return 90;
		}
		if(per==100 || per>100){
			return 100;
		}
		return 0;
	}
	
    /**
      	Accesses the goal
      	@return goal
     */
	public static double getGoal()
	{
		return goal;
	}

}
