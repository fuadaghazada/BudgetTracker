package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

/**
	MainFrame class - creates the graphics user interface for main
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/
public class MainFrame extends JFrame
{
	//class variables
	private static final long serialVersionUID = 1L;
	private HomePanel home_panel;
	private ExpensePanel expense_panel;
	private IncomePanel income_panel;
	private SavingsPanel savings_panel;
	private CalculatorPanel calculator_panel;
	private JMenuBar menuBar;
	private JMenu[] menus;
	
	private static MainFrame frame;
		
	/**
	 	Constructing the main frame of the program
	 */
	public MainFrame()
	{
		super("Budget Tracker");
		this.setLayout(new BorderLayout());
		
		this.init();
		this.listen();
	
		this.addContainers();
		
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.pack();
	    this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	/**
	 	Initializing the containers
	 */
	private void init()
	{
		home_panel = new HomePanel();
		expense_panel = new ExpensePanel();
		income_panel = new IncomePanel();
		savings_panel = new SavingsPanel();
		calculator_panel = new CalculatorPanel();
		
		home_panel.setPreferredSize(new Dimension(605,520));
		expense_panel.setPreferredSize(new Dimension(605,520));
		income_panel.setPreferredSize(new Dimension(605,520));
		savings_panel.setPreferredSize(new Dimension(605,520));
		calculator_panel.setPreferredSize(new Dimension(605,520));
		
		menuBar = new JMenuBar();
		menus = new JMenu[5];
		
		menus[0] = new JMenu("Home");
		menus[1] = new JMenu("Expenses");
		menus[2] = new JMenu("Income");
		menus[3] = new JMenu("Savings");
		menus[4] = new JMenu("Calculator");
		
		
	}
	
	private void listen()
	{
		/*
	 	Adding listener to each menu 
		 */
		menus[0].addMenuListener(new MenuListener() 
		{
	        public void menuSelected(MenuEvent evt)
	        {
	        	home_panel.setVisible(true);
	        	expense_panel.setVisible(false);
	        	income_panel.setVisible(false);
	        	savings_panel.setVisible(false);
	        	calculator_panel.setVisible(false);
	        }
	        public void menuDeselected(MenuEvent evt) {}
	        public void menuCanceled(MenuEvent evt) {}
	    });
		
		menus[1].addMenuListener(new MenuListener() 
		{
	        public void menuSelected(MenuEvent evt)
	        {
	        	home_panel.setVisible(false);
	        	expense_panel.setVisible(true);
	        	income_panel.setVisible(false);
	        	savings_panel.setVisible(false);
	        	calculator_panel.setVisible(false);
	        }
	        public void menuDeselected(MenuEvent evt) {}
	        public void menuCanceled(MenuEvent evt) {}
	    });
		
		menus[2].addMenuListener(new MenuListener() 
		{
	        public void menuSelected(MenuEvent evt)
	        {
	        	home_panel.setVisible(false);
	        	expense_panel.setVisible(false);
	        	income_panel.setVisible(true);
	        	savings_panel.setVisible(false);
	        	calculator_panel.setVisible(false);
	        }
	        public void menuDeselected(MenuEvent evt) {}
	        public void menuCanceled(MenuEvent evt) {}
	    });
		
		menus[3].addMenuListener(new MenuListener() 
		{
	        public void menuSelected(MenuEvent evt)
	        {
	        	home_panel.setVisible(false);
	        	expense_panel.setVisible(false);
	        	income_panel.setVisible(false);
	        	savings_panel.setVisible(true);
	        	calculator_panel.setVisible(false);
	        }
	        public void menuDeselected(MenuEvent evt) {}
	        public void menuCanceled(MenuEvent evt) {}
	    });
		
		menus[4].addMenuListener(new MenuListener() 
		{
	        public void menuSelected(MenuEvent evt)
	        {
	        	home_panel.setVisible(false);
	        	expense_panel.setVisible(false);
	        	income_panel.setVisible(false);
	        	savings_panel.setVisible(false);
	        	calculator_panel.setVisible(true);
	        }
	        public void menuDeselected(MenuEvent evt) {}
	        public void menuCanceled(MenuEvent evt) {}
	    });
		
		for(JMenu menu : menus)
		{
			menuBar.add(menu);
		}
		
		/**
		  	Asking the user before exiting the program
		 */
		addWindowListener(new WindowAdapter() {

			  @Override
			  public void windowClosing(WindowEvent we)
			  { 
				    String ObjButtons[] = {"Yes","No"};
				   
				    int PromptResult = JOptionPane.showOptionDialog(MainFrame.getFrame(), 
				        "Are you sure you want to exit?", "", 
				        JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, 
				        ObjButtons,ObjButtons[1]);
				    
				    if(PromptResult == 0)
				    {
				    	expense_panel.writeToFile();
				    	income_panel.writeToFile();
				    	home_panel.writeToFile();
				    	System.exit(0); 
				    }
			  }
			});
	}
	
	/**
	  	Adding initialized containers to the frame
	 */
	private void addContainers()
	{
		setJMenuBar(menuBar);
		
		GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 605, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            		.addComponent(home_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                .addComponent(expense_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(income_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(savings_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(calculator_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        ));
        
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGap(0, 424, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(home_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addComponent(expense_panel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(income_panel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(savings_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(calculator_panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))   
        ));
		
	}
	
	/**
	  	Access to the frame
	 */
	public static JFrame getFrame()
	{
		return frame;
	}
	
	/**
	  To run the program
	 */
	public static void main(String[] args)
	{
		frame = new MainFrame();
	}
	
}
