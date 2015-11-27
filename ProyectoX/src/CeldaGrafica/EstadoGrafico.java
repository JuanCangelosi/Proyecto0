/**
 * Es la representacion grafica de la abstraccion de los distintos estados de la celda
 * @author LeandroFuryk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package CeldaGrafica;

import Grafica.EntidadGrafica;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EstadoGrafico extends EntidadGrafica{

	private static final long serialVersionUID = 1L;
	protected ImageIcon imagen,animacion;
	protected boolean espared;
	protected Timer timer;
	
	
	public EstadoGrafico(int x, int y) {
		super(x, y);
		espared   = false;
		animacion = null;
		imagen    = null;
	}
	
	public EstadoGrafico(){
		super(0 ,0);
		
	}
	
	/**
	 * Introduce la direccion de X en el mapa
	 * @param x valor a modificar en el estado
	 */
	public void setX(int x){
		this.x = x;
		setBounds(x,y,width,height);
		
	}
	
	/**
	 * Introduce la direccion de Y en el mapa
	 * @param y valor a modificar en el estado
	 */
	public void setY(int y){
		this.y = y;
		setBounds(x,y,width,height);
		
	}
	
	/**
	 * Provoca la explosion de la pared graficamente
	 */
	public void explotarPared(){
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	animacion = null;
		    	repaint();
		        timer.stop();
		    } 
		});
		
		timer.start();
		
		setPiso();
		animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaPared.gif"));
		
		repaint();
		
	
	}
	
	/**
	 * Simula la explosion de los bordes graficamente
	 * @param pos determina cual de los bordes es
	 */
	public void explotarBorde(int pos){
		
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	animacion = null;
		    	repaint();
		        timer.stop();
		    } 
		});
		
		timer.start();
		

		if(pos==0 || pos ==1){
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaArriba.gif"));
		}
		else if(pos==2 || pos==3){
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaCostados.gif"));
		}
		
		repaint();
		
		
	}
	
	/**
	 * Explota la celda grafica permitiendo la vision del Piso
	 * @param i determina si es el centro de la explosion o un costado del mismo
	 */
	public void explotarPiso(int i){
		
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	animacion = null;
		    	repaint();
		        timer.stop();
		    } 
		});
		
		timer.start();
		

		if(i==0){
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaArriba.gif"));
		}
		else if(i==1){
			animacion = new ImageIcon(getClass().getResource("/Imagenes/BombaCostados.gif"));
		}
		
		repaint();
	}
	
	/**
	 * Setea la pared en el excenario
	 */
	public void setPared(){
		imagen  = new ImageIcon(getClass().getResource("/Imagenes/pared2.png"));
		espared = true;
		repaint();

		
	}
	
	/**
	 * Setea el piso en el escenario
	 */
	public void setPiso(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/piso.png"));
		repaint();
		
	}
	
	/**
	 * Setea la pared destruible en el escenario
	 */
	public void setParedDestruible(){
		imagen = new ImageIcon(getClass().getResource("/Imagenes/paredDestruible.png"));
		repaint();
		
	}
	
	/**
	 * Pinta el componente en el mapa
	 * @param g grafico a pintar
	 */
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(imagen!=null)
			g.drawImage(imagen.getImage(), 0, 0, this);
		if(animacion!=null)
			g.drawImage(animacion.getImage(), 0, 0, this);
	}

}
