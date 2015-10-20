package Bomba;
import Logica.*;

public class FabricaBomba implements AbstractFactory{
	//Atributos de Intancia
	protected int radio;
	
	//Constructor
	public FabricaBomba(){
		radio=1;
	}
	
	public Bomba darBomba(Celda c){
		Bomba b= new Bomba(c);
		b.setRadio(radio);
		return b;
	}
	
	public void duplicar(){
		radio*=2;
	}
}
