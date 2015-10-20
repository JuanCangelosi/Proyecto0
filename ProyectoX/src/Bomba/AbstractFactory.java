package Bomba;
import Logica.*;

public interface AbstractFactory {
	public Bomba darBomba(Celda c);
	public void duplicar();
	public void aumentarBombas();
	public int cantBombas();
}