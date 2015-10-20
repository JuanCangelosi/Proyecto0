/**
 * Clase con el proposito de brindar un bomba capaz de destruir los enemigos del mapa
 * asi como de destruir las paredes que lo permitan
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Bomba;

import Logica.*;

public class Bomba {
	// Atributos de Instancia
	protected int radio;
	protected Celda c;
	protected AbstractFactory a;

	// Constructor
	public Bomba(Celda celda,AbstractFactory a) {
		this.a=a;
		c = celda;
		radio = 1;
	}

	// Metodos
	/**
	 * Permite modificar el radio de explosion de la bomba
	 * 
	 * @param i
	 *            es la nueva magnitud de la explosion de la bomba
	 */
	public void setRadio(int i) {
		radio = i;
	}

	// Consultas
	/**
	 * revisa celda a celda del mapa dentro del radio, destruye las
	 * destructibles y mata a los personajes de las transitables
	 * 
	 * @return retorna el puntaje obtenido de matar 0 o mas personajes
	 */
	public int explotar() {
		int puntaje = 0;
		a.bombaMenos();
		for (int i = 1; i <= radio; i++) {
			Celda c1 = c.getMapa().getCelda(c.getPosX() + i, c.getPosY());
			puntaje += c1.explosion();

			c1 = c.getMapa().getCelda(c.getPosX() - i, c.getPosY());
			puntaje += c1.explosion();

			c1 = c.getMapa().getCelda(c.getPosX(), c.getPosY() + i);
			puntaje += c1.explosion();

			c1 = c.getMapa().getCelda(c.getPosX(), c.getPosY() - i);
			puntaje += c1.explosion();
		}
		return puntaje;
	}

	/**
	 * Devuelve el radio de la bomba
	 * 
	 * @return retorna el radio de explosion de la bomba
	 */
	public int getRadio() {
		return radio;
	}

	/**
	 * Devuelve la celda en la cual la bomba esta colocada
	 * 
	 * @return retorna la celda donde se encuentra la bomba
	 */
	public Celda getCelda() {
		return c;
	}

}