package Logica;
import Personajes.*;

public class Pared implements EstadoCelda {
	public boolean serAvanzado(Personaje p){
		return false;
	}
	public boolean destruir(){
		return false;
	}
}
