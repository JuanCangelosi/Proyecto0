package Grafica;


import javax.swing.ImageIcon;

public class BombalityGrafico extends PowerupGrafico{

	private static final long serialVersionUID = 1L;
	
	public BombalityGrafico(int x, int y) {
		super(x, y);
	}
	
	public BombalityGrafico(){
		super(0,0);
		
	}

	public void mostrar() {
		posicion=1;
		imagen = new ImageIcon(getClass().getResource("/Imagenes/bombality.png"));	
		repaint();
		
	}

}
