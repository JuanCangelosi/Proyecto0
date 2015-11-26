package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Grafica.*;



public class Menu {
	
	protected JLabel fondo;
	protected JButton iniciar,salir,musica;
	protected Juego gui;
	protected boolean sonido;

	public Menu(Juego gui) {
		sonido=true;
		this.gui = gui;
		fondo    = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		iniciar  = new JButton(new ImageIcon(getClass().getResource("/Imagenes/iniciar.png")));
		salir    = new JButton(new ImageIcon(getClass().getResource("/Imagenes/salir.png")));
		musica	 = new JButton(new ImageIcon(getClass().getResource("/Imagenes/sonido.png")));
		
		fondo.setBounds(0,0,1010,460);
		iniciar.setBounds(100, 200, 200, 50);
		salir.setBounds(100, 300, 200, 50);
		musica.setBounds(850,25,75,75);
		
		fondo.add(iniciar);
		fondo.add(salir);
		fondo.add(musica);
		iniciar.addActionListener(new iniciarBoton());
		salir.addActionListener(new salirBoton());
		musica.addActionListener(new musicaBoton());
		this.gui.getContentPane().add(fondo,0);
		//this.gui.getContentPane().add(iniciar,1);
		//this.gui.getContentPane().add(salir,1);	
	
	}

	private class iniciarBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			gui.getContentPane().remove(fondo);
			//gui.getContentPane().remove(iniciar);
			//gui.getContentPane().remove(salir);
			
			gui.iniciarJuego();
			
		}
	}
	private class musicaBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			if(sonido){
				musica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/sonido2.png")));
			}
			else{
				musica.setIcon(new ImageIcon(getClass().getResource("/Imagenes/sonido.png")));
			}
			sonido=!sonido;
		}
	}
	
	private class salirBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			gui.salirJuego();
			
		}
	}
	
	public boolean sonido(){
		return sonido;
	}
		
}
