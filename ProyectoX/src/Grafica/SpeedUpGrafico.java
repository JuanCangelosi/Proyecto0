package Grafica;

import javax.swing.ImageIcon;

public class SpeedUpGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;

	public SpeedUpGrafico(int x, int y) {
		super(x, y);
		posicion = 4;
	}
	
	public SpeedUpGrafico(){
		super(0,0);
		
	}
	
	public void mostrar(){
		posicion=4;
		imagen = new ImageIcon(getClass().getResource("/Imagenes/speedup.png"));	
		repaint();	
		
	}

}
