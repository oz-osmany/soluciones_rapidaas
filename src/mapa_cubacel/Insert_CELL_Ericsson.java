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
public class Insert_CELL_Ericsson {
     @SuppressWarnings("empty-statement")
public static void main(String[] args) {
Socket      s;

   

        String subStr[][]=new String[2000][2000];
        String subStr0[]=new String[2000];
        String subStr1[]=new String[2000];
        String subStr4[]=new String[2000];
            String subStr2[]=new String[2000]; 
            String subStr3[]=new String[2000];
            
            
        int aq=0;    
        PrintStream             p;
        BufferedReader    b;
        int m=0;
        String []host = {"10.50.10.40","10.92.1.14","10.92.17.14"/*,*/};//Cubanacan,Panorama,Villa"10.50.10.40","10.92.17.14",
        String []tabla={"TB_cell_cub","TB_cell_pan","TB_cell_vclara"/**/};//,"TB_cell_vclara""TB_cell_cub",
        int      port = 23;
        String[] respuesta=new String[3000];
             int first=1;//saber que fue la primera vez
        int[] y=new int[3000];
        //Referencia a la entrada por consola (System.in)
        BufferedReader    in = new BufferedReader(new InputStreamReader(System.in));
        String[] arr=new String[3050];
        String[] arr1=new String[3050];
        boolean fr[]={false,false,false,false,false,false,false,false,false,false,false,false,false,false};//para saber si se toman las frecuencias f2, f3.
       // boolean fr1=false;boolean fr2=false;boolean fr3=false;boolean fr4=false;boolean fr5=false;
       // boolean fr6=false;boolean fr7=false;boolean fr8=false;boolean fr9=false;
        int a=25;
        for(int ss=2;ss<3;ss++)
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
                    arr[0]="osmany";
                    arr[1]="Cubacel@123";
                    break;
                case 1:
                    arr[0]="osmany09";
                     arr[1]="Buenfuturo00.";
                    
                    break;
                case 2:
                     arr[0]="osmany";
                    arr[1]="Buenfuturo00.";
                     break;
            }
                arr[2]="";
                arr[3]="mml";
                arr[4]="rxtcp:moty=rxotg;";
                //arr[5]="rxmop:moty=rxotg;";
                arr[5]="rlcfp:cell=all;";
                arr[6]="rldep:cell=all;";
              
             
                
                
                int c=0; //contador de links
                int c1=1;
                int z=0;
                int z1=0;
for(int aa=0;aa<25;aa++) 
            {
                
                p.println(arr[aa]);
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(15);
            }
                    int ch=0;
                    p.println(arr[a]);
                    respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]);
                    ch=respuesta[a].indexOf("CHGR");//para saber donde empieza CHGR y tomar el numero
                    
         do
                   
               {
                a++;
                p.println(arr[a]);
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                Thread.sleep(15);
               
                   
                    if(respuesta[a].isEmpty())
                       {
                        p.println(arr[a]);
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]); 
                        continue;
                       }
                        
                    if(respuesta[a].substring(ch+1, ch+2).contains("0"))
                        
                    {
                        
                                       
                             c=respuesta[a].indexOf("RXOTG-");
                  
                       if(c>=0)
                             {
                                             
                                subStr1[c1]=respuesta[a].substring(6,9);//Tomar el valor del TG
                                subStr1[c1]=subStr1[c1].replaceAll(" ","");

                                subStr0[c1]=respuesta[a].substring(17,25);//Para las celdas
                                subStr0[c1]=subStr0[c1].replaceAll(" ",""); 
                                c1++;
                               }
                       else
                               {
                                    
                                subStr1[c1]=subStr1[c1-1]; 
                                subStr0[c1]=respuesta[a].substring(17,25);//Para las celdas
                                subStr0[c1]=subStr0[c1].replaceAll(" ",""); 
                                
                                
                                c1++;

                               }
                      }
                     
                
               }
               
                  while(!respuesta[a].equals("END"));
               
         
          
                //para tomar las frecuencias.
           for(int aa=0;aa<4;aa++) //Si no utilizamos rxtcp se pone aa<24
          {
                
                p.println(arr[aa]);
                respuesta[aa] = b.readLine();
                System.out.println(respuesta[aa]); 
                Thread.sleep(15);
            }
                
               //c1=1;
                
                int q[]={1,1,1,1,1,1,1,1,1,1,1,1,1};
                
                int c2=1;
                int c3=1;
                int c4=1;
                int c5=1;int c6=1;int c7=1;int c8=1;int c9=1;int c10=1;int c11=1;int c12=1,c13=1;
                int cel=1;
                int cc1=1;
                int cc2=1;
               /* p.println(arr1[a]);                   //tomo la celda   
                respuesta[a] = b.readLine();
                System.out.println(respuesta[a]); 
                if(respuesta[a].contains("CELL"))
                         
                {
                    
                         p.println(arr1[a]);                   //tomo la celda   
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]); 
                         
                         subStr[0][cel]=respuesta[a].substring(0, respuesta[a].length());//para tomar nombre de celda
                         subStr[0][cel]=subStr[0][cel].replaceAll(" ", ""); 
                         cel++;
                         for(int h=0;h<2;h++)//Cuando cambie seguir hasta la informacion
                            {
                                 p.println(arr1[a]);                      
                                 respuesta[a] = b.readLine();
                                 System.out.println(respuesta[a]); 
                                

                            }
                                 
                }*/
                
                
                int bb=respuesta[a].indexOf("TN");
                
                do
                {
                    
                     //p.println(arr1[a]);                      
                     respuesta[a] = b.readLine();
                     System.out.println(respuesta[a]); 
                     
                     
                     if(respuesta[a].contains("CELL"))
                         
                     {
                         cc2=1;
                         //p.println(arr1[a]);                   //tomo la celda   
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]); 
                         subStr[0][cel]=respuesta[a].substring(0,respuesta[a].length());//tomo nombre de la celda
                         subStr[0][cel]=subStr[0][cel].replaceAll(" ", ""); 
                         if(subStr[0][cel].equals("MICROVC"))
                     {
                         
                         int t=0;
                     }
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]); 
                         respuesta[a] = b.readLine();
                         System.out.println(respuesta[a]);
                         
                         
                     //if(respuesta[a].contains("HPY9083")||respuesta[a].contains("HPY9081"))//||respuesta[a].contains("HPY9082")||respuesta[a].contains("BSC9053")
                    if(respuesta[a].contains("CHGR   SCTYPE    SDCCH   SDCCHAC   TN   CBCH     HSN   HOP  DCHNO"))       
                     {
                                 aq=respuesta[a].indexOf("DCHNO");
                                      //p.println(arr1[a]);                      
                                      respuesta[a] = b.readLine();
                                      System.out.println(respuesta[a]); 
                                      if(respuesta[a].contains("OFF      "))
                                      {
                                        //subStr[0][cel]=""; 
                                        continue;
                                      }
                                 
                            }  
                         
                                 
                        cel++;
                       int inc=5;//para incrementar los substring de las frecuencias.
                       int frec=3;//para empezar la 3ra frecuencia e incrementar
                                 for(int i=1;i<13;i++)
                                 {
                                     
                                         if(fr[i]==false && first>1)// si no hubo y no es la primera vez
                                         {
                                             q[i]++;
                                         subStr[i][q[i-1]-1]="No";//para poner las frecuencias en No
                                         //q[i]--;
                                         //inc++;
                                         }
                                         else 
                                         {
                                            fr[i]=false;
                                         //c2++;
                                         }
                                         //frec++;
                                 }
                                  //inc=5;
                            for(int h=0;h<3;h++)//Cuando cambie seguir hasta la informacion
                            {
                                 p.println(arr1[a]);                      
                                 respuesta[a] = b.readLine();
                                 System.out.println(respuesta[a]); 
                                if(respuesta[a].isEmpty())
                                {
                                  h=3;
                                }
                                if(respuesta[a].contains("END"))
                                {
                                  h=3;
                                }
                            }
                      
                     }
                     
                     if(respuesta[a].isEmpty())
                     {
                        continue;
                     }
                     
                      
                     if(respuesta[a].contains("END"))
                     {
                        continue;
                     }
                     if(q[1]==49)
                     {
                     int h=0;
                     }
                     if(respuesta[a].contains("                                   7")||respuesta[a].contains("                                   1"))
                     {
                         int t=respuesta[a].indexOf("7");//saber si la linea tiene una frecuencia
                         if(respuesta[a].substring(t+1, respuesta[a].length()).isEmpty())
                         {
                         continue;//esta vacio
                         
                         }
                         int tt=respuesta[a].indexOf("1");//saber si la linea tiene una frecuencia
                         if(respuesta[a].substring(tt+1, respuesta[a].length()).isEmpty())
                         {
                         continue;//esta vacio
                         
                         }
                                           
                     }    
                     if(respuesta[a].contains("NO        8    OFF"))
                     {
                        int rrr=respuesta[a].indexOf("OFF");
                        if(respuesta[a].substring(rrr+3,respuesta[a].length()).isEmpty())
                        {
                            continue;
                        }
                        
                     }
                     switch(cc2)
                     {
                         
                         case 1:
                                subStr[1][q[1]]=respuesta[a].substring(aq+1, aq+4);//bcch
                                subStr[1][q[1]]=subStr[1][q[1]].replaceAll(" ", "");
                               q[1]++;
                                 cc1++;
                                 cc2++;
                                 fr[1]=true;
                                break;
                         case 2:
                                
                                m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }
                                else
                                {
                                subStr[2][q[2]]=respuesta[a].substring(aq+1, aq+4);//f1
                                subStr[2][q[2]]=subStr[2][q[2]].replaceAll(" ", "");
                                q[2]++;
                                cc1++;
                                cc2++;
                                fr[2]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                         case 3:
                             
                                m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }
                                else{
                                subStr[3][q[3]]=respuesta[a].substring(aq+1, aq+4);//f2
                                subStr[3][q[3]]=subStr[3][q[3]].replaceAll(" ", "");
                                q[3]++;
                                cc1++;
                                cc2++;
                                fr[3]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                         case 4:
                            
                                m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }
                                else{
                                subStr[4][q[4]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[4][q[4]]=subStr[4][q[4]].replaceAll(" ", "");
                                q[4]++;
                                cc1++;
                                cc2++;
                                fr[4]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 5:
                              
                                m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[5][q[5]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[5][q[5]]=subStr[5][q[5]].replaceAll(" ", "");
                                q[5]++;
                                cc1++;
                                cc2++;
                                fr[5]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 6:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[6][q[6]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[6][q[6]]=subStr[6][q[6]].replaceAll(" ", "");
                                q[6]++;
                                cc1++;
                                cc2++;
                                fr[6]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 7:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[7][q[7]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[7][q[7]]=subStr[7][q[7]].replaceAll(" ", "");
                                q[7]++;
                                cc1++;
                                cc2++;
                                fr[7]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 8:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[8][q[8]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[8][q[8]]=subStr[8][q[8]].replaceAll(" ", "");
                                q[8]++;
                                cc1++;
                                cc2++;
                                fr[8]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 9:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[9][q[9]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[9][q[9]]=subStr[9][q[9]].replaceAll(" ", "");
                                q[9]++;
                                cc1++;
                                cc2++;
                                fr[9]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 10:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[10][q[10]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[10][q[10]]=subStr[10][q[10]].replaceAll(" ", "");
                                q[10]++;
                                cc1++;
                                cc2++;
                                fr[10]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 11:
                              m=respuesta[a].length();
                                if(m<64)
                                {
                                int yl=0;
                                }else{
                                subStr[11][q[11]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[11][q[11]]=subStr[11][q[11]].replaceAll(" ", "");
                                q[12]++;
                                cc1++;
                                cc2++;
                                fr[11]=true;
                                first=2;//no es la primera vez
                                }
                                break;
                          case 12:
                                subStr[12][q[12]]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[12][q[12]]=subStr[12][q[12]].replaceAll(" ", "");
                                q[12]++;
                                cc1++;
                                cc2++;
                                fr[12]=true;
                                first=2;//no es la primera vez
                                break;  
                        case 13:
                                subStr[13][c13]=respuesta[a].substring(aq+1, aq+4);//f3
                                subStr[13][c13]=subStr[13][c13].replaceAll(" ", "");
                                c13++;
                                cc1++;
                                cc2++;
                                fr[13]=true;
                                first=2;//no es la primera vez
                                break;     
                     }
                     
                     if(cc2>=123)
                     cc2=1;
                }
                while(!respuesta[a].equals("END"));
                
               /* for(int u=0;u<333;u++)
                {
                   System.out.println(subStr[0][u]);
                }
                int tt=0;*/
                //Para tomar cgi
                for(int h=0;h<5;h++)
                {
                
                    p.println(arr1[a]);                   
                    respuesta[a] = b.readLine();
                    System.out.println(respuesta[a]); 
                }
                
                int t=1; 
                do
                {
                   
                 if(respuesta[a].contains("CELL     CGI"))
                    {   
                        p.println(arr1[a]);                  
                        respuesta[a] = b.readLine();
                        System.out.println(respuesta[a]);
                     
                        subStr[13][t]=respuesta[a].substring(9, 23); //tomo el cgi
                        subStr[13][t]=subStr[13][t].replaceAll(" ", "");
                        subStr[14][t]=respuesta[a].substring(0, 8); //tomo el celda
                        subStr[14][t]=subStr[14][t].replaceAll(" ", "");
                        t++;
                        for(int dd=0;dd<8;dd++)
                        {
                          p.println(arr1[a]);                   
                          respuesta[a] = b.readLine();
                          System.out.println(respuesta[a]);  
                            if(respuesta[a].contains("END"))
                            {
                               
                                dd=8;

                            }
                        }
                    
                
                    }
                
                }
                while(!respuesta[a].equals("END"));             
                for(int i=1;i<c1;i++)//para ordenar los subtr y ponerlos todos iguales en la iteracion
                {
                    for(int e=1;e<cel;e++)
                    {
                        if(i==323)
                        {
                        int fff=0;
                        }
                      if(subStr0[i].equals(subStr[0][e]))
                       {
                           subStr2[i]=subStr0[i];//
                           subStr3[i]=subStr1[i];
                           e=cel;
                       }
                      
                      
                    }
                    
                
                }
                for(int i=1;i<c1;i++)//para ordenar los subtr y ponerlos todos iguales en la iteracion
                {
                    for(int e=1;e<cel;e++)
                    {
                        if(subStr0[i].equals(subStr[14][e]))
                      {
                        subStr4[i]=subStr[13][e];e=cel;
                      }
                        
                        
                    }
                   
                }
      int ii=0;
               
               
               
             //{
                
           try{
               
               //cell='"+subStr[i]+"',tg='"+ subStr1[i] +"'rsite='"+subStr2[i]+"',
               
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();
String strSQL="delete from "+tabla[ss]+" ";
boolean rs = st.execute(strSQL);
st.close(); 
//String strSQL="update "+tabla[ss]+" set cgi='"+subStr[13][i]+"',bcch='"+subStr[1][i]+"',f1='"+subStr[2][i]+"',f2='"+subStr[3][i]+"',f3='"+subStr[4][i]+"',f4='"+subStr[5][i]+"',f5='"+subStr[6][i]+"',f6='"+subStr[7][i]+"',f7='"+subStr[8][i]+"',f8='"+subStr[9][i]+"',f9='"+subStr[10][i]+"',f10='"+subStr[11][i]+"',f11='"+subStr[12][i]+"' where cell='"+subStr[0][i]+"' ";
for(int i=1;i<c1;i++)
{
Statement stt = con.createStatement();
String strSQL1="INSERT INTO "+tabla[ss]+" (id,cell,tg,cgi,bcch,f1,f2,f3,f4,f5,f6,f7,f8,f9,f10,f11,f12,f13,med) VALUES ('"+i+"','"+ subStr2[i] +"','"+ subStr3[i] +"','"+subStr4[i]+"','"+subStr[1][i]+"','"+subStr[2][i]+"','"+subStr[3][i]+"','"+subStr[4][i]+"','"+subStr[5][i]+"','"+subStr[6][i]+"','"+subStr[7][i]+"','"+subStr[8][i]+"','"+subStr[9][i]+"','"+subStr[10][i]+"','"+subStr[11][i]+"','"+subStr[12][i]+"','"+subStr[12][i]+"','"+subStr[12][i]+"','ddd') ";
                    int rs1 = stt.executeUpdate(strSQL1); 
                    stt.close();
}       
//id_bsc=2 es para panorama
              
//rs.close();
   
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
             
                
            // }      
              
               
               
             
               
              
               
               
               
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
        Logger.getLogger(Insert_CELL_Ericsson.class.getName()).log(Level.SEVERE, null, ex);
    }
       
        
        } 
     } 
}
