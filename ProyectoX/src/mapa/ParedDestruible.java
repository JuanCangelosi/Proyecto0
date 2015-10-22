package mapa;

import Bomba.Bomba;
import Personajes.*;
import PowerUp.PowerUp;

public class ParedDestruible implements EstadoCelda {
	public void serAvanzado(Bomberman b, Celda c){
		if(b.esEspecial())
		c.setBomberman(b);
	}
	public void serAvanzado(Enemigo e, Celda c){
		if(e.esEspecial())
		c.setEnemigo(e);
	}
	public int destruir(Celda c){
		c.setEstado(new Piso());
		int puntaje=10;
		return puntaje+c.explosion();
	}
	public void ocuparBomba(Bomba b,Celda c){
	}

}
