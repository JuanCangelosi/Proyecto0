package mapa;

import Personajes.*;
/**
 * Clase nivel representa el nivel en que se esta jugando.
 */
public class Nivel {
	protected int tiempo;
	protected int puntaje;
	protected Bomberman bomberman;
	protected Mapa mapa;

	public Nivel() {
		mapa = new Mapa();
		bomberman=new Bomberman(mapa.getCelda(1,1));
		mapa.getCelda(1,1).setBomberman(bomberman);
		puntaje=0;
		
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
	public boolean gano() {
		return mapa.getCantParedesDest()==0;
	}
}
