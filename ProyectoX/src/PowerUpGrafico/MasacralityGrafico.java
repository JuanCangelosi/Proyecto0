/**
 * Implementacion grafica del powerUp Masacrality
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUpGrafico;

import javax.swing.ImageIcon;

public class MasacralityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public MasacralityGrafico(int x, int y) {
		super(x, y);
	}
	
	public MasacralityGrafico(){
		super(0,0);
		
	}
	
	/**
	 * Muestra el powerUp en el mapa
	 */
	public void mostrar() {
		imagen = new ImageIcon(getClass().getResource("/Imagenes/masacrality.png"));
		repaint();
		
	}

}
