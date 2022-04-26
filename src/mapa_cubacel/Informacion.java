/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

/**
 *
 * @author kevin
 */
public class Informacion {
public Informacion(int e,int t)//opcion del menu y nodo seleccionado

{
    
   switch(e)
   {
       case 0:
            Link dg1=new Link(t);

            dg1.setSize(1100, 700);
            dg1.setTitle("Información de links");
            //dg.add(new MenuPanel());
            dg1.setVisible(true);
            break;
      case 1:
            Rutas_Mapa dg2=new Rutas_Mapa(t);
            dg2.setSize(1100, 700);
            dg2.setTitle("Información de rutas");
            //dg1.add(new MenuPanel());
            dg2.setVisible(true);
            break;
       case 2:
           /*MapaMinilink dg3=new MapaMinilink();         
            dg3.setSize(1100, 700);
            dg3.setTitle("Mapa de los Minilinks");
            //dg.add(new MenuPanel());
            dg3.setVisible(true);*/
            break;
           
       case 3:
           /*MapaOComerciales dg4=new MapaOComerciales();          
            dg4.setSize(1100, 700);
            dg4.setTitle("Mapa de las Oficinas Comerciales");
            //dg.add(new MenuPanel());
            dg4.setVisible(true);*/
            break;
       case 4:
           BSC_info dg5=new BSC_info(t);
           dg5.setSize(1100, 700);
            dg5.setTitle("Informacion de Estaciones Bases");
            //dg.add(new MenuPanel());
            dg5.setVisible(true);
           break;
  
   }
   
   
   }
}
