package mapa;

import Personajes.*;

public class Nivel {
	protected int tiempo;
	protected int puntaje;
	protected Bomberman bomberman;
	protected Mapa mapa;

	public Nivel() {
		mapa = new Mapa();
	}

	public void sumarPuntaje(int n) {
		puntaje += n;
	}

	public Bomberman getHeroe() {
		return bomberman;
	}

	public Mapa getMapa() {
		return mapa;
	}
/*
	public boolean gano() {

	}
*/
}
