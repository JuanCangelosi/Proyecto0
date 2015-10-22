package mapa;

import Bomba.Bomba;
import Personajes.*;
import PowerUp.*;
import Grafica.*;
/**
 * Clase ParedDestruible representa a las paredes que al explotar la bomba se destruyen y pueden ser atravesadas
 * por bomberman en modos dios y por Altair.
 */
public class ParedDestruible implements EstadoCelda {
	protected EstadoGrafico eg;
	/**
	 * Crea una nueva paredDestruible y su entidad grafica correspondiente
	 */
	public ParedDestruible(){
		eg=new ParedDestruibleGrafico();
	}
	/**
	 * Retorna el estado grafico asociada a la pared Destruible
	 */
	public EstadoGrafico getEntidadGrafica(){
		return eg;
	}
	/**
	 * La pared Destruible solo puede ser avanzada por bomberman si es especial
	 */
	public boolean serAvanzado(Bomberman b,PowerUp p, Celda c){
		boolean exito=false;
		if(b.esEspecial()){
			exito=c.setBomberman(b);
		}
		return exito;
	}
	/**
	 * La pared destruible solo puede ser avanzada por el enemigo que es especial, es decir rugulos.
	 */
	public boolean serAvanzado(Enemigo e, Celda c){
		boolean exito=false;
		if(e.esEspecial()){
			exito=c.setEnemigo(e);
		}
		return exito;
	}
	/**
	 * Al ser destruida la pared retorna el puntaje de la destruccion y setea el estado de la celda c en piso
	 * tambien se decrementa la cantidad de paredes restantes en el mapa.
	 */
	public int destruir(Celda c){
		c.setEstado(new Piso());
		c.getMapa().decrementarPared();
		return 10;
	}
	/**
	 * Una pared destruible no puede tener bombas
	 */
	public void ocuparBomba(Bomba b,Celda c){
	}
	
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionArriba(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX()+1,c.getPosY()).explosionArriba(r-1);
		else return punt;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionAbajo(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX()-1,c.getPosY()).explosionAbajo(r-1);
		else return punt;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionIzq(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX(),c.getPosY()-1).explosionIzq(r-1);
		else return punt;
	}
	/**
	 * Se le envia a las celdas adyacentes el mensaje explosion con el radio disminuido
	 */
	public int explosionDer(Celda c,int r){
		int punt=destruir(c);
		if(r!=0)
		return punt+c.getMapa().getCelda(c.getPosX(),c.getPosY()+1).explosionDer(r-1);
		else return punt;
	}

}
