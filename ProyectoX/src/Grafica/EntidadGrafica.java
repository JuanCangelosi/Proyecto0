/**
 * Abstraccion grafica de los personajes del mapa
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Grafica;

import java.awt.Container;

import javax.swing.JComponent;
import javax.swing.JLayeredPane;


public abstract class EntidadGrafica extends JComponent{
	
	private static final long serialVersionUID = 1L;
	protected final int width = 32;
	protected final int height = 32;
	protected int velocidad;
	protected int x,y;
	protected JLayeredPane  container;
	
	protected EntidadGrafica(int x, int y) {
		this.x = x;
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	/**
	 * Setea la posicion X del personaje grafico
	 * @param x el nuevo valor X del personaje en el mapa
	 */
	public void setX(int x){
		this.x = x;
		setBounds(x,y,width,height);
		
	}
	
	/**
	 * Setea la posicion Y del personaje grafico
	 * @param y el nuevo valor Y del personaje en el mapa
	 */
	public void setY(int y){
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	/**
	 * Almacena el contenedor del Frame en el personaje
	 * @param c es el contenedor del Juego
	 */
	public void setContainer(Container c){
		container = (JLayeredPane) c;
	}
	
	/**
	 * Devuelve el contenedor del Juego
	 * @return el contenedor del Frame
	 */
	public JLayeredPane getContainer(){
		return container;
	}
	
	/**
	 * Elimina al personaje grafico del mapa
	 */
	public void eliminar(){
		setVisible(false);
		container.remove(this);
	}

}
