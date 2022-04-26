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
 * @author osmany.machado
 */

                  
                  
public class Abis {
    String user="etecsa";
String pass="etecsa";
String url="jdbc:mysql://10.94.1.143:3306/gestion_trafico";
 
     

  @SuppressWarnings("empty-statement")
public static void main(String[] args) {
      
        Socket      s;
        String subStr2[]=new String[100];
        String subStr1[]=new String[99000];
        String subStr[]=new String[99000];
        String ext[]=new String[100];
        int dev[]=new int[500];
        int dev1[]=new int[500];
        int dip[]=new int[500];
        PrintStream             p;
        BufferedReader    b;

        String          host = "10.92.17.14";
        int      port = 23;
        String[] respuesta=new String[99000];
       String q,w,e; 
        int[] datos=new int[300];
        int[] y=new int[300];
        int g;
        int a=0;
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[90250];
        byte[] buffer = new byte[1024]; 
        
        
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host,port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                arr[0]=new String("osmany");
                arr[1]=new String("Buenfuturo00.");//Buenfuturo00.
                arr[2]=new String("");
                arr[3]=new String("mml");
                arr[4]=new String("dtstp:dip=all;");
                arr[5]=new String("dtdip:dip=all;");
               arr[6]=new String("");
                
                
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
            for(int aa=0;aa<25;aa++)
            {
                
                p.println(arr[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
            }
                
           do
            {
                if(!respuesta[a].equals("DIP"))
             
                         {
                              a++;
                              p.println(arr[a]);                      
                              respuesta[a] = b.readLine();
                              System.out.println(respuesta[a]);
                              if(respuesta[a].isEmpty())
                                    {
                                        continue;
                                    
                                    }
                              if(respuesta[a].equals("END"))
                                    {
                                        continue;
                                    
                                    }
                              
                              if(respuesta[a].substring(9,12).equals("IEX"))
                                    {
                                        if(respuesta[a].substring(17,19).equals("WO"))
                                        {
                                        
                                         subStr[c1]=respuesta[a].substring(0,6);//recojo el dip
                                         subStr[c1]=subStr[c1].replaceAll(" ","");
                                    
                                        
                                         c1++;
                                        
                                        }
                              
                              
                                    }
                              
                              
                              
                              
                                   
                         }
                   
                              p.println(arr[a]);                      
                              respuesta[a] = b.readLine();
                              System.out.println(respuesta[a]);
                   
              }     
                   
                 while(!respuesta[a].equals("END"));
                
                
                
                
                             
                
                
                
  //Buscar la snt a traves de dtdip              
                
                a=0;
             for(int bb=0;bb<2;bb++)
             {
                do
                     {
                        p.println(arr[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]); 
                     
                     }
                  while (!respuesta[a].equals("DIGITAL PATH")) ;        
             }       
                    p.println(arr[a]);                      
                    respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]);
                    a++;
                    p.println(arr[a]);                      
                    respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]);
                    p.println(arr[a]);        
                    a++;
                    respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]);
                  
                
                 do
                     {
                      
                        
                        
                        subStr1[c1]=respuesta[a].substring(0,9);//Recojo el dip
                        subStr1[c1]=subStr[c1].replaceAll(" ","");
                        
                        subStr2[c1]=respuesta[a].substring(9,16);//Recojo snt
                        subStr2[c1]=subStr1[c1].replaceAll(" ","");
                        
                       q=respuesta[a].substring(0,respuesta[a].indexOf("R"));
                        dip[c1]=Integer.parseInt(q);
                        
                        dev[c1]=((dip[c1]*32));
                        dev1[c1]=dev[c1]+31;
                        
                        p.println(arr[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                        
                        c1++;
                     }
                  while (!respuesta[a].equals("END")) ;   
                   
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                  
             for(int i=0;i<c1;i++)
                                  
             {
                
           try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();


String strSQL="insert into TB_BSC_vclara (dip,dev,snt) values ('"+subStr[i]+"','RBLT2-"+dev[i]+"&&-"+dev1[i]+"','"+subStr1[i]+"')";




                    int rs = st.executeUpdate(strSQL); 

              
//rs.close();
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
            
                    

        } catch (UnknownHostException r) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException r) {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
       
        
    } 

 }
