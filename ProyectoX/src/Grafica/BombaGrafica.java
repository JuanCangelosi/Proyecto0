package Grafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class BombaGrafica extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen,bomba,explosion;

	public BombaGrafica(int x, int y) {
		super(x, y);
		bomba     = new ImageIcon(getClass().getResource("/Imagenes/bomba.gif"));
		explosion = new ImageIcon(getClass().getResource("/Imagenes/BombaCentro.gif"));
		imagen    = null;

	}
	
	public void colocarBomba(){
		imagen = bomba;
		repaint();
		
	}
	
	public void explotarBomba(){
		imagen = explosion;
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}

}
