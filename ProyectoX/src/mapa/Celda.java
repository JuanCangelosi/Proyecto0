package mapa;

import Bomba.*;
import Grafica.*;
import Personajes.*;
import PowerUp.PowerUp;

/**
 * Clase celda define los comportamientos de las celdas del mapa del juego.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes 
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
	 * @param es es el estado de la celda: piso, pared o pared destruible
	 * @param map es el mapa al que pertenece la celda
	 * @param x la posicion X de la celda en la matriz
	 * @param y la posicion Y de la celda en la matriz
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
	 * Retorna el powerUp asociado a la celda, en caso de no poseer ninguno retorna nulo
	 * @return null si celda no posee powerup y el powerup caso contrario.
	 */
	public PowerUp getPowerUp() {
		return p;
	}

	/**
	 * Retorna el bomberMan que ocupa la celda, en caso de poseer retorna nulo
	 * @return null si no hay un bomberman en la celda y el bomberman en caso contrario.
	 */
	public Bomberman getBomberMan() {
		return bomberM;
	}

	/**
	 * Retorna el Enemigo que ocupa la celda, en caso de poseer retorna nulo
	 * @return null si no hay enemigo en la celda, y el enemigo en caso contrario
	 */
	public Enemigo getEnemigo() {
		return e;
	}

	/**
	 * Retorna la posicion X de la celda
	 *  @return un entero que representa la posicion X
	 */
	public int getPosX() {
		return posX;
	}

	/**
	 * Retorna la posicion Y de la celda
	 * @return un entero que representa la posicion Y
	 */
	public int getPosY() {
		return posY;
	}

	/**
	 * Setea, de ser posible a bomberman en la celda, liberando la celda en la
	 * que estaba antes Si bm es nulo, entonces libera la celda.
	 * @param bm el bomberman que se desea setear en la celda
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
	 * @param bm Bomberman
	 * @param n es la direccion del movimiento; 0 para arriba, 1 para abajo, 2 para izquierda, 3 para derecha
	 */
	public void avanzar(Bomberman bm,int n) {
		estado.serAvanzado(bm, p, this, n);
	}

	/**
	 * Setea, de ser posible al enemigo en la celda, liberando la celda en la
	 * que estaba antes Si bm es nulo, entonces libera la celda.
	 * @param enem el enemigo que se desea setear en la celda.
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
	 * @param enem: el enemigo que desa avanzar
	 * @param n: la posicion de avance 0=arriba, 1=abajo, 2= izq, 3= der
	 */

	public void avanzar(Enemigo enem,int n) {
		estado.serAvanzado(enem, this, n);
	}

	/**
	 * Intenta colocar la bomba en la celda, controlando que no haya una bomba
	 * en la misma y que la celda sea piso
	 * @param bomb bomba que se desea setear en la celda
	 */

	public void ponerBomba(Bomba bomb) {
		if (b == null)
			estado.ocuparBomba(bomb, this);
	}

	
	/**
	 * Coloca la bomba en la celda
	 * @param bomb bomba a setear en la celda
	 */
	public void setBomba(Bomba bomb) {
		b = bomb;
	}

	/**
	 * Agrega un powerup a la celda
	 * @param p powerup a setear
	 */
	public void setPowerUp(PowerUp p) {
		this.p = p;
	}

	/**
	 * La celda recibe un mensaje de explosion, matando a todo personaje de la
	 * celda, liberando la bomba y enviando los mensajes explosion a las celdas
	 * adyacentes. Retorna el puntaje obtenido de la explosion.
	 * @return puntaje resultante de la explosion
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
		puntaje += m.getCelda(posX-1, posY).explosion(radio,0);
		puntaje += m.getCelda(posX+1, posY).explosion(radio,1);
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
		puntaje+=estado.explosion(this, r-1,pos);
		if(pos==0 || pos==1){
			estadog.explosion(0);
		}
		else{
			estadog.explosion(1;)
		}
		return puntaje;
	}

	/**
	 * Retorna el mapa asociado a la celda
	 * @return mapa al que pertenece la celda
	 */

	public Mapa getMapa() {
		return m;
	}
	/**
	 * retorna la entidad grafica de la celda
	 * @return entidad grafica de la celda
	 */

	public EstadoGrafico getEntidadGrafica() {
		return estadog;
	}
	/**
	 * activa la visibilidad del powerup
	 */

	public void mostrarPowerUp() {
		p.getEntidadGrafica().mostrar();
	}
	/**
	 * cambia el estado de la celda por un nuevo estado
	 * @param est estado que se le seteara a la celda
	 */
	public void setEstado(EstadoCelda est){
		estado=est;
	}
	/**
	 * retorna la bomba de la celda
	 * @return la bomba si es que posee una o nulo en caso contrario
	 */
	public Bomba getBomba(){
		return b;
	}
}