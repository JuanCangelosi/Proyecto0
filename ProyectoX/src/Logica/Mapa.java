package Logica;
import java.util.Random;

public class Mapa {
	protected Celda[][] celdas;
	
	public Mapa(){
		celdas=new Celda[31][13];
		inicializarBordes();
		colocarParedes();
		inicializarPiso();
		
	}
	
	public Celda getCelda(int x, int y){
		return celdas[x][y];
	}
	
	private void inicializarBordes(){
		for( int i= 0; i<13; i++){
			celdas[0][i]=new Celda(new Pared());
			celdas[30][i]=new Celda(new Pared());
			//me falta un metodo setPared
		}
		//los bordes ya se inicializaron con el loop superior
		for(int i=1; i<30; i++){
			celdas[i][0]=new Celda();
			celdas[i][12]=new Celda();
			//metodo
		}
	}
	private void incializarPiso(){
		for(int i=0; i<31;i++){
			for(int j=0; j<13; j++){
				if(celda[i][j]!=null){
					celda[i][j]=new Celda(new Piso());
				}
			}
		}
	}
	
	private void colocarParedes(){
		Random generador=new Random();
		for(int i=2;i<=28;i=(i+2)){
			for(int j=2;j<=10;j=(j+2)){
				celdas[i][j]=new Celda(new Pared());
			}
		}
		int cantParedesDes=0;
		int cantPowerUps=0;
		PowerUp powerups[]=new PowerUp[11];
		//agregar los powerups Al arreglo
		for(int i=0; i<4; i++){
			powerups[i]=new SpeedUp();
		}
		for(int i=4; i<7;i++){
			powerups[i]=new Fatality();
			powerups[i+3]=new Bombality();
		}
		powerups[11]=new Masacrality();
		while(cantParedesDes<125){
			int posX=0;
			int posY=0;
			while(posX<2 && posY<2){
				posX=1+generador.nextInt(29);
				posY=1+generador.nextInt(11);
			}
			celdas[posX][posY]=new Celda(new ParedDestruible());
			cantParedesDes++;
			if(cantPowerUps<powerups.size){
				celdas[posX][posY].setPowerUp(powerups[cantPowerUps]);
				cantPowerUps++;
			}
		}
	}
	
	
}

