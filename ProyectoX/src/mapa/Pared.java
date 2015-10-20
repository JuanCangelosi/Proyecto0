package mapa;
import Bomba.Bomba;
import Personajes.*;

public class Pared implements EstadoCelda {
	public void serAvanzado(Bomberman b, Celda c){
	}
	public void serAvanzado(Enemigo e, Celda c){
	}
	public int destruir(int arriba, int abajo, int izq, int der, Celda c){
		return 0;
	}
	public void ocuparBomba(Bomba b,Celda c){
	}

}
