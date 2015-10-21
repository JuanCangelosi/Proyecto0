package mapa;
import Bomba.*;
import Personajes.*;
import PowerUp.PowerUp;
/**
 * Clase celda define los comportamientos de las celdas del mapa del juego.
 */
public class Celda {
	//atributos de instancia
	protected int posX;
	protected int posY;
	protected EstadoCelda estado;
	protected Bomberman bomberM;
	protected Bomba b;
	protected Enemigo e;
	protected Mapa m;
	protected PowerUp p;
	//constructor
	/**
	 * Crea una nueva celda con un estado e, un mapa m y sus coordenadas X e Y
	 */
	
	public Celda(EstadoCelda es, Mapa map,int x, int y){
		m=map;
		bomberM=null;
		e=null;
		b=null;
		posX=x;
		posY=y;
		estado=es;
	}
	/**
	 * Retorna el powerUp asociado a la celda, en caso de no poseer ninguno retorna nulo
	 */
	
	public PowerUp getPowerUp(){
		return p;
	}
	/**
	 * Retorna el bomberMan que ocupa la celda, en caso de poseer retorna nulo
	 */
	public Bomberman getBomberMan(){
		return bomberM;
	}
	/**
	 * Retorna el Enemigo que ocupa la celda, en caso de poseer retorna nulo
	 */
	public Enemigo getEnemigo(){
		return e;
	}
	/**
	 * Retorna la posicion X de la celda
	 */
	public int getPosX(){
		return posX;
	}
	/**
	 * Retorna la posicion Y de la celda
	 */
	public int getPosY(){
		return posY;
	}
	
	/**
	 * Setea, de ser posible a bomberman en la celda, liberando la celda en la que estaba antes
	 * Si bm es nulo, entonces libera la celda.
	 */
	public void setBomberman(Bomberman bm){
		if(bm==null){
			bomberM=null;
		}
		else{
			if(e!=null){
				bm.morir();
			}
			if(b!=null){
				bm.getCelda().setBomberman(null);
				bomberM=bm;
				bomberM.setCelda(this);
			}
		}
	}
	/**
	 * Intenta que bomberman avance la celda basandose en su estado.
	 */
	
	public void avanzar(Bomberman bm){
		estado.serAvanzado(bm, this);
	}
	/**
	 * Setea, de ser posible al enemigo en la celda, liberando la celda en la que estaba antes
	 * Si bm es nulo, entonces libera la celda.
	 */
	public void setEnemigo(Enemigo enem){
		if(enem==null){
			e=null;
		}
		else{
			if(bomberM!=null){
				bomberM.morir();
			}
			if(e!=null && b!=null){
				enem.getCelda().setEnemigo(null);
				e=enem;
				enem.setCelda(this);
			}
		}
	}
	/**
	 * Intenta que el enemigo avance la celda basandose en su estado.
	 */
	
	public void avanzar(Enemigo enem){
		estado.serAvanzado(enem, this);
	}
	/**
	 * Intenta colocar la bomba en la celda, controlando que no haya una bomba en la misma y que la celda sea 
	 * piso
	 */
	
	public void ponerBomba(Bomba bomb){
		if(b!=null)
		estado.ocuparBomba(bomb,this);
	}
	/**
	 * Coloca la bomba en la celda
	 */
	
	public void setBomba(Bomba bomb){
		b=bomb;
	}
	/**
	 * Agrega un powerup a la celda
	 */
	public void setPowerUp(PowerUp p){
		this.p=p;
	}
	/**
	 * La celda recibe un mensaje de explosion, lo cual mata a cualquier personaje de la celda y retorna el 
	 * puntaje de las explosiones
	 */
	public int explotarBomba(){
		int puntaje=0;
		b=null;
		puntaje=estado.destruir(b.getRadio(), b.getRadio(), b.getRadio(), b.getRadio(), this);
		return puntaje;
	}
	public int explosion(int arriba, int abajo, int izq, int der){
		int puntaje=0;
		if(e!=null){
			puntaje+=e.morir();
		}
		if(bomberM!=null){
			bomberM.morir();
		}
		return puntaje+estado.destruir(arriba, abajo, izq, der,this);
	}
	/**
	 * Retorna el mapa asociado a la celda
	 */
	
	public Mapa getMapa(){
		return m;
	}
	/**
	 * Setea el estado de la celda.
	 */
	
	public void setEstado(EstadoCelda est){
		estado=est;
	}
}