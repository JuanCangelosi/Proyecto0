package Logica;
import Bomba.*;
import Personajes.*;
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
	
	public Celda(EstadoCelda e, Mapa map,int x, int y){
		m=map;
		bomberM=null;
		e=null;
		b=null;
		posX=x;
		posY=y;
		estado=e;
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
	 * Trata de ocupar la celda con el bomberman pasado por parametro,  esta operacion tendra exito solo si no
	 * hay enemigos (si hay enemigos en la celda bomberman morira),ni bombas en la celda y si la celda 
	 * puede ser avanzada por el bomberman, al avanzar el bomberman puede recibir un powerup si la celda 
	 * posee uno.
	 * Si bomberman es nulo se eliminar al bomberman actual de la celda.
	 */
	public void ocuparBomberMan(Bomberman bm){
		if(bm==null){
			bomberM=null;
		}
		else{
			if(estado.serAvanzado(bm) && b==null){
				if(e==null){
					bomberM=bm;
					if(p!=null){
						p.dar(bomberM);
					}
					bomberM.setCelda(this);
				}
				else{
					if(!bm.esEspecial())
					bm.morir();
				}
			}
		}
	}
	/**
	 * Trata de ocupar la celda con el enemigo pasado por parametro, esto solo tendra exito si no hay enemigos
	 * ocupando la celda,la celda es transitable y no hay bombas en la celda. Si hay un bomberman en la celda se lo matara.
	 * Si el enemigo pasado por parametro es nulo, se seteara el parametro enemigo de celda en nulo.
	 */
	public void ocuparEnemigo(Enemigo enem){
		if(enem==null){
			e=null;
		}
		else{
			if(estado.serAvanzado(enem) && e==null && b==null ){
				if(bomberM!=null && !bomberM.esEspecial()){
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
	public int explosion(){
		int puntaje=0;
		if (bomberM!=null){
			bomberM.morir();
		}
		if(e!=null){
			puntaje+=e.morir();
		}
		if(estado.destruir()){
			estado=new Piso();
			puntaje+=10;
		}
		return puntaje;
	}
	/**
	 * Retorna el mapa asociado a la celda
	 */
	
	public Mapa getMapa(){
		return m;
	}
}