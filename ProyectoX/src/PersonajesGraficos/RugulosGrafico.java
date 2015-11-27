/**
 * Implementacion grafica del enemigo Rugulos 
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PersonajesGraficos;

import javax.swing.ImageIcon;

public class RugulosGrafico extends PersonajeGrafico{

	private static final long serialVersionUID = 1L;

	public RugulosGrafico(int x, int y) {
		super(x, y);

		centro = new ImageIcon(getClass().getResource("/Imagenes/rugulos-abajo1.png"));
		abajo1 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-abajo2.png"));
		abajo2 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-abajo1.png"));
			
		arriba1 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-arriba1.png"));
		arriba2 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-arriba2.png"));
		arriba3 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-arriba1.png"));
			
		derecha1 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-derecha1.png"));
		derecha2 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-derecha2.png"));
		derecha3 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-derecha1.png"));
		
		izquierda1 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-izquierda1.png"));
		izquierda2 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-izquierda2.png"));
		izquierda3 = new ImageIcon(getClass().getResource("/Imagenes/rugulos-izquierda1.png"));
	
		morir	   = new ImageIcon(getClass().getResource("/Imagenes/rugulos-muere.gif"));
	}

}
