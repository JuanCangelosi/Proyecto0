package Bomba;
import Logica.*;

public class FabricaBomba implements AbstractFactory{
	//Atributos de Intancia
	protected int radio;
	protected int cantBombas;
	
	//Constructor
	public FabricaBomba(){
		radio=1;
		cantBombas=0;
	}
	
	public Bomba darBomba(Celda c){
		Bomba b= new Bomba(c);
		cantBombas++;
		b.setRadio(radio);
		return b;
	}
	
	public void duplicar(){
		radio*=2;
	}
	
	public void aumentarBombas(){
		cantBombas++;
	}
	
	public int cantBombas(){
		return cantBombas;
	}
}
