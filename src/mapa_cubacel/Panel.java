package mapa_cubacel;

//package Pruebas;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package Pruebas;


//import mapa_cubacel.*;
//import Mapa.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author osmany.machado
 */
 class Panel_muestra extends JPanel{
    
     
     
     
    private Image img;
    
   public Panel_muestra()
   {
       super();
       
    
    img=new ImageIcon(getClass().getResource("/Img/MapaCuba.jpg")).getImage();
    
    
    
        
        //this.add(b1);
    
   repaint();
   }
    public void paintComponent(Graphics g){
          super.paintComponent(g);
          if(img!=null)
          {
           g.drawImage(img, 0, 0,this);
          }
          
 } 
    
    
 }
public class Panel extends JApplet
{
    public Panel_muestra panel;  
    public JButton MSoftCamaguey;
    public JButton MsoftHabana ;
    public JButton MsofJaguey ;
    public JButton BSCPanorama ;
    public JButton BSCCubanacan;
    public JButton BSCHolguin ;
    public JButton BSCVClara ;
    public JButton BSCZTE ;
    public JButton BSCJaguey ;
    public JButton HlrHuawei;
    public JButton HlrPanorama;        
    public JButton THolguin;
    public JButton TLuz;
    public JButton TAguila;
    public JButton TVClara ;        
    public JButton RedInteligente;       
    public JButton MSCCubanacan ;        
    public JButton BSCCamaguey1 ;
    public JButton Opciones;
    
    
    
    
    public void init() {  
  
        try {  
            SwingUtilities.invokeAndWait(new Runnable() {  
                @Override  
                public void run() {  
                    printGraphics();  
                }  
            });  
        } catch (Exception e) {  
            System.err  
                    .println("There was something wrong with createGUI() method");  
        }  
    }  
      
    private void printGraphics()
    {  
        
panel = new Panel_muestra();  
        MSoftCamaguey = new javax.swing.JButton();
        MsoftHabana = new javax.swing.JButton();
        MsoftHabana.setBounds(70,100, 20, 20);
        MsoftHabana.setSize(20, 20);
        MsofJaguey = new javax.swing.JButton();
        BSCPanorama = new javax.swing.JButton();
        BSCCubanacan = new javax.swing.JButton();
        BSCHolguin = new javax.swing.JButton();
        BSCVClara = new javax.swing.JButton();
        BSCZTE = new javax.swing.JButton();
        BSCJaguey = new javax.swing.JButton();
        HlrHuawei = new javax.swing.JButton();
        HlrPanorama = new javax.swing.JButton();        
        THolguin = new javax.swing.JButton();
        TLuz = new javax.swing.JButton();
        TAguila = new javax.swing.JButton();
        TVClara = new javax.swing.JButton();        
        RedInteligente = new javax.swing.JButton();       
        MSCCubanacan = new javax.swing.JButton();        
        BSCCamaguey1 = new javax.swing.JButton();
        Opciones = new javax.swing.JButton();
        
        
        getContentPane().add(panel, BorderLayout.CENTER);  
       panel.add(MsoftHabana);
       panel.add(MSoftCamaguey);
       panel.add(Opciones);
       panel.add(BSCCamaguey1);
       panel.add(MSCCubanacan);
       panel.add(RedInteligente);
       panel.add(TVClara);
       panel.add(TAguila);
       panel.add(TLuz);
       panel.add(THolguin);
       panel.add(HlrPanorama);
       panel.add(HlrHuawei);
       panel.add(BSCJaguey);
       panel.add(BSCZTE);
       panel.add(BSCVClara);
       panel.add(BSCHolguin);
       panel.add(BSCCubanacan);
       panel.add(BSCPanorama);
       panel.add(MsofJaguey);
       
       HlrHuawei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/yy.gif"))); // NOI18N
        HlrHuawei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            HlrHuaweiActionPerformed(evt);
            }
        });
        HlrPanorama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/yy.gif"))); // NOI18N
        HlrPanorama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            HlrPanoramaActionPerformed(evt);
            }
        });
        
       MSoftCamaguey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG"))); // NOI18N
        MSoftCamaguey.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            MSoftCamagueyActionPerformed(evt);
            }
        });
       
       MsoftHabana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG")));
        MsoftHabana.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MsoftHabanaActionPerformed(evt);
    }
});
Opciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG")));
        Opciones.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        OpcionesActionPerformed(evt);
    }
});
BSCCamaguey1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCCamaguey1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCCamaguey1ActionPerformed(evt);
    }
});
MSCCubanacan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG")));
        MSCCubanacan.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MSCCubanacanActionPerformed(evt);
    }
});
RedInteligente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG")));
        RedInteligente.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        RedInteligenteActionPerformed(evt);
    }
});
BSCJaguey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCJaguey.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCJagueyActionPerformed(evt);
    }
});
BSCZTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCZTE.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCZTEActionPerformed(evt);
    }
});
BSCVClara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCVClara.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCVClaraActionPerformed(evt);
    }
});
BSCHolguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCHolguin.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCHolguinActionPerformed(evt);
    }
});
BSCCubanacan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCCubanacan.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCCubanacanActionPerformed(evt);
    }
});
BSCPanorama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG")));
        BSCPanorama.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCPanoramaActionPerformed(evt);
    }
});
MsofJaguey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG")));
        MsofJaguey.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
       MsofJagueyActionPerformed(evt);
    }
});
TAguila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif")));
        TAguila.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TAguilaActionPerformed(evt);
    }
});
TLuz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif")));
        TLuz.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TLuzActionPerformed(evt);
    }
});
THolguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif")));
        THolguin.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        THolguinActionPerformed(evt);
    }
});
TVClara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif")));
        TVClara.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TVClaraActionPerformed(evt);
    }
});


    }
    
    
    
private void MsoftHabanaActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
           
}  
private void MSoftCamagueyActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}

private void OpcionesActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCCamaguey1ActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void MSCCubanacanActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void RedInteligenteActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCJagueyActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCZTEActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCVClaraActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCHolguinActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCCubanacanActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void BSCPanoramaActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void MsofJagueyActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void TAguilaActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void TLuzActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void THolguinActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void TVClaraActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}

private void HlrPanoramaActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
private void HlrHuaweiActionPerformed(java.awt.event.ActionEvent evt) {
   // id=0;
    Reconocimiento rc=new Reconocimiento(0);//para index detalles del nodo
    Menu_Select mn=new Menu_Select(0);
    
}
    }




   

