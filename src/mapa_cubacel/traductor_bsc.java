/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

/**
 *
 * @author osmany.machado
 */
public class traductor_bsc {
    
    public String tb_bsc=null;
    public String tb_cell=null;
        
    public traductor_bsc(String bsc)
    {
        if(bsc.equals("BSC_PANORAMA_CH_"))        
        {
         tb_bsc="tb_bsc_pan";
         tb_cell="tb_cell_pan";
         
        }
        if(bsc.equals("BSC_CUBACAN_C.HAB")||bsc.equals("BSC_CUBACAN_HAB"))
        
        {
         tb_bsc="tb_bsc_cub";
         tb_cell="tb_cell_cub";
         
        }
        
        if(bsc.equals("JAG_TEST"))
        {
        tb_bsc="tb_bsc_cmg";
         tb_cell="tb_cell_cam";
        
        }
    
    }
    

}
