package mapa_cubacel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;

/*
 * Puertos.java
 *
 * Created on May 16, 2012, 12:23 AM
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author  kevin
 */
public class Puertos extends javax.swing.JFrame {
    private JInternalFrame jInternalFrame1;
    String valor;
String user="etecsa";
String pass="etecsa";
String url="jdbc:mysql://10.94.1.143:3306/gestion_trafico";
Object [] fila = new Object[5]; 
ResultSet rs;
    /** Creates new form Puertos */
    public Puertos(int list,int type) {
        initComponents();
        
        try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection(url,user,pass);

java.sql.Statement st =con.createStatement();
if(type==1)
{
    //Para informacion de facilidades en los MSOFT
//st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
String strSQL="Select board_type, board_no,frame_no,slot_no,port_no from TB_TID where (tid_end - "+list+") >= 0 AND ("+list+" - tid_star) >= 0 "; 
rs = st.executeQuery(strSQL); 
}
else
{
    
//Para informacion de facilidades en el MSC
String strSQL="Select dev,rutas  from TB_dev_msc where rutas= "; 
 rs = st.executeQuery(strSQL); 
}

DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);
final JDialog dg=new JDialog();
dg.setBounds(600, 360, 300 ,300);
tabla.setPreferredScrollableViewportSize(new Dimension(500, 220));
//this.pack();

// Creamos las columnas.
modelo.addColumn("Board_type");
modelo.addColumn("Board_no");
modelo.addColumn("Frame_no");
modelo.addColumn("Slot_no");
modelo.addColumn("Port_no");




           
       

while (rs.next()) {
   
  //System.out.println(rs.getString(1));
  //System.out.println(rs.getFloat(2));
  //System.out.println(rs.getInt(3));
       
    
    for (int i=0;i<5;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

   // Se añade al modelo la fila completa.
   modelo.addRow(fila); 
  
   
  }
dg.getContentPane().add(scrollpane,BorderLayout.CENTER);
dg.setVisible(true);
            
rs.close();
st.close();
con.close();
        }
       catch ( SQLException excepcionSql)
{ 
JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos", JOptionPane.ERROR_MESSAGE );
}

//errores con la carga del controlador de la base de datos(Driver)

catch ( ClassNotFoundException claseNoEncontrada ){
JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),"No se encontró el controlador", JOptionPane.ERROR_MESSAGE );
} 
        
    }

   

 

    private Puertos() {
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puertos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    // End of variables declaration                   

}
