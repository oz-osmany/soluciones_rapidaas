package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package mapa_cubacel;

//import mapa_cubacel.*;
//import Mapa.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author osmany.machado
 */
class SineDraw extends JPanel{
      static final int FACTOR_de_ESCALA=200;
      int ciclos;
      int puntos;
      double[] senos;
      int[] ptos;
     
      SineDraw(){ setCiclos(5);}
      public void setCiclos(int nuevosCiclos){
          ciclos=nuevosCiclos;
          puntos =FACTOR_de_ESCALA*ciclos*2;
          senos = new double[puntos];
          ptos = new int[puntos];
          for(int i=0;i<puntos;i++){
                       double radianes =(Math.PI/FACTOR_de_ESCALA)*i;
                       senos[i]=Math.sin(radianes);
          }//Ffor
          repaint();
      }//Ffunc setCiclos
      public void paintComponent(Graphics g){
          super.paintComponent(g);
          int maxWidth=getWidth();
          double hstep = (double)maxWidth/(double)puntos;
          int maxHeight =getHeight();
          for(int i=0;i<puntos;i++)  ptos[i]=(int)(senos[i]*maxHeight/2*.95+maxHeight/2);
          g.setColor(Color.red);
          
          for(int i=1;i<puntos;i++){
            int x1=(int)((i-1)*hstep);
            int x2=(int)(i*hstep);
            int y1=ptos[i-1];
            int y2=ptos[i];
            g.drawLine(x1,y1,x2,y2);
          }//Ffor          
      }//Ffunc paintComponent
   }//Fclass SineDraw
public class SineWave extends JApplet
{
     SineDraw senos = new SineDraw();
     JSlider ciclos = new JSlider(1,30,5);
     public void init(){
        Container cp = getContentPane();
        cp.add(senos);
        ciclos.addChangeListener(new ChangeListener(){
          public void stateChanged(ChangeEvent e){
                          senos.setCiclos(((JSlider)e.getSource()).getValue());
                           ((JSlider)e.getSource()).setToolTipText(""+ciclos.getValue());
          }//Ffunc anonima

            
        });
        cp.add(BorderLayout.SOUTH, ciclos);
      }//Ffunc init
   }//Fclass 


