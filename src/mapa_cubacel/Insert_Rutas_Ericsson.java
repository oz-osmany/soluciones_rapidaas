package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;


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
/**
 *
 * @author heidy.capote
 */
public class Insert_Rutas_Ericsson {
    @SuppressWarnings("empty-statement")
    
     public static void main(String[] args) {
      Socket      s;
        String subStr2[]=new String[2900];
        String subStr1[]=new String[2900];
        //String subStr[]=new String[100];
       // String ext[]=new String[100];
        PrintStream      p;
        BufferedReader    b;
        String   host = "10.50.10.30";
        int      port = 23;
        String[] respuesta=new String[2900];
        String q,w,e; 
        int[] datos=new int[300];
        //int[] y=new int[300];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[2900];
        byte[] buffer = new byte[2024]; 
 
   
    //private static JInternalFrame jInternalFrame1;
      
 

       
     
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host,port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                arr[0]=new String("osmany");
                arr[1]=new String("Cubacel@2010");
                arr[2]=new String("");
                arr[3]=new String("mml");
                arr[4]=new String("strsp:r=all;");
                arr[5]=new String("");
              
                
                
                
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
            for(int a=0;a<3009;a++) {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(arr[a]);
                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                  if ( a>=24) {
                       if(respuesta[a].contains("END"))
                    {
                        a=3009;
                    }
                   subStr2[z]=respuesta[a].substring(0,7);
                   subStr2[z]=subStr2[z].replaceAll(" ", "");
                   subStr1[z1]=respuesta[a].substring(12,16);
                   subStr1[z1]=subStr1[z1].replaceAll(" ", "");
                    datos[z1]=Integer.parseInt(subStr1[z1]);//paso el string a int del NDV de la tabla
                   
                   if(datos[z1]<1) //saber los que tienen carga
                 {continue;}
                   
                   z++;
                   z1++;
                  }
            }   
                
                
                
                
                
             for(int i=0;i<2799;i++)
                                  
             {
                 
                 
           try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:sqlserver://10.50.103.70:1433;databaseName=gestion_trafico;user=etecsa;password=etecsa;");

Statement st = con.createStatement();


String strSQL="INSERT INTO TB_Rutas (rutas,cic) VALUES ('"+ subStr2[i] +"','"+ datos[i] +"')";
//String strSQL="Select rutas,cic from TB_Rutas ";           
ResultSet rs = st.executeQuery(strSQL); 


            
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
              
               
               
               
                       
            p.close();
            b.close();  
            s.close();
            
                    
                    
                          
            
               //String res=b.readLine();
                //subStr2[0]=respuesta[29].substring(0);
                //subStr[0]=respuesta[29].substring(0);
                //subStr1[0]=respuesta[29].substring(0);
               
            
            

        } catch (UnknownHostException r) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException r) {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
        
       
 }
    }
    
      
        
    

