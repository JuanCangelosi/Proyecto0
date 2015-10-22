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
		return 10;
	}
	public void ocuparBomba(Bomba b,Celda c){
	}
	public int explosionArriba(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX()+1,c.getPosY()).explosionArriba(r-1);
		else return punt;
	}
	public int explosionAbajo(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX()-1,c.getPosY()).explosionAbajo(r-1);
		else return punt;
	}
	public int explosionIzq(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX(),c.getPosY()-1).explosionIzq(r-1);
		else return punt;
	}
	public int explosionDer(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX(),c.getPosY()+1).explosionDer(r-1);
		else return punt;
	}

}
