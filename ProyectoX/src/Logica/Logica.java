/**
 * Control logico del juego, administracion de la coordinacion grafica-logica
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package Logica;
import mapa.Nivel;
import Grafica.Juego;

public class Logica {
	
	protected Nivel nivel;
	protected Juego gui;
	
	/**
	 * Inicializa la logica recibiendo como parametro la gui, colocando las entidades graficas de las celdas en 
	 * la misma
	 *  @param gui el panel donde se colocaran las entidades graficas
	 */
	public Logica(Juego gui){
		nivel=new Nivel(this);
		this.gui = gui;
		
		for(int i=0; i< 13; i++){
			for(int j=0; j<31; j++){
				gui.getContentPane().add(nivel.getMapa().getCelda(i, j).getEntidadGrafica(),new Integer(1));
				nivel.getMapa().getCelda(i, j).getEntidadGrafica().setContainer(gui.getContentPane());
				if(nivel.getMapa().getCelda(i, j).getPowerUp()!=null){
					
					nivel.getMapa().getCelda(i, j).getPowerUp().getEntidadGrafica().setX(j*32);
					nivel.getMapa().getCelda(i, j).getPowerUp().getEntidadGrafica().setY(i*32);
					
					gui.getContentPane().add(nivel.getMapa().getCelda(i, j).getPowerUp().getEntidadGrafica(),new Integer(2));
					nivel.getMapa().getCelda(i, j).getPowerUp().getEntidadGrafica().setContainer(gui.getContentPane());
				}
			}
		}
		
		gui.getContentPane().add(nivel.getMapa().getHeroe().grafico(),new Integer(4));
		nivel.getMapa().getHeroe().grafico().setContainer(gui.getContentPane());
		
		for(int i=0; i<6; i++){
			gui.getContentPane().add(nivel.getMapa().getEnemigo(i).grafico(), new Integer(3));
			nivel.getMapa().getEnemigo(i).grafico().setContainer(gui.getContentPane());
		}
		
		
				
	}
	/**
	 *Devuelve el nivel actual
	 *@return el nivel que se creo
	 */
	public Nivel getNivel(){
		return nivel;
	}
	public void actualizarPuntaje(){
		gui.getPanel().setPuntaje(nivel.getPuntaje());
	}
	/**
	 * Decide si el juego termino
	 * @return true si bomberman murio y false caso contrario
	 */
	public void gameOver(){
		nivel.getMapa().limpiarMapa();
		gui.gameOver();
	}
	
	/**
	 * Retorna true si no hay mas paredes en el mapa
	 * @return true si no hay mas paredes en el mapa, false caso contrario
	 */
	public boolean gano() {
		return nivel.getMapa().getCantParedesDest()==0;
	}
}
