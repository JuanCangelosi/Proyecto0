/**
 * Es la clase abstracta que engloba todo lo que los enemigos disponene para hacer
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import Threads.*;
import mapa.Celda;

public abstract class Enemigo extends Personaje{
	// Atributos de Instancia
	protected int puntaje;
	protected ThreadEnemigo t;

	// Constructor
	protected Enemigo(Celda c) {
		super(c);
		t=new ThreadEnemigo(this);
	}

	// Metodos Abstractos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public abstract void loop();

	// Metodos

	/**
	 * Libera la celda actual y ocupa la siguiente con Enemigo
	 */
	protected void ocupar(Celda c, int n) {
		c.avanzar(this,n);
	}

	// Consultas
	/**
	 * Establece al enemigo como muerto
	 * 
	 * @return retorna el puntaje que el enemigo posee al morir
	 */
	public int morir() {
		muerto = true;
		t.detener();
		celda.setEnemigo(null);
		return puntaje;
	}
	
	/**
	 * retorna el thread para ser activado cuando se inicia el mapa
	 * @return retorna el thread del enemigo
	 */
	public Thread darThread(){
		return t;
	}
}
