package Bomba;

import Logica.*;

public class Bomba {
	// Atributos de Instancia
	protected int radio;
	protected Celda c;

	// Constructor
	public Bomba(Celda celda) {
		c = celda;
		radio = 1;
	}

	// Metodos
	public void setRadio(int i) {
		radio = i;
	}

	// Consultas
	public int explotar() {
		int puntaje = 0;
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

	public int getRadio() {
		return radio;
	}

	public Celda getCelda() {
		return c;
	}

}