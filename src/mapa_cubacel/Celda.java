package mapa_cubacel;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.beans.Statement;
import java.sql.Connection;

/*
 * Celda.java
 *
 * Created on April 11, 2012, 3:17 AM
 */
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



/**
 *
 * @author  osmany.machado
 */
public class Celda extends javax.swing.JFrame {
   private JInternalFrame jInternalFrame1;
   private   Connection con = null; 
   private  Statement st = null;
   private  ResultSet rs = null; 
   DefaultTableModel modelo = new DefaultTableModel();
   DefaultTableModel modelo1 = new DefaultTableModel();
   DefaultTableModel modelo2 = new DefaultTableModel();
   int vec=0; //para la tabla de vecinas
  
   int s=0;
   Object [] fila = new Object[6];
   Object [] fila1 = new Object[11];
   Object [] fila2 = new Object[2];
    private   String a[]=new String[7];
   int e;
   int cont=0;//para contar cuantas filas para las celdas vecinas hay
   int tipo;     
   String rsite;
   private String result,result1;
    /** Creates new form Celda */
   public Celda(String rs1,int type) {//rsite y el nodo que procede
   rsite=rs1;
   tipo=type;
       
        
        switch(type)
           {
            case 5://Esta es la numeracion del BSC
                result="tb_cell_pan";
                result1="tb_bsc_pan";
                vec=5;
                break;
            case 6 :
                result="tb_cell_cub";
                result1="tb_bsc_cub";
                vec=6;
                break;
            case 7:
                result="tb_cell_cam";
                result1="tb_bsc_zte";
                vec=9;
                break;
            case 8:
                result="tb_cell_cam";
                result1="tb_bsc_jaguey";
                vec=8;
                break;
            case 9:
                result="tb_cell_vclara";
               result1="tb_bsc_vclara";
               vec=7;
                break;
            case 10:
                result="tb_cell_cam";
                result1="tb_bsc_cam";
                vec=10;
                break;
            case 11:
                result="tb_cell_cam";
              
                break;
        
        }
       
try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
  con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

            java.sql.Statement st =con.createStatement();
            if(vec>7)
            {
            String strSQL="Select distinct cell from "+result+" where rsite='"+rsite+"'and id_bsc="+vec+"  group by cell ";
            rs = st.executeQuery(strSQL); 
            }
            else
            {
            //st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
            String strSQL1="Select distinct t1.cell from "+result+" t1, "+result1+" t2 where t1.tg=t2.tg and rsite='"+rsite+"'  group by cell ";
             rs = st.executeQuery(strSQL1); 

            }




while (rs.next()) 
{
  a[s]=rs.getString(1);
  s++;
  
 }  // close all the connections.

//Tabla para mostrar informacion de las celdas

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

        initComponents();
        //preparado();
    }


    private Celda() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
  
 public void preparado()
 {   
 try{
con = (Connection) DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");
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

   
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    
        
       setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 700));
        setResizable(false);
      // JPanel jPanel1 = new javax.swing.JPanel();
        JPanel jPanel1=new JPanel(); 
        jPanel1.setBackground(new java.awt.Color(51, 51, 255));
        jPanel1.setMinimumSize(new java.awt.Dimension(200, 700));
        jPanel1.setPreferredSize(new java.awt.Dimension(290, 700));
        // Code of sub-components and layout - not shown here
        
        Cel2 = new javax.swing.JButton();
        Cel2.setBounds(410, 160, 73, 23);
        Cel2.setText(a[1]);
        Cel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Celda2ActionPerformed(evt);
            }
        });
        jPanel1.add(Cel2);




        JButton Cel1 = new javax.swing.JButton();
        Cel1.setBounds(410, 260, 73, 23);
        Cel1.setText(a[0]);
        Cel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Celda1ActionPerformed(evt);
            }
           
        });
        jPanel1.add(Cel1);
        JButton Cel3 = new javax.swing.JButton();
        Cel3.setBounds(110, 360, 73, 23);
        Cel3.setText(a[2]);
        Cel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Celda3ActionPerformed(evt);
            }
           
        });
        jPanel1.add(Cel3);
        
        getContentPane().add(jPanel1, java.awt.BorderLayout.WEST);
        
        JPanel jPanel2=new JPanel(); 
        jPanel2.setBackground(new java.awt.Color(100, 100, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(200, 700));
        jPanel2.setPreferredSize(new java.awt.Dimension(800, 700));
        
        
        
        
        final JTable tabla = new JTable(modelo);
        final JTable tabla1 = new JTable(modelo1);
        final JTable tabla2 = new JTable(modelo2);
        JScrollPane scrollpane = new JScrollPane(tabla);
        JScrollPane scrollpane1 = new JScrollPane(tabla1);
        JScrollPane scrollpane2 = new JScrollPane(tabla2);
        tabla.setPreferredScrollableViewportSize(new Dimension(800, 40));
        tabla1.setPreferredScrollableViewportSize(new Dimension(800, 40));
        tabla2.setPreferredScrollableViewportSize(new Dimension(800, 400));
        
// Creamos las columnas.

        modelo.addColumn("RSite");
        modelo.addColumn("TG");       
        modelo.addColumn("Cell");
        modelo.addColumn("CGI");
        modelo.addColumn("DIP");
        modelo.addColumn("Device");
        modelo1.addColumn("BCCH");
        modelo1.addColumn("FR1");
        modelo1.addColumn("FR2");
        modelo1.addColumn("FR3");
        modelo1.addColumn("FR4");
        modelo1.addColumn("FR5");
        modelo1.addColumn("FR6");
        modelo1.addColumn("FR7");
        modelo1.addColumn("FR8");
        modelo1.addColumn("FR9");
        modelo1.addColumn("FR10");
       // modelo1.addColumn("FR11");
        modelo2.addColumn("Celdas vecinas");
        modelo2.addColumn("Tipo");
       
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jInternalFrame1.setTitle("Informacion de celdas");
        jInternalFrame1.setResizable(false);
        jInternalFrame1.setVisible(true);
        jInternalFrame1.setBounds(600, 0, 780, 700);
        jInternalFrame1.getContentPane().add(scrollpane, BorderLayout.NORTH);
        jInternalFrame1.getContentPane().add(scrollpane1, BorderLayout.CENTER);
        jInternalFrame1.getContentPane().add(scrollpane2, BorderLayout.SOUTH);
        jPanel2.add(jInternalFrame1);
        getContentPane().add(jPanel2, java.awt.BorderLayout.EAST);
       
        //getContentPane().add(jButton1);
       // jButton1.setBounds(390, 270, 73, 23);

        

        //pack();
    }// </editor-fold>                        
private void Celda2ActionPerformed(java.awt.event.ActionEvent evt) {                                       
// TODO add your handling code here:
    //e=1;
   if(e==1)
   {
    modelo.removeRow(0);
    modelo1.removeRow(0);
    for(int c=0;c<cont;c++)
    modelo2.removeRow(0);
    cont=0;
   }
        try {
        preparado();
        java.sql.Statement st =con.createStatement();
        
        if(vec>7)
            
        {
            String strSQL1="Select t2.rsite,t1.tg,t1.cell,t1.cgi,t2.dip,t2.dev,t1.bcch, t1.f1,t1.f2,t1.f3,t1.f4,t1.f5,t1.f6,t1.f7,t1.f8,t1.f9,t1.f10,t1.f11,t1.f12,t3.vecinas,t3.dir from "+result+" t1,"+result1+" t2,tb_celdas_vecinas_"+vec+" t3 where t1.tg=t2.tg and t1.cell=t3.cell and t1.cell='"+a[1]+"' ";            
            rs = st.executeQuery(strSQL1);  
        }
        else
        {
            String strSQL1="Select t2.rsite,t1.tg,t1.cell,t1.cgi,t2.dip,t2.dev,t1.bcch, t1.f1,t1.f2,t1.f3,t1.f4,t1.f5,t1.f6,t1.f7,t1.f8,t1.f9,t1.f10,t1.f11,t1.f12,t3.vecinas,t3.dir from "+result+" t1,"+result1+" t2,tb_celdas_vecinas_"+vec+" t3 where t1.tg=t2.tg and t1.cell=t3.cell and t1.cell='"+a[1]+"' ";            
             rs = st.executeQuery(strSQL1);  
        
        }
               
        int g=0;//para utilizar las celdas vecinas
        
while (rs.next()) {
   
    if(g==0)
   {
 for (int i=0;i<6;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
      modelo.addRow(fila); 
  
 for (int ii=0;ii<11;ii++)
      fila1[ii] = rs.getObject(ii+7); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
      modelo1.addRow(fila1);
      g=1;
   }
    else
    {
        cont++;
 for (int iii=0;iii<2;iii++)
      fila2[iii] = rs.getObject(iii+20); // tomo vecinas
      modelo2.addRow(fila2);
      
    } 
      
    
  }     
        e=1;
    rs.close();           
    st.close(); 
    con.close();
    
                    
    
                    }
                    catch (SQLException ex) {
JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, varifica tus datos de conexion");
}

   

            

               
            
}    


private void Celda3ActionPerformed(java.awt.event.ActionEvent evt) {                                       
if(e==1)
   {
    modelo.removeRow(0);
    modelo1.removeRow(0);
    for(int c=0;c<cont;c++)//para borrar todas las filas 
    modelo2.removeRow(0);
    cont=0;
   }
  try {
        preparado();
        java.sql.Statement st =con.createStatement();
       String strSQL1="Select t2.rsite,t1.tg,t1.cell,t1.cgi,t2.dip,t2.dev,t1.bcch, t1.f1,t1.f2,t1.f3,t1.f4,t1.f5,t1.f6,t1.f7,t1.f8,t1.f9,t1.f10,t1.f11,t1.f12,t3.vecinas,t3.dir from "+result+" t1,"+result1+" t2,tb_celdas_vecinas_"+vec+" t3 where t1.tg=t2.tg and t1.cell=t3.cell and t1.cell='"+a[1]+"' ";            
            
        ResultSet rs = st.executeQuery(strSQL1);          
        int g=0;
        
while (rs.next()) {
   
    if(g==0)
   {
 for (int i=0;i<6;i++)
      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
      modelo.addRow(fila); 
  
 for (int ii=0;ii<11;ii++)
      fila1[ii] = rs.getObject(ii+7); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
      modelo1.addRow(fila1);
      g=1;
   }
    else
    {
        cont++;
 for (int iii=0;iii<2;iii++)
      fila2[iii] = rs.getObject(iii+20); // tomo vecinas
      modelo2.addRow(fila2);
      
    } 
      
    e=1;
  }             
    rs.close();           
    st.close(); 
    con.close();
    
                    
    
                    }
                    catch (SQLException ex) {
JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, varifica tus datos de conexion");
}

}                                      

private void Celda1ActionPerformed(java.awt.event.ActionEvent evt) {                                       
// TODO add your handling code here:
    if(e==1)
   {
    modelo.removeRow(0);
    modelo1.removeRow(0);
    for(int c=0;c<cont;c++)
    modelo2.removeRow(0);
    cont=0;
   }
    try {
        preparado();
        java.sql.Statement st =con.createStatement();
       String strSQL1="Select t2.rsite,t1.tg,t1.cell,t1.cgi,t2.dip,t2.dev,t1.bcch, t1.f1,t1.f2,t1.f3,t1.f4,t1.f5,t1.f6,t1.f7,t1.f8,t1.f9,t1.f10,t1.f11,t1.f12,t3.vecinas,t3.dir from "+result+" t1,"+result1+" t2,tb_celdas_vecinas_"+vec+" t3 where t1.tg=t2.tg and t1.cell=t3.cell and t1.cell='"+a[1]+"' ";            
            
        ResultSet rs = st.executeQuery(strSQL1);          
        int g=0;
        
while (rs.next()) {
   
    if(g==0)
   {
 for (int i=0;i<6;i++)
      fila[i] = rs.getObject(i+1); // 
      modelo.addRow(fila); 
  
 for (int ii=0;ii<11;ii++)
      fila1[ii] = rs.getObject(ii+7); // 
      modelo1.addRow(fila1);
      g=1;
   }
    else
    {
        cont++;
 for (int iii=0;iii<2;iii++)
      fila2[iii] = rs.getObject(iii+20); // tomo vecinas
      modelo2.addRow(fila2);
      
    } 
      
    
  }  
        

        
      e=1;  
        
        
    rs.close();           
    st.close(); 
    con.close();
    
                    
    
                    }
                    catch (SQLException ex) {
JOptionPane.showMessageDialog(null,"Error al tratar de conectar la base, varifica tus datos de conexion");
}
}                                      

private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
// TODO add your handling code here:
  try {
                        preparado();
                        java.sql.Statement st =con.createStatement();
                        String strSQL1="Select rsite,dip,dev from TB_BSC_CUB where tg=2'";            
                        ResultSet rs = st.executeQuery(strSQL1);           
        
DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);
final JDialog dg=new JDialog();
dg.setBounds(600, 360, 300 ,300);
tabla.setPreferredScrollableViewportSize(new Dimension(500, 220));
//this.pack();

// Creamos las columnas.

modelo.addColumn("RSITE");
modelo.addColumn("DIP");
modelo.addColumn("DEV");


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
   
    for (int i=0;i<3;i++)
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

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Celda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton Celda1;
    private javax.swing.JButton Celda2;
    private javax.swing.JButton Celda3;
    private javax.swing.JButton Cel2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration                   

}
