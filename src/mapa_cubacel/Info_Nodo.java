/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author osmany
 */
 class Info_Nodo  {
  public int index,ide;  
    Msoft ms=new Msoft();
BSC bsc=new BSC();
//Object fila[]=new Object[10];
    
    public Info_Nodo(int ident)
    {
    
 final JDialog dg=new JDialog();
        dg.setBounds(190, 190, 200 ,150);        
        
        final DefaultTableModel modelo = new DefaultTableModel();
        final JTable tabla = new JTable(modelo);
        JScrollPane scrollpane = new JScrollPane(tabla);

        tabla.setPreferredScrollableViewportSize(new Dimension(250, 20));

// Creamos las columnas.
            ide=ident;
         dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
         Reconocimiento rc=new Reconocimiento(ident);          
        
         String fila[]=rc.Reconocimiento_info();
         
         
         String []k=new String[10] ;
         for(int i=0;i<10;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Infomacion", fila);
         
        
                      tabla.addMouseListener(new MouseAdapter() 
                   {
                      public void mouseClicked(MouseEvent e) 
                      {
                         int fila = tabla.rowAtPoint(e.getPoint());
                         int columna = tabla.columnAtPoint(e.getPoint());
                         if ((fila > -1) && (columna > -1))

                            switch(fila)
                            {
                                case 0:
                                    index=0;//Opcion en el menu
                                    dg.setVisible(false);
                                    if(ide<=4)
                                        {
                                        ms.Decision(ide, index);
                                        }
                                    else
                                        {
                                         bsc.Decision(ide, index);
                                        }
                                    
                            break;
                                case 1:
                                    index=1;
                                    dg.setVisible(false);
                                    if(ide<=4)
                                        {
                                        ms.Decision(ide, index);
                                        }
                                    else
                                        {
                                         bsc.Decision(ide, index);
                                        }
                       
                        break;
                                case 2:
                                    index=2;
                                    dg.setVisible(false);
                                    if(ide<=4)
                                        {
                                        ms.Decision(ide, index);
                                        }
                                    else
                                        {
                                         bsc.Decision(ide, index);
                                        }
                        
                        break;

                            }
                      }
                   });

    
    }
    
    
    
}
