package Grafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;

public abstract class PowerupGrafico extends EntidadGrafica{
	
	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen;
	protected boolean agarrado;
	protected int posicion;


	public PowerupGrafico(int x, int y) {
		super(x, y);
		imagen = null;
		agarrado = false;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		if(imagen!=null && agarrado){
			setBounds(90+(posicion*32),425,width,height);
			g.drawImage(imagen.getImage(), 0, 0, this);
		}
		else if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
	}
	
	public void ocultar(){
		
		
	}
	
	public void setAgarrado(boolean agarrado){
		this.agarrado = agarrado;
	}
	
	public void setPosicion(int n){
		posicion= n;
	}
	
	public abstract void mostrar();
}
