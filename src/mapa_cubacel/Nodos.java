/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;



/**
 *
 * @author osmany
 */
public class Nodos  {
    
    public String ip,gt,ps,prto;//ip de conexion,global title,punto de senalizacion y puerto
   
    public Nodos(String gtitle,String pto, String puerto,String ipp)
    {
        gt=gtitle;
        ps=pto;
        prto=puerto;
        ip=ipp;
        
    }
    public Nodos()
    {
    
    }
    public String[] Nodos()
    {
    
    String info[]={gt,ps,prto,ip};
    return info;
    
    }
    
    
    public String[] InformacionMenu(int ident)
    {
        if(ident<=4)
        {
      String inf[]={"Información de links.","Información de rutas","Informaciones del nodo.","Ubicacion del nodo."};
        return inf;
        }
            else 
                if(ident>4 && ident<20)
            {   
                String inf[]={"Estaciones bases.","Informaciones del nodo.","Ubicacion del nodo."};
                return inf;
            }
                else
                {
                String inf[] = {"Buscador.","Oficinas comerciales","Simulacion de llamada."};
                return inf;
                }
    
    }

}
