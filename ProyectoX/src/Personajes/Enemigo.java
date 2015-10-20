package Personajes;

import InteligenciaArtificial.IA;
import Logica.Celda;

public abstract class Enemigo extends Personaje implements IA {
	// Atributos de Instancia
	protected int puntaje;

	// Constructor
	protected Enemigo(Celda c) {
		super(c);
	}

	// Metodos Abstractos
	public abstract int morir();

	public abstract void loop();

	// Metodos
	public void arriba() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y + 1);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	public void abajo() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y - 1);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	public void izquierda() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x - 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}

	public void derecha() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x + 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparEnemigo(this);
	}
}
