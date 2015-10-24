package mapa;

import Personajes.*;
/**
 * Clase nivel representa el nivel en que se esta jugando.
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Nivel {
	protected int tiempo;
	protected int puntaje;
	
	protected Mapa mapa;

	public Nivel() {
		mapa = new Mapa();
		
		puntaje=0;
		
	}

	public void sumarPuntaje(int n) {
		puntaje += n;
	}

	public Mapa getMapa() {
		return mapa;
	}
	public boolean gano() {
		return mapa.getCantParedesDest()==0;
	}
}
