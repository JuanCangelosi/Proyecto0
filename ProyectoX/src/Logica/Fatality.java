package Logica;
import Personajes.*;
import bomba.*;

public class Fatality implements PowerUp {
	public void dar(Bomberman b){
		b.fabrica().duplicarRadio();
		b.getNivel().sumarPuntaje(35);
	}
}
