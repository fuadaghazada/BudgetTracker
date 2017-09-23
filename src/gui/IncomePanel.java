package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import charts.BarChart;
import charts.PieChart;
import charts.Slice;
import core.Data;
import core.Income;
import core.Time;
import exceptions.NoSuchDateException;
import keeper.DataItem;
import keeper.DataSet;
/**
	IncomePanel class - creates the graphics user interface for incomes
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/
public class IncomePanel extends JPanel
{
	//class variables
	private static final long serialVersionUID = 1L;
	
	private static final String[] MONTHS = {" ", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	private static final Color[] COLORS = {Color.RED, Color.BLUE, Color.CYAN, Color.GRAY, Color.GREEN, Color.YELLOW, Color.WHITE, Color.PINK, Color.MAGENTA, Color.ORANGE, Color.LIGHT_GRAY, Color.DARK_GRAY};
	public static Income income = Income.getObject();
	
	private String category;
	private double amount;
	
	private String[][] incomeData;
	
	private double totalIncomes;
	private String[] row = new String[100];
	
	private JLabel incomes, totalIncome;
	private JTable incomeTable;
	private DefaultTableModel model;
	
	private JButton addInc, deleteInc;
    private JPanel chart_panel1;			//bar chart panel
    private JPanel chart_panel2;			//pie chart panel
    private JComboBox<String> chart_types;
    private JComboBox<String> monthes;
	private JComboBox<String> timely;
	private JScrollPane scroll_pane;	
	
	private ArrayList<Slice> slices;
	private PieChart pie_chart;
	private BarChart bar_chart;
	
	
	/**
	  	Constructing expense panel
	 */
	public IncomePanel()
	{
		this.init();
		this.modify();
		this.readFromFile();
		this.listen();
		this.setVisible(false);
		
	}
	
	/**
	  	Initializing the objects (containers)
	 */
	private void init()
	{
		incomes = new JLabel("Incomes");
		
		incomeTable = new JTable()							//Adding tool tip tex for the cells of the table
		{	
			private static final long serialVersionUID = 1L;
			//Implement table cell tool tips.           
            public String getToolTipText(MouseEvent e) 
            {
                String tip = null;
                Point p = e.getPoint();
                int rowIndex = rowAtPoint(p);
                int colIndex = columnAtPoint(p);

                try 
                {
                    tip = getValueAt(rowIndex, colIndex).toString();
                } 
                catch (RuntimeException e1) 
                {
                    System.out.println("ERROR");
                }

                return tip;
            }
        };
        
		addInc = new JButton("Add Income");
		deleteInc = new JButton("Delete Income");
		timely = new JComboBox<>();
		scroll_pane = new JScrollPane();
		chart_panel1 = new JPanel();
		chart_panel2 = new JPanel();
		chart_types = new JComboBox<>();
		monthes = new JComboBox<>();	
			
		incomeData = new String[100][13];
		totalIncome = new JLabel("Total Incomes: " + totalIncomes);
		
		slices = new ArrayList<>();
		
		pie_chart = new PieChart(slices);
		pie_chart.setPreferredSize(new Dimension(240,240));
		
		bar_chart = new BarChart(6000);
		bar_chart.setPreferredSize(new Dimension(307,261));
		
		//As default : When the program starts only bar chart panel will be shown
		chart_panel2.setVisible(false);
	
		//Making focusable
		chart_panel1.setFocusable(true);
		chart_panel2.setFocusable(true);
		
		
	}
	
	/**
	  	Reading income data from the income file
	 */

	private void readFromFile()
	{
		DataSet ds = new DataSet("Incomes.txt");
		
		ds.readFromFile();
		
		ArrayList<DataItem> readDataItem = ds.getDataItems();
		ArrayList<String> categories = new ArrayList<>();
		
		for(DataItem eachDataItem : readDataItem)
		{
			categories.add(eachDataItem.getCategory());
		}
				
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
		
		System.out.println("[[[[[[[[[[[[[[[[[" + categories.size());
		
		model.setRowCount(categories.size());
			
		for(DataItem eachDataItem : readDataItem)
		{
			String[] fullDate = eachDataItem.getDate().split("/");
			String month = fullDate[1];
		
			try 
			{
				Data dataForIncome = new Data(eachDataItem.getCategory(),
						Double.parseDouble(eachDataItem.getAmount()),
						new Time(Integer.parseInt(fullDate[0]), Integer.parseInt(fullDate[1]), Integer.parseInt(fullDate[2])));
				
				income.addIncome(dataForIncome);
			} catch (NumberFormatException | NoSuchDateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			System.out.println("Index:" + income.getIndex(eachDataItem.getCategory()));
			//addding to the income table
			model.setValueAt(eachDataItem.getCategory(), income.getIndex(eachDataItem.getCategory()), 0);
			model.setValueAt(eachDataItem.getAmount(), income.getIndex(eachDataItem.getCategory()), Integer.parseInt(month));
			
			System.out.println("------");
			System.out.println(income);
			System.out.println("------");
			
			totalIncome.setText("Total Incomes: " + income.getTotalIncome());
	
			HomePanel.updatePieChart();
			HomePanel.updateProgressBar1();
			HomePanel.updateProgressBar2();
		}
		
	}
	/**
	  	Writing income data to the income file
	 */
	public void writeToFile()
	{
		DataSet ds = new DataSet("Incomes.txt");
		
		ds.prepareToWrite();
		
		for(Data data : income.getIncomes())
		{
			String date;
			date = "" +   data.getTime().getDay();
			date += "/" + data.getTime().getMonth();
			date += "/" + data.getTime().getYear();
			
			ds.add(data.getCategory(), data.getAmount() + "", date);
		}
		
		ds.writeToFile();
	}
	
	/**
	  	Modifiying the components and locating them in the frame
	 */
	private void modify()
	{
		timely.setModel(new DefaultComboBoxModel<>(new String[] { "monthly"}));
		chart_types.setModel(new DefaultComboBoxModel<>(new String[] { "Bar Chart", "Pie Chart" }));
		monthes.setModel(new DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
		
		model = new DefaultTableModel(incomeData, MONTHS);

		//model.setRowCount(0);
		//model.setRowCount(1);;
		//model.setValueAt("0", 0, 0);
		
		incomeTable.setModel(model);
		
	        scroll_pane.setViewportView(incomeTable);
	        if (incomeTable.getColumnModel().getColumnCount() > 0) 
	        {
	        	incomeTable.getColumnModel().getColumn(0).setHeaderValue(" ");
	        	incomeTable.getColumnModel().getColumn(1).setHeaderValue("JAN");
	        	incomeTable.getColumnModel().getColumn(2).setHeaderValue("FEB");
	        	incomeTable.getColumnModel().getColumn(3).setHeaderValue("MAR");
	        	incomeTable.getColumnModel().getColumn(4).setHeaderValue("APR");
	        	incomeTable.getColumnModel().getColumn(5).setHeaderValue("MAY");
	        	incomeTable.getColumnModel().getColumn(6).setHeaderValue("JUN");
	        	incomeTable.getColumnModel().getColumn(7).setHeaderValue("JUL");
	        	incomeTable.getColumnModel().getColumn(8).setHeaderValue("AUG");
	        	incomeTable.getColumnModel().getColumn(9).setHeaderValue("SEP");
	        	incomeTable.getColumnModel().getColumn(10).setHeaderValue("OCT");
	        	incomeTable.getColumnModel().getColumn(11).setHeaderValue("NOV");
	        	incomeTable.getColumnModel().getColumn(12).setHeaderValue("DEC");
	        }
	       
	        GroupLayout chart_panel1Layout = new GroupLayout(chart_panel1);
	        chart_panel1.setLayout(chart_panel1Layout);
	        chart_panel1Layout.setHorizontalGroup(
	            chart_panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 600, Short.MAX_VALUE)
	        );
	        
	        
	        chart_panel1Layout.setVerticalGroup(
	            chart_panel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 269, Short.MAX_VALUE)
	        );
	             
	        GroupLayout chart_panel2Layout = new GroupLayout(chart_panel2);
	        chart_panel2.setLayout(chart_panel2Layout);
	        chart_panel2Layout.setHorizontalGroup(
	            chart_panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 240, Short.MAX_VALUE)
	        );
	        chart_panel2Layout.setVerticalGroup(
	            chart_panel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGap(0, 240, Short.MAX_VALUE)
	        );
	        
	        chart_panel1.setBackground(new Color(238,238,238));
	        chart_panel1.setLayout(new BorderLayout());
	        chart_panel1.setFocusable(true);
	        chart_panel1.add(bar_chart, BorderLayout.CENTER);

	        chart_panel2.setBackground(new Color(238,238,238));
	        chart_panel2.setLayout(new BorderLayout());
	        chart_panel2.setFocusable(true);
	        chart_panel2.add(pie_chart, BorderLayout.CENTER);
	 
	        GroupLayout expensePanelLayout = new GroupLayout(this);
	        this.setLayout(expensePanelLayout);
	        expensePanelLayout.setHorizontalGroup(
	            expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(expensePanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addComponent(scroll_pane)
	                    .addGroup(expensePanelLayout.createSequentialGroup()
	                        .addComponent(incomes)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(timely, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))    
	                    .addGroup(expensePanelLayout.createSequentialGroup()
	                        .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
	                            .addComponent(chart_panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                            .addComponent(totalIncome)
	                            .addGroup(GroupLayout.Alignment.LEADING, expensePanelLayout.createSequentialGroup()
	                                .addComponent(addInc, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
	                                .addGap(18, 18, 18)
	                                .addComponent(deleteInc, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)))
	                        .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                            .addGroup(expensePanelLayout.createSequentialGroup()
	                                .addGap(39, 39, 39)
	                                .addComponent(chart_types, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
	                                .addComponent(monthes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                            .addGroup(expensePanelLayout.createSequentialGroup()	                            		
	                            		.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)                                
	                                .addGap(18, 18, 18)
	                                .addComponent(chart_panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
	                				
	                			.addContainerGap())
	        );
	        expensePanelLayout.setVerticalGroup(
	            expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(expensePanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                    .addComponent(timely, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
	                    .addComponent(incomes)
	                    .addComponent(totalIncome))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(scroll_pane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
	                        .addComponent(deleteInc, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(chart_types, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
	                        .addComponent(monthes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
	                    .addComponent(addInc, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	                    .addGroup(expensePanelLayout.createSequentialGroup()
	                        .addComponent(chart_panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
	                        .addGap(0, 30, Short.MAX_VALUE)
	                    .addGroup(expensePanelLayout.createSequentialGroup()
	                        .addComponent(chart_panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)                        
	                        .addContainerGap(18, Short.MAX_VALUE))
	        ))));
	}
	
	/**
	  	Will add the listeners to the components
	 */
	private void listen()
	{
		addInc.addActionListener(new Handler());
		
		HomePanel.getIncBtn().addActionListener(new Handler());
		
		deleteInc.addActionListener(new Handler());
		
		chart_types.addActionListener(new Handler());
		
		monthes.addActionListener(new Handler());	
		
	}
	
	/**
	  	Inner class for the listeners
	 */
	private class Handler implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == addInc || e.getSource() == HomePanel.getIncBtn())
			{
				try
				{
					System.out.println(income);
					// asking input from the user by a pop up menu
					JOptionPaneMultiInput jp = new JOptionPaneMultiInput("Add Income", 3);
					
					category = jp.getTxtf2().getText();
					String amountTxt = jp.getTxtf1().getText();
					
					int day = jp.getDay();
					int month = jp.getMonth();
					int year = jp.getYear();
					
					amount = Double.parseDouble(amountTxt);
					// End of getting the inputs and converting them to the proper format
		
					Data data = new Data(category, amount, new Time(day, month, year));
					
					
					String[] row = new String[13];
					
					if(!income.contains(data))
					{
						if(income.getIncomes().size() > 0)
						{
							int count = 0;
							
							for(int i = 0; i < income.getIncomes().size(); i++)
							{
								if(income.getIncomes().get(i).getCategory().equals(data.getCategory()))
								{
									income.addIncome(data);
									System.out.println("*******" + income.getIndex(data.getCategory()));
									model.setValueAt("" + amount, income.getIndex(data.getCategory()), month);
									break;
								}
								else
								{
									count++;
								}
								
								if(count == income.getIncomes().size())
								{
									income.addIncome(data);
									row[0] = data.getCategory();
									row[month] = data.getAmount() + "";
									model.addRow(row);
									System.out.println("========" + income.getIndex(data.getCategory()));
									break;
								}
							}
						}
						else
						{
							income.addIncome(data);
							row[0] = data.getCategory();
							row[month] = data.getAmount() + "";
							model.addRow(row);
						}
					}
					else
					{
						System.out.println(income.getAmount(new Time(day, month, year), data.getCategory()));
						if(income.getAmount(new Time(day, month, year), data.getCategory()) != 0)
						{
							System.out.println(income.getIndex(data.getCategory()));
							double total = income.getAmount(new Time(day, month, year), category) + amount; 
							income.setAmount(new Time(day, month, year), category, total);
							model.setValueAt("" + total, income.getIndex(data.getCategory()), month);
						}
					}
					//End
					totalIncome.setText("Total Expenses: " + income.getTotalIncome());
					
					HomePanel.updatePieChart();
					HomePanel.updateProgressBar1();
					HomePanel.updateProgressBar2();
					
					bar_chart.repaint();
					chart_panel1.repaint();
					pie_chart.repaint();
					chart_panel2.repaint();
					
					System.out.println(income);
				}
				catch(NumberFormatException e1)
				{
					JOptionPane.showMessageDialog(MainFrame.getFrame(), "Wrong input types!", "ERROR", 1);
				}
				catch(NoSuchDateException e2)
				{
					JOptionPane.showMessageDialog(MainFrame.getFrame(), e2.getMessage(), "ERROR", 1);
				}
			}
			
			else if(e.getSource() == deleteInc)
			{
				System.out.println(income);
				
				try
				{
					JOptionPaneMultiInput jp = new JOptionPaneMultiInput("Delete Expense", 2);
					String category = jp.getTxtf2().getText();
					int month = Integer.parseInt(jp.getTxtf3().getText());
					
					int index = income.getIndex(category);
					
					try
					{
						income.deleteIncome(category, month);				
														
						model.setValueAt(null, index, month);
						totalIncome.setText("Total Expenses: " + income.getTotalIncome());
						
						for(int i = 1; i <= 12; i++)
						{
							if(model.getValueAt(index, i) == null)
							{
								if(i == 12)
								{
									model.removeRow(index);
								}
							}
							else
							{
								System.out.print("FLAG");
								break;
							}
						}
						
						//updating the visual components
						HomePanel.updatePieChart();
						HomePanel.updateProgressBar1();
						HomePanel.updateProgressBar2();
						
					}
					catch(Exception e2)
					{
						System.out.println(e2.getMessage());
						JOptionPane.showMessageDialog(MainFrame.getFrame(), "No such category to delete!", "ERROR", 1);
					}
				
					System.out.println(income);
					
					
				}
				catch(NumberFormatException e1)
				{
					System.out.print(e1.getMessage());
					JOptionPane.showMessageDialog(MainFrame.getFrame(), "Wrong input types!", "ERROR", 1);
				}
			}
			else if(e.getSource() == chart_types)
			{
				if(chart_types.getSelectedItem().equals("Bar Chart"))
                {
                    chart_panel1.setVisible(true);
                    chart_panel2.setVisible(false);
                    chart_panel1.repaint();
                }
                else if(chart_types.getSelectedItem().equals("Pie Chart"))
                {
                    chart_panel1.setVisible(false);
                    chart_panel2.setVisible(true);
                    chart_panel2.repaint();
                }
			}
			else if(e.getSource() == monthes)
			{
				int a = monthes.getSelectedIndex() + 1;
          	  
	           	 // JOptionPane.showMessageDialog(null, monthes.getSelectedItem() + "\nTotal expense: " + expense.monthlyTotalExpenses(a));
	           	  
				//clearing the charts
	           	  bar_chart.clear();
	           	  pie_chart.clear();
	           	  bar_chart.repaint();
	           	  pie_chart.repaint();
	           	  
	           	  double amount = 0;
	           	  int temp = 0;
	           	  
	           	  for(int i = 0; i < model.getRowCount(); i++)
	           	  {
	           		  if(temp == COLORS.length)
	           		  {
	           			  temp = 0;
	           		  }
	           		  
	           		  Color color = COLORS[temp];
	           		  temp++;
	           		  
	           		  if(model.getValueAt(i, a) != null)
	           		  {
		            		  double value = Double.parseDouble((String) (model.getValueAt(i, a)));
		            		  amount += value;
		            		  
		            		  if(((String)(model.getValueAt(i, 0))).length() >= 3)
		            			  bar_chart.append(amount, ((String)(model.getValueAt(i, 0))).substring(0, 3));
		            		  else
		            			  bar_chart.append(amount, ((String)(model.getValueAt(i, 0))));
		            		  
		            		  pie_chart.addSlice(amount, color);
		            		  
		            		  amount = 0;
	           		  }
	           	  }
	           	  
	           	  JOptionPane.showMessageDialog(MainFrame.getFrame(), monthes.getSelectedItem() + "\nTotal Incomes: " + income.monthlyTotalIncomes(a, 2017));
	           	  
	           	  
	           	  //TODO - append monthly elements to the bar chart and the pie chart
	           	  
	           	  bar_chart.repaint();
	           	  chart_panel1.repaint();
	           	  pie_chart.repaint();
	           	  chart_panel2.repaint();
			}
		}
		
	}
		
	/**
	  	Access the components
	 */
	public JTable getExpenseTable()
	{
		return incomeTable;
	}
	
	public String[] getRow()//added
	{
		return row;
	}
	public DefaultTableModel getModel()//added
	{
		return model;
	}
	public Income getExpense()//added
	{
		return income;
	}	
}
