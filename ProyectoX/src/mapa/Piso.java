package mapa;
import Bomba.Bomba;
import Grafica.EntidadGrafica;
import Personajes.*;
import PowerUp.PowerUp;

public class Piso implements EstadoCelda {
	public Piso(){
		eg=new PisoGrafico();
	}
	public EntidadGrafica getEntidadGrafica(){
		return eg;
	}
	public int destruir(Celda c){
		return 0;
	}
	public boolean serAvanzado(Bomberman b, Celda c){
		return true && c.setBomberman(b);
	}
	public boolean serAvanzado(Enemigo e, Celda c){
		return true && c.setEnemigo(e);
	}
	public void ocuparBomba(Bomba b,Celda c){
		c.setBomba(b);
		b.activar();
	}
	public int explosionArriba(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX()+1,c.getPosY()).explosionArriba(r-1);
		else return 0;
	}
	public int explosionAbajo(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX()-1,c.getPosY()).explosionAbajo(r-1);
		else return 0;
	}
	public int explosionIzq(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX(),c.getPosY()-1).explosionIzq(r-1);
		else return 0;
	}
	public int explosionDer(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX(),c.getPosY()+1).explosionDer(r-1);
		else return 0;
	}
}
