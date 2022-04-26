package mapa_cubacel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author heidy.capote
 */
public class Circuitos extends  JFrame  {
//super("Ejemplo 1");
    ResultSet rs;
    String user="etecsa";
String pass="etecsa";
String url="jdbc:mysql://10.94.1.143:3306/gestion_trafico";
  private JDialog dg=new JDialog();
   private JInternalFrame jInternalFrame1;
   public int w,h,type,cant;
   String valor;
  
public Circuitos(String str,int nodo)
{
   w=nodo;
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
   
    try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection(url,user,pass);

            java.sql.Statement st = con.createStatement();
            if(valor.equals("TB_Rutas_msc"))//Para printear rutas de msc cubanacan
            {
                type=0;
            String strSQL="Select  rutas,dev from tb_dev_msc where rutas='"+str+"' ";
 rs = st.executeQuery(strSQL); 
            
            }
            else
            {
            type=1;
//st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
String strSQL="Select ruta,cic,tid_star,tid_end from "+valor+" where ruta='"+str+"' ";
 rs = st.executeQuery(strSQL); 
            }

 dg.setBounds(300, 160, 300 ,300);           
DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);

JScrollPane scrollpane = new JScrollPane(tabla);
dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
tabla.setPreferredScrollableViewportSize(new Dimension(200, 220));
//this.pack();

// Creamos las columnas.
if(type==0)
{
modelo.addColumn("Ruta");
modelo.addColumn("Device");
cant=2;
}
else
{
modelo.addColumn("Trunk Group");
modelo.addColumn("CIC_START");
modelo.addColumn("TID_START");
modelo.addColumn("TID_END");
cant=4;
}
            

while (rs.next()) {
   
  //System.out.println(rs.getString(1));
  //System.out.println(rs.getFloat(2));
  //System.out.println(rs.getInt(3));
    Object [] fila = new Object[cant]; 
    for (int i=0;i<cant;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

   // Se añade al modelo la fila completa.
   modelo.addRow(fila); 

  
  }  // close all the connections.

dg.setVisible(true);



tabla.addMouseListener(new MouseAdapter() 
   {
                private int row;
                private String id;
                
                
      public void mouseClicked(MouseEvent e) 
      {
         
                        int fila = tabla.rowAtPoint(e.getPoint());
                        int columna = tabla.columnAtPoint(e.getPoint());
                        if ((fila > -1) && (columna > -1)) {
                            row = tabla.getSelectedRow();
                        }
                        id = tabla.getValueAt(row, 2).toString(); //tengo el valor de la celda
                        h=Integer.parseInt(id);// se convierte a entero
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
                    
                    Puertos pr=new Puertos(h,type);//valor de celda y tipo de nodo(msoft, msc)
                }
    

             

               
                });








  rs.close();
  st.close();




con.close();//se cierra la conexion con la base de datos
 
}//excepcionSql = puede ponerle otro nombre
    
catch ( SQLException excepcionSql)
{ 
JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos", JOptionPane.ERROR_MESSAGE );
}

//errores con la carga del controlador de la base de datos(Driver)

catch ( ClassNotFoundException claseNoEncontrada ){
JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),"No se encontró el controlador", JOptionPane.ERROR_MESSAGE );
}    
    
    
addWindowListener(new WindowAdapter() {

public void windowClosing(WindowEvent e) { 
System.exit(0); 
} 
}); 
}

public static void main(String ar[]) { 
 java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Circuitos().setVisible(true);
               
            }
        });
}

    private Circuitos() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}