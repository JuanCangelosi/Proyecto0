package Grafica;

import javax.swing.ImageIcon;

public class FatalityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public FatalityGrafico(int x, int y) {
		super(x, y);
		//posicion = 2;
	}
	
	public FatalityGrafico(){
		super(0,0);
		
	}

	public void mostrar() {
		//posicion=2;
		imagen = new ImageIcon(getClass().getResource("/Imagenes/fatality.png"));
		repaint();
		
	}

}
