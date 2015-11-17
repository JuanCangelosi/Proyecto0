package Grafica;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu extends JFrame{
	JPanel panel;
	JLabel hola;
	JButton pantalla;
	Juego j;
	public static void main(String[] args) {
				Menu m = new Menu();
				m.setVisible(true);
	}
	public Menu(){
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 540);
		setLayout(new GridLayout());
		panel=new JPanel();
		hola=new JLabel("hola");
		panel.add(hola);
		setContentPane(panel);
		pantalla=new JButton("press");
		pantalla.addActionListener(new OyenteBoton());
		panel.add(pantalla);
	}
	private class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			j=new Juego();
			j.setVisible(true);
			
		}
	}
}
