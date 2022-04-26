package mapa_cubacel;

import javax.swing.*;
import java.awt.*;
/**
@autor: Jimmy Morales
*/

public class JButtonEfec extends JButton{
    
    

	private Image image=null;
	private String text,desc;
	private int x;
	private float trans=0.9f;
	private boolean runner=true;
	private Graphics2D g2;

    private Color color1;//Color mas claro
    private Color color2;
    private Color color3;//Color del border
    private Color colort;//Color del TITULO
    private Color colord;//Color del TITULO

    public JButtonEfec() {
		propies();
    }

    public JButtonEfec(String i,String t,String d){
		ImageIcon icon = new ImageIcon(i);
		setImage(icon);
		text=t;
		desc=d;
		color1=new Color(231,239,245);
		color2=new Color(60,127,177);
		color3=new Color(180,180,180);
		colort=Color.WHITE;
		colord=new Color(250,250,250);
		propies();

    }

    public JButtonEfec(String i,String t,String d,Color c1,Color c2){
		ImageIcon icon = new ImageIcon(i,t+"."+d);
		setImage(icon);
		text=t;
		desc=d;
		color1=c1;
		color2=c2;
		colort=Color.WHITE;
		colord=new Color(250,250,250);
		propies();
    }

    public JButtonEfec(String i,String t,String d,Color c1,boolean dual){
		ImageIcon icon = new ImageIcon(i,t+"."+d);
		setImage(icon);
		text=t;
		desc=d;
		if(dual){
			color1=c1.brighter();
			color2=c1.darker();
		}else{
			color1=color2=c1;
		}
		colort=Color.WHITE;
		colord=new Color(250,250,250);
		x=image.getWidth(null);
		propies();
    }

    public JButtonEfec(String i,String t,String d,Color c1,boolean dual,Color c3){
		ImageIcon icon = new ImageIcon(i,t+"."+d);
		setImage(icon);
		text=t;
		desc=d;
		if(dual){
			color1=c1.brighter();
			color2=c1.darker();
		}else{
			color1=color2=c1;
		}
		color3=c3;
		colort=Color.WHITE;
		colord=new Color(250,250,250);
		x=image.getWidth(null);
		propies();
    }

	private void propies(){
        //setForeground(Color.BLACK);
        setOpaque(false);
        setContentAreaFilled(false);
        setFocusPainted(true);
        setBorderPainted(false);
		setPreferredSize(new Dimension(image.getWidth(null)+150,image.getHeight(null)+8));
	}

    public void paint(Graphics g) {
        super.paint(g);
        g2 = (Graphics2D) g;

        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);

        ButtonModel m = getModel();
        //Composite composite;

        if (m.isPressed()){//al hacer click
        	apariencia(color1,color2,color3);
        	repaint();
			if(runner)new effecto();
        } else if(m.isRollover()){//Cuando pasa el mousebrighter()
        	apariencia(color1,color2.darker(),color3);
        }

        else{//Si no hay nada;
        	apariencia(color1,color2,color3);
		}

        if (!m.isEnabled()){}

    }

	public Image getImage() {
		return image;
	}

	public void setImage(ImageIcon i) {
		image=i.getImage();
	}

	public void colorTitulo(Color ct){
		colort=ct;
	}

	public void colorDescripcion(Color cd){
		colord=cd;
	}

	public void efecto(boolean r){
		runner=r;
	}

	class effecto extends Thread{
		public effecto(){
			start();
		}
		public void run(){
			runner=false;
			x=image.getWidth(null);;
			for(int i=0;i<=4;i++){
				if(i==0)
					trans=0.8f;
				else if(i==1)
					trans=0.6f;
				else if(i==2)
					trans=0.4f;
				else if(i==3)
					trans=0.2f;
				else if(i==3)
					trans=0.0f;

				x+=10;
				repaint();
				try{Thread.sleep(100);}catch(Exception exc){}
			}
				//System.out.println(runn);
			x=image.getWidth(null);
			trans=0.9f;
			runner=true;
			repaint();
		}
	}

	private void apariencia(Color c1,Color c2,Color c3){

		//g2.setColor(Color.RED);48
		//g2.fillRect(0,0,getWidth(),getHeight());

		g2.setPaint(new GradientPaint(0,0,c1,0,getHeight(),c2));
		g2.fillRoundRect(0,0,getWidth(), getHeight(),10,10);

		g2.setColor(colort);
		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,1.0f));
		g2.setFont(new Font("Arial",0,18));
		g2.drawString(text,image.getWidth(null)+10,25);
		g2.setColor(colord);
		g2.setFont(new Font("Tahoma",0,11));
		g2.drawString(desc,image.getWidth(null)+20,40);
		g2.drawImage(getImage(),10,(int)(getHeight()-image.getHeight(null))/2, null);

		g2.setColor(c3);
		g2.drawRoundRect(0,0,getWidth()-1, getHeight()-1,10,10);

		g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,trans));
		g2.drawImage(getImage(),10,(int)(getHeight()-x)/2,x,x, null);
		//repaint();

	}
      public static void main(String[] args)
      {
      
      
      
      }
}
        

