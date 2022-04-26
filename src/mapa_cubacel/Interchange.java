/*
 * Interchange.java
 *
 * Created on March 12, 2013, 6:47 AM
 */

package mapa_cubacel;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;

/**
 *
 * @author  osmany.machado
 */
public class Interchange extends javax.swing.JFrame {
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
    /** Creates new form Interchange */
    public Interchange() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Msoft = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Msoft.setText("Msoft");
        Msoft.setName("Msoft"); // NOI18N
        Msoft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MsoftActionPerformed(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.setName("jButton1"); // NOI18N

        jButton2.setText("jButton2");
        jButton2.setName("jButton2"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 111, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(100, 100, 100))
            .addGroup(layout.createSequentialGroup()
                .addGap(147, 147, 147)
                .addComponent(Msoft, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(219, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(Msoft)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(62, 62, 62))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void MsoftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MsoftActionPerformed
// TODO add your handling code here:
    LinesComponent line=new LinesComponent();
    line.coordenadas(jButton1.getX(), jButton2.getX(),jButton1.getY(), jButton2.getX());
}//GEN-LAST:event_MsoftActionPerformed
protected void paintComponent(Graphics g) {
    //super.paintComponent(g);
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
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Interchange().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Msoft;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration//GEN-END:variables

}
