package mapa;
import Bomba.Bomba;
import Personajes.*;
import PowerUp.PowerUp;

public class Piso implements EstadoCelda {	
	public int destruir(Celda c){
		c.setEstado(new Piso());
		return c.explosion();
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
