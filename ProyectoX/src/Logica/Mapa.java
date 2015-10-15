package Logica;
import java.util.Random;

public class Mapa {
	protected Celda[][] celdas;
	
	public Mapa(){
		celdas=new Celda[31][13];
		inicializarBordes();
		inicializarPiso();
		colocarParedesD();
	}
	
	public Celda getCelda(int x, int y){
		return celdas[x][y];
	}
	
	private void inicializarBordes(){
		for( int i= 0; i<13; i++){
			celdas[0][i]=new Celda();
			celdas[30][i]=new Celda();
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
				celdas[i][j]=new Celda();
				//metodo set
			}
		}
	}
	
	private void colocarParedes(){
		Random generador=new Random();
	}
	
	
}
