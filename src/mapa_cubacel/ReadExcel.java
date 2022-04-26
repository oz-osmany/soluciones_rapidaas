/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mapa_cubacel;

/**
 *
 * @author osmany.machado
 */
//import jxl.*; 
import java.io.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/*
public class ReadExcel { 

String site[]=new String[1000];
String celda[]=new String[1000];
String provincia[]=new String[1000];
String cgi[]=new String[1000];
   
private void leerArchivoExcel(String archivoDestino) { 


try { 
Workbook archivoExcel = Workbook.getWorkbook(new File( 
archivoDestino)); 
System.out.println("Número de Hojas\t" 
+ archivoExcel.getNumberOfSheets()); 
for (int sheetNo = 0; sheetNo < archivoExcel.getNumberOfSheets(); sheetNo++) // Recorre 
// cada    
// hoja                                                                                                                                                       
{ 
Sheet hoja = archivoExcel.getSheet(sheetNo); 
int numColumnas = hoja.getColumns(); 
int numFilas = hoja.getRows(); 
String data; 
System.out.println("Nombre de la Hoja\t" 
+ archivoExcel.getSheet(sheetNo).getName()); 


for (int fila = 0; fila < numFilas; fila++) { // Recorre cada 
// fila de la 
// hoja 
for (int columna = 0; columna < numColumnas; columna++) { // Recorre                                                                                
// cada                                                                                
// columna                                                                            
// de                                                                                
// la                                                                                
// fila 
data = hoja.getCell(columna, fila).getContents(); 
site[fila]=hoja.getCell(0, fila).getContents(); 
celda[fila]=hoja.getCell(1, fila).getContents(); 
provincia[fila]=hoja.getCell(2, fila).getContents(); 
cgi[fila]=hoja.getCell(3, fila).getContents(); 

} 
//System.out.println(cgi[fila]); 

 try{
Class.forName("com.mysql.jdbc.Driver"); // 2005 version
Connection con = DriverManager.getConnection("jdbc:mysql://10.94.1.143:3306/gestion_trafico","etecsa","etecsa");

Statement st = con.createStatement();

//String strSQL="update tb_bsc_pan set rsite='"+subStr2[i]+"',tg='"+subStr3[i]+"',dip='"+dip[i] +"RBL2',dev='RBLT2-"+subStr[i]+"&&-"+dev1[i]+"' where id="+i+" ";
String strSQL="INSERT INTO info_zte (id,site,cell,provincia,cgi) VALUES ( "+fila+",'"+site[fila]+"','"+celda[fila]+"','"+provincia[fila]+"','"+cgi[fila]+"' ) ";
                    boolean rs = st.execute(strSQL); 

             
             
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

} 

  
          
             
                
                 







} 
} catch (Exception ioe) { 
ioe.printStackTrace(); 
} 

} 

public static void main(String arg[]) { 
ReadExcel excel = new ReadExcel(); 

excel.leerArchivoExcel("Celdas_ZTE2.xls"); 
} 
}
*/