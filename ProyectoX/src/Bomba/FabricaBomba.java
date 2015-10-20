/**
 * Implementa la interfaz AbstractFactory y reproduce el patron mismo, 
 * ofreciendole bombas a los personajes de manera anonima
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Bomba;

import mapa.Celda;

public class FabricaBomba implements AbstractFactory {
	// Atributos de Intancia
	protected int radio;
	protected int cantBombas;

	// Constructor
	public FabricaBomba() {
		radio = 1;
		cantBombas = 0;
	}

	// Metodos

	/**
	 * Duplica el valor del radio de la bomba
	 */
	public void duplicar() {
		radio *= 2;
	}

	/**
	 * Disminuje en uno la cantidad de bombas colocadas, uso exclusivo de la
	 * bomba cada vez que explote
	 */
	public void bombaMenos() {
		cantBombas--;
	}

	// Consultas

	/**
	 * crea un objeto Bomba y se lo retorna al Personaje
	 * 
	 * @param c
	 *            es la celda en la cual se va colocar la bombar
	 * @return retorna una bomba, colocada en la celda
	 */
	public Bomba darBomba(Celda c) {
		Bomba b = new Bomba(c,this);
		cantBombas++;
		b.setRadio(radio);
		return b;
	}

	/**
	 * Devuelve la cantidad de bombas en el mapa que no han explotado
	 * 
	 * @return Devuelve la cantidad de bombas colocadas
	 */
	public int cantBombas() {
		return cantBombas;
	}
}
