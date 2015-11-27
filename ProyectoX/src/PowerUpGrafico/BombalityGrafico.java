/**
 * Implementacion grafica del powerUp Bombality
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package PowerUpGrafico;


import javax.swing.ImageIcon;

public class BombalityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;
	
	public BombalityGrafico(int x, int y) {
		super(x, y);
	}
	
	public BombalityGrafico(){
		super(0,0);
		
	}
	
	/**
	 * Muestra el powerUp en el mapa
	 */
	public void mostrar() {
		imagen = new ImageIcon(getClass().getResource("/Imagenes/bombality.png"));	
		repaint();
		
	}

}
