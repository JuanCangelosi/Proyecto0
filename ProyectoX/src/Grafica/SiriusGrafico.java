package Grafica;

import javax.swing.ImageIcon;

public class SiriusGrafico extends PersonajeGrafico{

	private static final long serialVersionUID = 1L;

	public SiriusGrafico(int x, int y) {
		super(x, y);
		
		centro = new ImageIcon(getClass().getResource("/Imagenes/sirius-abajo1.png"));
		abajo1 = new ImageIcon(getClass().getResource("/Imagenes/sirius-abajo2.png"));
		abajo2 = new ImageIcon(getClass().getResource("/Imagenes/sirius-abajo3.png"));
			
		arriba1 = new ImageIcon(getClass().getResource("/Imagenes/sirius-arriba1.png"));
		arriba2 = new ImageIcon(getClass().getResource("/Imagenes/sirius-arriba2.png"));
		arriba3 = new ImageIcon(getClass().getResource("/Imagenes/sirius-arriba3.png"));
			
		derecha1 = new ImageIcon(getClass().getResource("/Imagenes/sirius-derecha1.png"));
		derecha2 = new ImageIcon(getClass().getResource("/Imagenes/sirius-derecha2.png"));
		derecha3 = new ImageIcon(getClass().getResource("/Imagenes/sirius-derecha3.png"));
			
		izquierda1 = new ImageIcon(getClass().getResource("/Imagenes/sirius-izquierda1.png"));
		izquierda2 = new ImageIcon(getClass().getResource("/Imagenes/sirius-izquierda2.png"));
		izquierda3 = new ImageIcon(getClass().getResource("/Imagenes/sirius-izquierda3.png"));

		morir	   = new ImageIcon(getClass().getResource("/Imagenes/sirius-muere.gif"));
	}
}
