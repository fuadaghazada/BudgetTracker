package core;

import exceptions.NoSuchDateException;

public class Tester {
	public static void main(String[] args) throws NoSuchDateException
	{
		Expenses exps = new Expenses();
		
		Data d1 = new Data("A", 200, new Time(1, 2, 2016));
		Data d2 = new Data("B", 300, new Time(2, 2, 2016));
		Data d3 = new Data("A", 400, new Time(2, 3, 2016));
		Data d4 = new Data("C", 400, new Time(2, 3, 2016));
		Data d5 = new Data("A", 400, new Time(2, 3, 2016));

		
		exps.addExpense(d1);
		exps.addExpense(d2);
		exps.addExpense(d3);
		exps.addExpense(d4);
		exps.addExpense(d5);
		
		System.out.println(exps);
	
		
		
		

//		
//		System.out.println(exps.getAmount(new Time(2,2,2016), "B"));
		
//		Scanner sc = new Scanner(System.in);
//		
//		Expenses expense = new Expenses();
//		do
//		{
//			System.out.println("Enter category");
//			String category = sc.next();
//			System.out.println("Enter day");
//			int day = sc.nextInt();
//			System.out.println("Enter month");
//			int month = sc.nextInt();
//			System.out.println("Enter year");
//			int year = sc.nextInt();
//			System.out.println("Enter amount");
//			double amount = sc.nextDouble();
//			
//			//String[][] expenseData = new String[6][14];
//			
//			
//			
//			
//			//Creating a new temporary array in order to avoid concurrent modification exception 
//			Data[] temp = new Data[expense.getExpenses().size()];
//			
//			//Filling the temp array
//			if(expense.getExpenses().size() >= 1)
//			{
//				for(int i = 0; i < expense.getExpenses().size(); i++)
//					temp[i] = expense.getExpenses().get(i);
//			}
//			
//			//Filling the expense collection
//			if(expense.getExpenses().size() >= 1)
//			{
//				for(Data data : temp)
//				{
//					if(data.getCategory().equals(category))
//					{
//						if(data.getTime().getDay() == day && data.getTime().getMonth() == month && data.getTime().getYear() == year)
//						{
//							data.setAmount(data.getAmount() + amount);
//							break;
//						}
//						else
//						{
//							data.setAmount(data.getAmount());
//							break;
//						}
//					}
//					else
//					{
//						try {
//							expense.addExpense(new Data(category, amount, new Time(day, month, year)));
//							break;
//						} catch (NoSuchDateException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//					}
//				}
//			}
//			else
//			{
//				try {
//					expense.addExpense(new Data(category, amount, new Time(day, month, year)));
//				} catch (NoSuchDateException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}		
//			
//			for(Data d : expense.getExpenses())
//			{
//				System.out.println(d);
//			}
//			
//			
////			for(int i = 0; i < expenseData.length; i++)
////			{
////				if(expense.getExpenses().get(i) != null)
////				{
////					expenseData[i][0] = expense.getExpenses().get(i).getCategory();
////				
////					for(int j = 1; j < expenseData[i].length; j++)
////					{
////						if(expense.getExpenses().get(j) != null)
////							expenseData[i][j] = expense.getExpenses().get(j).getAmount() + "$";
////					}
////				}
////			}
////			
////			for(int i = 0; i < expenseData.length; i++)
////			{
////				for(int j = 0; j < expenseData[i].length; j++)
////				{
////					System.out.print(expenseData[i][j] + "  ");
////				}
////				System.out.println();
////			}
//		}	
//		while(1<6);	
//			
	}
//	
//	public boolean validateInput()
//	{
//		String input = "";
////		input = in.next();
//		return false;
//	}
}
