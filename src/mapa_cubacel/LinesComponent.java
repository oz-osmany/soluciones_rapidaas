/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author osmany.machado
 */


public class LinesComponent extends JComponent{

private static class Line{
    final int x1; 
    final int y1;
    final int x2;
    final int y2;   
    final Color color;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }               
}

private final LinkedList<Line> lines = new LinkedList<Line>();

public void addLine(int x1, int x2, int x3, int x4) {
    addLine(x1, x2, x3, x4, Color.black);
}

public void addLine(int x1, int x2, int x3, int x4, Color color) {
    lines.add(new Line(x1,x2,x3,x4, color));        
    repaint();
}

public void clearLines() {
    lines.clear();
    repaint();
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    for (Line line : lines) {
        g.setColor(line.color);
        g.drawLine(line.x1, line.y1, line.x2, line.y2);
    }
}
public void coordenadas(int x_1,int y_1,int x_2, int y_2)
{


            int x1 = x_1;
            int x2 = x_2;
            int y1 = y_1;
            int y2 = y_2;
            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            addLine(x1, y1, x2, y2, randomColor);
       

}

public static void main(String[] args) {
   JFrame testFrame = new JFrame();
    testFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    final LinesComponent comp = new LinesComponent();
    //comp.setPreferredSize(new Dimension(320, 200));
    testFrame.getContentPane().add(comp);
    testFrame.setSize(1100, 700);
    JPanel buttonsPanel = new JPanel();
   
    
    JButton newLineButton = new JButton("New Line");
    newLineButton.setBounds(50, 45, 50, 20);
    JButton clearButton = new JButton("Clear");
    buttonsPanel.add(newLineButton);
    
    buttonsPanel.add(clearButton);
    testFrame.getContentPane().add(buttonsPanel);
    newLineButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            int x1 = (int) (Math.random()*320);
            int x2 = (int) (Math.random()*320);
            int y1 = (int) (Math.random()*200);
            int y2 = (int) (Math.random()*200);
            Color randomColor = new Color((float)Math.random(), (float)Math.random(), (float)Math.random());
            comp.addLine(x1, y1, x2, y2, randomColor);
        }
    });
    clearButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            comp.clearLines();
        }
    });
   //testFrame.pack();
    testFrame.setVisible(true);
}

}