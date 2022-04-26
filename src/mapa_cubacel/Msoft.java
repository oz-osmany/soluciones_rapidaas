/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import javax.swing.JDialog;
//import mapa.Link_Mapa;

/**
 *
 * @author osmany
 */
public class Msoft extends Nodos
{
    String tred,prtocol,inter,name,ubicacion;
    int id;
    public Msoft(String gtitle,String pto, String puerto,String ipp,String tr,String prt,String itf,String nomb,String ubica,int ident)//tipo de red, protocolo,interface
    {
        super(gtitle,pto,puerto,ipp);
        tred=tr;
        prtocol=prt;
        inter=itf;
        name=nomb;
        ubicacion=ubica;
        id=ident;
        
    
    }
    public Msoft()
    {
        Msoft();
    
    }
    
    public String[] Msoft()
    {
    
    String info[]={tred,prtocol,inter,name,ubicacion,toString().valueOf(id)};
    return info;
    
    }
    
   public void Decision(int id,int index)
    {
        switch(index)
   {
       case 0:
            Link dg1=new Link(id);
            // JDialog dg1=new JDialog();                         
            
            dg1.setSize(1100, 700);
            dg1.setTitle("Información de links");
            dg1.setVisible(true);
        
            break;
            
            
      case 1:
          
            Rutas_Mapa dg2=new Rutas_Mapa(id);
            dg2.setSize(1100, 700);
            dg2.setTitle("Información de rutas");
            //dg1.add(new MenuPanel());
            dg2.setVisible(true);
            break;
       case 2:
           Info_Nodo dg3=new Info_Nodo(id);  
           
           // dg3.setSize(1100,700);
            //dg3.setTitle("Mapa de los Minilinks");
            //dg.add(new MenuPanel());
           // dg3.setVisible(true);
            break;
           
         
   }
   
   
   }
    
   
    }

  