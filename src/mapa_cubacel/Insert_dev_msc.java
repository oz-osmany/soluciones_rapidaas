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
//import oracle.toplink.essentials.internal.parsing.LengthNode;
/**
 *
 * @author heidy.capote
 */
public class Insert_dev_msc {
    @SuppressWarnings("empty-statement")
    
     public static void main(String[] args) {
      Socket      s;
        String subStr2[]=new String[38900];
        String subStr1[]=new String[38900];
         String subStr3[]=new String[38900];//Para dividir el device
         String subStr4[]=new String[38900];
         String subStr5[]=new String[38900];
         String subStr6[]=new String[38900];
         String subStr7[]=new String[38900];
         String subStr8[]=new String[38900];
         String subStr9[]=new String[38900];
         String subStr10[]=new String[38900];
        //String subStr[]=new String[100];
       // String ext[]=new String[100];
        PrintStream             p;
        BufferedReader    b;
        String          host = "10.50.10.30";
        int      port = 23;
        String[] respuesta=new String[38900];
        String q,w,e; 
        int[] datos=new int[300];
        //int[] y=new int[300];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[38900];
        byte[] buffer = new byte[2024]; 
        int a=0; 
        int aa=0;
        int cont=0;
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
                arr[4]=new String("strdp:r=all;");
               
               
                
                
                
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
                for(int d=0;d<=22;d++)
                {
                    p.println(arr[d]);
                    respuesta[d] = b.readLine();
                    System.out.println(respuesta[d]); 
                }
                
          
         do 
         {
             
                         p.println(arr[a]);                      //Printeo 4 veces para llegar a la ruta
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);    
                         a++;
                        p.println(arr[a]);                      //Printeo 4 veces para llegar a la ruta
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);
                           a++;
                         //subStr1[z1]=respuesta[a-1].substring(0,10);//tomo la ruta
                       // subStr1[z1]=subStr1[z1].replaceAll(" ","");
                       // z1++;
                        
                        p.println(arr[a]);                      //Printeo 4 veces para llegar a la ruta
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);
                         a++;
                         p.println(arr[a]);                      //Printeo 4 veces para llegar a la ruta
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);
                         a++;
                         p.println(arr[a]);                      //Printeo 4 veces para llegar a la ruta
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);
                        
                do//Para tomar todos los devices
                {
                    if(respuesta[a].equals("                      MBL"))
                    {
                        p.println(arr[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                        continue;
                    }
                    if(respuesta[a].equals("NONE"))
                    {
                        p.println(arr[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                        //a++;
                        
                    }
                    else
                    {
                       if(respuesta[a].contains("END"))
                       {
                       
                       break;
                       }
                       
                        subStr1[z1]=respuesta[a-3].substring(0,10);//tomo la ruta
                        subStr1[z1]=subStr1[z1].replaceAll(" ","");
                        subStr2[z1]=respuesta[a].substring(0,10);//tomo el device
                        subStr2[z1]=subStr2[z1].replaceAll(" ","");
                        //c1=respuesta[a].indexOf("-");
                        subStr3[z1]=respuesta[a].substring(0,respuesta[a].indexOf("-")+1);//1 dev
                        subStr3[z1]=subStr3[z1].replaceAll("-","");
                        
                        subStr4[z1]=respuesta[a].substring(respuesta[a].indexOf("-")+1,11);//2 num
                        subStr4[z1]=subStr4[z1].replaceAll(" ","");
                        //if(!subStr4[z1].equals(""))
                        //{
                        
                       
                        if(subStr3[z1].equals("UPD"))
                        {
                            subStr6[cont]=subStr1[z1];//repongo las rutas
                            subStr7[cont]=subStr2[z1];//repongo devices
                            subStr8[cont]=subStr3[z1];//repongo dev
                           // subStr9[cont]=subStr4[z1];//repongo numero
                            //subStr10[cont]=subStr5[z1];//repongo dip 
                            c1=Integer.parseInt(subStr4[z1]);
                            subStr5[z1]=String.valueOf(c1/32);
                            z1++;
                            cont++;
                        }
                        else
                                    if(subStr3[z1].equals("UPD1"))
                                       {
                                        subStr6[cont]=subStr1[z1];//repongo las rutas
                                        subStr7[cont]=subStr2[z1];//repongo devices
                                        subStr8[cont]=subStr3[z1];//repongo dev
                                        //subStr9[cont]=subStr4[z1];//repongo numero
                                        //subStr10[cont]=subStr5[z1];//repongo dip
                                        c1=Integer.parseInt(subStr4[z1]);
                                        subStr5[z1]=String.valueOf(c1/32);
                                        z1++;
                                        cont++;

                                       }
                       else
                                 if(subStr3[z1].equals("MAL1"))
                                       {
                                        subStr6[cont]=subStr1[z1];//repongo las rutas
                                        subStr7[cont]=subStr2[z1];//repongo devices
                                        subStr8[cont]=subStr3[z1];//repongo dev
                                        //subStr9[cont]=subStr4[z1];//repongo numero
                                        //subStr10[cont]=subStr5[z1];//repongo dip
                                        c1=Integer.parseInt(subStr4[z1]);
                                        subStr5[z1]=String.valueOf(c1/32);
                                        z1++;
                                        cont++;

                                       }
                       else
                                  if(subStr3[z1].equals("MALT"))
                                       {
                                        subStr6[cont]=subStr1[z1];//repongo las rutas
                                        subStr7[cont]=subStr2[z1];//repongo devices
                                        subStr8[cont]=subStr3[z1];//repongo dev
                                        //subStr9[cont]=subStr4[z1];//repongo numero
                                        //subStr10[cont]=subStr5[z1];//repongo dip
                                        c1=Integer.parseInt(subStr4[z1]);
                                        subStr5[z1]=String.valueOf(c1/32);
                                        z1++;
                                        cont++;

                                       }
                        else
                                   if(subStr3[z1].equals("LIPRAGS"))
                                       {
                                        subStr6[cont]=subStr1[z1];//repongo las rutas
                                        subStr7[cont]=subStr2[z1];//repongo devices
                                        subStr8[cont]=subStr3[z1];//repongo dev
                                        //subStr9[cont]=subStr4[z1];//repongo numero
                                        //subStr10[cont]=subStr5[z1];//repongo dip
                                        c1=Integer.parseInt(subStr4[z1]);
                                        subStr5[z1]=String.valueOf(c1/32);
                                        z1++;
                                        cont++;

                                       }   
                        
                      
                        
                         //a++;
                        p.println(arr[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                        //}
                        
                        
                        } 
                         //aa++;
                         //cont++;
                      
                    
                }
                while(!respuesta[a].contains("DEVICE STATE SURVEY"));
                
                
                
         }
                while(!respuesta[a].equals("END"));//llego al final
                
                
                
           
                
                 
                    //datos[z1]=Integer.parseInt(subStr1[z1]);//paso el string a int del NDV de la tabla
                   
                
                
             for(int ss=0;ss<2;ss++)
                                  
             {
                 for(int i=0;i<cont-1;i++)
                 {
           try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();

//String strSQL="update tb_dev_msc set dip='"+subStr5[i]+"' where id=(1+'"+i+"')";
//String strSQL="update tb_dev_msc set   dip="+subStr5[i]+" where id=("+i+"+1)";
String strSQL="INSERT INTO TB_dev_msc_prueba (dev,rutas,device,dip) VALUES ('"+ subStr7[i]+"','"+ subStr6[i]+"','"+ subStr8[i]+"','"+ subStr5[i]+"') ";
//String strSQL="Select rutas,cic from TB_Rutas ";           
                    boolean rs = st.execute(strSQL); 


            
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
    
      
        
    

