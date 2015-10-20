package mapa;

import Bomba.Bomba;
import Personajes.*;

public class ParedDestruible implements EstadoCelda {
	public void serAvanzado(Bomberman b, Celda c){
		if(b.esEspecial())
		c.setBomberman(b);
	}
	public void serAvanzado(Enemigo e, Celda c){
		if(e.esEspecial())
		c.setEnemigo(e);
	}
	public int destruir(int arriba, int abajo, int izq, int der, Celda c){
		c.setEstado(new Piso());
		int puntaje=10;
		return puntaje+c.explosion(arriba-1,abajo-1,izq-1,der-1);
	}
	public void ocuparBomba(Bomba b,Celda c){
	}

}
