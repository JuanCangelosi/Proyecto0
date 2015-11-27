package CeldaGrafica;

import javax.swing.ImageIcon;

public class ParedGrafico extends EstadoGrafico{

	private static final long serialVersionUID = 1L;
	
	public ParedGrafico(int x, int y) {
		super(x, y);

		imagen = new ImageIcon(getClass().getResource("/Imagenes/pared2.png"));

	}
	
	public ParedGrafico(){
		super();
		
	}

}
