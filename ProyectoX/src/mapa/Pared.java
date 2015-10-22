package mapa;
import Bomba.Bomba;
import Grafica.EntidadGrafica;
import Personajes.*;
import PowerUp.PowerUp;

public class Pared implements EstadoCelda {
	protected EntidadGrafica eg;
	public Pared(){
		eg=new ParedGrafica();
	}
	public EntidadGrafica getEntidadGrafica(){
		return eg;
	}
	public boolean serAvanzado(Bomberman b, Celda c){
		return false;
	}
	public boolean serAvanzado(Enemigo e, Celda c){
		return false;
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
