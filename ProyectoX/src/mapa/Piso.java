package mapa;
import Bomba.Bomba;
import Personajes.*;

public class Piso implements EstadoCelda {
	public int destruir(int arriba, int abajo, int izq, int der, Celda c){
		c.setEstado(new Piso());
		return c.explosion(arriba-1,abajo-1,izq-1,der-1);
	}
	public void serAvanzado(Bomberman b, Celda c){
		c.setBomberman(b);
	}
	public void serAvanzado(Enemigo e, Celda c){
		c.setEnemigo(e);
	}
	public void ocuparBomba(Bomba b,Celda c){
		c.setBomba(b);
		b.activar();
	}
}
