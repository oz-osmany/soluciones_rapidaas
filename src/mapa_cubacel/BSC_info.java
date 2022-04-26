package mapa_cubacel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * Ruta_Mapa.java
 *
 * Created on January 28, 2012, 11:01 AM
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/*
 * BSC_info.java
 *
 * Created on April 11, 2012, 12:34 AM
 */



/**
 *
 * @author  osmany.machado
 */
public class BSC_info extends javax.swing.JFrame {
private JInternalFrame jInternalFrame1;
private int saber,tipo,row;
private String id,result;

String user="etecsa";
String pass="etecsa";
String url="jdbc:mysql://10.94.1.143:3306/gestion_trafico";

Object [] fila = new Object[3]; 
    /** Creates new form BSC_info */
    public BSC_info(int nodo) {
        initComponents();
        this.setSize(1100,720);
        switch(nodo)
        {case 5://Esta es la numeracion del BSC
             result="tb_bsc_pan";
             tipo=nodo;
        break;
            case 6 :
                result="TB_BSC_CUB";
                tipo=nodo;
                break;
            case 7:
                result="TB_cell_cam";
                tipo=nodo;
                break;
            case 8:
                result="TB_cell_cam";
                tipo=nodo;
                break;
            case 9:
                result="TB_BSC_vclara";
                tipo=nodo;
                break;
            case 10:
                result="TB_cell_cam";
                tipo=nodo;
                break;
            case 11:
                result="TB_cell_cam";
                tipo=nodo;
                break;
        
        }
       try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection(url,user,pass);

java.sql.Statement st =con.createStatement();
//st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
String strSQL="Select distinct rsite from "+result+" group by rsite";
ResultSet rs = st.executeQuery(strSQL); 


DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);
final JDialog dg=new JDialog();
dg.setBounds(600, 360, 300 ,300);
tabla.setPreferredScrollableViewportSize(new Dimension(500, 220));
//this.pack();

// Creamos las columnas.
modelo.addColumn("RSITE");
//modelo.addColumn("CIC");
//modelo.addColumn("SLC");



            jInternalFrame1 = new javax.swing.JInternalFrame();
            jInternalFrame1.setTitle("Informacion de rutas y links");
             //jInternalFrame1.add(dial);
            jInternalFrame1.setResizable(false);
            //jInternalFrame1.setClosable(true);
            jInternalFrame1.setVisible(true);
            getContentPane().add(jInternalFrame1);
            jInternalFrame1.setBounds(50, 100, 1000, 560);
            jInternalFrame1.getContentPane().add(scrollpane, BorderLayout.CENTER);
       

while (rs.next()) {
   
  //System.out.println(rs.getString(1));
  //System.out.println(rs.getFloat(2));
  //System.out.println(rs.getInt(3));
       
    
    for (int i=0;i<1;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

   // Se añade al modelo la fila completa.
   modelo.addRow(fila); 
  
   
  }  // close all the connections.
      tabla.addMouseListener(new MouseAdapter() 
   {
      public void mouseClicked(MouseEvent e) 
      {
         
                    try {
                        int fila = tabla.rowAtPoint(e.getPoint());
                        int columna = tabla.columnAtPoint(e.getPoint());
                        if ((fila > -1) && (columna > -1)) {
                            row = tabla.getSelectedRow();
                        }
                        id = tabla.getValueAt(row, 0).toString(); //tengo el nombre del rsite


                        labelrMouseClicked(e);
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(BSC_info.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        Logger.getLogger(BSC_info.class.getName()).log(Level.SEVERE, null, ex);
                    }
         
      }

                private void labelrMouseClicked(MouseEvent e) throws ClassNotFoundException, SQLException {
                    
       /* Class.forName("com.mysql.jdbc.Driver"); // 2005 version
       Connection con = DriverManager.getConnection(url,user,pass);

        java.sql.Statement st1 =con.createStatement();    
         String strSQL1="Select tg from "+result+" where rsite='"+id+"' ";
         
        ResultSet  rs1 = st1.executeQuery(strSQL1); 
             if (rs1.next()) { // IMPORTANT, this can also be a while(res.next()) ofcourse....
// now you do your thing
        saber= rs1.getInt(1); 
        } */
        
                   Celda dg3=new Celda(id,tipo); //
                   //dg3.setSize(1100, 700);
                    dg3.setTitle("Informacion de Estaciones Bases");
                     //dg.add(new MenuPanel());
                    dg3.setVisible(true);
                    
                    
                    
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
    }

    private BSC_info() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
    
   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>                        

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BSC_info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   

}
