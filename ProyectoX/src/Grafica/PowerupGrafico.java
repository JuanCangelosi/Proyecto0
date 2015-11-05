package Grafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen;

	public PowerupGrafico(int x, int y) {
		super(x, y);
		imagen = null;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}
	
	public void ocultar(){
		
		setVisible(false);
	}
	
	public abstract void mostrar();
}
