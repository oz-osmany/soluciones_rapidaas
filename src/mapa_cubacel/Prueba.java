/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author osmany.machado
 */
public class Prueba {
        java.sql.ResultSet rs;
    //ResultSet rs;
private   Connection con = null; 
  private  Statement st = null;
    Prueba(){
    
    try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
  con =     (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_trafico","etecsa","etecsa");

           java.sql.Statement  st = con.createStatement();
           
         
            
      String strSQL="Select distinct orden,flujo from tb_recorrido where hasta='LACOLOMA' group by flujo,orden ";
       rs =  st.executeQuery(strSQL); 
             
       
 while (rs.next()) 
 {
    
        System.out.println(rs.getString(1));     
        //System.out.println(rs.getString(2));     
         //rs.next();        
            
 }
          
           
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
    
    public static void main(String[] args) {
    Prueba pr=new Prueba();
    
    
    }
    
    
    
    
    
    
}   

 