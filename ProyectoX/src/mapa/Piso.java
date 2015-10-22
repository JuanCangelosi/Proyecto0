package mapa;
import Bomba.Bomba;
import PowerUp.*;
import Grafica.EntidadGrafica;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;

public class Piso implements EstadoCelda {
	protected EstadoGrafico eg;
	public Piso(){
		eg=new PisoGrafico();
	}
	public EstadoGrafico getEntidadGrafica(){
		return eg;
	}
	public int destruir(Celda c){
		return 0;
	}
	public boolean serAvanzado(Bomberman b,PowerUp p, Celda c){
		boolean exito=c.setBomberman(b);
		if(exito){
			p.dar(b);
			c.setPowerUp(null);
		}
		return exito;
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
