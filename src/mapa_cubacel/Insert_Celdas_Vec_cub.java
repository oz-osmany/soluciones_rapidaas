package mapa_cubacel;


import java.beans.Statement;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author osmany.machado
 */
public class Insert_Celdas_Vec_cub {
 @SuppressWarnings("empty-statement")
public static void main(String[] args) throws InterruptedException {
Socket      s;

   

        String subStr2[]=new String[6000];
        String subStr1[]=new String[6000];
        String subStr[]=new String[6000];
        String ext[]=new String[100];
        
        PrintStream             p;
        BufferedReader    b;

         String []host = {"10.92.1.14","10.92.17.14"};//Cubanacan,Villa,Panorama "10.50.10.40","10.92.17.14"
        String []tabla={"TB_celdas_vecinas_5","TB_celdas_vecinas_9"};//"TB_celdas_vecinas_6","TB_celdas_vecinas_9",
        int      port = 23;
        String[] respuesta=new String[6000];
       String q,w,e; 
        int[] datos=new int[300];
        int[] y=new int[300];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[6050];
        byte[] buffer = new byte[1024]; 
        int[] cont=new int[50];
        int a=24;
        for(int ss=0;ss<1;ss++)
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
                    arr[0]="osmany09";
                    arr[1]="Buenfuturo00.";
                    break;
                case 1:
                    arr[0]="osmany";
                     arr[1]="Buenfuturo00.";
                    
                    break;
                case 2:
                     arr[0]="osmany09";
                    arr[1]="Buenfuturo00.";
                     break;
            }
                
                arr[2]="";
                arr[3]="mml";
                arr[4]="rlnrp:cell=all,nodata;";
                arr[5]="";
               
             
                
                int m1=0;
                int c=0; //contador de links
                int c1=0;
                int z=0;
                int z1=0;
                for(int aa=0;aa<25;aa++)
                    {
                
                      p.println(arr[aa]);
                      respuesta[aa] = b.readLine();
                      System.out.println(respuesta[aa]); 
                      Thread.sleep(5);
                    }        
 
                    
      
      //subStr[c1]=subStr[c1].replaceAll(" ","");
      //saber si llego al final
       
                 do //pregunta si hubo cambio de celda
                               
                     {//hubo cambio de celda
                            p.println(arr[a]);
                             respuesta[a] = b.readLine();
                             System.out.println(respuesta[a]); 
                       //tomar nombre de la celda
                            subStr[c1]=respuesta[a].substring(0,respuesta[a].length());
                             subStr[c1]=subStr[c1].replaceAll(" ","");    
                              for(int gg=0;gg<2;gg++)
                        {
                             p.println(arr[a]);
                             respuesta[a] = b.readLine();
                             System.out.println(respuesta[a]);
                         }
                  do
                            {   //saltar una linea 
                      
                             p.println(arr[a]);
                             respuesta[a] = b.readLine();
                             System.out.println(respuesta[a]);
                      //saltar dos lineas
                    
                   
                                                         if(respuesta[a].equals("NONE")) //Para las celdas desactivadas
                                                            {
                                                               for(int h=0;h<2;h++) 
                                                               {p.println(arr[a]);
                                                                respuesta[a] = b.readLine();
                                                                System.out.println(respuesta[a]);
                                                               }
                                                            }
                                                                 else
                                                                  {
                                 
                                                                    
                                 
                                                                  //tomo valor de la vecina 
                                                                      subStr1[c1]=respuesta[a].substring(0,10);
                                                                      subStr1[c1]=subStr1[c1].replaceAll(" ","");
                                                                      //saber si es interno o no
                                                                      subStr2[c1]=respuesta[a].substring(10,16);
                                                                      subStr2[c1]=subStr2[c1].replaceAll(" ","");
                                                                      c1++;
                                                                       subStr[c1]=subStr[c1-1];
                                                                      
                                                                      p.println(arr[a]);
                                                                respuesta[a] = b.readLine();
                                                                System.out.println(respuesta[a]);
                                                                if(respuesta[a].equals("END"))
                                                                 {
                                                                   break;
                                                                     
                                                                 }

                                                                p.println(arr[a]);
                                                                respuesta[a] = b.readLine();
                                                                System.out.println(respuesta[a]);
                                                                    }
                               }
                     
                        while(!respuesta[a].equals("CELL"));
                   
      
        }                   
                    
            while(!respuesta[a].equals("END"));
            respuesta[a] = b.readLine();
            System.out.println(respuesta[a]);
            p.println(arr[a]);
                
              
                
           try{
               
               //cell='"+subStr[i]+"',tg='"+ subStr1[i] +"'rsite='"+subStr2[i]+"',
               
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

java.sql.Statement st = con.createStatement();
String strSQL="delete from "+tabla[ss]+" ";
boolean rs = st.execute(strSQL);
st.close(); 
//String strSQL="update "+tabla[ss]+" set cgi='"+subStr[13][i]+"',bcch='"+subStr[1][i]+"',f1='"+subStr[2][i]+"',f2='"+subStr[3][i]+"',f3='"+subStr[4][i]+"',f4='"+subStr[5][i]+"',f5='"+subStr[6][i]+"',f6='"+subStr[7][i]+"',f7='"+subStr[8][i]+"',f8='"+subStr[9][i]+"',f9='"+subStr[10][i]+"',f10='"+subStr[11][i]+"',f11='"+subStr[12][i]+"' where cell='"+subStr[0][i]+"' ";
for(int i=1;i<c1;i++)
{
java.sql.Statement stt = con.createStatement();
String strSQL1="INSERT INTO "+tabla[ss]+" (cell,vecinas,dir,id_bsc) VALUES ('"+ subStr[i] +"','"+ subStr1[i] +"','"+ subStr2[i] +"',6)";
                    int rs1 = stt.executeUpdate(strSQL1); 
                    stt.close();
}       
//id_bsc=2 es para panorama
              
//rs1.close();
   
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
             
                
                   
            
            p.close();
            b.close();  
            s.close();
           
                

        } catch (UnknownHostException r) {
            System.out.println("No puedo conectarme a " + host + ":" + port);
        } catch (IOException r) {
            System.out.println("Error de E/S en " + host + ":" + port);
        }
       
        
    } 
 }
}










