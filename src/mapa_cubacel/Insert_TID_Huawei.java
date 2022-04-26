package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author kevin
 */
public class Insert_TID_Huawei {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
Socket      s;
        String subStr3[]=new String[900];
        String subStr2[]=new String[1500];
        String subStr1[]=new String[900];
        String subStr[]=new String[900];
        String subStr4[]=new String[900];
        String subStr5[]=new String[900];
        String subStr6[]=new String[900];
        String subStr7[]=new String[900];
        String num_resul[]=new String[100];
        int z=0;
        PrintStream             p;
        BufferedReader    b;
        int a=16;
        String [] host ={ "10.90.17.124","10.90.1.124","10.90.81.3","10.90.33.124"};//UMG Camaguey,Habana,Jaguey, Holguin
        int [] id_umg=new int[5];
        int      port = 6000;
        String[] respuesta=new String[600];
        String[] recibir=new String[600];
       String q,w,e; 
       int sbr=0;
        //int[] datos=new int[300];
       // int[] y=new int[300];
       
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[1000];
        String[] arr1=new String[1000];
        byte[] buffer = new byte[1024]; 
        int[] num_res= new int[20];
        int umg=3;
        for(int ss=3;ss<4;ss++)
        {
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host[ss],port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
            
            switch(ss)
            {
                case 0:
                     arr[0]="LGI :op=\"trafico\",pwd=\"NchOEakD1r+\";";//UMG Camg
                     arr[1]="LST TDMIU:;"; // sacar todos los link set , despues los links
                     id_umg[0]=0;
                    break;
                case 1:
                   arr[0]="LGI :op=\"trafico\",pwd=\"NchOEakD1r+\";";//UMG Habana
                   arr[1]="LST TDMIU:;"; // sacar todos los link set , despues los links
                    id_umg[1]=1;
                    break;
                case 3:
                     arr[0]="LGI :op=\"trafico\",pwd=\"NchOEakD1r+\";";//UMG Holguin
                     arr[1]="LST TDMIU:;"; // sacar todos los link set , despues los links
                     id_umg[3]=3;
                     break;
                     
                case 2:
                      arr[0]="LGI :op=\"admin\",pwd=\"lem\";";
                      arr[1]="use me:meid=5;";
                      arr[2]="LST TDMIU:;"; // sacar todos los link set , despues los links
                      id_umg[2]=2;
                     break;     
            }
            
               
               int pos=0;
               
               int j=0;
               int cont=0;
               int l=0;
               //hay que saber la cantidad que se espera...
               int num_r=0; //para tener el numero de los resultados
               for(int c=0;c<3;c++)
               {
                p.println(arr[c]);                     
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                Thread.sleep(10);
               }
           
              for(int c=0;c<17;c++)//c<12 para Habana
               {
               
                     
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                Thread.sleep(10);
               }
               
             /* for(int aa=0;aa<15;aa++)
              {
                p.println(arr[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(5);
              }*/
              
         do   ////necesito saber la cantidad de linkset ??
            {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                a++;
                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                //Thread.sleep(5);
                
               //if ( a>=17)
                //{
                  
                   if(respuesta[a].startsWith("(Number"))
                   {
                       
                       for(int aa=0;aa<14;aa++)
                       {
                           
                        respuesta[aa] = b.readLine();
                        
                        System.out.println(respuesta[aa]);
                        if(respuesta[aa].contains("2 reports in total"))
                        { respuesta[a] = respuesta[aa];aa=14;sbr=1;}
                        //a++;
                       }
                       if(sbr!=1)
                       {
                       respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                        }
                   }
                       
                  /*if(respuesta[a].startsWith("Table"))
                   {
                     p.println(arr[a]);//salta dos lineas
                     respuesta[a] = b.readLine();
                     System.out.println(respuesta[a]); 
                     
                     p.println(arr[a]);
                     respuesta[a] = b.readLine();
                     System.out.println(respuesta[a]); 
                      continue;} 
                   
                    subStr[a]=respuesta[a].replaceAll(" ", "");
                     if((subStr[a].isEmpty())) //salto de linea
                   {
                      continue;
                   
                   }  */
                         if(sbr==0)
                         {
                  subStr[z]=respuesta[a].substring(0,3); //Board type 
                  subStr1[z]=respuesta[a].substring(14,15);//Board No
                  subStr2[z]=respuesta[a].substring(42,47);//Tid star
                  subStr3[z]=respuesta[a].substring(56,61);//TID end
                  
                  subStr[z]=subStr[z].replaceAll(" ","");
                  subStr2[z]=subStr2[z].replaceAll(" ","");
                  subStr3[z]=subStr3[z].replaceAll(" ","");
                  
                 
                  
                  
                   z++;                 
                  }
              
            }
          while(!respuesta[a].contains("2 reports in total"));
            //while(!respuesta[a].contains("2 reports"));
            p.close();
            b.close();  
            s.close(); 
              
            
            s = new Socket(host[ss],port);   
            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
                arr1[0]="LGI :op=\"trafico\",pwd=\"NchOEakD1r+\";";
               //arr[1]=new String("LGI :op=\"trafico\",pwd=\"trafico123\";");
                p.println(arr1[0]);                      
                respuesta[0] = b.readLine();
                System.out.println(respuesta[0]); 
            for(int aa=0;aa<7;aa++)
              {
                //p.println(arr1[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(5);
              }
                for(int h=1;h<220;h++)
                {
              arr1[h]="LST TDMTID: TIDFVDEC="+subStr2[h-1]+";"; // sacar la posicion en la tarjeta
                }
                
               int z1=0;
                for(int aa=0;aa<17;aa++)
              {
                p.println(arr1[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(5);
              }                           
               //hay que saber la cantidad que se espera...
               //nt num_r=0; //para tener el numero de los resultados
           // for(int ee=0;ee<z;ee++)//necesito saber la cantidad de linkset ??
            //{
                 for(int bb=1;bb<z;bb++)
                 {
               
                p.println(arr1[bb]);
                      
                respuesta[bb] = b.readLine();
                System.out.println(respuesta[bb]); 
               // if(ee==0 || ee==20 || ee==33 || ee==46 || ee==60 || ee==73)
               // {            
               //if ( a>=13)
                 
                   
                //{
                   /*if(a==(z*10)-1)
                       
                   {
                       continue;
                   }
                   
                   if(respuesta[bb].startsWith("---"))
                   {//a=70;
                       for(int i=0;i<10;i++)
                       {
                     //p.println(arr1[a]);                      
                     respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]); 
                       }
                    
                                        
                   continue;
                   }
                   if(respuesta[bb].startsWith("(Number"))
                   {
                   continue;
                   }*/
                  if(respuesta[bb].startsWith("TID Information"))
                   {
                       for(int y=0;y<4;y++)
                       {
                       respuesta[bb] = b.readLine();
                       System.out.println(respuesta[bb]); 
                       }
                     
                     
                    /* p.println(arr1[a]);
                     respuesta[a] = b.readLine();
                     System.out.println(respuesta[a]); 
                      continue;} */
                   
                    //subStr[a]=respuesta[a].replaceAll(" ", "");
                     if((respuesta[bb].isEmpty())) //salto de linea
                   {
                      continue;
                   
                   }  
                           
                  subStr4[z1]=respuesta[bb].substring(9,10); //Frame No
                  subStr5[z1]=respuesta[bb].substring(15,17);//Slot No
                  subStr6[z1]=respuesta[bb].substring(33,35);//Port No
                  //subStr7[z1]=respuesta[a].substring(39,41);//TSlot end
                  
                  //subStr7[z1]=subStr4[z1].replaceAll(" ","");
                  subStr4[z1]=subStr4[z1].replaceAll(" ","");
                  subStr5[z1]=subStr5[z1].replaceAll(" ","");
                  subStr6[z1]=subStr6[z1].replaceAll(" ","");
                  
                  
                  
                  
                   z1++;                 
                  }
               for(int aa=0;aa<9;aa++)
              {
                //p.println(arr1[aa]);                      
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(5);
              }                     
                
            }
            
               
               
               //hacer un ciclo para insertar datos
               for(int i=0;i<z;i++)
               {
         try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();

String strSQL="INSERT INTO TB_TID (board_type,board_no,tid_star,tid_end,frame_no,slot_no,port_no,id_umg) VALUES ('"+subStr[i]+"','"+subStr1[i]+"','"+subStr2[i]+"','"+subStr3[i]+"','"+subStr4[i]+"','"+subStr5[i]+"','"+subStr6[i]+"','"+id_umg[ss]+"')";

//String strSQL="update TB_TID set board_type='"+subStr[i]+"',board_no='"+subStr1[i]+"',tid_star='"+subStr2[i]+"',tid_end='"+subStr3[i]+"',frame_no='"+subStr4[i]+"',slot_no='"+subStr5[i]+"',port_no='"+subStr6[i]+"',id_umg='"+id_umg[ss]+"' where id="+(i+1)+" ";
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
            p.close();
            b.close();  
            s.close();
            
    
               //String res=b.readLine();
                //subStr2[0]=respuesta[29].substring(0);
                //subStr[0]=respuesta[29].substring(0);
                //subStr1[0]=respuesta[29].substring(0);
               
            
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
