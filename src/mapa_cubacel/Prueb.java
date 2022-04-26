package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package mapa_cubacel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JApplet;
import javax.swing.JFrame;
//import org.jvnet.substance.SubstanceLookAndFeel;
import javax.swing.JPanel;

/**  
 *
 * @author osmany.machado
 */
public class Prueb extends JApplet{

    
  private JPanel jContentPane = null;
/*
*Se sobre escribe el método init() para
*inicializar el applet
*
*/
public void init() {
/*
* Se define un color de fondo y tamaño
* como se hace para otros contenedores
*/
this.setSize(300, 200);
this.setBackground(Color.ORANGE);
/*
* Se determina al JPanel como contenedor
*/
this.setContentPane(getJContentPane());
repaint();
}
/*
* Se se inicializa el JPanel
*/
private JPanel getJContentPane() {
if (jContentPane == null) {
jContentPane = new JPanel();
jContentPane.setLayout(new GridLayout(5,2));
}
return jContentPane;
}
/*
* Se sobreescribe el metodo paint, para que
* dibuje algunos gráficos en el applet
*
*/
public void paint(Graphics g) {
Font f=new Font("Arial",Font.ITALIC,30);
for(int i=0;i<150;i+=3) {
if((i%2)!=0)
g.setColor(Color.GREEN);
else
g.setColor(Color.BLUE);
g.drawRect(150, 50, i+10, i);
}
g.setFont(f);
g.drawString("Applet Basico", 10, 30);
}
}


