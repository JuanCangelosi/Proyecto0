package mapa;
import Personajes.*;
import Bomba.*;
import Grafica.*;
public interface EstadoCelda {
	public int destruir(Celda c);
	public boolean serAvanzado(Bomberman b,Celda c);
	public boolean serAvanzado(Enemigo e, Celda c);
	public void ocuparBomba(Bomba b,Celda c);
	public int explosionArriba(Celda c,int r);
	public int explosionAbajo(Celda c,int r);
	public int explosionIzq(Celda c,int r);
	public int explosionDer(Celda c,int r);
	public EstadoGrafico getEntidadGrafica();
}
