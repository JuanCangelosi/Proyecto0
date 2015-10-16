package Logica;
import bomba.*;
import Personajes.*;

public class Celda {
	protected int posX;
	protected int posY;
	protected EstadoCelda estado;
	protected Bomberman bomberM;
	protected Bomba b;
	protected Enemigo e;
	protected Mapa m;
	protected PowerUp p;
	
	public Celda(EstadoCelda e, Mapa map,int x, int y){
		m=map;
		bomberM=null;
		e=null;
		b=null;
		posX=x;
		posY=y;
		estado=e;
	}
	
	public PowerUp getPowerUp(){
		return p;
	}
	
	public Bomberman getBomberMan(){
		return bomberM;
	}
	
	public Enemigo getEnemigo(){
		return e;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void ocuparBomberMan(Bomberman bm){
		if(bm==null){
			bomberM=null;
		}
		else{
			if(estado.serAvanzado(bm) && b==null){
				if(e==null){
					bomberM=bm;
					bomberM.setCelda(this);
				}
				else{
					bomberM.morir();
				}
			}
		}
	}
	public void ocuparEnemigo(Enemigo enem){
		if(enem==null){
			e=null;
		}
		else{
			if(estado.setAvanzado(enem) && e==null && b==null ){
				if(bomberM!=null){
					bomberM.morir();
				}
				e=enem;
				e.setCelda(this);
			}
		}
	}
	public void setBomba(Bomba bomb){
		if(b==null && e==null){
			b=bomb;
			b.setCelda(this);
		}
	}
	public void setPowerUp(PowerUp p){
		this.p=p;
	}
	public void explosion(){
		
	}
	
	public Mapa getMapa(){
		return m;
	}
}