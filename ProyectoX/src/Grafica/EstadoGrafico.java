package Grafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class EstadoGrafico extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen;
	
	public EstadoGrafico(int x, int y) {
		super(x, y);
		
	}
	
	public EstadoGrafico(){
		super(0 ,0);
		
	}
	
	public void setX(int x){
		this.x = x;
		setBounds(x,y,width,height);
		
	}
	
	public void setY(int y){
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	
	public void setPared(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/pared2.png"));
		repaint();

		
	}
	
	public void setPiso(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/piso.png"));
		repaint();
		
	}
	
	public void setParedDestruible(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/paredDestruible.png"));
		repaint();
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	    g.drawImage(imagen.getImage(), 0, 0, this);
	    
	}

}
