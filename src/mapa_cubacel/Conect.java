package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author heidy.capote
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conect {
     public static void main(String[] args) {
         
         
   try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://localhost,databaseName=gestion_trafico;");

Statement st = con.createStatement();
//st.executeUpdate("CREATE TABLE contacto (id INT AUTO_INCREMENT, PRIMARY KEY(id), nombre VARCHAR(20), apellidos VARCHAR(20), telefono VARCHAR(20))");
String strSQL="Select spid,ls,slc from TB_Senalizacion ";
ResultSet rs = st.executeQuery(strSQL); 

while (rs.next()) {
   
  System.out.println(rs.getString(1));
  System.out.println(rs.getFloat(2));
  System.out.println(rs.getInt(3));
  
  }  // close all the connections.

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
}