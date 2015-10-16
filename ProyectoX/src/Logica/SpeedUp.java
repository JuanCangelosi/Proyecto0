package Logica;
import Personajes.*;

public class SpeedUp implements PowerUp {
	public void dar(Bomberman b){
		b.setVelocidad(b.getVelocidad()*2);
	}
}
