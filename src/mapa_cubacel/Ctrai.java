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
import java.sql.SQLException;

/**
 *
 * @author osmany.machado
 */
public class Ctrai {
    
     public Socket  s=null;
     public String cellda=null;
     public String tb_cell=null;//para las tablas
     public String tb_bsc=null;//para las tablas
     PrintStream p;
     BufferedReader b;   
     String mtv=null;
     String host =null;
     String[] respuesta=new String[100];
     String lac=null;
     String lai=null;
     String[] arr=new String[50];
     String[] arr1=new String[50];
    public String cell=null;
     int      port;
     int num=9;
     public  Ctrai()
    {}
    public Ctrai(String ent)
    {
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        try
        {
        port=23;
        host = "10.90.97.12";//10.50.10.30";//
        s = new Socket(host ,port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                    
                    
                    arr[0]="osmany";
                    arr[1]="Cubacel*2014";
                    arr[2]="";
                    arr[3]="mml";
                    arr[4]="ctrai:msisdn="+ent+";";
                    
                         
                    for(int j=0;j<5;j++)
                        {
                         p.println(arr[j]);
                         respuesta[j] = b.readLine();
                         System.out.println(respuesta[j]);
                         
                        }
                     for(int j=4;j<28;j++)
                        {
                         //p.println(arr[j]);
                         respuesta[j] = b.readLine();
                         System.out.println(respuesta[j]);
                         
                        }
             
                         mtv=respuesta[27].substring(8, 14);
                         mtv=mtv.replaceAll(" ","");
                    arr[5]="test system;";
                    arr[6]="print var mtv "+mtv+":330;";
                    arr[7]="print var mtv "+mtv+":329;";
                    arr[8]="print var mtv "+mtv+":328;";
                    arr[9]="print var mtv "+mtv+":327;";
                    arr[10]="end test;"; 
                    
                    
                         for(int k=23;k<27;k++)
                         {
                         //p.println(arr[j]);
                         respuesta[k] = b.readLine();
                         System.out.println(respuesta[k]);
                         
                         }
                    
                for(int j=5;j<11;j++)//para tomar el lac y lai
                        {
                             p.println(arr[j]);
                             respuesta[j] = b.readLine();
                             System.out.println(respuesta[j]);
                             
                             
                        }
                    for(int j=10;j<32;j++)
                    {
                             respuesta[j] = b.readLine();
                             System.out.println(respuesta[j]);
                                 if(respuesta[j].contains("8=H'"))
                                 {
                                    int hh=respuesta[j].indexOf("8=H'");
                                    String lac_cgi=respuesta[j].substring(hh+4, hh+8);
                                    Hex lac1=new Hex();
                                    
                                    lac=Long.toString(lac1.Hex(lac_cgi));
                                    //int num_lac=Integer.parseInt(lac);
                                    //int large=lac.length();
                                    //int dec=
                                 }
                             if(respuesta[j].contains("7=H'"))
                                 {
                                    int hh=respuesta[j].indexOf("7=H'");
                                    String lai_cgi=respuesta[j].substring(hh+4, hh+8);
                                    Hex lai_=new Hex();
                                    lai=Long.toString(lai_.Hex(lai_cgi));
                                    for(int q=0;q<5;q++)
                                    {
                                     respuesta[q] = b.readLine();
                                    System.out.println(respuesta[q]);
                                    }
                                    
                                   
                                    j=32;
                                 }
                        }  
                    arr[11]="mgcep:lai=368-01-"+lac+";";  
                 //arr[11]=new String("mgcep:lai=368-01-43;");   
                /* p.println(arr[11]);
                 respuesta[11] = b.readLine();
                 System.out.println(respuesta[11]);*/
                    for(int tt=11;tt<62;tt++)//para tomar el lac y lai
                        {
                             p.println(arr[tt]);
                             respuesta[tt] = b.readLine();
                             System.out.println(respuesta[tt]);
                             if(respuesta[tt].contains("368-01-43-"+lai+""))
                             {
                                  cell=respuesta[tt].substring(0, 8);
                                 tt=62;
                                
                             }
                       }
                    
                 
                  switch(num)
           {
            case 5://Esta es la numeracion del BSC
                cellda=cell;
                tb_bsc="tb_bsc_pan";
                tb_cell="tb_cell_pan";
                //vec=5;
                break;
            case 6 :
                cellda=cell;
                tb_bsc="tb_bsc_cub";
                tb_cell="tb_cell_cub";
                //vec=6;
                break;
            case 7:
                cellda=cell;
                tb_bsc="tb_bsc_zte";
                tb_cell="tb_cell_zte";
                //vec=9;
                break;
            case 8:
                cellda=cell;
                tb_bsc="tb_bsc_jaguey";
                tb_cell="tb_cell_cam";
                //vec=8;
                break;
            case 9:
                cellda=cell;
               tb_bsc="tb_bsc_vclara";
               tb_cell="tb_cell_vclara";
               //vec=7;
                break;
            case 10:
                cellda=cell;
                tb_bsc="tb_bsc_cam";
                //vec=10;
                break;
            case 11:
                //result="tb_cell_cam";
              
                break;
        
        }
                   
                    
                   
                   //arr[13]=new String("rxmop:mo=rxotg-"++";");
                   
       }
   
        
    
    
    catch (UnknownHostException r) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException r) {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
   }
    
}
