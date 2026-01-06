/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java2ddrawingapplication;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author jmw
 */
public class DrawingApplicationFrame extends JFrame
{

    // Create the panels for the top of the application. One panel for each
    // line and one to contain both of those panels.
    private final JPanel panel1;
    private final JPanel panel2;
    private final JPanel topPanel;
    // create the widgets for the firstLine Panel.
    private final JLabel string1;
    private final JButton color1Button;
    private Color color1;
    private final JButton color2Button;
    private Color color2;
    private final JButton undoButton;
    private final JButton clearButton;
    private final JComboBox<String> shapeJComboBox;
    private final ArrayList<MyShapes> shapes;
    private MyShapes currentShape;
    private String selectedShape;
    // create the widgets for the secondLine Panel.
    private final JLabel string2;
    private final JCheckBox fillCheckBox;
    private final JCheckBox gradientCheckBox;
    private final JCheckBox dashCheckBox;
    private final JLabel string3;
    private final JSpinner width;
    private final JLabel string4;
    private final JSpinner length;
    // Variables for drawPanel.
    private final DrawPanel drawPanel;
    // add status label
    private final JLabel status;
    // Constructor for DrawingApplicationFrame
    public DrawingApplicationFrame()
    {
        super("Java 2D Drawings");
        
        // add widgets to panels
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        string1 = new JLabel("Shape: ");
        String[] shapeOption= {"Line","Oval","Rectangle"};
        shapes = new ArrayList<>();
        shapeJComboBox = new JComboBox<String>(shapeOption);
        color1Button = new JButton("1st Color...");
        color2Button = new JButton("2nd Color...");
        undoButton = new JButton("Undo");
        clearButton = new JButton("Clear");
        shapeJComboBox.setMaximumRowCount(4);
        shapeJComboBox.setSelectedIndex(0);
        
                
        panel1.add(string1);
        panel1.add(shapeJComboBox);
        panel1.add(color1Button);
        panel1.add(color2Button);
        panel1.add(undoButton);
        panel1.add(clearButton);
        panel1.setBackground(new Color(135, 206, 235));
   
        // firstLine widgets
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout());
        string2 = new JLabel("Options: ");
        fillCheckBox = new JCheckBox("Filled");
        gradientCheckBox = new JCheckBox("Use Gradient");
        dashCheckBox = new JCheckBox("Dashed");
        string3 = new JLabel("Line Width: ");
        width = new JSpinner(new SpinnerNumberModel(10, 1, 99, 1));
        string4 = new JLabel("Dash Length: ");
        length = new JSpinner(new SpinnerNumberModel(10, 1, 99, 1));
        // secondLine widgets
        panel2.add(string2);
        panel2.add(fillCheckBox);
        panel2.add(gradientCheckBox);
        panel2.add(dashCheckBox);
        panel2.add(string3);
        panel2.add(width);
        panel2.add(string4);
        panel2.add(length);
        panel2.setBackground(new Color(135, 206, 235));
        // add top panel of two panels
        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(2,1));
        topPanel.add(panel1);
        topPanel.add(panel2);
        topPanel.setBackground(new Color(135, 206, 235));
        
        

        // add topPanel to North, drawPanel to Center, and statusLabel to South
        drawPanel = new DrawPanel();
        status = new JLabel();
        status.setBackground(Color.LIGHT_GRAY);
        add(drawPanel, BorderLayout.CENTER);
        add(status, BorderLayout.SOUTH);
        
        
        add(topPanel, BorderLayout.NORTH);
        
        //add listeners and event handlers
        
        
        color1Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                color1 =JColorChooser.showDialog(DrawingApplicationFrame.this,"", color1);
            }
        });
        color2Button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                color2 =JColorChooser.showDialog(DrawingApplicationFrame.this,"", color2);
            }
        });
        
        undoButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
        if (!shapes.isEmpty()) {
                shapes.remove(shapes.size() - 1);
                drawPanel.repaint();
                
            }
        }});
        
        clearButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent event){
                shapes.clear();
                drawPanel.repaint();
            }
        });
        
        MouseAdapter mouseHandler = drawPanel.new MouseHandler();
        drawPanel.addMouseMotionListener(mouseHandler);
        drawPanel.addMouseListener(mouseHandler);
        
        drawPanel.addMouseMotionListener(new MouseAdapter(){
            public void mouseMoved(MouseEvent event){
                status.setText(String.format("(%d,%d)", event.getX(), event.getY()));
    }});
        
    }
    
    // Create event handlers, if needed
    
    // Create a private inner class for the DrawPanel.
    private class DrawPanel extends JPanel
    {
        
        
        
        public DrawPanel()
        {
            setBackground(Color.WHITE);
        }

        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            
            for (MyShapes shape : shapes){
                shape.draw(g2d);
                
            }
            
            if (currentShape != null){
                currentShape.draw(g2d);
            
            
                }
            //loop through and draw each shape in the shapes arraylist

        }


        private class MouseHandler extends MouseAdapter implements MouseMotionListener
        {

            public void mousePressed(MouseEvent event)
            {
                Point startPoint = event.getPoint();
                String selectedShape = (String) shapeJComboBox.getSelectedItem();
                int lineWidth = (int) width.getValue();
                float[] dashLength = {(int) length.getValue()};
                
                Stroke stroke;
                if (dashCheckBox.isSelected())
            {
                stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10, dashLength, 0);
            }   else
            {
                stroke = new BasicStroke(lineWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
            }
                
                Paint paint;
                if (gradientCheckBox.isSelected())
            {
                paint = new GradientPaint(0, 0, color1, 50, 50, color2, true);
            }   else
            {
                paint = color1;
            
            }
                if (selectedShape == ("Line")) {
                    currentShape = new MyLine(startPoint, startPoint, paint, stroke);}
                else if (selectedShape == ("Oval")) {
                    if (fillCheckBox.isSelected()) {
                        currentShape = new MyOval(startPoint, startPoint, paint, stroke, true);
                    } else 
                    {
                        currentShape = new MyOval(startPoint, startPoint, paint, stroke, false);
                    }
                }
                
                else if (selectedShape == ("Rectangle")) {
                    if (fillCheckBox.isSelected()) {
                        currentShape = new MyRectangle(startPoint, startPoint, paint, stroke, true);
                    } else {
                        currentShape = new MyRectangle(startPoint, startPoint, paint, stroke, false);
                    }}
            }

            public void mouseReleased(MouseEvent event)
            {
                if (currentShape != null) 
                {
                    currentShape.setEndPoint(event.getPoint());
                    shapes.add(currentShape);
                    
                    currentShape = null;
                    repaint();
                
            }}

            @Override
            public void mouseDragged(MouseEvent event)
            {
                if (currentShape != null) {
                    currentShape.setEndPoint(event.getPoint());
                    status.setText(String.format("(%d,%d)", event.getX(), event.getY()));
            }}

            @Override
            public void mouseMoved(MouseEvent event)
            {
                status.setText(String.format("(%d,%d)", event.getX(), event.getY()));
            }
        }

    }
}
