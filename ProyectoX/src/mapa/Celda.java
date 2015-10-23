package mapa;

import Bomba.*;
import Grafica.*;
import Personajes.*;
import PowerUp.PowerUp;

/**
 * Clase celda define los comportamientos de las celdas del mapa del juego.
 */
public class Celda {
	// atributos de instancia
	protected int posX;
	protected int posY;
	protected EstadoCelda estado;
	protected Bomberman bomberM;
	protected Bomba b;
	protected Enemigo e;
	protected Mapa m;
	protected PowerUp p;
	protected EstadoGrafico estadog;

	// constructor
	/**
	 * Crea una nueva celda con un estado e, un mapa m y sus coordenadas X e Y
	 */

	public Celda(EstadoCelda es, Mapa map, int x, int y) {
		m = map;
		bomberM = null;
		e = null;
		b = null;
		posX = x;
		posY = y;
		estado = es;
		estadog = new EstadoGrafico(posY * 32, posX * 32);
		estado.setImagen(estadog);
	}

	/**
	 * Retorna el powerUp asociado a la celda, en caso de no poseer ninguno
	 * retorna nulo
	 */

	public PowerUp getPowerUp() {
		return p;
	}

	/**
	 * Retorna el bomberMan que ocupa la celda, en caso de poseer retorna nulo
	 */
	public Bomberman getBomberMan() {
		return bomberM;
	}

	/**
	 * Retorna el Enemigo que ocupa la celda, en caso de poseer retorna nulo
	 */
	public Enemigo getEnemigo() {
		return e;
	}

	/**
	 * Retorna la posicion X de la celda
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Retorna la posicion Y de la celda
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Setea, de ser posible a bomberman en la celda, liberando la celda en la
	 * que estaba antes Si bm es nulo, entonces libera la celda.
	 */
	public void setBomberman(Bomberman bm) {
		if (bm == null) {
			bomberM = null;
		} else {
			if (e != null) {
				bm.morir();
			}
				if (bm.getCelda() != null)
					bm.getCelda().setBomberman(null);
				bomberM = bm;
				bomberM.setCelda(this);
		}
	}

	/**
	 * Intenta que bomberman avance la celda basandose en su estado.
	 */

	public void avanzar(Bomberman bm,int n) {
		estado.serAvanzado(bm, p, this, n);
	}

	/**
	 * Setea, de ser posible al enemigo en la celda, liberando la celda en la
	 * que estaba antes Si bm es nulo, entonces libera la celda.
	 */
	public void setEnemigo(Enemigo enem) {
		if (enem == null) {
			e = null;
		} else {
			if (bomberM != null) {
				bomberM.morir();
			}
				e = enem;
				enem.setCelda(this);
			}
		}

	/**
	 * Intenta que el enemigo avance la celda basandose en su estado.
	 */

	public void avanzar(Enemigo enem,int n) {
		estado.serAvanzado(enem, this, n);
	}

	/**
	 * Intenta colocar la bomba en la celda, controlando que no haya una bomba
	 * en la misma y que la celda sea piso
	 */

	public void ponerBomba(Bomba bomb) {
		if (b == null)
			estado.ocuparBomba(bomb, this);
	}

	/**
	 * Coloca la bomba en la celda
	 */

	public void setBomba(Bomba bomb) {
		b = bomb;
	}

	/**
	 * Agrega un powerup a la celda
	 */
	public void setPowerUp(PowerUp p) {
		this.p = p;
	}

	/**
	 * La celda recibe un mensaje de explosion, matando a todo personaje de la
	 * celda, liberando la bomba y enviando los mensajes explosion a las celdas
	 * adyacentes. Retorna el puntaje obtenido de la explosion.
	 */
	public int explotarBomba() {
		int puntaje = 0;
		int radio = b.getRadio();
		b = null;
		puntaje += estado.destruir(this);
		if (e != null)
			puntaje += e.morir();
		if (bomberM != null)
			bomberM.morir();
		puntaje += m.getCelda(posX+1, posY).explosion(radio,0);
		puntaje += m.getCelda(posX-1, posY).explosion(radio,1);
		puntaje += m.getCelda(posX, posY-1).explosion(radio,2);
		puntaje += m.getCelda(posX, posY+1).explosion(radio,3);
		return puntaje;
	}
	public int explosion(int r, int pos){
		int puntaje = 0;
		if (e != null)
			puntaje += e.morir();
		if (bomberM != null)
			bomberM.morir();
		puntaje+=estado.explosion(this, r,pos);
		return puntaje;
	}

	/**
	 * Retorna el mapa asociado a la celda
	 */

	public Mapa getMapa() {
		return m;
	}

	public EstadoGrafico getEntidadGrafica() {
		return estadog;
	}

	public void mostrarPowerUp() {
		estadog.mostrarPowerUp(p.getEntidadGrafica());
	}
	public void setEstado(EstadoCelda est){
		estado=est;
	}
	
	public Bomba getBomba(){
		return b;
	}
}