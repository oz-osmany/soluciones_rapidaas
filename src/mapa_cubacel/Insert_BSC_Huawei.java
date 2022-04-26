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
 * @author heidy.capote
 */
public class Insert_BSC_Huawei {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) throws InterruptedException {
Socket      s=null;
   
        String subStr2[]=new String[1800];
        String subStr1[]=new String[1800];
        String subStr[]=new String[1800];
        String subStr3[]=new String[1800];
        String subStr4[]=new String[1800];
        String num_resul[]=new String[100];
        String linea=null;
        PrintStream   p=null;
        BufferedReader b=null;
        String tabla="tb_cell_cam";
        int [] id_bsc={10,11,8,7};
        String[]  host = {"100.9.17.110","100.9.3.120","100.9.81.6","100.9.17.17"};//Camaguey,holguin,jaguey1,zte
        int []     port = {6000,6000,6000,2121};
        String[] respuesta=new String[2000];
       String q,w,e; 
        int []invento= new int[1000];//Nombre de BTS
        int cell=1;
        int a=0;//tipo de bts
        String total1=null;
        int[] datos=new int[300];
        int[] y=new int[300];
        int h=0;
        int hh=0;
        int hh1=0;
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[250];
        String[] arr1=new String[250];
        byte[] buffer = new byte[1024]; 
        int[] num_res= new int[20];
        int[] cont=new int[800];
        int suc=0;
        
 try {
        for(int ss=0;ss<1;ss++)
        {
            //Creo una conexion al socket servidor
            s = new Socket(host[ss],port[ss]);   

            //Creo las referencias al canal de escritura y lectura del socket
            p = new PrintStream(s.getOutputStream());
            b = new BufferedReader ( new InputStreamReader ( s.getInputStream()) );
               
               int pos=0;
               int z=0;
               int j=0;
              switch(ss)
            {
                case 0:
                    arr[0]=new String("LGI :op=\"mapared\",pwd=\"123mapared\";");//Camaguey
                    arr[1]=new String("LST GCELL:IDTYPE=BYNAME;");
                    
                    
                    break;
                case 1:
                    arr[0]=new String("LGI :op=\"nelsonb\",pwd=\"123mapared\";");//Holguin
                    arr[1]=new String("LST GCELL:IDTYPE=BYNAME;");
                    
                    break;
                case 2:
                    arr[0]=new String("LGI :op=\"mapared\",pwd=\"123Mapared\";");//Jaguey
                    arr[1]=new String("LST GCELL:IDTYPE=BYNAME;");
                     break;
                case 3:
                    arr[0]=new String(" cgn");//ZTE  mapared cgn
                    arr[1]=new String("cgn2011*");
                    arr[2]=new String("SHW IBTSFUNC;");//'SHW IBTSFUNC;getcpuratio
                     break;
            }
              for(int c=0;c<3;c++)
               {
                p.println(arr[c]);                      
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                Thread.sleep(5);
               }
               for(int c=3;c<37;c++)
               {
               //p.println(arr[c]);
                      
                respuesta[c] = b.readLine();
                System.out.println(respuesta[c]); 
                //Thread.sleep(5);
               }
             
      //AHora para las celdas
            do
              {
                  linea=b.readLine();
                  System.out.println(linea);
                  if(linea.contains("BTS Name"))
                  {
                  a=linea.indexOf("BTS Name");
                  h=linea.indexOf("Cell LAC");
                  hh=linea.indexOf("Cell CI");
                  hh1=linea.indexOf("MCC");
                  
                  continue;
                  }
                 // 
                  
                  if(linea.isEmpty())
                  {
                    continue;
                  }
                  if(linea.contains("(Number of results"))
                  {
                    continue;
                  }
                  if(linea.contains("To be continued"))
                  {
                    continue;
                  }
                  if(linea.contains("Prompt information"))
                  {
                      for(int i=0;i<2;i++)
                      {
                        linea=b.readLine();
                        System.out.println(linea);
                      }
                    continue;
                  }
                  

                  if(linea.contains("---    END"))
                  {
                      for(int i=0;i<10;i++)
                      {
                        linea=b.readLine();
                        System.out.println(linea);
                      }
                    continue;
                  }
                  int u=linea.indexOf(" Unlock");//PARA TOMAR BTS SIN LLEGAR AL UNLOCK 
                  subStr2[cell]=linea.substring(a,u);//Tomo el nombre de la BTS
                 invento[cell]=id_bsc[ss];
                  if(subStr2[cell].contains("CMG ")||subStr2[cell].contains("GTM ")||subStr2[cell].contains("HLG ")||subStr2[cell].contains("MG ")||subStr2[cell].contains("GRM ")||subStr2[cell].contains("RM ")||subStr2[cell].contains("TU ")
                  ||subStr2[cell].contains("LTU ")||subStr2[cell].contains("CAV ")||subStr2[cell].contains("CU ")||subStr2[cell].contains("GTM ")||subStr2[cell].contains("HLG ")||subStr2[cell].contains("LG ")||subStr2[cell].contains("SCU "))
                  {
                  subStr2[cell]=subStr2[cell].replaceAll("CMG ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("MG ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("GRM ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("RM ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("TU ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("LTU ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("CAV ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("HLG ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("GTM ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("CU ", "");
                  subStr2[cell]=subStr2[cell].replaceAll("SCU", "");
                  subStr2[cell]=subStr2[cell].replaceAll("LG ", "");
                  
                   
                  }
                  subStr3[cell]=linea.substring(12,23);//Tomo la celda
                  subStr3[cell]=subStr3[cell].replaceAll(" ", "");
                  subStr2[cell]=subStr2[cell].replaceAll(" ", "");
                  
                  subStr4[cell]=linea.substring(hh1,hh1+3);
                  subStr4[cell]=subStr4[cell].concat("-").concat(linea.substring(hh1+5, hh1+7)).concat("-").concat(linea.substring(h+7, linea.indexOf(")")).concat("-").concat(linea.substring(hh+7, hh+10)));
                  
                 //subStr4[cell]=subStr4[cell].replaceAll(" ", "");
                  cell++;
                  //tip_b++;
                  
                  
              
              
              }
               while(!linea.contains("Total number"));
               
              //if(linea.contains("Total number of all results = 42"))
              //{
              int tt=linea.indexOf("= ");
              
               total1=linea.substring(tt+2,linea.length());//Tomo la cantidad de ocurrencia
               total1=total1.replaceAll(" ", "");
               suc=suc+Integer.parseInt(total1);
              }
               
               
               
               
               
               
               //Integer.parseInt(total1)
               
               //hacer un ciclo para insertar datos
               for(int i=1;i<suc;i++)
               {
         try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();


String strSQL="INSERT INTO "+tabla+" (rsite,cell,cgi,id_bsc) VALUES ('"+subStr2[i]+"','"+subStr3[i]+"','"+subStr4[i]+"','"+invento[i]+"')";
              

 //String strSQL="update "+tabla+" set rsite='"+subStr1[i]+"',tg='"+subStr2[i]+"',dip='"+subStr3[i]+"',dev='"+subStr4[i]+"'";     
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
    