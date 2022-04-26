/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osmany.machado
 */
public class Celdas extends JFrame {
    

    //private javax.swing.JPanel jPanel2;
  private   Connection con = null; 
  private  Statement st = null;
  //private  ResultSet rs = null; 
  Object [] fila = new Object[3];
  DefaultTableModel modelo;
  String user="etecsa";
  String pass="etecsa";
  String url="jdbc:mysql://localhost:3306/gestion_trafico";
  private JInternalFrame jInternalFrame1;
     public Celdas() {
         
        initComponents();
    }
     
     
   private  void initComponents()
     {
              
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1000, 600));
        setResizable(false);
        JPanel jPanel1=new JPanel(); 
        JPanel jPanel2=new JPanel(); 
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 600));
        jPanel1.setPreferredSize(new java.awt.Dimension(340, 600));
        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
// Code of sub-components and layout - not shown here
        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setMinimumSize(new java.awt.Dimension(200, 600));
        jPanel2.setPreferredSize(new java.awt.Dimension(700, 600));
        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);
        jPanel2.setBackground(new java.awt.Color(11, 11, 255));
        //JDialog dg=new JDialog();
       // dg.setBounds(400, 600, 700, 600);
        JLabel jLabel1=new JLabel();
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Celda.JPG"))); // NOI18N
        jLabel1.setBounds(20, 0, 200, 660);
        //getContentPane().add(jLabel1,java.awt.BorderLayout.WEST);    
    
        final DefaultTableModel modelo = new DefaultTableModel();
        final JTable tabla = new JTable(modelo);
        tabla.setPreferredScrollableViewportSize(new Dimension(750, 220));
        JScrollPane scrollpane = new JScrollPane(tabla);
        modelo.addColumn("RSite");
        modelo.addColumn("DIP");
        modelo.addColumn("Device");
        modelo.addColumn("Cell");
        modelo.addColumn("CGI");
        modelo.addColumn("BCCH");
        modelo.addColumn("FR1");
        modelo.addColumn("FR2");
        modelo.addColumn("FR3");
        getContentPane().add(scrollpane, BorderLayout.EAST);
      
        
        JButton jButton1 = new javax.swing.JButton();
        jButton1.setText("jButton1");
        jPanel1.add(jButton1);
        jButton1.setBounds(390, 270, 73, 23);
        
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            } });
        
     }
   
   
   
   private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
// TODO add your handling code here:
    //e=1;
  
                    try {
                        preparado();
                        java.sql.Statement st =con.createStatement();
                        String strSQL1="Select rsite,tg from TB_cell_cub where id=1 ";            
                        ResultSet rs = st.executeQuery(strSQL1);           
        
DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);
final JDialog dg=new JDialog();
dg.setBounds(600, 360, 300 ,300);
tabla.setPreferredScrollableViewportSize(new Dimension(500, 220));
//this.pack();

// Creamos las columnas.
//modelo.addColumn("RSITE");
modelo.addColumn("Vecinas");
modelo.addColumn("DIR");



            jInternalFrame1 = new javax.swing.JInternalFrame();
            jInternalFrame1.setTitle("Informacion de celdas");
             //jInternalFrame1.add(dial);
            jInternalFrame1.setResizable(false);
            //jInternalFrame1.setClosable(true);
            jInternalFrame1.setVisible(true);
            getContentPane().add(jInternalFrame1);
            jInternalFrame1.setBounds(590, 0, 500, 660);
            jInternalFrame1.getContentPane().add(scrollpane, BorderLayout.CENTER);

        
while (rs.next()) {
   
    for (int i=0;i<2;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

   // Se añade al modelo la fila completa.
   modelo.addRow(fila); 
  
   
  }             
    rs.close();           
    st.close(); 
    con.close();
    
                    
    
                    }
                    catch (SQLException ex) {
JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, varifica tus datos de conexion");
}

   

            

               
            
}       
     public void preparado()
 {   
try{
con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_trafico","etecsa","etecsa");
if ( con != null )
{
//System.out.println("Se ha establecido una conexión a la base de datos n " + url );
st = (Statement) con.createStatement();
}


}
catch(Exception e)
{
JOptionPane.showMessageDialog(null,"Se mostraran datos validos");
}

 }
     
     
     public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Celdas cld=new Celdas();
                cld.setVisible(true);
            }
        });
    }

}
