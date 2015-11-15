package mapa;

import Bomba.Bomba;
import Grafica.PersonajeGrafico;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;

/**
 * Clase piso representa las celdas transitables por todos los personajes del
 * juego
 */
public class Piso implements EstadoCelda {

	/**
	 * El piso no puede ser destruido, entonces se retorna 0
	 */
	public int destruir(Celda c) {
		return 0;
	}

	/**
	 * El piso puede ser avanzado por bomberman, pero solo si la celda se
	 * encuentra desocupada si powerup no es nulo,es decir el piso posee un
	 * powerup, se lo otorga a bomberman
	 */
	public void serAvanzado(Bomberman b, PowerUp p, Celda c, int n) {
		if (c.getBomba() == null) {
			c.setBomberman(b);
			PersonajeGrafico pg = b.grafico();
			switch (n) {
			case 0: {
				pg.arriba();
				break;
			}
			case 1: {
				pg.abajo();
				break;
			}
			case 2: {
				pg.izquierda();
				break;
			}
			case 3: {
				pg.derecha();
				break;
			}
			}
			if (p != null) {
				p.dar(b);
				c.setPowerUp(null);
			}
		}
	}

	/**
	 * El enemigo puede avanzar por el piso, pero solo si la celda se encuentra
	 * desocupada.
	 */
	public void serAvanzado(Enemigo e, Celda c, int n) {
		if (c.getBomba() == null && c.getEnemigo() == null) {
			if (e.getCelda() != null)
				e.getCelda().setEnemigo(null);
			c.setEnemigo(e);
			PersonajeGrafico pg = e.grafico();
			switch (n) {
			case 0: {
				pg.arriba();
				break;
			}
			case 1: {
				pg.abajo();
				break;
			}
			case 2: {
				pg.izquierda();
				break;
			}
			case 3: {
				pg.derecha();
				break;
			}
			}
			try{
				e.darThread().sleep(1000);}
			catch(InterruptedException exc){
				exc.printStackTrace();
			}
		}
	}

	/**
	 * Trata de colocar la bomba en la celda y la activa.
	 */
	public void ocuparBomba(Bomba b, Celda c) {
		c.setBomba(b);
		b.activar();
	}

	public int explosion(Celda c, int r, int pos) {
		int puntaje = 0;
		if (r != 0) {
			switch (pos) {
			case 0: {
				puntaje += c.getMapa().getCelda(c.getPosX() - 1, c.getPosY())
						.explosion(r , pos);
				break;
			}
			case 1: {
				puntaje += c.getMapa().getCelda(c.getPosX() + 1, c.getPosY())
						.explosion(r , pos);
				break;
			}
			case 2: {
				puntaje += c.getMapa().getCelda(c.getPosX(), c.getPosY() - 1)
						.explosion(r , pos);
				break;
			}
			case 3: {
				puntaje += c.getMapa().getCelda(c.getPosX(), c.getPosY() + 1)
						.explosion(r , pos);
				break;
			}
			}
		}
		return puntaje;
	}

	public void setImagen(EstadoGrafico e) {
		e.setPiso();
	}
}
