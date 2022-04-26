/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;
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
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
//import oracle.toplink.essentials.mappings.converters.Converter;
/**
/**
 *
 * @author osmany.machado
 */
public class Backup {
    
    @SuppressWarnings("empty-statement")
public static void main(String[] args) {
Socket      s;

   

        
        int asc=16453;
        PrintStream             p;
        BufferedReader    b;

        String          host = "192.168.10.5";
        int      port = 5000;
        String[] respuesta=new String[2000];
      
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[250];
       
        //arr[5]=new Character((char)asc).toString();
       // System.out.println(arr[5]); 
        
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host,port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                arr[0]=new String("osmany");
                arr[1]=new String("osmany2010");
                arr[2]=new String("");
                arr[3]=new String("mml");
                arr[4]=new String("sybup:file;");
                arr[5]=new String(";");//arr[5]=new String().valueOf(asc).toString();
                arr[6]=new String("");
               arr[7]=new String(";");
            
                
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
            for(int a=0;a<30;a++) {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(arr[a]);
                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
            }            
              /*   if ( a>=25) {
                            
                    
                     p.println(arr[a]);                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
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
                   } 
            
               
              
               
               
               
            p.close();
            b.close();  
            s.close();
            
                     */
                    
                          
            
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
