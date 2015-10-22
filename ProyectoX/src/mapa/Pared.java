package mapa;
import Bomba.Bomba;
import PowerUp.*;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;

public class Pared implements EstadoCelda {
	protected EstadoGrafico eg;
	public Pared(){
		eg=new ParedGrafico();
	}
	public EstadoGrafico getEntidadGrafica(){
		return eg;
	}
	public boolean serAvanzado(Bomberman b,PowerUp p, Celda c){
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
