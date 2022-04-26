/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package mapa_cubacel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class Main extends JFrame{
int saber,tipo;
    private Object evt;
    public Main()
    {
        
        
    
//Boton HLR Panorama
  JButton HlrPanorama = new javax.swing.JButton();
  JLabel lb=new javax.swing.JLabel();
  HlrPanorama.setBounds(170, 110, 20, 20);
  HlrPanorama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/yy.gif"))); 
  HlrPanorama.setBackground(javax.swing.UIManager.getDefaults().getColor("TextArea.inactiveBackground"));
  HlrPanorama.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        HlrPanoramaActionPerformed(evt);
    }

           
        });

//getContentPane().add(HlrPanorama);



//Boton MSof Habana
JButton MsoftHabana = new javax.swing.JButton();
MsoftHabana.setBounds(260, 130, 28, 20);
MsoftHabana.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG"))); // NOI18N

MsoftHabana.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MsoftHabanaActionPerformed(evt);
    }

            
        });

        
//Boton MSC
JButton MSC1 = new javax.swing.JButton();
MSC1.setBounds(490, 160, 28, 20);
MSC1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG"))); // NOI18N

MSC1.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MSC1ActionPerformed(evt);
    }

            
        });

//Boton MSof Camaguey
        
JButton MSoftCamaguey = new javax.swing.JButton();
MSoftCamaguey.setBounds(770, 290, 28, 20);
MSoftCamaguey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Nodo1.JPG"))); // NOI18N

MSoftCamaguey.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        MSoftCamagueyActionPerformed(evt);
    }

            
        });

//Boton BSC Pan
        
JButton BSCPanorama = new javax.swing.JButton();
BSCPanorama.setBounds(230, 180, 28, 17);
BSCPanorama.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N

BSCPanorama.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCPanoramaActionPerformed(evt);
    }

            
        });

//Boton BSC Cubanacan
JButton BSCCubanacan = new javax.swing.JButton();
BSCCubanacan.setBounds(280, 170, 28, 17);
BSCCubanacan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N

BSCCubanacan.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCCubanacanActionPerformed(evt);
    }

            
        });

JButton BSCVClara = new javax.swing.JButton();
BSCVClara.setBounds(430, 190, 28, 17);
BSCVClara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N
BSCVClara.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCVClaraActionPerformed(evt);
    }

            
        });

JButton BSCZTE = new javax.swing.JButton();
BSCZTE.setBounds(520, 220, 28, 17);
BSCZTE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N
BSCZTE.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCZTEActionPerformed(evt);
    }

            
        });

JButton BSCCamaguey = new javax.swing.JButton();
BSCCamaguey.setBounds(650, 380, 28, 17);
BSCCamaguey.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N
BSCCamaguey.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCCamagueyActionPerformed(evt);
    }

            
        });

        JButton BSCHolguin = new javax.swing.JButton();
BSCHolguin.setBounds(900, 410, 28, 17);
BSCHolguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/BSC.JPG"))); // NOI18N

BSCHolguin.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        BSCHolguinActionPerformed(evt);
    }

           
        });

        JButton HlrHuawei = new javax.swing.JButton();
HlrHuawei.setBounds(740, 210, 20, 20);
HlrHuawei.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/yy.gif"))); // NOI18N
HlrHuawei.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        HlrHuaweiActionPerformed(evt);
    }

           
        });
        JButton TLuz = new javax.swing.JButton();
TLuz.setBounds(230, 220, 10, 10);
TLuz.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif"))); // NOI18N

TLuz.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TLuzActionPerformed(evt);
    }

            
        });


        JButton TAguila = new javax.swing.JButton();
TAguila.setBounds(300, 220, 10, 10);
TAguila.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif"))); // NOI18N

TAguila.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TAguilaActionPerformed(evt);
    }

            
        });

        JButton TVClara = new javax.swing.JButton();
TVClara.setBounds(440, 260, 10, 10);
TVClara.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif"))); // NOI18N

TVClara.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        TVClaraActionPerformed(evt);
    }

           
        });

        JButton THolguin = new javax.swing.JButton();
THolguin.setBounds(860, 380, 10, 10);
THolguin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/ball.red.gif"))); // NOI18N

THolguin.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        THolguinActionPerformed(evt);
    }

            
        });

        JButton Opciones = new javax.swing.JButton();
Opciones.setBounds(0, 480, 10, 80);
Opciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Menu.JPG"))); // NOI18N

Opciones.addActionListener(new java.awt.event.ActionListener() {
    public void actionPerformed(java.awt.event.ActionEvent evt) {
        OpcionesActionPerformed(evt);
    }

           
        });




lb.setSize(1100, 720);
lb.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/MapaCuba.jpg")));

JFrame fr=new JFrame();
    fr.setSize(1100,720);
   fr.setTitle("Mapa de Cubacel");
   fr.add(HlrPanorama);
   fr.add(MsoftHabana);
   fr.add(MSC1);
   fr.add(MSoftCamaguey);
   fr.add(BSCPanorama);
   fr.add(BSCVClara);
   fr.add(BSCZTE);
   fr.add(BSCCubanacan);
   fr.add(BSCHolguin);
   fr.add(BSCCamaguey);
   fr.add(HlrHuawei);
   fr.add(TLuz);
   fr.add(TAguila);
   fr.add(TVClara);
   fr.add(THolguin);
   fr.add(Opciones);
   
   
   
   fr.getContentPane().add(lb);
   fr.setVisible(true);
    }
   
    
//Implementacion de los metodos
 private void HlrPanoramaActionPerformed(ActionEvent evt) {
               final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }    
    
private void MsoftHabanaActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;//Link
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
            
                case 1:
                    saber=1;
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        case 4:
                    saber=3;
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
            }
      }

            
   });
            }    
private void MSC1ActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(190, 190, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }  
private void MSoftCamagueyActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(470, 280, 300 ,300);final DefaultTableModel modelo = new DefaultTableModel();
        final JTable tabla = new JTable(modelo);
        JScrollPane scrollpane = new JScrollPane(tabla);
        tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=2;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=2;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=2;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }
private void BSCPanoramaActionPerformed(ActionEvent evt) {
               final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Estaciones Bases.","Informacion de celdas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=4;//Nos dice que se refiere a celdas
                    tipo=4;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }
private void BSCCubanacanActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Estaciones Bases.","Informacion de celdas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=4;
                    tipo=3;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=3;
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=1;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

private void BSCVClaraActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(135, 210, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }


private void BSCZTEActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(230, 250, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

private void BSCCamagueyActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(350, 360, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

 private void BSCHolguinActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(600, 360, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

 private void HlrHuaweiActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

private void TLuzActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }
private void TAguilaActionPerformed(ActionEvent evt) {
                final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }

 private void TVClaraActionPerformed(ActionEvent evt) {
                 final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }
private void THolguinActionPerformed(ActionEvent evt) {
                 final JDialog dg=new JDialog();
        dg.setBounds(300, 160, 300 ,300);
        
        
final DefaultTableModel modelo = new DefaultTableModel();
final JTable tabla = new JTable(modelo);
JScrollPane scrollpane = new JScrollPane(tabla);

tabla.setPreferredScrollableViewportSize(new Dimension(50, 20));
//this.pack();

// Creamos las columnas.
       //modelo.addColumn("SPID");
       dg.getContentPane().add(scrollpane, BorderLayout.CENTER);
         dg.setVisible(true);
          
         String fila[] = {"Información de links.","Información de rutas","Otras informaciones.","Ubicacion del nodo."};
         
         
         String []k=new String[3] ;
         for(int i=0;i<3;i++)
         k[i]=fila[i];
         
         modelo.addColumn("Menú", fila);
         
        
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
                    saber=0;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
            break;
                case 1:
                    saber=1;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
                case 2:
                    saber=2;
                    tipo=0;
                    dg.setVisible(false);
        labelrMouseClicked(e);
        break;
        
            }
      }
   });
            }




 private void OpcionesActionPerformed(ActionEvent evt) {
                JInternalFrame jInternalFrame1 = new javax.swing.JInternalFrame();
    jInternalFrame1.setTitle("Informaciones adicionales");
    
    jInternalFrame1.setBounds(10, 353, 400, 375);
    jInternalFrame1.setVisible(true);
    jInternalFrame1.setResizable(false);
    jInternalFrame1.setClosable(true);
    
    

        JLabel jLabela = new javax.swing.JLabel();
        JLabel jLabelb = new javax.swing.JLabel();
        JLabel jLabelc = new javax.swing.JLabel();
        
        jLabela.setText("Simulacro de llamadas");
        jLabela.setBounds(3, 10, 400, 10);
       jInternalFrame1.add(jLabela);
       
        jLabelb.setText("Facilidades existentes");
        jLabelb.setBounds(3, 30, 400, 10);
      
    
        jInternalFrame1.add(jLabelb);
    
        jLabelc.setText("Informacion de los Minilink");
        jLabelc.setBounds(3, 50, 400, 10);
        jInternalFrame1.add(jLabelc);
        
        //jInternalFrame1.add(new FondoOpciones());
        
        
       jLabela.addMouseListener(new java.awt.event.MouseAdapter() {
    public void mouseClicked(java.awt.event.MouseEvent evt) {
        jLabelaMouseClicked(evt);
    }

            private void jLabelaMouseClicked(MouseEvent evt) {
                throw new UnsupportedOperationException("Not yet implemented");
            }
        });
            }
private void labelrMouseClicked(MouseEvent evt) {
                if (evt.getClickCount()==2)
     {
        
   // inf=new Informacion(saber);
    
    }
    Informacion inf=new Informacion(saber,tipo);
            }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Main();
        //JFrame fr=new JFrame();
    }

}
