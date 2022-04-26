/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class Rutas_Mapa extends JFrame {
private JInternalFrame jInternalFrame1;
ResultSet rs;
String user="etecsa";
String pass="etecsa";
String url="jdbc:mysql://10.94.1.143:3306/gestion_trafico";
    String valor,id,result;
    int row,saber;
    int []get=new int[800];
    String [] get1=new String[800];

    public Rutas_Mapa(int w)
    {
    /** Creates new form Ruta_Mapa */
      saber=w;
        switch(w)
        {
            case 0:
                valor="TB_Rutas_msfhab";
                
                break;
            case 1:
                valor="TB_Rutas_MSfjaguey";
                break;
            case 2:
                valor="TB_Rutas_msc";
                break;
            case 3:
                valor="TB_Rutas_MSfCam";
                break;    
        }
        
        this.setSize(1100,720);
        Tabla();
    }

   

    public void Tabla()
{
try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection(url,user,pass);

            java.sql.Statement st =con.createStatement();
            
            if(valor.equals("TB_Rutas_msc"))
            {
            String strSQL="Select distinct ruta,cic from "+valor+"  group by ruta ";
           rs = st.executeQuery(strSQL); 
            
            }
            else
            {
//st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
String strSQL="Select distinct ruta,count(cic)  from "+valor+"  group by ruta ";
 rs = st.executeQuery(strSQL); 
            }
DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(500, 220));
//this.pack();

// Creamos las columnas.
modelo.addColumn("Rutas");
modelo.addColumn("CIC");
//modelo.addColumn("TID_Start");
//modelo.addColumn("TID__End");



            jInternalFrame1 = new javax.swing.JInternalFrame();
            jInternalFrame1.setTitle("Informacion de rutas.");
             //jInternalFrame1.add(dial);
            jInternalFrame1.setResizable(false);
            //jInternalFrame1.setClosable(true);
            jInternalFrame1.setVisible(true);
            getContentPane().add(jInternalFrame1);
            jInternalFrame1.setBounds(50, 300, 1000, 360);
            jInternalFrame1.getContentPane().add(scrollpane, BorderLayout.CENTER);
         


while (rs.next()) {
   
  //System.out.println(rs.getString(1));
  //System.out.println(rs.getFloat(2));
  //System.out.println(rs.getInt(3));
       
    Object [] fila = new Object[2]; 
    for (int i=0;i<2;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

   // Se añade al modelo la fila completa.
   modelo.addRow(fila); 
  
  }  // close all the connections.
tabla.addMouseListener(new MouseAdapter() 
   {
                
                
      public void mouseClicked(MouseEvent e) 
      {
         
                   
                      
                        int fila = tabla.rowAtPoint(e.getPoint());
                        int columna = tabla.columnAtPoint(e.getPoint());
                        if ((fila > -1) && (columna > -1)) {
                            row = tabla.getSelectedRow();
                        }
                        id = tabla.getValueAt(row, 0).toString(); //tengo el nombre del rsite

                    try {
                        //tengo el nombre del rsite

                        labelrMouseClicked(e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(Rutas_Mapa.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(Rutas_Mapa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                   
         
      }

                private void labelrMouseClicked(MouseEvent e) throws ClassNotFoundException, SQLException {
                    
                    Circuitos k=new Circuitos(id,saber);
                    //Puertos pr=new Puertos(row);
                }
    

             

               
                });
                
                
rs.close();
st.close();
con.close();//se cierra la conexion con la base de datos
}




catch ( SQLException excepcionSql)
{ 
JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos", JOptionPane.ERROR_MESSAGE );
}

//errores con la carga del controlador de la base de datos(Driver)

catch ( ClassNotFoundException claseNoEncontrada ){
JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),"No se encontró el controlador", JOptionPane.ERROR_MESSAGE );
}

    
    
    
    
    
    JLabel jLabel1 = new javax.swing.JLabel();
   jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MapaRutas.JPG"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(100, -50, 920, 390);

        pack();
    }
    
}