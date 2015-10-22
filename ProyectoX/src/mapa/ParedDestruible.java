package mapa;

import Bomba.Bomba;
import Personajes.*;
import PowerUp.*;
import Grafica.*;

public class ParedDestruible implements EstadoCelda {
	protected EstadoGrafico eg;
	
	public ParedDestruible(){
		eg=new ParedDestruibleGrafico();
	}
	public EstadoGrafico getEntidadGrafica(){
		return eg;
	}
	public boolean serAvanzado(Bomberman b,PowerUp p, Celda c){
		boolean exito=false;
		if(b.esEspecial()){
			exito=c.setBomberman(b);
		}
		return exito;
	}
	public boolean serAvanzado(Enemigo e, Celda c){
		boolean exito=false;
		if(e.esEspecial()){
			exito=c.setEnemigo(e);
		}
		return exito;
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
