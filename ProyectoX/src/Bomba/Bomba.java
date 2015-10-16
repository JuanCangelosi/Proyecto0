package Bomba;
import Logica.*;
public class Bomba {
//	Atributos de Intancia
	protected int radio;
	protected Celda celda;
	
//	Constructor
	public Bomba(Celda c){
		celda=c;
		radio=1;	
	}
	
	public int explotar(){
		int x,y;
		x=celda.getPosH();
		y=celda.getPosV();
		int n=0;
		for (int i=1; i<=radio; i++){
			
			Celda c=celda.getMapa().getCelda(x+1,y);
			if(c.getBomberman()!=null)
				n+=c.getBomberman().morir();
			if(c.getEnemigo()!=null)
				n+=c.getEnemigo().morir();
			
			Celda c1=celda.getMapa().getCelda(x-1,y);
			if(c1.getBomberman()!=null)
				n+=c1.getBomberman().morir();
			if(c1.getEnemigo()!=null)
				n+=c1.getEnemigo().morir();
			
			Celda c2=celda.getMapa().getCelda(x,y+1);
			if(c2.getBomberman()!=null)
				n+=c2.getBomberman().morir();
			if(c2.getEnemigo()!=null)
				n+=c2.getEnemigo().morir();
			
			Celda c3=celda.getMapa().getCelda(x+1,y-1);
			if(c3.getBomberman()!=null)
				n+=c3.getBomberman().morir();
			if(c3.getEnemigo()!=null)
				n+=c3.getEnemigo().morir();
		}
		return n;
	}
	
	public int getRadio(){
		return radio;
	}
	
	public Celda getCelda(){
		return celda;
	}
}	
