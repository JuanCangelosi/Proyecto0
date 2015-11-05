package Grafica;

import javax.swing.ImageIcon;

public class FatalityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public FatalityGrafico(int x, int y) {
		super(x, y);
		
	}
	
	public FatalityGrafico(){
		super(0,0);
		
	}

	public void mostrar() {
		imagen = new ImageIcon(getClass().getResource("/Imagenes/fatality.png"));
		repaint();
		
	}

}
