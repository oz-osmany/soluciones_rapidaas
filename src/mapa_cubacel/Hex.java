/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import java.util.Scanner;

/**
 *
 * @author osmany.machado
 */
public class Hex {
    
    public static long Hex (String n) { 
        StringBuilder conversion = new StringBuilder(n).reverse(); 
        long suma=0; 
        for( int i = 0; i < conversion.length(); i++) 
        {
if(conversion.charAt(i)=='A')
suma = suma + 10 * (long)Math.pow(16, i); 
else
    if(conversion.charAt(i)=='B') 
        suma = suma + 11 * (long)Math.pow(16, i);
    else
        if(conversion.charAt(i)=='C')
            suma = suma + 12 * (long)Math.pow(16, i); 
        else if(conversion.charAt(i)=='D')
            suma = suma + 13 * (long)Math.pow(16, i);
        else 
            if(conversion.charAt(i)=='E') 
                suma = suma + 14 * (long)Math.pow(16, i);
            else if(conversion.charAt(i)=='F') 
                suma = suma + 15 * (long)Math.pow(16, i);
            else
            { 
                suma = suma + Integer. parseInt("" + conversion. charAt(i)) * (long) Math. pow(16, i) ;
            }
        } 
        return suma; 
    } 
    /*public static void main(String[]args)
    { Scanner lee = new Scanner(System.in); 
      System.out.println("Ingresa un numero hexadecimal");
      String numero = lee.nextLine().toUpperCase(); 
      System.out.println( Hex. Hex_Decimal(numero) ) ; 
    } */

    

}
