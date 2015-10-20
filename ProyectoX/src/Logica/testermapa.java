package Logica;

public class testermapa {
	public static void main(String args[]){
		Mapa map=new Mapa();
		for(int i=0; i<31;i++){
			for(int j=0; j<13; j++){
				map.getCelda(i, j).print();
			}
		System.out.println("");
	}
	}
}
