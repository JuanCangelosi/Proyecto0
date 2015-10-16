package Logica;

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
	
	public BomberMan getBomberMan(){
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
	
	public void ocuparBomberMan(BomberMan bm){
		if(estado.serAvanzado(bm)){
			bomberM=bm;
			bomberM.setCelda(this);
		}
	}
	public void ocuparEnemigo(Enemigo enem){
		
		if(estado.setAvanzado(enem)){
			if(bomberM!=null){
				bomberM.morir();
			}
			e=enem;
			e.setCelda(this);
		}
	}
	public void setBomba(Bomba bomb){
		if(b==null && ){
			b=bomb;
			b.setCelda(this);
		}
	}
	public void explosion(){
		
	}
	
	public Mapa getMapa(){
		return mapa;
	}
}