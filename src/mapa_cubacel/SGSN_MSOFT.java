/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa_cubacel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author osmany.machado
 */
public class SGSN_MSOFT {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
   Socket      s;
   
        String subStr2[]=new String[5800];
        String subStr1[]=new String[5800];
        String subStr[]=new String[5800];
        String subStr3[]=new String[5800];
        String subStr4[]=new String[2800];
        String num_resul[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

        String  [] host = {"10.90.81.3","10.90.17.126","10.90.1.126"};//Jaguey, camaguey, habana
        String []tabla={"tb_link_jaguey","tb_link_camaguey","tb_link_habana"};
        int      port = 6000;
        String[] respuesta=new String[2900];
        long x[]=new long[2800];
        long y[]=new long[2800];
        long z[]=new long[2800];
        int[] datos=new int[300];
        //int[] y=new int[300];
        int inicio=0;
        int incr=17;
       
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[1550];
        String[] arr1=new String[1550];
        byte[] buffer = new byte[1024]; 
        int[] num_res= new int[20];
        int[] cont=new int[1800];
        int suc=0;
        for(int ss=0;ss<3;ss++)
        {
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host[ss],port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
            
             //arr[0]="LGI :op=\"trafico\",pwd=\"trafico123\";";
             //arr[1]="LST ROAMRESTGRP:;";
             arr[0]="LGI :op=\"admin\",pwd=\"lem\";";
             arr[1]="use me:meid=5;";
             arr[2]="LST ROAMRESTGRP:;"; // sacar todos los link set , despues los links
             for(int h=0;h<3;h++)
             {
                 p.println(arr[h]);
                respuesta[h] = b.readLine();
                System.out.println(respuesta[h]); 
             }
              
                        
    for(int a=0;a<35;a++)//necesito saber la cantidad de linkset ??
     {
        respuesta[a] = b.readLine();
        System.out.println(respuesta[a]); 
                   
          if(respuesta[a].contains("Start subscriber number") )     
              {
               respuesta[a] = b.readLine();
               System.out.println(respuesta[a]); 
               
               inicio=a;
               a=35;
               }
                      
      }
               
            do
                {
                    
                    inicio++;
                    respuesta[inicio] = b.readLine();
                    System.out.println(respuesta[inicio]); 
                   if(respuesta[inicio].contains("(Number of") )//saber que hay salto de linea
                     {
                         for(int r=inicio;r<inicio+12;r++)
                         {
                             respuesta[r] = b.readLine();//pasar las lineas no deseadas
                             System.out.println(respuesta[r]); 
                             if(respuesta[r].contains("RoamMsTypeGroup") )
                                 {
                                     r=inicio+12;
                                     respuesta[inicio]="RoamMsTypeGroup";
                                 }
                         }
                     }
                   else
                     {
                         
                       subStr1[inicio]=respuesta[inicio].substring(1,16);
                       x[inicio]=Long.parseLong(subStr1[inicio]);
                       ///lg = lg.valueOf(Str);      
                       subStr2[inicio]=respuesta[inicio].substring(26,41);
                        y[inicio]=Long.parseLong(subStr2[inicio]);
                       //inicio++;
                       if(respuesta[inicio].contains("INTER3GALLOW"))
                       {
                           if(respuesta[inicio].contains("36801"))
                           {
                           z[incr]=x[inicio];
                           incr++;
                           }
                           
                       }
                     }
                    
                }
                
            while(!respuesta[inicio].contains("RoamMsTypeGroup"));
             //subStr3[17]="999999999999991";
            // z[17]=Long.parseLong(subStr3[17]);
             
             for(int sss=17;sss<inicio;sss++)//recorrer los imsi
             {
                    for(int ii=17;ii<inicio;ii++) 
                      {
                                if((z[sss]<y[ii])&&(z[sss]>x[ii]))
                                {
                                    long xx=z[sss]+1;
                                    long yy=z[sss]-1;


                                   arr[0]="RMV ROAMRESTGRP: SERVICETYPE=ENROAMRST, RSTRIBY=IMSI, BEGINNUM=K'"+x[sss]+", ENDNUM=K'"+y[sss]+";";
                                   arr[1]="ADD ROAMRESTGRP: SERVICETYPE=ENROAMRST, RSTRIBY=IMSI, BEGINNUM=K'"+x[sss]+", ENDNUM=K'"+yy+",UGNAME=\"INTER3GREST\";";
                                   arr[2]="ADD ROAMRESTGRP: SERVICETYPE=ENROAMRST, RSTRIBY=IMSI, BEGINNUM=K'"+xx+", ENDNUM=K'"+y[sss]+",UGNAME=\"INTER3GREST\";";
                                   arr[3]="ADD ROAMRESTGRP: SERVICETYPE=ENROAMRST, RSTRIBY=IMSI, BEGINNUM=K'"+z[sss]+", ENDNUM=K'"+z[sss]+",UGNAME=\"INTERGALLOW\";";
                                            for (int i=0;i<4;i++)
                                            {
                                             p.println(arr[i]);
                                             respuesta[i] = b.readLine();
                                            }

                                    //System.out.println(respuesta[0]);
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

    
}        