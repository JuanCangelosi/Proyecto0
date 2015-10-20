package Personajes;

import Bomba.*;
import Logica.*;

public class Bomberman extends Personaje {
	// Atributos de Instancia
	private AbstractFactory a;
	protected int cantBombas;

	// Constructor
	public Bomberman(Celda c) {
		super(c);
		velocidad = 3;
		especial = false;
		cantBombas = 1;
	}

	// Metodos
	public void setVelocidad(int n) {
		velocidad = n;
	}

	public void ponerEspecial(Boolean b) {
		especial = b;
	}

	public void setCantBombas(int n) {
		cantBombas = n;
	}

	public void morir() {
		muerto = true;
	}

	public void arriba() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y + 1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	public void abajo() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x, y - 1);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	public void izquierda() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x - 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	public void derecha() {
		int x, y;
		x = celda.getPosX();
		y = celda.getPosY();
		Celda c = celda.getMapa().getCelda(x + 1, y);
		celda.ocuparBomberMan(null);
		c.ocuparBomberMan(this);
	}

	// Consultas
	public Bomba colocarBomba() {
		if (a.cantBombas() < cantBombas)
			return a.darBomba(celda);
		else
			return null;
	}

	public int cantBombas() {
		return cantBombas;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public AbstractFactory fabrica() {
		return a;
	}

}
