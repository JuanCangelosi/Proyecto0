package Personajes;

import Logica.*;

public abstract class Personaje {
	// Atributos de Instancia
	protected int velocidad;
	protected boolean muerto;
	protected boolean especial;
	protected Celda celda;

	// Constructor
	protected Personaje(Celda c) {
		celda = c;
		muerto = false;
	}

	// Metodos abstractos
	public abstract void arriba();

	public abstract void abajo();

	public abstract void izquierda();

	public abstract void derecha();

	// Metodos
	public void setCelda(Celda c) {
		celda = c;
	}

	// Consultas
	public Celda getCelda() {
		return celda;
	}

	public boolean murio() {
		return muerto;
	}

	public boolean esEspecial() {
		return especial;
	}
}
