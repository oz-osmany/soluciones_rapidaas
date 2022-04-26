package mapa_cubacel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//package mapa_cubacel;

/**
 *
 * @author osmany.machado
 */
import java.applet.*;
	import java.awt.*;
 
	/**
	 * The HelloWorld class implements an applet that
	 * simply displays "Hello World!".
	 */
	public class Bola extends Applet {
	   Button b1,b2,b3;

    public void init() {
        b1 = new Button( "Botón B1" );
        b2 = new Button( "Botón B2" );
        b3 = new Button( "Botón B3" );

        this.add( b1 );
        this.add( b2 );
        this.add( b3 );
        }

    public boolean action( Event evt,Object obj ) {
        if( evt.target.equals( b1 ) )
            System.out.println( "Se ha pulsado el boton B1" );
        if( evt.target.equals( b2 ) )
            System.out.println( "Se ha pulsado el boton B2" );
        if( evt.target.equals( b3 ) )
            System.out.println( "Se ha pulsado el boton B3" );

        return true;
        }
	}