package Grafica;

import java.awt.Container;

import javax.swing.JComponent;


public abstract class EntidadGrafica extends JComponent{
	
	private static final long serialVersionUID = 1L;
	protected final int width = 32;
	protected final int height = 32;
	protected int velocidad;
	protected int x,y;
	protected Container container;
	
	protected EntidadGrafica(int x, int y) {
		this.x = x;
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	public void setX(int x){
		this.x = x;
		setBounds(x,y,width,height);
		
	}
	
	public void setY(int y){
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	public void setContainer(Container c){
		container = c;
	}
	
	public void eliminar(){
		setVisible(false);
		container.remove(this);
	}

}
