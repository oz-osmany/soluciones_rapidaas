package mapa_cubacel;

import java.util.Scanner;


public class BusqPalabras{
 static String[] datos = {"Carla", "Maria", "Jose", "Marcos"};
 static String resultado="";
 static String textoIngresado;
 static boolean hayValor= true;
 public static void main(String[] args){
  Scanner in = new Scanner(System.in);
  //EL while simula la entrada de caracteres en un JtextField
  while(true){
   System.out.print("Ingresa caracter :");
   textoIngresado += in.nextLine();
   textoIngresado=textoIngresado.replace("null","");
   System.out.println(textoIngresado);
   BuscarSimilitud(textoIngresado);
  }//fin del while
 
 }
 
 public static void BuscarSimilitud(String textoIngresado){
  String[] caracteresdTextoIngresado = textoIngresado.split("");//uso el metodo Split para  
//convertir el String en un arreglo de sus caracteres para compararlos
  int longitud = textoIngresado.length();
  int numcoincidencia=0;
  for(String s : datos){ //este for me sirve para recorrer todos los valores de mi arreglo datos
   hayValor=true; // boolena que me indica si la comparacion es perfecta
   String[] caracteresdedatos = s.split("");//Con cada pasada del for each, convierto cada 
//palabra del arreglo datos en un arreglo para comparar sus caracteres
   System.out.println("Tabaja con :"+ s); //imprimo el string con el que estoy trabajando
   for(int i = 0; i <= longitud; i++){//reviso el valor de s hasta la longitud del string 
//ingresado por el usuario
    try{
    System.out.println(caracteresdTextoIngresado[i]+"=="+caracteresdedatos[i] +"? ");
    if (!caracteresdTextoIngresado.equals(null) && 
caracteresdTextoIngresado[i].equals(caracteresdedatos[i]))
//comparo cada caracter de la palabra con lo que ingreso el usuario
    {
     System.out.println("si");
 
 
    } else {
     hayValor=false;
     System.out.println("no");
    } 
    }catch (Exception e){ 
// capturo la excepcion si algun valor en datos es de menor longitud de lo que ingreso el usuario
     System.out.println("No coincide");
    }
   }
   if (hayValor){
    resultado+=s+".";
    numcoincidencia ++;
   } else {
    resultado=" ";
   }
  }
  System.out.println("Hay "+numcoincidencia  +" Coincidencia : "+resultado);
 
 }
}