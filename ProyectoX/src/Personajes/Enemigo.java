/**
 * Es la clase abstracta que engloba todo lo que los enemigos disponene para hacer
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import Grafica.BombermanGrafico;
import mapa.Celda;

public abstract class Enemigo extends Personaje implements Runnable {
	// Atributos de Instancia
	protected int puntaje;

	// Constructor
	protected Enemigo(Celda c) {
		super(c);
		p=new EnemigoGrafico(celda.getPosX()*32,celda.getPosY()*32);
	}

	// Metodos Abstractos

	/**
	 * Describe el comportamiento del enemigo, en relacion a sus movimientos y
	 * ataques
	 */
	public abstract void run();

	// Metodos

	/**
	 * Libera la celda actual y ocupa la siguiente con Enemigo
	 */
	protected boolean ocupar(Celda c) {
		celda.setEnemigo(null);
		if (c.avanzar(this))
			return true;
		else
			return false;
	}

	// Consultas
	/**
	 * Establece al enemigo como muerto
	 * 
	 * @return retorna el puntaje que el enemigo posee al morir
	 */
	public int morir() {
		muerto = true;
		Thread.interrupted();
		return puntaje;
	}
}
