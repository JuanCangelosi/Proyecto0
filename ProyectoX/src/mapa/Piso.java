package mapa;
import Personajes.*;

public class Piso implements EstadoCelda {
	public boolean destruir(){
		return false;
	}
	public boolean serAvanzado(Personaje p){
		return true;
	}
}
