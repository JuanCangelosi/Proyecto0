package Grafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public class EstadoGrafico extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen,animacion;
	protected boolean espared;
	
	public EstadoGrafico(int x, int y) {
		super(x, y);
		espared   = false;
		animacion = null;
		imagen    = null;
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
	
	public void explocion(int i){
		if(espared)
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaPared.gif"));
		if(i==0)
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaArriba.gif"));
		else if(i==1)
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaCostados.gif"));
	}
	
	
	public void setPared(){
		imagen  = new ImageIcon(getClass().getResource("/Imagenes/pared2.png"));
		espared = true;
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
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
		if(animacion!=null)
			g.drawImage(animacion.getImage(), 0, 0, this);
	}

}
