package mapa;

import Personajes.Personaje;

public class ParedDestruible implements EstadoCelda {
	public boolean serAvanzado(Personaje p){
		return p.esEspecial();
	}
	public boolean destruir(){
		return true;
	}

}
