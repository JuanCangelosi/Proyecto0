package mapa;
import java.util.Random;

import Personajes.*;
import PowerUp.Bombality;
import PowerUp.Fatality;
import PowerUp.Masacrality;
import PowerUp.PowerUp;
import PowerUp.SpeedUp;
/**
 * Clase Mapa representa al mapa del juego, que sera de 31x13 celdas.
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
public class Mapa {
	//atributos
	protected Nivel n;
	protected Celda[][] celdas;
	protected Enemigo[] enemigos;
	protected int paredesDest=125;
	protected Bomberman bomberman;
	
	/**
	 * Crea un nuevo Mapa de 31x13, inicializando los bordes, las paredes y el piso
	 */
	public Mapa(Nivel niv){
		n=niv;
		celdas=new Celda[13][31];
		enemigos=new Enemigo[6];
		inicializarBordes();
		colocarParedes();
		colocarEnemigos();
		inicializarPiso();
		bomberman=new Bomberman(getCelda(1,1));
		getCelda(1,1).setBomberman(bomberman);
		enemigos[0].darThread().start();
		enemigos[1].darThread().start();
		enemigos[2].darThread().start();
		enemigos[3].darThread().start();
		enemigos[4].darThread().start();
		enemigos[5].darThread().start();
	}
	/**
	 * Retorna la celda en las coordenadas x, y
	 * @param x: la posicion x
	 * @param y: la posicion y
	 * @return Retorna la celda en las coordenadas x, y
	 */
	public Celda getCelda(int x, int y){
		return celdas[x][y];
	}
	/**
	 * Retorna el enemigo del arreglo de enemigos, entre 0 y 5
	 * @param x es el numero del enemigo en el arreglo
	 * @return Retorna el enemigo del arreglo de enemigos, entre 0 y 5
	 */
	
	public Enemigo getEnemigo(int x){
		return enemigos[x];
	}
	/**
	 * Metodo auxiliar que inicializa los bordes como paredes indestructibles
	 */
	
	private void inicializarBordes(){
		for( int i= 1; i<12; i++){
			celdas[i][0]=new Celda(new Pared(),this,i,0);
			celdas[i][30]=new Celda(new Pared(),this,i,30);
		}
		//los bordes ya se inicializaron con el loop superior
		for(int i=0; i<31; i++){
			celdas[0][i]=new Celda(new Pared(),this,0,i);
			celdas[12][i]=new Celda(new Pared(),this,12,i);
		}
	}
	/**
	 * Metodo auxiliar que inicializa todo las celdas nulas como piso
	 */
	private void inicializarPiso(){
		for(int i=0; i<31;i++){
			for(int j=0; j<13; j++){
				if(celdas[j][i]==null){
					celdas[j][i]=new Celda(new Piso(),this,j,i);
				}
			}
		}
	}
	/**
	 * Metodo auxiliar que coloca las paredes indestructibles y luego coloca las destructibles en lo que queda libre
	 * del mapa, agregando los powerups correspondientes a las mismas.
	 */
	
	private void colocarParedes(){
		Random generador=new Random();
		for(int i=2;i<=28;i=(i+2)){
			for(int j=2;j<=10;j=(j+2)){
				celdas[j][i]=new Celda(new Pared(),this,j,i);
			}
		}
		int cantParedesDes=0;
		int cantPowerUps=0;
		PowerUp powerups[]=inicializarPowerUps();
		
		while(cantParedesDes<paredesDest){
			int posX=0;
			int posY=0;
			while((posX<3 && posY<3) || (posX>9 && posY>27) || celdas[posX][posY]!=null){
				posX=1+generador.nextInt(11);
				posY=1+generador.nextInt(29);
			}
			celdas[posX][posY]=new Celda(new ParedDestruible(),this,posX,posY);
			cantParedesDes++;
			if(cantPowerUps<powerups.length){
				celdas[posX][posY].setPowerUp(powerups[cantPowerUps]);
				cantPowerUps++;
			}
		}
	}
	/**
	 * Metodo auxiliar que inicializa el arreglo de enemigos
	 */
	private void inicializarEnemigos(Celda[] aux){
		enemigos[0]=new Rugulos(aux[0]);
		aux[0].setEnemigo(enemigos[0]);
		enemigos[1]=new Rugulos(aux[1]);
		aux[1].setEnemigo(enemigos[1]);
		enemigos[2]=new Rugulos(aux[2]);
		aux[2].setEnemigo(enemigos[2]);
		enemigos[3]=new Altair(aux[3]);
		aux[3].setEnemigo(enemigos[3]);
		enemigos[4]=new Altair(aux[4]);
		aux[4].setEnemigo(enemigos[4]);
		enemigos[5]=new Sirius(aux[5]);
		aux[5].setEnemigo(enemigos[5]);
	}
	/**
	 * Metodo auxiliar que coloca los enemigosen las celdas correspondientes
	 */
	private void colocarEnemigos(){
		Celda[] aux=new Celda[6];
		Random generador=new Random();
		int posX=0;
		int posY=0;
		for(int i=0; i<enemigos.length-1;i++){
			while((posX<3 && posY<3) || (posX>11 && posY>28) || celdas[posX][posY]!=null){
				posX=1+generador.nextInt(10);
				posY=1+generador.nextInt(28);
			}
			celdas[posX][posY]=new Celda(new Piso(),this,posX,posY);
			aux[i]=celdas[posX][posY];
		}
		celdas[11][29]=new Celda(new Piso(),this,11,29);
		aux[5]=celdas[11][29];
		inicializarEnemigos(aux);
	}
	/**
	 * Metodo auxiliar que crea y devuelve un arreglo de powerUps
	 */
	private PowerUp[] inicializarPowerUps(){
		PowerUp powerups[]=new PowerUp[11];
		for(int i=0; i<4; i++){
			powerups[i]=new SpeedUp();
		}
		for(int i=4; i<7;i++){
			powerups[i]=new Fatality();
			powerups[i+3]=new Bombality();
		}
		powerups[10]=new Masacrality();
		return powerups;
	}
	/**
	 * Retorna la cantidad de paredes destruibles que quedan en el mapa
	 * @return cantidad de paredes destruibles que quedan en el mapa
	 */
	public int getCantParedesDest(){
		return paredesDest;
	}
	/**
	 * Decrementa la cantidad de paredes destruibles en 1
	 */
	public void decrementarPared(){
		paredesDest--;
	}
	/**
	 * Retorna el bomberman del mapa
	 * @return bomberman
	 */
	public Bomberman getHeroe() {
		return bomberman;
	}
	public Nivel getNivel(){
		return n;
	}
}

