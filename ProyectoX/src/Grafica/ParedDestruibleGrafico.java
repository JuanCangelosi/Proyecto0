package Grafica;

import javax.swing.ImageIcon;

public class ParedDestruibleGrafico extends EstadoGrafico{
	
	private static final long serialVersionUID = 1L;
	
	public ParedDestruibleGrafico(int x, int y) {
		super(x, y);

		imagen = new ImageIcon(getClass().getResource("/Imagenes/paredDestruible.png"));

	}
	
	public ParedDestruibleGrafico(){
		super();
		
	}

}
