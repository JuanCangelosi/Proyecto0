package Logica;

public class Nivel {
	protected int tiempo;
	protected int puntaje;
	protected BomberMan bomberman;
	protected Enemigo[] enemigos;
	protected Mapa mapa;
	
	public Nivel(){
		mapa=new Mapa();
	}
	
	public void sumarPuntaje(int n){
		puntaje+=n;
	}
	
	public BomberMan getHeroe(){
		return bomberman;
	}
	
	public void eliminarEnemigo(){
		
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	
	public boolean gano(){
		return enemigos.size ==0;
	}

}
