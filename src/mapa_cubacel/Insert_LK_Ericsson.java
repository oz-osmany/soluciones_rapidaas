package mapa_cubacel;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
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
/**
 *
 * @author heidy.capote
 */
public class Insert_LK_Ericsson {

 
    @SuppressWarnings("empty-statement")
public static void main(String[] args) {
Socket      s;

   

        String subStr2[]=new String[100];
        String subStr1[]=new String[100];
        String subStr[]=new String[100];
        String ext[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

        String          host = "100.5.10.30";
        int      port = 23;
        String[] respuesta=new String[2000];
       String q,w,e; 
        int[] datos=new int[300];
        int[] y=new int[300];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[250];
        byte[] buffer = new byte[1024]; 
        
        
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
                arr[4]=new String("c7ltp:ls=all;");
                arr[5]=new String("");
               
                
                
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
            for(int a=0;a<100;a++) {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(arr[a]);
                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                              
                if ( a>=25) {
                                                        
                  subStr2[a]=respuesta[a].replaceAll(" ", "");
                   
                  if((subStr2[a].isEmpty())) //salto de linea
                   {
                      if(c!=0)
                      {
                      System.out.println(c);
                  y[c1]=c;
                  c=0;
                  c1++;}
                  }
               
                   else{
                    
               //System.out.println(subStr2);
                       
               subStr[z]=respuesta[a].substring(0);
               
               subStr[z]=respuesta[a].replaceAll(" ","");
               subStr[z]=respuesta[a].substring(0,6);
               ext[z]=subStr[z].replace("-",".");
               subStr[z]=ext[z];
               if(!subStr[z].isEmpty())
              {// la linea no esta vacia
                   //datos[z]=a;
                   
               }
               //System.out.println(subStr); 
                
                
              
                 subStr1[z1]=respuesta[a].substring(0);
               subStr1[z1]=respuesta[a].replaceAll(" ", "");
               subStr1[z1]=respuesta[a].substring(15,20);
               z1++;
               //System.out.println(subStr1);
                
                    subStr2[z]=respuesta[a].substring(23,25);
                if(!subStr2[z].isEmpty())
                {c++;
                z++;
                }
                   }  }}
             for(int i=0;i<69;i++)
                                  
             {
                
            /*try{
Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:sqlserver://10.50.103.70:1433;databaseName=gestion_trafico;user=etecsa;password=etecsa;");

Statement st = con.createStatement();


String strSQL="INSERT INTO TB_Senalizacion (ls,spid,slc) VALUES ("+ subStr[i] +",'"+ subStr1[i] +"',"+ y[i] +")";
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
           */   
                
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
