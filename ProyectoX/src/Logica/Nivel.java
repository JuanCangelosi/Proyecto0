package Logica;

import Personajes.*;

public class Nivel {
	protected int tiempo;
	protected int puntaje;
	protected Bomberman bomberman;
	protected Enemigo[] enemigos;
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

	public void eliminarEnemigo() {
		for (int i = 0; i < enemigos.length; i++) {
			if (enemigos[i] != null) {
				if (enemigos[i].murio() == true) {
					enemigos[i] = null;
				}
			}
		}
	}

	public Mapa getMapa() {
		return mapa;
	}

	public boolean gano() {
		return enemigos.size == 0;/* Ojo que asi no gana el bomberman! */
	}

}
