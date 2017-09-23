package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.table.DefaultTableModel;

import core.Saving;
/**
	Saving panel - panel for seaving
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/
public class SavingsPanel extends JPanel
{
	//class variables 
	private static final long serialVersionUID = 1L;
	private static final int FRAME_WIDTH = 605;
	private static final int FRAME_HEIGHT = 520;
	private static final int FIELD_WIDTH = 7;

	private static final double SAVINGS_GOAL = 0;
	//private static final double Expenses;
	//private static final double Income;

	private static final String[] MONTHS = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
	private String[][] savingsData;
	
	private JLabel goalLabel;
	
	
	private JTextField goalField;
	private JButton button;
	private JLabel resultLabel;
	private static double goalach = 0;
	private Saving obj = Saving.getObject(); 
	private SavingsImage image;
	
	private JProgressBar progress_bar;
	private JTable savingsTable;
	private String[] row;
	private JScrollPane scroll_pane;
	private DefaultTableModel model;
	private JComboBox<String> timely;
	private JLabel savings;
	
	private JPanel panel;

	/**
	  	Constructs a saving panel
	 */
	public SavingsPanel() 
	{		
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		
		createTable();
		createTextField();
		createButton();
		createProgressBar();
		createPanel(); 
		
		this.addMouseListener(new MouseHandler());
		
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setVisible(false);
	}
	
	/**
	  	Creates a table for savings (monthly)
	 */
	private void createTable()
	{
		timely = new JComboBox<>();
		timely.setModel(new DefaultComboBoxModel<>(new String[] { "monthly"}));
		
		savings = new JLabel("Savings");
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(605,260));
		
		savingsTable = new JTable();
		scroll_pane = new JScrollPane();
        
		model = new DefaultTableModel(savingsData, MONTHS);
		model.setRowCount(0);
		row = new String[13];
		model.addRow(row);
		savingsTable.setModel(model);
		
		
		
		scroll_pane.setViewportView(savingsTable);
		if (savingsTable.getColumnModel().getColumnCount() > 0) 
        {
			savingsTable.getColumnModel().getColumn(0).setHeaderValue("JAN");
        	savingsTable.getColumnModel().getColumn(1).setHeaderValue("FEB");
        	savingsTable.getColumnModel().getColumn(2).setHeaderValue("MAR");
        	savingsTable.getColumnModel().getColumn(3).setHeaderValue("APR");
        	savingsTable.getColumnModel().getColumn(4).setHeaderValue("MAY");
        	savingsTable.getColumnModel().getColumn(5).setHeaderValue("JUN");
        	savingsTable.getColumnModel().getColumn(6).setHeaderValue("JUL");
        	savingsTable.getColumnModel().getColumn(7).setHeaderValue("AUG");
        	savingsTable.getColumnModel().getColumn(8).setHeaderValue("SEP");
        	savingsTable.getColumnModel().getColumn(9).setHeaderValue("OCT");
        	savingsTable.getColumnModel().getColumn(10).setHeaderValue("NOV");
            savingsTable.getColumnModel().getColumn(11).setHeaderValue("DEC");

        }
		
		//locating
		
		GroupLayout expensePanelLayout = new GroupLayout(panel);
        panel.setLayout(expensePanelLayout);
        expensePanelLayout.setHorizontalGroup(
            expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(expensePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(scroll_pane)
                    .addGroup(expensePanelLayout.createSequentialGroup()
                    		.addComponent(savings)
	                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                        .addComponent(timely, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE))
	                    .addGroup(expensePanelLayout.createSequentialGroup()
                 .addContainerGap()))));
       
        expensePanelLayout.setVerticalGroup(
	            expensePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
	            .addGroup(expensePanelLayout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(expensePanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
		                    .addComponent(timely, GroupLayout.PREFERRED_SIZE, 15, GroupLayout.PREFERRED_SIZE)
		                    .addComponent(savings))
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
	                .addComponent(scroll_pane, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE)
	                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)));

		this.add(panel);	
	}
	
	/**
	  	Creating progressbar
	 */
	private void createProgressBar()
	{
		progress_bar = new JProgressBar();
		progress_bar.setBorderPainted(isEnabled());
		progress_bar.setPreferredSize(new Dimension(200,45));
	}
	
	/**
	  	Creating textfields and labels
	 */
	private void createTextField() 
	{
		resultLabel = new JLabel("Your house is " + goalach + "% complete.");
		goalLabel = new JLabel("Savings Goal: ");
	
	      
	    goalField = new JTextField(FIELD_WIDTH);
	    goalField.setText("" + SAVINGS_GOAL);
	}
	
	/**
	  	Inner class for listener
	 */
	class GoalAchievedListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent event)
		{
			//home progress bar works here
			double goal = Double.parseDouble(goalField.getText());
			obj.setGoal(goal);
			double totalSavings =0;
			
			for(int i = 1; i <= 12; i++)
			{
				totalSavings += obj.monthlyTotalSaving(i, 2017);
			}
			
			goalach = obj.roundoff(totalSavings);
			image.setState(goalach);
			image.repaint();
			resultLabel.setText("Goal Achieved: " + goalach + "%");
			
//			HomePanel.setPercentage1(goalach);
//			HomePanel.getLabel3().setText("You have achieved " + goalach + "% of your savings goal");
//			HomePanel.getProgressBar1().setValue((int)(goalach));
			HomePanel.updateProgressBar1();
			HomePanel.updateProgressBar2();
		} 
	}
	
	/**
	  	Inner class for mouse listener
	 */
	class MouseHandler extends MouseAdapter
	{
		//when the mouse entered the savings panel the table is updated
		public void mouseEntered(MouseEvent e)
		{		
			for(int i = 1; i <= 12; i++)
			{	
				double total =0;
				
				for(int o = 1; o <= 30; o++)
				{
					total += obj.dailyTotalSaving(o, i, 2017);
				}

				model.setValueAt("" + total,0,i-1);
			}
		}
		
		//when the mouse is clicked the total savings is shown
		public void mouseClicked(MouseEvent e)
		{	
			double total =0;
			
			for(int i = 1; i <= 12; i++)
			{	
				for(int o = 1; o <= 30; o++)
				{			
					total += obj.dailyTotalSaving(o, i, 2017);
				}
			}
			JOptionPane.showMessageDialog(MainFrame.getFrame(), "Total Savings:"  + total);
		}
	}
	
	/**
	  	Creates the button for adding the goal
	 */
	public void createButton()
	{
		button = new JButton("Add Savings Goal");
 		
		ActionListener listener = new GoalAchievedListener();
		button.addActionListener(listener);
	}
	
	/**
	  	Creates the panel for home image and txffields
	 */
	private void createPanel() 
	{
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new JPanel();
		JPanel panel4 = new JPanel();
		JPanel panel5 = new JPanel();
				
		panel1.setBackground(Color.WHITE);
		panel2.setBackground(Color.WHITE);
		panel3.setBackground(Color.WHITE);
		panel4.setBackground(Color.WHITE);
		panel5.setBackground(Color.WHITE);
		
		image = new SavingsImage();
		
		panel1.setLayout(new FlowLayout());		
		panel1.add(resultLabel);
		
		panel5.add(goalLabel);
		panel5.add(goalField);
		panel5.add(button);
		
	
		panel3.setLayout(new BorderLayout());
		panel3.add (image, BorderLayout.CENTER);
		panel3.add (panel5, BorderLayout.SOUTH);
		
		panel4.setPreferredSize(new Dimension(605,230));
		panel4.setLayout(new BorderLayout());
		panel4.add(panel1, BorderLayout.NORTH);
		panel4.add(panel3, BorderLayout.CENTER);
		
		add(panel4, BorderLayout.SOUTH);
	} 
	
	/**
	  	Getter and setters
	 */
	public Saving getobj()
	{
		return this.obj;
	}
	
	public static double getGoalAch()
	{
		return goalach;
	}
	 
	

}
