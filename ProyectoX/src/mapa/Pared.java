package mapa;
import Bomba.Bomba;
import Personajes.*;
import PowerUp.PowerUp;

public class Pared implements EstadoCelda {	
	public void serAvanzado(Bomberman b, Celda c){
	}
	public void serAvanzado(Enemigo e, Celda c){
	}
	public int destruir(Celda c){
		return 0;
	}
	public void ocuparBomba(Bomba b,Celda c){
	}
	public int explosionArriba(Celda c,int r){
		return 0;
	}
	public int explosionAbajo(Celda c,int r){
		return 0;
	}
	public int explosionIzq(Celda c,int r){
		return 0;
	}
	public int explosionDer(Celda c,int r){
		return 0;
	}

}
