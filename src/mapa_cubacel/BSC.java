/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import mapa_cubacel.BSC_info;

/**
 *
 * @author osmany
 */
public class BSC extends Nodos{
String tred,prtocol,inter,name,ubicacion;
 int id;   
    public BSC(String gtitle,String pto, String puerto,String ipp,String tr,String prt,String itf,String nomb,String ubica,int ident)//tipo de red, protocolo,interface
    {
        super(gtitle,pto,puerto,ipp);
        tred=tr;
        prtocol=prt;
        inter=itf;
        name=nomb;
        ubicacion=ubica;
        id=ident;
    }
    public BSC()
    {
        BSC();
    }
    
    public String[] BSC()
    {
    
    String info[]={tred,prtocol,inter,name,ubicacion,toString().valueOf(id)};
    return info;
    }
    
    public void Decision(int id,int index)
      {
                switch(index)
           {
               case 0:
                   BSC_info dg5=new BSC_info(id);
                   dg5.setSize(1100, 700);
                    dg5.setTitle("Informacion de Estaciones Bases");
                    //dg.add(new MenuPanel());
                    dg5.setVisible(true);
                   break;


              case 1:

                    Rutas_Mapa dg2=new Rutas_Mapa(id);//Hay que cambiarlo
                    dg2.setSize(1100, 700);
                    dg2.setTitle("Información de rutas");
                    //dg1.add(new MenuPanel());
                    dg2.setVisible(true);
                    break;
              
               case 2:
                    Info_Nodo dg3=new Info_Nodo(id);
                    break;

                 }
         }
}
