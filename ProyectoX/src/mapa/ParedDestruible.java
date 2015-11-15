package mapa;

import Bomba.Bomba;
import Personajes.*;
import PowerUp.*;
import Grafica.*;
/**
 * Clase ParedDestruible representa a las paredes que al explotar la bomba se destruyen y pueden ser atravesadas
 * por bomberman en modos dios y por Altair.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class ParedDestruible implements EstadoCelda {

	/**
	 * La pared Destruible solo puede ser avanzada por bomberman si es especial
	 */
	public void serAvanzado(Bomberman b,PowerUp p, Celda c, int n){
		if(b.esEspecial()){
			c.setBomberman(b);
			PersonajeGrafico pg= b.grafico();
			switch(n){
			case 0: {pg.arriba(); break;}
			case 1: {pg.abajo(); break;}
			case 2: {pg.izquierda(); break;}
			case 3: {pg.derecha(); break;}
			}
		}

	}
	/**
	 * La pared destruible solo puede ser avanzada por el enemigo que es especial, es decir rugulos.
	 */
	public void serAvanzado(Enemigo e, Celda c, int n){
		if(e.esEspecial()){
			if (c.getBomba() == null && c.getEnemigo() == null) {
				if (e.getCelda() != null)
					e.getCelda().setEnemigo(null);
			c.setEnemigo(e);
			PersonajeGrafico pg= e.grafico();
			switch(n){
			case 0: {pg.arriba(); break;}
			case 1: {pg.abajo(); break;}
			case 2: {pg.izquierda(); break;}
			case 3: {pg.derecha(); break;}
			}
			try{
				e.darThread().sleep(1000);
			}catch(InterruptedException exc){
				
			}
		}
		}
	}
	/**
	 * Al ser destruida la pared retorna el puntaje de la destruccion y setea el estado de la celda c en piso
	 * tambien se decrementa la cantidad de paredes restantes en el mapa.
	 */
	public int destruir(Celda c){
		c.setEstado(new Piso());
		c.getMapa().decrementarPared();
		c.getEntidadGrafica().setPiso();
		if(c.getPowerUp()!=null)
			c.mostrarPowerUp();
		return 10;
	}
	/**
	 * Una pared destruible no puede tener bombas
	 */
	public void ocuparBomba(Bomba b,Celda c){
	}
	public int explosion(Celda c, int r, int pos){
		if(pos==0 || pos==1){
			c.getEntidadGrafica().explosion(0);
		}
		else{
			c.getEntidadGrafica().explosion(1);
		}
		return destruir(c);
	}
	
	public void setImagen(EstadoGrafico e){
		e.setParedDestruible();
	}

}
