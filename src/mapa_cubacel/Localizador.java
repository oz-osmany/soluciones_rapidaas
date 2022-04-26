/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osmany.machado
 */
public class Localizador {
    
    public String bsc=null;//para recibir el BSC
    public String cell=null;//para recibir la celda
    public String cellda=null;
    public ResultSet rs = null;  
    public String tb_cell=null;//para las tablas
    public String tb_bsc=null;//para las tablas
     Socket      s=null;
     PrintStream p;
     BufferedReader b;
     String op=null;
     String pwd=null;
     String mtv=null;
     String host =null;
     String[] respuesta=new String[100];
     BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
     String[] arr=new String[50];
     String[] arr1=new String[50];
     int      port;
     int vec=0;//para saber cual bsc
     int c=0;//para tener el tg
     String result=null;
     String result1=null;
     String muestra=null;//para mostrar
    public Localizador(String entrada, int msc) 
    {
    String ent=entrada;
    int id_msc=msc;
    
     try {

            //Creo una conexion al socket servidor
            
     
            switch(id_msc)
            {
                case 1:
                    host="10.90.1.126";//Msoft Cubanacan
                    port=6000;
                    op="trafico";
                    pwd="trafico123";
                    arr[0]=new String("LGI :op=\""+op+"\",pwd=\""+pwd+"\";");
                    arr[1]=new String("DSP USRINF: UNT=MSISDN, D=K'"+ent+";");
                    //arr[1]=new String("use me:meid=5;");
                    break;
                case 2:
                    host="10.90.81.3";//Msoft Jaguey
                    port=6000;
                    op="admin";
                    pwd="lem";
                    arr[0]=new String("LGI :op=\""+op+"\",pwd=\""+pwd+"\";");
                    arr[2]=new String("DSP USRINF: UNT=MSISDN, D=K'"+ent+";");
                    arr[1]=new String("use me:meid=5;");

                    break;
                case 3:
                    host="10.90.17.126";//Msoft Camaguey
                    port=6000;
                    op="machado";
                    pwd="Yurismeri1985";
                    arr[0]=new String("LGI :op=\""+op+"\",pwd=\""+pwd+"\";");
                    arr[1]=new String("DSP USRINF: UNT=MSISDN, D=K'"+ent+";");
                    //arr[1]=new String("use me:meid=5;");
                    break;
              
            
            
            }
            if(id_msc==4)
                      {

                       Ctrai ct=new Ctrai(ent);
                       cellda=ct.cell;
                       tb_bsc=ct.tb_bsc;
                       tb_cell=ct.tb_cell;

                      }
            
            
       else
          {
            
            s = new Socket(host,port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
            
              p.println(arr[0]);
              respuesta[0] = b.readLine();
              System.out.println(respuesta[0]);  
               
               
              p.println(arr[1]);
              respuesta[1] = b.readLine();
              System.out.println(respuesta[1]);
              
                     if(id_msc==2)

                      {

                        //p.println(arr[2]);
                         for(int a=0;a<10;a++)
                         {
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]); 
                         }
                                 p.println(arr[2]);
                                 respuesta[2] = b.readLine();
                                 System.out.println(respuesta[2]);

                                 for(int t=0;t<46;t++)
                             {  
                                 p.println(arr[t]);
                                 respuesta[t] = b.readLine();
                                 System.out.println(respuesta[t]);
                              if(respuesta[t].contains("Location Area Name") )
                                  {
                                        int g=respuesta[t].indexOf("Location Area Name");
                                        bsc=respuesta[t].substring(g+23, respuesta[t].length());
                                        respuesta[t] = b.readLine();
                                        System.out.println(respuesta[t]); 
                                        respuesta[t] = b.readLine();
                                        System.out.println(respuesta[t]);
                                        cell=respuesta[t].substring(g+23, respuesta[t].length());


                                  }
                             }


                       }
                      
                             else//El resto
                             {
                                     for(int t=0;t<46;t++)
                                     {  
                                         //p.println(arr[t]);
                                         respuesta[t] = b.readLine();
                                         System.out.println(respuesta[t]);
                                      if(respuesta[t].contains("Location Area Name") )
                                          {
                                                int g=respuesta[t].indexOf("Location Area Name");
                                                bsc=respuesta[t].substring(g+23, respuesta[t].length());
                                                respuesta[t] = b.readLine();
                                                System.out.println(respuesta[t]); 
                                                respuesta[t] = b.readLine();
                                                System.out.println(respuesta[t]);
                                                cell=respuesta[t].substring(g+23, respuesta[t].length());


                                          }
                                     }


                               }
             
              
              
           }       
              
              
      }
    
     catch (UnknownHostException r)
    {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        }
    catch (IOException r)
    {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
       
     
     
     }
    
    
    
    
    
    
    
   
            
            
        
        
    
    
    
    
    
    

}
