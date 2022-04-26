/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;
/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.text.Document;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author osmany.machado

public class Hlr_BuenaV implements Job{
    String []num=new String[100];
    Socket   s;   
    String subStr2[]=new String[100];
    String subStr1[]=new String[100];
    String subStr[]=new String[100];
    String num_resul[]=new String[100];
    PrintStream             p;
    BufferedReader    b;
    String host = "100.9.17.245";//HLR Huawei192.168.10.5
    String []tabla={"tb_link_jaguey","tb_link_camaguey","tb_link_habana"};
    int      port = 23;
    String[] respuesta=new String[200];
    //Referencia a la entrada por consola (System.in)
    BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
    String[] arr=new String[100];
    
    
    public void execute(JobExecutionContext jec) throws JobExecutionException
    {
    
    try {
           
                       // for(int ss=0;ss<46;ss++)
                        //{

                       


                            //Creo una conexion al socket servidor
                                    s = new Socket(host,port);   

                                    //Creo las referencias al canal de escritura y lectura del socket
                                    p = new PrintStream(s.getOutputStream());
                                    b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );

                                    arr[0]=new String("osmany");                                    
                                    arr[1]=new String("Anneris09");
                                    arr[2]=new String("sybfp:file;");
                                  byte ar[]=new byte[]{(byte)(0x04)};
                                     //arr[3]=new String("\u0004");
                                     // arr[4]=new String("@E");
                                   // arr[4]=new String("hgsdp:msisdn=5352800006,all;");
                                    //arr[5]=new String(";");
                                   // arr[]=new String("hgsdp:msisdn=5352889381,all;");

                                         //   
                               //{
                                  
                                   for(int r=0;r<4;r++)
                                    {
                                    
                                       p.println(arr[r]);
                                      
                                   }
                                      p.println(ar[0]);
                                    
                                     for(int c=0;c<120;c++)
                                     {
                                     respuesta[c] = b.readLine();
                                     System.out.println(respuesta[c]); 
                                     }
                                  
                                                                          
                                    
                               



                        //}
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
    

    /*public static void main(String[] args) {
        
        
        

  //Metodo que se ejecutara cada cierto tiempo que lo programemos despues
  
       
    }

    
        
}*/
