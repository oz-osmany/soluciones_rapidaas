/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

/**
 *
 * @author osmany
 */
public class Reconocimiento {
    Object ob[]=new Object[10];
    public String name,ubicacion,tred,gt,ps,ip,puerto;
    public boolean umg;
    String protocolo;
    String inter;
    int id;
    public Reconocimiento()
    {}
    
    public Reconocimiento(int ident)
    {
        Reconocimiento rc;
    id=ident;
    switch(id)
    {
        case 0:
            name="MSotCubanacan";
            ubicacion="CGNM Cubanacan";
            tred="Core Network";//tipo de red
            gt="5372640021";//global title
            ps="2070";//punto de senalizacion
            ip="10.50.10.40";
            puerto="6000";
            umg=true;
            protocolo ="MAP";
            inter="A";
            //Object[] ob={name,ubicacion,tred,gt,ps,ip,puerto,toString().valueOf(umg),protocolo,inter};
            Msoft ms=new Msoft(gt, ps, puerto, ip, tred, protocolo, inter,name,ubicacion,id);
            
            break;
        case 1:
            name="MSotJaguey";
            ubicacion="Jaguey Grande";
            tred="Core Network";//tipo de red
            gt="5372640014";//global title
            ps="2070";//punto de senalizacion
            ip="10.92.1.126";
            puerto="6000";
            umg=true;
            protocolo ="MAP";
            inter="A"; 
            //String[] ob={this.name,ubicacion,tred,gt,ps,ip,puerto,toString().valueOf(umg),protocolo,inter};
            Msoft ms1=new Msoft(gt, ps, puerto, ip, tred, protocolo, inter,name,ubicacion,id);
            break;
    
          case 5:
            name="BSC_Panorama";
            ubicacion="Panorama";
            tred="Acceso";//tipo de red
            gt="5372640014";//global title
            ps="2070";//punto de senalizacion
            ip="10.92.1.126";
            puerto="23";
            umg=true;
            protocolo ="BSSAP";
            inter="Abis";  
            BSC bsc_pan=new BSC(gt, ps, puerto, ip, tred, protocolo, inter,name,ubicacion,id);
            break;
         case 6:
            name="BSC_Cubanacan";
            ubicacion="Cubanacan";
            tred="Acceso";//tipo de red
            gt="5372640014";//global title
            ps="2070";//punto de senalizacion
            ip="10.92.1.126";
            puerto="23";
            umg=true;
            protocolo ="BSSAP";
            inter="Abis";  
            BSC bsc_cub=new BSC(gt, ps, puerto, ip, tred, protocolo, inter,name,ubicacion,id);
            break;  
       
    }
    
    
    }
    public String[] Reconocimiento_info()
    {
    
        String[] obj={name,ubicacion,tred,gt,ps,ip,puerto,toString().valueOf(umg),protocolo,inter};
        return obj;
    }
    

}
