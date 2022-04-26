/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

//import com.mysql.jdbc.Connection;
//import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author osmany
 */
public class Similidad {

    private   Connection con = null; 
    private  Statement st = null;
    java.sql.ResultSet rs;  
    int c=0;
    int l=0;
    String d,x=null;
    String e,y=null;
    String f,g,h,i=null;
    boolean q,w,r,t;
    int tk=0;
    int yy=0;
      String rec=null;  
    String hh=null;
    String take[]=new String[3];
    int cant[]=new int[3];//para saber cual por ciento es el mayor
      Similidad(String desde,String hasta1)
      {
          String a=hasta1;
          hh=a.toUpperCase();
        //System.out.println(hh);
        try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
  con = (Connection) DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

           java.sql.Statement  st = con.createStatement();
      String strSQL="Select hasta from tb_recorrido where desde='"+desde+"' ";
       rs =  st.executeQuery(strSQL); 
             
       
 while (rs.next()) 
 {
        
             
        int rr=rs.getString(1).length();
          rec=rs.getString(1);
        for(int aa=0;aa<rr-1;aa++)
        {
            g=rs.getString(1).substring(aa,aa+2);
            q=hh.contains(g);
                if(q==true)
                {
                    c++;//coincide
                }
                else
                {
                    l++;//no coincide

                }
        }
        int cont;
        cont=c*100/(rr-1);
        System.out.println("El porciento es:"+cont);    
         //rs.next();  
        if(cont>=35)
        {
            take[tk]=rec;
            cant[tk]=cont;
            tk++;
            
           
        }
        
             c=0;
    
 }
   
            
           
   rs.close();           
   st.close(); 
   con.close();
     
   
   for(int gg=0;gg<tk-1;gg++)
        {
            yy=cant[gg]-cant[gg+1];
            if(yy>0)
            {
                cant[gg]=cant[gg];
            }
            else
            {
                cant[gg]=cant[gg+1];
            
            }
            
        }    
   yy=cant[0]-cant[1];
            if(yy>0)
            {
                cant[0]=cant[0];
            }
           else
            {
                cant[0]=cant[1];
                
            } 
   d=take[0];  
}
    
catch ( SQLException excepcionSql)
{ 
JOptionPane.showMessageDialog( null, excepcionSql.getMessage(),"Error en base de datos", JOptionPane.ERROR_MESSAGE );
}

//errores con la carga del controlador de la base de datos(Driver)

catch ( ClassNotFoundException claseNoEncontrada ){
JOptionPane.showMessageDialog( null, claseNoEncontrada.getMessage(),"No se encontró el controlador", JOptionPane.ERROR_MESSAGE );
} 
    
            
}                        
        
        
        
}       
        
        
        
    

