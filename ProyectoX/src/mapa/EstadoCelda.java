package mapa;
import Personajes.*;
import Bomba.*;

public interface EstadoCelda {
	public int destruir(Celda c);
	public void serAvanzado(Bomberman b,Celda c);
	public void serAvanzado(Enemigo e, Celda c);
	public void ocuparBomba(Bomba b,Celda c);
	public int explosionArriba(Celda c,int r);
	public int explosionAbajo(Celda c,int r);
	public int explosionIzq(Celda c,int r);
	public int explosionDer(Celda c,int r);
}
