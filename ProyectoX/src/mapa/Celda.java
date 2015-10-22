package mapa;
import Bomba.*;
import Grafica.*;
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
	protected EstadoGrafico estadog;
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
		es.getEntidadGrafica().setX(posX*32);
		es.getEntidadGrafica().setY(posY*32);
		estadog=new EstadoGrafico(posX,posY);
		estado.setImagen(estadog);
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
	public boolean setBomberman(Bomberman bm){
		boolean exito=false;
		if(bm==null){
			bomberM=null;
		}
		else{
			if(e!=null){
				bm.morir();
			}
			if(b!=null){
				if(bm.getCelda()!=null)
					bm.getCelda().setBomberman(null);
				bomberM=bm;
				bomberM.setCelda(this);
				exito=true;
			}
		}
		return exito;
	}
	/**
	 * Intenta que bomberman avance la celda basandose en su estado.
	 */
	
	public boolean avanzar(Bomberman bm){
		return estado.serAvanzado(bm,p, this);
	}
	/**
	 * Setea, de ser posible al enemigo en la celda, liberando la celda en la que estaba antes
	 * Si bm es nulo, entonces libera la celda.
	 */
	public boolean setEnemigo(Enemigo enem){
		boolean exito=false;
		if(enem==null){
			e=null;
		}
		else{
			if(bomberM!=null){
				bomberM.morir();
			}
			if(e!=null && b!=null){
				if(enem.getCelda()!=null)
					enem.getCelda().setEnemigo(null);
				e=enem;
				enem.setCelda(this);
				exito=true;
			}
		}
		return exito;
	}
	
	/**
	 * Intenta que el enemigo avance la celda basandose en su estado.
	 */
	
	public boolean avanzar(Enemigo enem){
		return estado.serAvanzado(enem, this);
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
	 * La celda recibe un mensaje de explosion, matando a todo personaje de la celda, liberando la bomba y
	 * enviando los mensajes explosion a las celdas adyacentes. Retorna el puntaje obtenido de la explosion.
	 */
	public int explotarBomba(){
		int puntaje=0;
		int radio=b.getRadio();
		b=null;
		puntaje+=estado.destruir(this);
		if(e!=null)
			puntaje+=e.morir();
		if(bomberM!=null)
			bomberM.morir();
		puntaje+=m.getCelda(posX,posY+1).explosionArriba(radio);
		puntaje+=m.getCelda(posX,posY-1).explosionAbajo(radio);
		puntaje+=m.getCelda(posX-1,posY).explosionIzq(radio);
		puntaje+=m.getCelda(posX+1,posY).explosionDer(radio);
		return puntaje;
	}
	/**
	 * Mata a todos los personajes de la celda y luego se chequea el estado para enviar el mensaje a las celdas
	 * adyacentes
	 */
	public int explosionArriba(int r){
		int puntaje=0;
		if(e!=null)
			puntaje+=e.morir();
		if(bomberM!=null)
			bomberM.morir();
		return puntaje+estado.explosionArriba(this,r);
	}
	/**
	 * Mata a todos los personajes de la celda y luego se chequea el estado para enviar el mensaje a las celdas
	 * adyacentes
	 */
	public int explosionAbajo(int r){
		int puntaje=0;
		if(e!=null)
			puntaje+=e.morir();
		if(bomberM!=null)
			bomberM.morir();
		return puntaje+estado.explosionAbajo(this,r);
	}
	/**
	 * Mata a todos los personajes de la celda y luego se chequea el estado para enviar el mensaje a las celdas
	 * adyacentes
	 */
	public int explosionIzq(int r){
		int puntaje=0;
		if(e!=null)
			puntaje+=e.morir();
		if(bomberM!=null)
			bomberM.morir();
		return puntaje+estado.explosionIzq(this,r);
	}
	/**
	 * Mata a todos los personajes de la celda y luego se chequea el estado para enviar el mensaje a las celdas
	 * adyacentes
	 */
	public int explosionDer(int r){
		int puntaje=0;
		if(e!=null)
			puntaje+=e.morir();
		if(bomberM!=null)
			bomberM.morir();
		return puntaje+estado.explosionDer(this,r);
	}
	/**
	 * Retorna el mapa asociado a la celda
	 */
	
	public Mapa getMapa(){
		return m;
	}
	
	public EntidadGrafica getEntidadGrafica(){
		return estado.getEntidadGrafica();
	}
	public void mostrarPowerUp(){
		estado.mostrarPowerUp(p.getEntidadGrafica());
	}
}