package Grafica;

import javax.swing.ImageIcon;

public class AltairGrafico extends PersonajeGrafico{

	private static final long serialVersionUID = 1L;

	public AltairGrafico(int x, int y) {
		super(x, y);
			
		centro = new ImageIcon(getClass().getResource("/Imagenes/altair-abajo1.png"));
		abajo1 = new ImageIcon(getClass().getResource("/Imagenes/altair-abajo2.png"));
		abajo2 = new ImageIcon(getClass().getResource("/Imagenes/altair-abajo1.png"));
			
		arriba1 = new ImageIcon(getClass().getResource("/Imagenes/altair-arriba1.png"));
		arriba2 = new ImageIcon(getClass().getResource("/Imagenes/altair-arriba2.png"));
		arriba3 = new ImageIcon(getClass().getResource("/Imagenes/altair-arriba1.png"));
			
		derecha1 = new ImageIcon(getClass().getResource("/Imagenes/altair-derecha1.png"));
		derecha2 = new ImageIcon(getClass().getResource("/Imagenes/altair-derecha2.png"));
		derecha3 = new ImageIcon(getClass().getResource("/Imagenes/altair-derecha1.png"));
			
		izquierda1 = new ImageIcon(getClass().getResource("/Imagenes/altair-izquierda1.png"));
		izquierda2 = new ImageIcon(getClass().getResource("/Imagenes/altair-izquierda2.png"));
		izquierda3 = new ImageIcon(getClass().getResource("/Imagenes/altair-izquierda1.png"));	
		
		morir	   = new ImageIcon(getClass().getResource("/Imagenes/altair-muere.gif"));
			
	}

}
