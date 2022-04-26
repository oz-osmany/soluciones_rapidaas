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

/**
 *
 * @author osmany.machado
 */
public class Hlr {
String []num=new String[100];
    public static void main(String[] args) throws InterruptedException {
        Socket   s;   
        String subStr2[]=new String[100];
        String subStr1[]=new String[100];
        String subStr[]=new String[100];
        String num_resul[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

        String host = "192.168.10.5";//"192.168.10.5";//HLR Huawei
        String []tabla={"tb_link_jaguey","tb_link_camaguey","tb_link_habana"};
        int      port = 5000;
        String[] respuesta=new String[200];
        String msisdn="5352889381";
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[100];
                    //arr[0]="";
                    arr[0]="osmany";
                    arr[1]="osmany2010";
                    arr[2]="hgsdp:msisdn='"+msisdn+"',all;";
                    arr[3]="";
                     //arr[4]="";
                      arr[4]="";
                       arr[5]="";
                        arr[6]="";
                         arr[7]="";
      
       try {
                                    s = new Socket(host,port);   
//Thread.sleep(25);
                                    //Creo las referencias al canal de escritura y lectura del socket
                                    p = new PrintStream(s.getOutputStream());
                                    b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                        for(int ss=0;ss<29;ss++)
                        {


                                     p.println(arr[ss]);    //Thread.sleep(10);                  
                                     respuesta[ss] = b.readLine();
                                     System.out.println(respuesta[ss]); 
                                     

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
