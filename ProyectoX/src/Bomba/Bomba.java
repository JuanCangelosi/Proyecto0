package Bomba;
import Logica.*;
public class Bomba {
	//Atributos de Instancia
	protected int radio;
	protected Celda c;
	
	//Constructor 				
	public Bomba(Celda celda){
		c=celda;
		radio=1;
	}
	
	public void explotar(){
		for(int i=1; i<=radio; i++){
			Celda c1= c.getMapa().getCelda(c.getPosX()+i, c.getPosY());
			if(c1.getEnemigo()!= null){
				c1.getEnemigo().morir();
			}else
				if(c1.getBomberMan()!=null)
					c1.getBomberMan().morir();
			
			c1= c.getMapa().getCelda(c.getPosX()-i, c.getPosY());
			if(c1.getEnemigo()!= null){
				c1.getEnemigo().morir();
			}else
				if(c1.getBomberMan()!=null)
					c1.getBomberMan().morir();
			
			c1= c.getMapa().getCelda(c.getPosX(), c.getPosY()+i);
			if(c1.getEnemigo()!= null){
				c1.getEnemigo().morir();
			}else
				if(c1.getBomberMan()!=null)
					c1.getBomberMan().morir();
			
			c1= c.getMapa().getCelda(c.getPosX(), c.getPosY()-i);
			if(c1.getEnemigo()!= null){
				c1.getEnemigo().morir();
			}else
				if(c1.getBomberMan()!=null)
					c1.getBomberMan().morir();
		}	
	}

}