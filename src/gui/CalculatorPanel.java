package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;

/**
	CalculatorPanel - panel for calculator
	
	@authors 	Fuad Aghazada 
				Fatih Özgür Ardıç 
				Babanazar Gutlygeldiyev 
				Haya Shamim Khan Khattak 
				Orcan Yazıcı
	@version 1.00 
*/
public class CalculatorPanel extends JPanel 
{
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form CalculatorPanel
     */
    private double firstnum;
    private double secondnum;
    private String operations;
    private double result;
    
    // Variables declaration                    
    private JButton btn0;
    private JButton btn1;
    private JButton btn2;
    private JButton btn3;
    private JButton btn4;
    private JButton btn5;
    private JButton btn6;
    private JButton btn7;
    private JButton btn8;
    private JButton btn9;
    private JButton btnAdd;
    private JButton btnC;
    private JButton btnComma;
    private JButton btnDivide;
    private JButton btnEqual;
    private JButton btnMultiply;
    private JButton btnPercent;
    private JButton btnPos_Neg;
    private JButton btnSubstract;
    private JTextField txtField;
    
    public CalculatorPanel() 
    {
        initComponents();
        this.setVisible(false);
    }

    /**
     	Initializing the components
     */                        
    private void initComponents() 
    {

        txtField = new JTextField();
        btnC = new JButton();
        btnPos_Neg = new JButton();
        btnPercent = new JButton();
        btn7 = new JButton();
        btn8 = new JButton();
        btn9 = new JButton();
        btn4 = new JButton();
        btn5 = new JButton();
        btn6 = new JButton();
        btn1 = new JButton();
        btn2 = new JButton();
        btn3 = new JButton();
        btn0 = new JButton();
        btnComma = new JButton();
        btnDivide = new JButton();
        btnMultiply = new JButton();
        btnSubstract = new JButton();
        btnAdd = new JButton();
        btnEqual = new JButton();
        
        txtField.setEditable(false);

        btnC.setText("C");
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCActionPerformed(evt);
            }
        });

        btnPos_Neg.setText("+/-");
        btnPos_Neg.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPos_NegActionPerformed(evt);
            }
        });

        btnPercent.setText("%");
        btnPercent.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnPercentActionPerformed(evt);
            }
        });

        btn7.setText("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn8.setText("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn9.setText("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        btn4.setText("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn5.setText("5");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn6.setText("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn1.setText("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn2.setText("2");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn3.setText("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn0.setText("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btn0ActionPerformed(evt);
            }
        });

        btnComma.setText(".");
        btnComma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCommaActionPerformed(evt);
            }
        });

        btnDivide.setText("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnDivideActionPerformed(evt);
            }
        });

        btnMultiply.setText("X");
        btnMultiply.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnMultiplyActionPerformed(evt);
            }
        });

        btnSubstract.setText("-");
        btnSubstract.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSubstractActionPerformed(evt);
            }
        });

        btnAdd.setText("+");
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEqual.setText("=");
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnEqualActionPerformed(evt);
            }
        });

        this.locateAdd();
        
    }
    /**
      	Locate the components and add
     */
    private void locateAdd()
    {
    	GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnC, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPos_Neg, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPercent, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btn0, GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnComma, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(btnSubstract, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnMultiply, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDivide, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEqual, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(187, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btnC, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPos_Neg, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPercent, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn7, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn8, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn9, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn4, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn5, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn6, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn1, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn2, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn3, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btn0, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnComma, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnDivide, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMultiply, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSubstract, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAdd, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEqual, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }

    private void btn1ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn1.getText());
    }                                    

    private void btn2ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn2.getText());
    }                                    

    private void btn3ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn3.getText());
    }                                    

    private void btn4ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn4.getText());
    }                                    

    private void btn5ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn5.getText());
    }                                    

    private void btn6ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn6.getText());
    }                                    

    private void btn7ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn7.getText());
    }                                    

    private void btn8ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn8.getText());
    }                                    

    private void btn9ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn9.getText());
    }                                    

    private void btn0ActionPerformed(ActionEvent evt) {                                     
        txtField.setText(txtField.getText() + btn0.getText());
    }                                    

    private void btnCActionPerformed(ActionEvent evt) {                                     
        txtField.setText("");
    }                                    

    private void btnAddActionPerformed(ActionEvent evt) {                                       
        firstnum = Double.parseDouble(txtField.getText());
        txtField.setText("");
        operations = "+";
    }                                      

    private void btnSubstractActionPerformed(ActionEvent evt) {                                             
        firstnum = Double.parseDouble(txtField.getText());
        txtField.setText("");
        operations = "-";
    }                                            

    private void btnMultiplyActionPerformed(ActionEvent evt) {                                            
        firstnum = Double.parseDouble(txtField.getText());
        txtField.setText("");
        operations = "*";
    }                                           

    private void btnDivideActionPerformed(ActionEvent evt) {                                          
        firstnum = Double.parseDouble(txtField.getText());
        txtField.setText("");
        operations = "/";
    }                                         

    private void btnCommaActionPerformed(ActionEvent evt) {                                         
        txtField.setText(txtField.getText() + btnComma.getText());
    }                                        

    private void btnPos_NegActionPerformed(ActionEvent evt) {                                           
        double ops = Double.parseDouble(String.valueOf(txtField.getText()));
        ops *= -1;
        txtField.setText(String.valueOf(ops));
    }                                          

    private void btnEqualActionPerformed(ActionEvent evt) {                                         
        String answer;
        
        secondnum = Double.parseDouble(txtField.getText());
        
        if(operations.equals("+"))
        {
            result = firstnum + secondnum;
            answer = String.format("%.1f", result);
            txtField.setText(answer);
        }
        else if(operations.equals("-"))
        {
            result = firstnum - secondnum;
            answer = String.format("%.1f", result);
            txtField.setText(answer);
        }
        else if(operations.equals("*"))
        {
            result = firstnum * secondnum;
            answer = String.format("%.1f", result);
            txtField.setText(answer);
        }
        else if(operations.equals("/"))
        {
            try
            {
                result = firstnum / secondnum;
                answer = String.format("%.1f", result);
                txtField.setText(answer);
            }
            catch(ArithmeticException e)
            {
                System.out.println("Error");
             }
        }
    }                                        

    private void btnPercentActionPerformed(ActionEvent evt) 
    {                                           
        double percentage = Double.parseDouble(txtField.getText()) / 100.0;
        String answer = String.format("%.10f", percentage);
        txtField.setText(answer);
    }                                          
   

   
}
