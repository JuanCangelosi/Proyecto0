package Gui;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JPanel {
	private JPanel panelImagen;
	private JPanel panelTexto, panelSur;
	private JButton boton;
	private JFrame frame;
	private JLabel imagen;
	private JLabel texto;
	private JTextField texto1;

	public Gui(){
		frame = new JFrame("The simpsons");
		Image img1 = new ImageIcon(this.getClass().getResource(
				"/Imagenes/icono.jpg")).getImage();
		frame.setIconImage(img1);
		frame.setSize(new Dimension(500,385));
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout());
		
		panelTexto=new JPanel();
		panelImagen=new JPanel();
		ImageIcon img = new ImageIcon(this.getClass().getResource(
				"/Imagenes/Ralph.jpg"));
		imagen=new JLabel(img);
		panelImagen.add(imagen);
		
		//Panel Sur contiene cuadro de texto y botonera
		panelSur= new JPanel();
		panelSur.setLayout(new GridLayout(2,1));
		texto1= new JTextField();
		texto1.setEditable(false);
		texto1.setBackground(Color.WHITE);
		panelSur.add(texto1);
		texto1.setHorizontalAlignment(JTextField.CENTER);
		boton=new JButton("PRESIONAME");
		boton.setBackground(Color.WHITE);
		boton.addActionListener(new OyenteBoton());
		panelSur.add(boton);
		
		frame.getContentPane().add(panelTexto);
		frame.getContentPane().add(panelImagen, BorderLayout.CENTER);
		frame.getContentPane().add(panelSur, BorderLayout.SOUTH);
		
		}
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			texto1.setText("Hola Lisa, hola super Nintendo Chalmers.");
			texto1.setFont(new Font("Arial", Font.BOLD, 20));
		}
	}
}
