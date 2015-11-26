package Grafica;

import java.awt.Graphics;

import javax.swing.ImageIcon;

public class Mensaje extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	private ImageIcon mensaje;
	
	public Mensaje(int x, int y) {
		super(250, 250);
		setBounds(230,130,600,300);
		mensaje = null;
		repaint();
	}
	
	public void GameOver(){
		mensaje = new ImageIcon(getClass().getResource("/Imagenes/game-over.png"));
		repaint();
	}
	
	public void Win(){
		mensaje = new ImageIcon(getClass().getResource("/Imagenes/winner.png"));
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(mensaje!=null)
			g.drawImage(mensaje.getImage(), 0, 0, this);
	}

}
