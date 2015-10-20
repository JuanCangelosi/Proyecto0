package mapa;
import Personajes.*;

public interface EstadoCelda {
	public boolean destruir();
	public boolean serAvanzado(Personaje p);
}
