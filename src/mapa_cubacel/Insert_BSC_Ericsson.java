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
public class Insert_BSC_Ericsson {
     @SuppressWarnings("empty-statement")
public static void main(String[] args) {
Socket      s;

   

        String subStr2[]=new String[1000];
        String subStr1[]=new String[8000];
        String subStr3[]=new String[8000];
        String subStr[]=new String[8000];
        String subStr4[]=new String[8000];
        String subStr5[]=new String[8000];
        String subStr6[]=new String[8000];
        
        PrintStream   p;
        BufferedReader  b;

        String []host = {"100.9.1.14","100.92.17.14","100.9.105.05"};//Buena vista panorama y villa clara"100.9.105.05",
        String []tabla={"TB_bsc_pan","TB_bsc_vclara","TB_bsc_cub"};//,,"TB_bsc_pan","TB_bsc_vclara"
        int port = 23;
        String[] respuesta=new String[3000];
      
        int[] datos=new int[300];
        int[] y=new int[300];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[2250];
        String[] arr1=new String[2250];
        String[] dev=new String[2250];
        String[] dev1=new String[2250];
        String[] dip=new String[2250];
        String tipo=null;
       int [] rr=new int[200];
        int a=26;
        int q;
        for(int ss=2;ss<3;ss++)
        {
            
            
      
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host[ss],port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
            
            //Se envia loging y pass en dependencia del nodo
            switch(ss)
            {
                case 0:
                    
                    arr[1]="osmany09";
                     arr[2]="Buenfuturo00.";
                     tipo="RBL2";
                    
                    break;
                case 1:
                      arr[1]="osmany";
                    arr[2]="Buenfuturo00.";
                    tipo="RB2";    
                    
                    break;
                case 2:
                     
                    arr[1]="carlos";
                    arr[2]="Carlcg@1987";
                    tipo="RBL2";
                     break;
            }
                
                arr[3]="";
                arr[4]="mml";                
                arr[5]="rxapp:moty=rxotg;";
                arr[6]="rxmop:moty=rxotg;";
               
               // arr[7]=new String("rlcfp:cell=all;");
               //arr[8]=new String("rldep:cell=all;");
              
                
                
                int c=1; //contador de links
                int c1=1;
                int z=0;
                int z1=0;
          for(int aa=1;aa<5;aa++) 
            {
                
                p.println(arr[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(15);
            }
            
          for(int aa=4;aa<8;aa++) 
            {
                
                
                p.println(arr[aa]);                      
                respuesta[aa]= b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(15);
            }
            
          for(int aa=7;aa<27;aa++) 
            {
                
                
               // p.println(arr[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
               // Thread.sleep(15);
            }
                              
                do
            {
                                 
                   if(respuesta[a].equals("MO"))
             
                         {
                       a++;
                             // p.println(arr[a]);                      
                              respuesta[a] = b.readLine();
                              System.out.println(respuesta[a]);
                              
                              
                              subStr1[c1]=respuesta[a].substring(6,respuesta[a].length());//recojo el Tg
                                 for(int i=0;i<3;i++)
                                    {
                                     p.println(arr[a]);                      
                                    respuesta[a] = b.readLine();
                                     System.out.println(respuesta[a]); 
                                     
                                    }
                                    if(respuesta[a].equals("NONE"))
                                    {
                                        subStr[c1]="";
                                        dip[c1]="";
                                        dev1[c1]="";
                                        rr[c1]=c1;//para saber que un tg no tiene dispositivos
                                        c1++;
                                        continue;
                                    
                                    }
                                       
                           subStr[c1]=respuesta[a].substring(6,10);//recojo el device
                           subStr[c1]=subStr[c1].replaceAll(" ","");
                           q=Integer.parseInt(subStr[c1]);
                            dip[c1]=String.valueOf(q/32);
                            q=Integer.parseInt(subStr[c1])+31;
                            dev1[c1]=String.valueOf(q);
                                    c1++;
                                   
                         }
                   
                              //p.println(arr[a]);                      
                              respuesta[a] = b.readLine();
                              System.out.println(respuesta[a]);
                   
              }     
                   
                 while(!respuesta[a].equals("END"));
               
                c1=1;
                a=1;
                    for(int i=1;i<8;i++)
                    {
                         p.println(arr1[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]); 
                       // p.println(arr1[a]);  
                    }
                
                do
                 {
                       
                   
                   c=respuesta[a].indexOf("RXOTG-");
                  
                  if(c>=0)//saber que llego a un RISTE
                     {
                         
                        if(rr[c]==0)
                            
                        {//
                            
                            subStr3[c1]=respuesta[a].substring(6,9);//recojo el tg
                            subStr3[c1]=subStr3[c1].replaceAll(" ","");
                            
                            subStr2[c1]=respuesta[a].substring(18,32);//Recojo el rsite
                            subStr2[c1]=subStr2[c1].replaceAll(" ","");
                            if(subStr2[c1].contains("ABIS_IP"))
                            {
                                subStr3[c1]="";
                                subStr2[c1]="";
                                c1--;
                            }
                        
                        }
                        else
                        {
                            subStr3[c1]="";
                            subStr2[c1]="";
                        
                        }
                        c1++;
                     }
                   
                        p.println(arr1[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                   
                   }
                
                while(!respuesta[a].equals("END"));
                 
             
                
                //para bcch y fr
              /*  for(int i=1;i<6;i++)
                    {
                         p.println(arr1[a]);                      
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]); 
                        p.println(arr1[a]);  
                    }
                
                c1=1;
                int cc1=1;
                int aa=respuesta[a].indexOf("DCHNO");
                int bb=respuesta[a].indexOf("TN");
                do
                {
                    
                     p.println(arr1[a]);                      
                     respuesta[a] = b.readLine();
                     System.out.println(respuesta[a]); 
                     
                     if(respuesta[a].isEmpty())
                     {
                        continue;
                     }
                     
                     
                     if(respuesta[a].contains("END"))
                     {
                        continue;
                     }
                     if(respuesta[a].contains("CELL"))
                         
                     {
                            for(int h=0;h<4;h++)//Cuando cambie seguir hasta la informacion
                            {
                                 p.println(arr1[a]);                      
                                 respuesta[a] = b.readLine();
                                 System.out.println(respuesta[a]); 
                                

                            }
                      
                     }
                     if(respuesta[a].contains("                                   7"))
                     {
                        continue;
                     }
                     if(respuesta[a].contains("NO        8    OFF"))
                     {
                        continue;
                     }
                     
                     subStr4[c1]=respuesta[a].substring(aa+1, aa+4);
                     subStr4[c1]=subStr4[c1].replaceAll(" ", "");
                     
                     
                     c1++;
                
                }
                while(!respuesta[a].equals("END"));
                
                */
                
                
                
                
                
                
                  
             //for(int i=1;i<c1;i++)
                                  
            // {
                
           try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();

String strSQL="delete from "+tabla[ss]+" ";
boolean rs = st.execute(strSQL);
for(int i=1;i<c1;i++){
Statement stt = con.createStatement();
String strSQL1="INSERT INTO "+tabla[ss]+" (id,rsite,tg,dip,dev) VALUES ( "+i+",'"+subStr2[i]+"','"+subStr3[i]+"','"+dip[i] +""+tipo+"','RBLT2-"+subStr[i]+"&&-"+dev1[i]+"') ";
                    boolean rs1 = stt.execute(strSQL1); 
                    stt.close();
}
             
             
//rs.close();]+"','"+dip[i] +""+tipo+"','RBLT2-"+subStr[i]+"&&-"+dev1[i]+"')";
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
             
                
//}      
           
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
        } catch (InterruptedException ex) {
        Logger.getLogger(Insert_BSC_Ericsson.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        
    } 
  }
}
