/**
 * Implementacion grafica del powerUp
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PowerUpGrafico;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import Grafica.EntidadGrafica;

public abstract class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen;
	protected boolean agarrado;
	protected int posicion;


	public PowerupGrafico(int x, int y) {
		super(x, y);
		imagen = null;
		agarrado = false;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(imagen!=null && agarrado){
			setBounds(90+(posicion*32),425,width,height);
			g.drawImage(imagen.getImage(), 0, 0, this);
		}
		else if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}
	
	/**
	 * Indica que el powerUp fue agarrado
	 * @param agarrado indica que el powerUp fue agarrado
	 */
	public void setAgarrado(boolean agarrado){
		this.agarrado = agarrado;
	}
	
	/**
	 * Setea posicion en el panel
	 * @param n posicion en el panel
	 */
	public void setPosicion(int n){
		posicion= n;
	}
	
	/**
	 * Muestra el powerUp en el mapa
	 */
	public abstract void mostrar();
}
