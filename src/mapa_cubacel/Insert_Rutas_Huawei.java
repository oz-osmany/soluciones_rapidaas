package mapa_cubacel;


//import java.beans.Statement;
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
 * @author heidy.capote
 */
public class Insert_Rutas_Huawei{

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
Socket      s;
   
        String subStr2[]=new String[2800];
        String subStr1[]=new String[2800];
        String subStr[]=new String[2800];
        String subStr3[]=new String[2900];
        String subStr4[]=new String[2800];
        String num_resul[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

        String  [] host = {"10.90.17.126","10.90.1.126","10.90.81.3"};// camaguey, habana,Jaguey
        String []tabla={"tb_rutas_msfcam","tb_rutas_msfhab","tb_rutas_msfjaguey"};
        int      port = 6000;
        String[] respuesta=new String[1000];
        String q,w,e; 
        int[] datos=new int[300];
        int[] y=new int[300];
        int total=0;
       int a=16;
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[1550];
        String[] arr1=new String[1550];
        byte[] buffer = new byte[1024]; 
        int[] num_res= new int[20];
        int[] cont=new int[1800];
        int suc=0;
        for(int ss=2;ss<3;ss++)
        {
        try {

            //Creo una conexion al socket servidor
            s = new Socket(host[ss],port);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
            
            switch(ss)
            {//9061mgw
                case 2:
                    arr[0]="LGI :op=\"admin\",pwd=\"lem\";";
                    arr[1]="use me:meid=5;";
                    arr[2]="LST OFCTKC: CDT=OFCCIC, QR=LOCAL;"; // sacar todos los link set , despues los links
                    break;
                case 1:
                   arr[0]="LGI :op=\"machado\",pwd=\"Buenfuturo30/\";";
                   arr[1]="LST OFCTKC: CDT=OFCCIC, QR=LOCAL;";
                   //arr[2]="LST OFCTKC: CDT=OFCCIC, QR=LOCAL;";
                   
                   //arr[2]="";
                    
                    break;
                case 0:
                     arr[0]="LGI :op=\"machado\",pwd=\"Buenfuturo30/\";";
                     arr[1]="LST OFCTKC: CDT=OFCCIC, QR=LOCAL;";
                     break;
            }
            
            
                
               int pos=0;
               int pos1=0;
               int pos2=0;
               int pos3=0;
               
               int z=0;
               int j=0;
               
               int cont1=0;
               int cont2=0;
               int cont3=0;
               int cont4=0;
               int cont5=0;
               int cont6=0;
               int l=0;
               
                        
              
             for(int c=0;c<2;c++)
               {
                p.println(arr[c]);                     
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                Thread.sleep(10);
               }
           
               for(int c=0;c<10;c++)//c<12 para Habana
               {
               
                     
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                Thread.sleep(10);
               } //p.println(arr[2]);
              
              for(int c=2;c<9;c++) //11 para habana 5 para jaguey
              {
               p.println(arr[c]);
             respuesta[c] = b.readLine();
              
              System.out.println(respuesta[c]);
              
              }
               
               do
                 {
                 a++;
                 respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                if((respuesta[a].isEmpty())) //salto de linea
                        {
                           continue;
                 
                         }  
                    else
                         {
                             subStr[z]=respuesta[a].substring(0);
                        subStr[z]=subStr[z].substring(0,subStr[z].length());
                       if(pos<1)
                       {
                        
                        pos=subStr[z].indexOf("Start CIC");
                        pos1=subStr[z].indexOf("End CIC");
                        if(ss>1)
                        {
                         pos2=subStr[z].indexOf("Start Circuit Termination ID");//Start TID Start Circuit Termination ID   Start TID
                         pos3=subStr[z].indexOf("End Circuit Termination ID");//End Circuit Termination ID   End TID
                        }
                        else
                        {
                         pos2=subStr[z].indexOf("Start TID");//Start TID Start Circuit Termination ID   Start TID
                         pos3=subStr[z].indexOf("End TID");
                        
                        }
                       
                        continue;
                       }
                        /*if(respuesta[a].equals("3 reports in total") )
                        {
                             continue;
                         }*/
                   
                         if(subStr[z].startsWith("(Number") )//Para saber que se termino
                             {
                                 continue;
                             }
                  
                  
                   else 
                        {
                           
                                      
                                              if(respuesta[a].startsWith("To be continued"))
                                               {
                                                  for(int i=0;i<12;i++)
                                                  {p.println(arr[a]);
                                                    respuesta[a] = b.readLine();
                                                     System.out.println(respuesta[a]);    }
                                                  
                                                  }
                                              
                                              
                                              else
                                              {
                                             
                                              subStr4[z]=respuesta[a].substring(pos3,pos3+4);//TID end
                                              subStr4[z]=subStr4[z].replaceAll(" ", "");
                                              subStr3[z]=respuesta[a].substring(pos2,pos2+4);//TID start
                                             subStr3[z]=subStr3[z].replaceAll(" ", "");
                                              subStr1[z]=respuesta[a].substring(1,16); //Trunk group
                                              subStr1[z]=subStr1[z].replaceAll(" ", "");
                                              //cont[z]++;
                                              subStr2[z]=respuesta[a].substring(pos1,pos1+4);//CIC start
                                              subStr2[z]=subStr2[z].replaceAll(" ", "");
                                              z++;
                                              }
                                   
                                        }
                          }
                 
                 }
               while (!respuesta[a].contains("(Number of results"));//(Number of results = 72
               
             /*  int num_r=0; //para tener el numero de los resultados
            for(int a=1;a<=99;a++)//necesito saber la cantidad de linkset ??
            {
                
                //Ingreso un String por consola 
              // System.out.print("Mensaje a enviar: ");

                //Escribo en el canal de escritura del socket
                p.println(arr[a]);
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                
                if ( a>=11)
                {
                   // subStr[a]=respuesta[a].replaceAll(" ", "");
                     if((respuesta[a].isEmpty())) //salto de linea
                        {
                           continue;
                 
                         }  
             else
                {
                    
                  subStr[z]=respuesta[a].substring(0);
                  subStr[z]=subStr[z].substring(0,subStr[z].length());
                  if(respuesta[a].equals("3 reports in total") )
                {
                     continue; 
                  }
                   
                            if(subStr[z].startsWith("(Number") )//Para saber que se termino
                             {
                                 continue;
                            }
                  
                   if(respuesta[a].equals("---    END") )
                {
                    total=a-2;    
                    a=99;
                continue;
                }
                  
                   else 
                        {
                           //z++; 
                            if(a==99)
                                {a=0;}
                                    else
                                        {
                                              if(respuesta[a].startsWith("To be continued"))
                                               {
                                                  for(int i=0;i<12;i++)
                                                  {p.println(arr[a]);
                                                    respuesta[a] = b.readLine();
                                                     System.out.println(respuesta[a]);    }
                                                  
                                                  }
                                              
                                              
                                              else
                                              {
                                             
                                              subStr4[z]=respuesta[a].substring(145,149);//TID end
                                              subStr4[z]=subStr4[z].replaceAll(" ", "");
                                              subStr3[z]=respuesta[a].substring(115,119);//TID start
                                             subStr3[z]=subStr3[z].replaceAll(" ", "");
                                              subStr1[z]=respuesta[a].substring(1,16); //Trunk group
                                              subStr1[z]=subStr1[z].replaceAll(" ", "");
                                              //cont[z]++;
                                              subStr2[z]=respuesta[a].substring(95,99);//CIC start
                                              subStr2[z]=subStr2[z].replaceAll(" ", "");
                                              z++;
                                              }
                                    } 
                                        }
                          }
                }
         }*/
                          
               
        
               
               //Para saber cuantos linkset hay
                        
    /*    for(int ch=0;ch<201;ch++)   //Recortar el String y llenar el arreglo
        {
            subStr1[ch]=subStr[ch].substring(1,15);
            }
                for(int hc=210;hc<z+1;hc++)//z es la cantidad de rutas
                {
                   
                    subStr1[hc-11]=subStr[hc].substring(1,15);
                    
                }
     
  //Para saber cuantos linkset hay
for(int x=0;x<179;x++)
   {
   /* if(subStr1[x].equals(null))
    {
    x=397;
    continue;
    }
        
      if(subStr1[x].equals(subStr1[x+1]))  //saber si son iguales en el arreglo
         {
            cont[cont1]=cont[cont1]+1;
         }
      else
      {
          //subStr2[cont1]=subStr1[x];
          cont1++;
          subStr1[x+1]=subStr1[x+2];
          
      }
          
}           */        
  
              
              /* num_resul[z]=respuesta[39].substring(0);
               num_resul[z]=num_resul[z].substring(21,23);
               num_r=Integer.parseInt(num_resul[z]);*/
               
        
               
               //hacer un ciclo para insertar datos
               for(int i=1;i<z;i++)
               {
         try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();


String strSQL="INSERT INTO "+tabla[ss]+" (ruta,cic,tid_star,tid_end,id_soft) VALUES ('"+subStr1[i]+"','"+subStr2[i]+"','"+subStr3[i]+"','"+subStr4[i]+"','"+ss+"')";
              

// String strSQL="update "+tabla+" set ruta='"+subStr1[i]+"',cic='"+subStr2[i]+"',tid_star='"+subStr3[i]+"',tid_end='"+subStr4[i]+"',id_soft=1";     
    boolean rs = st.execute(strSQL); 
              
//while (rs.next())   
//{}
              
              
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
