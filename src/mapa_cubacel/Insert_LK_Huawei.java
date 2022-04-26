/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.Timer;
/**
 *
 * @author kevin
 */
public class Insert_LK_Huawei {
 public static void main(String[] args) {
Socket   s;
   
        String subStr2[]=new String[100];
        String subStr1[]=new String[100];
        String subStr[]=new String[100];
        String num_resul[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

        String  [] host = {"100.9.81.3","100.9.17.126","100.9.10.126"};//Jaguey, camaguey, habana
        String []tabla={"tb_link_jaguey","tb_link_camaguey","tb_link_habana"};
        int      port = 6000;
        String[] respuesta=new String[200];
       String q,w,e; 
        //int[] datos=new int[300];
       // int[] y=new int[300];
       
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[100];
        String[] arr1=new String[100];
        byte[] buffer = new byte[1024]; 
        int[] num_res= new int[20];
        int suc=0;
        int total=0;//para saber cuando llego a Mumber of results
        for(int ss=1;ss<2;ss++)
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
                    arr[0]=new String("LGI :op=\"admin\",pwd=\"lem\";");
                    arr[2]=new String("LST N7LKS:LTP=LOCAL;");// sacar todos los link set , despues los links
                    arr[1]=new String("use me:meid=5;"); 
                    break;
                case 1:
                   arr[0]=new String("LGI :op=\"machado\",pwd=\"Yurismeri1985\";");
                    arr[1]=new String("LST N7LKS:LTP=LOCAL;");
                    
                    break;
                case 2:
                     arr[0]=new String("LGI :op=\"machado\",pwd=\"Buenfuturo30/\";");
                     arr[1]=new String("LST N7LKS:LTP=LOCAL;"); 
                     break;
            }
                
               int pos=0;
               int z=0;
               int cont=0;
               int l=0;
               //hay que saber la cantidad que se espera...
               int num_r=0; //para tener el numero de los resultados
               
          
               
           
              p.println(arr[0]);
              respuesta[0] = b.readLine();
              System.out.println(respuesta[0]);  
               
               
              p.println(arr[1]);
              respuesta[1] = b.readLine();
              System.out.println(respuesta[1]); 
              
               
           for(int a=0;a<10;a++)//necesito saber la cantidad de linkset ??
            {
                   respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                   
                   
               }
              
              
              
              
              
            for(int a=2;a<45;a++)//necesito saber la cantidad de linkset ??
            {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(arr[a]);
                   
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
           
                
               if ( a>=11)
                {
                    subStr[a]=respuesta[a].replaceAll(" ", "");
                     if((subStr[a].isEmpty())) //salto de linea
                   {
                      continue;
                   
                   }  
                    if(respuesta[a].equals("---    END") )
                {
                    total=a-2;    
                    a=45;
                continue;
                }
                    
                    
                  subStr[z]=respuesta[a].substring(0);
                  subStr2[z]=subStr[z].substring(0,15);
                  subStr1[z]=subStr2[z].replaceAll(" ","");
                   z++;                 
                  }
                     
               
                }
               
               //Para saber cuantos linkset hay
               
               num_resul[z]=respuesta[total].substring(0);
               num_resul[z]=num_resul[z].substring(21,23);
              num_resul[z]=num_resul[z].substring(0).replace(")", "");
               num_r=Integer.parseInt(num_resul[z]);
               
                     z=0;
                     int z1=0;
               //Empieza con los link
                for(int i=1;i<num_r+1;i++)
               {
                   
               arr[i]="LST N7LNK:LSNM=\""+subStr1[i-1]+"\",LTP=LOCAL;";    //pregunta por los link set  
               }//aqui termina el ciclo
               
               
               //
               for(int a=0;a<=99;a++) 
               {
                   
               p.println(arr[a]);
                      
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                
           /*if(respuesta[a].equals("---    END") )
                {
                    l=0;
                break;
                }*/
          
               subStr[a]=respuesta[a].replaceAll(" ", "");
                           if((subStr[a].isEmpty())) 
                   {
                      //j++; //salto de linea
                  }  
                           else
                           {
                                    
                  subStr[z1]=respuesta[a].substring(0);
                  subStr2[z1]=subStr[z1].substring(0);
                  pos=subStr2[z1].indexOf("No.7 link table");// devuelve 1 si contiene ese texto
                  if(pos>=0)
                  {
                      subStr[z1]=respuesta[a].substring(0);
                      subStr[z1]=subStr[z1].substring(17,subStr[z1].length());
                      //saber si el link tiene dos formas TDM o M2UA 
                      if(respuesta[a-2].startsWith("(Number"))
                      {
                      for(int h=num_r;h>cont-2;h--)
                      {
                      subStr1[h+1]=subStr1[h];//desplazamiento del arreglo hacia delante
                      
                      }
                      
                      }
                      
                      arr1[z1]=subStr[z1].substring(0).replace(")", "");//tengo tipo de link (M2UA 2M link)
                       z1++;
                      
                      
                      
                      
                  }
                  else
                  {
                  
                  subStr[z]=respuesta[a].substring(0);
                  subStr2[z]=subStr[z].substring(0);
                  pos=subStr2[z].indexOf("Number of results");// devuelve 1 si contiene ese texto
                
                  if(pos>=0)
                  {
                       cont++;
                       //Tomo el valor de la cantidad del resultado
                      subStr[z]=respuesta[a].substring(0);
                      subStr[z]=subStr[z].substring(21,23);
                      if(subStr[z].substring(1).equals(")"))
                      {
                          num_res[suc]=Integer.parseInt(subStr[z].replace(")", ""));//aqui esta guardado el valor de la cantidad
                      suc++;
                       z++;
                      }
                      else
                      {
                      num_res[suc]=Integer.parseInt(subStr[z]);//aqui esta guardado el valor de la cantidad
                      suc++;
                       z++;}
                  
                  }
                  }
                           }
               
               
             if(respuesta[a].equals("%%LST N7LNK:LSNM=\"WIN_CUB_USAU2\",LTP=LOCAL;%%"))
                {
               a=86;
               }
               else
               {
                   if(a==99 && respuesta[a].equals("---    END"))
                   {
                       continue;}
                   else
                   {
                    if(a==99)
                        a=0;
                   }
               }
                    
                }
                    
               
             
                
                            
               
               //hacer un ciclo para insertar datos
               for(int i=0;i<cont;i++)
               {
         try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
 Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");
Statement st = con.createStatement();


String strSQL="INSERT INTO "+tabla+" (Linkset,SPID,SLC) VALUES ('"+arr1[i]+"','"+subStr1[i]+"','"+num_res[i]+"')";
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
