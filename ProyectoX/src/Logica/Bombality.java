package Logica;

public class Bombality implements PowerUp {
	public void dar(Bomberman b){
		b.getBomba().setRadio(b.getBomba().getRadio()*2);
	}
}
