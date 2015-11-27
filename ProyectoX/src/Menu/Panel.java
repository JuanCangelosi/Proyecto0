/**
 * Representa el menu del juego 
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;

public class Panel {

	private JLabel powerups,puntaje,tiempo;
	private Juego gui;
	private Timer timer;
	private int itiempo;

	public Panel(Juego gui) {
		
		this.gui  = gui;
		powerups  = new JLabel("Powerups : ");
		puntaje   = new JLabel("Puntaje : 0");
		tiempo    = new JLabel("Tiempo : "+itiempo);		
		itiempo   = 0;
		
		powerups.setBounds(0,420,200,50);
		puntaje.setBounds(486, 420, 200, 50);
		tiempo.setBounds(900, 420, 200, 50);
		
		
		this.gui.getContentPane().add(powerups,0);
		this.gui.getContentPane().add(puntaje,1);
		this.gui.getContentPane().add(tiempo,1);
		
		timer = new Timer(1500,new ActionListener () 
		{ 
		    public void actionPerformed(ActionEvent e) 
		    {
		    	itiempo++;
		    	tiempo.setText("Tiempo : "+itiempo);
		        
		     } 
		});
	
		timer.start();
	}
	/**
	 * Cambia el puntaje del escenario
	 * @param i puntaje a actualizar
	 */
	public void setPuntaje(int i){
		puntaje.setText("Puntaje : "+i);
	}
		
}