package Grafica;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;


public class BombaGrafica extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	private ImageIcon imagen,bomba,explosion;
	private Timer timer;

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
		
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	explosion = null;
		    	setVisible(false);
		    	repaint();
		        timer.stop();
		    } 
		});
		
		timer.start();

		imagen = explosion;
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}

}
