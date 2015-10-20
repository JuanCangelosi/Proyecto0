package Logica;
import Personajes.*;
import bomba.*;

public class Bombality implements PowerUp {
	public void dar(Bomberman b){
		b.setCantBombas(b.cantBombas()*2);
		b.getNivel().sumarPuntaje(35);
	}
}
