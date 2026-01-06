/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pizza.servings.calculator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PizzaServingsCalculator extends JFrame  {

    private final JLabel titleLabel;
    private final JLabel pizzaSizePromptLabel;
    private final JTextField pizzaSizeTextField;
    private final JButton convertButton;
    private final JLabel numberOfServingsLabel;
    private final JPanel inputPanel;

    public PizzaServingsCalculator() {
        setTitle("Pizza Servings Calculator");
        
        
        setLayout(new GridLayout(4, 1)); 

        titleLabel = new JLabel("Pizza Servings Calculator", SwingConstants.CENTER);
        
        titleLabel.setFont(new Font("Serif", Font.BOLD,  24));
        titleLabel.setForeground(Color.RED);

        
        pizzaSizePromptLabel = new JLabel("Enter the size of the pizza in inches: ");
        pizzaSizeTextField = new JTextField(4); 
        
        
        
        inputPanel = new JPanel();
        inputPanel.add(pizzaSizePromptLabel);
        
        inputPanel.add(pizzaSizeTextField);
  
        
        
        convertButton = new JButton("Calculate Servings");
      
        convertButton.addActionListener(new ButtonHandler());
        
        numberOfServingsLabel = new JLabel("", SwingConstants.CENTER);
        
        numberOfServingsLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        add(titleLabel); 
        add(inputPanel); 
        add(convertButton); 
        add(numberOfServingsLabel); 
        
        
        }
    
    private class ButtonHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            
                double size = Double.parseDouble(pizzaSizeTextField.getText());
                
                double servings = Math.pow(size / 8.0, 2);
                
                String formattedServings = String.format("%.2f",  servings);
                
                int intSize = (int) size; 
                
                numberOfServingsLabel.setText("A " + intSize + " inch pizza will serve " + formattedServings + " people.");}
    }

    public static void main(String[] args) {
        PizzaServingsCalculator calculator = new PizzaServingsCalculator();
        
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        calculator.setSize(350, 300);
        
        calculator.setVisible(true);
    }
}