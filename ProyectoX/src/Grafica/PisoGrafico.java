package Grafica;

import javax.swing.ImageIcon;

public class PisoGrafico extends EstadoGrafico{

	private static final long serialVersionUID = 1L;
	
	public PisoGrafico(int x, int y) {
		super(x, y);
		
		imagen = new ImageIcon(getClass().getResource("/Imagenes/piso.png"));
		
	}
	
	public PisoGrafico(){
		super();
	}

}
