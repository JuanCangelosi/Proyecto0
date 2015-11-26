package Grafica;

import javax.swing.ImageIcon;

public class MasacralityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public MasacralityGrafico(int x, int y) {
		super(x, y);
		//posicion = 3;
	}
	
	public MasacralityGrafico(){
		super(0,0);
		
	}

	public void mostrar() {
		//posicion=3;
		imagen = new ImageIcon(getClass().getResource("/Imagenes/masacrality.png"));
		repaint();
		
	}

}
