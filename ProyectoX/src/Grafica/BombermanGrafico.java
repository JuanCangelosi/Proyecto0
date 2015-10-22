package Grafica;

import java.io.IOException;

import javax.imageio.ImageIO;


public class BombermanGrafico extends PersonajeGrafico{
	
	private static final long serialVersionUID = 1L;
	
	protected BombermanGrafico(int x, int y) {
		super(x, y);
		try {

			direccion = 0;
			
			centro = ImageIO.read(getClass().getResource("/Imagenes/player-abajo1.png"));
			abajo1 = ImageIO.read(getClass().getResource("/Imagenes/player-abajo2.png"));
			abajo2 = ImageIO.read(getClass().getResource("/Imagenes/player-abajo3.png"));
			
			arriba1 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba1.png"));
			arriba2 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba2.png"));
			arriba3 = ImageIO.read(getClass().getResource("/Imagenes/player-arriba3.png"));
			
			derecha1 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha1.png"));
			derecha2 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha2.png"));
			derecha3 = ImageIO.read(getClass().getResource("/Imagenes/player-derecha3.png"));
			
			izquierda1 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda1.png"));
			izquierda2 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda2.png"));
			izquierda3 = ImageIO.read(getClass().getResource("/Imagenes/player-izquierda3.png"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void derecha(){
		
		if(x<928){
			this.x+=32;
					
			if(direccion != 30 && direccion!=31 && direccion!=32)
				direccion = 30;

			else if(direccion == 30)
				direccion = 31;
			
			else if(direccion == 31)
				direccion = 32;
			
			else if(direccion == 32)
				direccion = 30;

			setBounds(x,y,32,32);
		}
	}
	
	public void izquierda(){
		
		if(x>32){
			this.x-=32;
					
			if(direccion != 10 && direccion != 11 && direccion !=12)
				direccion = 10;
				
			else if(direccion == 10)
				direccion = 11;

			else if(direccion == 11)
				direccion = 12;
			
			else if(direccion == 12)
				direccion = 10;
					
			setBounds(x,y,32,32);
		}
	}
	
	public void arriba(){
		
		if(y>32){
			this.y-=32;
					
			if(direccion !=40 && direccion!=41 && direccion!=42)
				direccion = 40;
		
			else if(direccion == 40)
				direccion = 41;
			
			else if(direccion == 41)
				direccion = 42;
			
			else if(direccion == 42)
				direccion = 40;
			
					
			setBounds(x,y,32,32);
		}
	}
	
	public void abajo(){
		
		if(y<352){
			this.y+=32;
					
			if(direccion!=0 && direccion!=20 && direccion!=21)
				direccion = 0;

			else if(direccion == 0)
				direccion = 20;

			else if(direccion == 20)
				direccion = 21;
				
			else if(direccion == 21)
				direccion = 0;
					
			setBounds(x,y,32,32);
			
		}
	}
	
}
	


