package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import Grafica.*;



public class Menu {

	JLabel fondo;
	JButton iniciar,salir;
	Juego gui;

	public Menu(Juego gui) {
		
		this.gui = gui;
		fondo    = new JLabel(new ImageIcon(getClass().getResource("/Imagenes/fondo.png")));
		iniciar  = new JButton(new ImageIcon(getClass().getResource("/Imagenes/iniciar.png")));
		salir    = new JButton(new ImageIcon(getClass().getResource("/Imagenes/salir.png")));		
		
		fondo.setBounds(0,0,1010,460);
		iniciar.setBounds(100, 200, 200, 50);
		salir.setBounds(100, 300, 200, 50);
		
		iniciar.addActionListener(new iniciarBoton());
		salir.addActionListener(new salirBoton());
		
		this.gui.getContentPane().add(fondo,0);
		this.gui.getContentPane().add(iniciar,1);
		this.gui.getContentPane().add(salir,1);	
	
	}

	private class iniciarBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			gui.getContentPane().remove(fondo);
			gui.getContentPane().remove(iniciar);
			gui.getContentPane().remove(salir);
			
			gui.iniciarJuego();
			
		}
	}
	
	private class salirBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			gui.salirJuego();
			
		}
	}
		
}
