/**
 * Implementacion grafica del powerUp SpeedUp
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUpGrafico;

import javax.swing.ImageIcon;

public class SpeedUpGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public SpeedUpGrafico(int x, int y) {
		super(x, y);
	}
	
	public SpeedUpGrafico(){
		super(0,0);
		
	}
	
	/**
	 * Muestra el powerUp en el mapa
	 */
	public void mostrar(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/speedup.png"));	
		repaint();	
		
	}

}
