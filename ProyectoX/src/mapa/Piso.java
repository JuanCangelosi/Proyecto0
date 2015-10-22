
package mapa;
import Bomba.Bomba;
import PowerUp.*;
import Grafica.EntidadGrafica;
import Personajes.*;
import PowerUp.PowerUp;
import Grafica.*;
/**
 * Clase piso representa las celdas transitables por todos los personajes del juego
 */
public class Piso implements EstadoCelda {
	
	/**
	 * El piso no puede ser destruido, entonces se retorna 0
	 */
	public int destruir(Celda c){
		return 0;
	}
	/**
	 * El piso puede ser avanzado por bomberman, pero solo si la celda se encuentra desocupada
	 *  si powerup no es nulo,es decir el piso posee un powerup, se lo otorga a bomberman
	 */
	public boolean serAvanzado(Bomberman b,PowerUp p, Celda c){
		boolean exito=c.setBomberman(b);
		if(exito){
			if(p!=null){
				p.dar(b);
				c.setPowerUp(null);
			}
		}
		return exito;
	}
	/**
	 * El enemigo puede avanzar por el piso, pero solo si la celda se encuentra desocupada.
	 */
	public boolean serAvanzado(Enemigo e, Celda c){
		return c.setEnemigo(e);
	}
	/**
	 * Trata de colocar la bomba en la celda y la activa.
	 */
	public void ocuparBomba(Bomba b,Celda c){
		c.setBomba(b);
		b.activar();
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionArriba(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX()+1,c.getPosY()).explosionArriba(r-1);
		else return 0;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionAbajo(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX()-1,c.getPosY()).explosionAbajo(r-1);
		else return 0;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionIzq(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX(),c.getPosY()-1).explosionIzq(r-1);
		else return 0;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionDer(Celda c,int r){
		if(r!=0)
		return c.getMapa().getCelda(c.getPosX(),c.getPosY()+1).explosionDer(r-1);
		else return 0;
	}
	public void setImagen(EstadoGrafico e){
		e.setPiso();
	}
}
