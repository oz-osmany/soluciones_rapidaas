/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import com.sun.org.apache.xpath.internal.operations.Equals;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.text.Document;
 
/**
 *
 * @author osmany.machado
 */
public class OrdenTrabajo {

     public static void main(String[] args)
     {
        
         File archivo=null;
         File file;
         FileReader fr=null;
         BufferedReader br=null;
         String num_ot[]=new String[9000];
         String desde[]=new String[9000];
         String hasta[]=new String[9000];
         String fj[]=new String[9000];
         String recorrido[]=new String[9000];
         String fecha[]=new String[9000];
         String asunto[]=new String[9000];
         String gg,yy = null;
         String hh;
         int aa=0;
         ObjectInputStream entrada;
         archivo=new File("\\\\10.50.103.62\\OTrabajo\\prueba\\");
         int dev=0;
         int f=1;int asunt = 1;
         int desd = 1;int hast=1;
         int ot=1; 
         int rec=1;
         int ind=0;
         int inc=0;
         int fech=1;
         int ctrol=0;
         
         
         String [] arreglo=archivo.list();
         int num=arreglo.length;
         
     try{
        
         
         
         
         String linea;
         
       for(int i=1;i<num;i++)
       {
            file=new File("\\\\10.50.103.62\\OTrabajo\\prueba\\"+arreglo[i]+" ");
            fr=new FileReader(file);
             br=new BufferedReader(fr);
             yy=null;
             ind++;
             hh=null;
             //para saber cuales no tienen DESDE T HASTA
             inc=0;             
         do
         {
             
             
             
                 
             
         
            linea=br.readLine();
            System.out.println(linea);
            
           
            
            if(linea.contains("ORDEN DE TRABAJO:")||linea.contains("Orden de Trabajo:"))
            {
                int r=linea.indexOf("TRABAJO");//tomo la posicion de donde termina el texto
                
                if(r<0)//Es con minuscula
                {
                    int rr=linea.indexOf("Trabajo");
                    num_ot[ot]=linea.substring(rr+9, rr+18);//Tengo el numero de la OT
                    
                    ot++; 
                }
                else
                {
                    num_ot[ot]=linea.substring(r+9, r+18);//Tengo el numero de la OT
                    ot++;
                }
            }
            
          if(linea.contains("Fecha y hora de Ejecución") ||linea.contains("Desde la fecha" ))
              
          {
              
              int ht=0;
              
             if(linea.contains("Fecha y hora de Ejecución"))
             {
                linea=br.readLine();
                System.out.println(linea);
             
             }
              
              
            
            
            
            if(linea.contains("/"))
            {
            ht=linea.indexOf("/");
            
            }
            
            if(linea.contains("-"))
            {
            ht=linea.indexOf("-");
            
            }
                if(linea.contains("NO ES"))
                {
                
                fecha[fech]=linea.substring(0, linea.length());
                fecha[fech]=fecha[fech].replaceAll(" ", "");
                fech++;
                continue;
                }
            if(ht==1)
            {
                fecha[fech]=linea.substring(ht-1, ht+8);
                fecha[fech]=fecha[fech].replaceAll(" ", "");
                fech++;
            }
            else
            {
                
                     fecha[fech]=linea.substring(ht-2, ht+8);
                     fecha[fech]=fecha[fech].replaceAll(" ", "");
                     fech++;
                    
            
            }
            
            
            
            
                
                
                
                
            
          
          }
              
              
            if(linea.contains("Asunto"))
            {
                /*/if(linea.contains("ASIGNACIÓN DE UN  SERVICIO  ETHERNET  PARA"))
                    {
                    
                    i++;
                    }*/
                int h=0;
                asunto[asunt]=linea;
                h=linea.indexOf("Asunto");
                if(asunto[asunt].isEmpty())
                {
                    
                    linea=br.readLine();
                    System.out.println(linea);
                    
                    
                    asunto[asunt]=linea.substring(h+7, linea.length());
                    
                    asunt++;
                }
                else
                {
                asunto[asunt]=linea.substring(h+7, linea.length());//Tengo el asunto de la OT
                 asunt++; 
                }
            }
            if(linea.contains("ING.")||linea.contains("ESP.")||linea.contains("EST. DTORA")||linea.contains("ESTACION DIRECTORA")||linea.contains("ESTACIÓN DIRECTORA"))
            {
                if(hh==null)
                    {
                        continue;

                    }
                
                
            linea="Observaciones:";
         
            }
            if(linea.contains("DESDE:"))
            {   yy=linea.substring(0,5);
                int tt=0;
                
                int ii=0;
                tt=linea.indexOf("   ");
                ii=linea.indexOf("DESDE");
                if(tt<0)
                {
                    desde[desd]=linea.substring(ii+7, linea.length());
                    //desde[desd]=desde[desd].replaceAll(" ", "");
                    desd++;
                    
                }
                else
                {
                    desde[desd]=linea.substring(ii+7, tt);
                    //desde[desd]=desde[desd].replaceAll(" ", "");
                    
                    desd++;
                }
                
            }
            if(linea.contains("HASTA:"))
            {
                if(linea.contains("DESCRIPCIÓN")|| linea.contains("Asunto"))
                {
                
                      continue;  

                }
                ctrol++;
                int tt=0;
                int ii=0;
                tt=linea.indexOf("                                                                                 ");
                ii=linea.indexOf("HASTA");
                if(tt<0)
                {
                    hasta[hast]=linea.substring(ii+7, linea.length());
                   
                    hasta[hast]=hasta[hast].replaceAll("BTS", "");
                  
                    
                    hast++;
                
                }
                else
                {
                    hasta[hast]=linea.substring(ii+7, tt);
                    hast++;
                }
                
            }
            if(linea.contains("FJ-")|| linea.contains("fj-")|| linea.contains("FJ "))//Obtengo el FJ
                
            {
                
                
                if(linea.contains("DESCRIPCIÓN")|| linea.contains("Asunto")|| linea.contains("CAMBIO")|| linea.contains("Asunto")|| linea.contains("Descripción"))
                {
                      continue;  

                }
                    else
                    {
                        int ii=0;
                        int tt=0;
                        ii=linea.indexOf("   ");
                        tt=linea.indexOf("FJ");
                        
                        inc++;
                        hh=linea.substring(0,linea.length());
                            if(ind==0)//saber si no cambio de OT
                            {
                                fecha[fech]=fecha[fech-1];  
                                num_ot[ot]=num_ot[ot-1];//
                                asunto[asunt]=asunto[asunt-1];//dentro de la misma pagina 
                                if(yy==null)//saber si hubo desde y hasta
                                    {
                                        desde[desd]="";// no hubo
                                        hasta[hast]="";
                                        desd++;
                                        hast++;
                                        
                                    }
                                else
                                    {
                                        desde[desd]=desde[desd-1];//si hubo
                                        hasta[hast]=hasta[hast-1];//recojo el anterior
                                        //desd++;
                                        //hast++;
                                    }
                                asunt++;
                                ot++;
                                fech++;
                                ind=0;
                                if(ii<0) //Para determinar la posiocion en que se encuentra el fj
                                    {
                                        fj[f]=linea.substring(tt, linea.length());//-1
                                        if(fj[f].contains("FJ "))
                                        fj[f]=fj[f].replaceAll(" ", "-");
                                        fj[f]=fj[f].replaceAll(" ", "");
                                        if(fj[f].equals(fj[f-1]))//saber si tienen el mismo fj
                                        {
                                           fj[f]=fj[f-1];
                                        
                                        }  
                                        f++;

                                    }
                                    else
                                    {
                                        fj[f]=linea.substring(tt,ii);
                                        if(fj[f].contains("FJ "))
                                        fj[f]=fj[f].replaceAll(" ", "-");
                                        if(fj[f].equals(fj[f-1]))//saber si tienen el mismo fj
                                        {
                                           fj[f]=fj[f-1];
                                        
                                        } 
                                        f++;

                                    }
                                
                            }
                            else
                            {
                                     //num_ot[ot-1]=num_ot[ot-1];//Entro por primera vez
                                    // asunto[asunt-1]=asunto[asunt-1];
                                     //fecha[fech-1]=fecha[fech-1];
                                     if(yy==null)//saber si hubo desde y hasta
                                    {
                                        desde[desd]="";// no hubo
                                        hasta[hast]="";
                                        desd++;
                                        hast++;
                                        
                                    }
                                    else
                                        {
                                            desde[desd-1]=desde[desd-1];//si hubo
                                            hasta[hast-1]=hasta[hast-1];//recojo el anterior
                                            
                                        }
                  if(ii<0) //Para determinar la posiocion en que se encuentra el fj
                        {
                            fj[f]=linea.substring(tt, linea.length());//-1
                            if(fj[f].contains("FJ "))
                            fj[f]=fj[f].replaceAll(" ", "-");
                            fj[f]=fj[f].replaceAll(" ", "");
                            f++;

                         }
                                                else
                                    {
                                        fj[f]=linea.substring(tt,ii);
                                       
                                        f++;

                                    }
                            
                                /*num_ot[ot]=num_ot[ot-1];//Si cambio
                                asunto[asunt]=asunto[asunt-1];
                                ot++;
                                asunt++;*/
                                ind--;
                            }


                    }

                yy=null;
                
            }
            else
            {
                if(linea.contains("RECORRIDO ACTUAL")||linea.contains("FACILIDADES A CONECTAR")|| linea.contains("RECORRIDO A LIBERAR:")|| linea.contains("FACILIDADES A LIBERAR:")|| linea.contains("R. ACTUAL")|| linea.contains("PRINCIPAL:")|| linea.contains("FACILIDADES:"))//obtengo el recorrido actual
                {
                    //gg="";
                     recorrido[rec]="";
                     dev=rec;//para saber donde empieza
                     do
                       {
                            linea=br.readLine();
                            System.out.println(linea);
                           
                            if(linea.equals(""))
                            {
                            gg="+";
                            }
                            else
                            {
                            recorrido[rec]+=linea.substring(0,linea.length());
                            recorrido[rec]=recorrido[rec].replaceAll(" ", "");
                            gg=recorrido[rec].substring(recorrido[rec].length()-1);
                            //aa++;
                            }
                            
                      }

                
                     while(gg.equals("+"));
                rec++;
                }
                       
                
                else      
                            
                     {              
                                    
                                
                            if(linea.contains("NUEVO RECORRIDO")||linea.contains("RECORRIDO NUEVO")|| linea.contains("PROTECCIÓN:"))//obtengo recorrido nuevo
                            {
                                recorrido[rec]="";
                                rec=dev;
                                do
                                   {

                                        linea=br.readLine();
                                        System.out.println(linea);

                                            if(linea.equals(""))
                                            {
                                                gg="+";
                                            }
                                                else
                                                {
                                                    recorrido[rec]+=linea.substring(0,linea.length());
                                                    recorrido[rec]=recorrido[rec].replaceAll(" ", "");
                                                    gg=recorrido[rec].substring(recorrido[rec].length()-1);
                                                //aa++;
                                                }
                                  }

                                while(gg.equals("+"));
                            
                            rec++;
                            }

                     }   
            }
             
         //||
         }
             
         while(!linea.contains("Observaciones"));
             
             
             if(hh==null)//por si no hubo fj
             {
                fj[f]="";
                f++;
                ind--;
             }
             
            
     }     
         
         
       
   for(int t=1;t<=f;t++)
   
   {
         try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_trafico","etecsa","etecsa");

Statement st =  (Statement) con.createStatement();

//String strSQL="update tb_dev_msc set dip='"+subStr5[i]+"' where id=(1+'"+i+"')";
//String strSQL="update tb_dev_msc set   dip="+subStr5[i]+" where id=("+i+"+1)";
//String strSQL="update TB_recorrido set orden='"+ num_ot[t]+"',flujo='"+ fj[t]+"',recorrido='"+ recorrido[t]+"',desde='"+ desde[t]+"',hasta='"+ hasta[t]+"',asunto='"+asunto[t]+"',fecha='"+fecha[t]+"' where id='"+t+"' ";

String strSQL="insert into TB_recorrido (orden,flujo,recorrido,desde,hasta,asunto,fecha) values('"+ num_ot[t]+"','"+ fj[t]+"','"+ recorrido[t]+"','"+ desde[t]+"','"+ hasta[t]+"','"+asunto[t]+"','"+fecha[t]+"') ";
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
        
       
        
           }//excepcionSql = puede ponerle otro nombre
     
     
     
catch (Exception e)
{ 
e.printStackTrace();
}
finally
{
        try
            {
            
            }
        catch(Exception e2)
        {
            e2.printStackTrace();
        
        }

}
                 
//errores con la carga del controlador de la base de datos(Driver)


     }
}
