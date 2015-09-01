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
	private JTextPane texto1;
	public static void main(String[] args) {
		Gui window = new Gui();
		window.frame.setVisible(true);
	}
	public Gui(){
		frame = new JFrame("The simpsons");
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
		panelSur.setLayout(new GridLayout(1,2));
		texto1= new JTextPane();
		texto1.setEditable(false);
		panelSur.add(texto1);
		boton=new JButton("PRESIONAME");
		boton.setBackground(Color.WHITE);
		boton.addActionListener(new OyenteBoton());
		panelSur.add(boton);
		
		frame.add(panelTexto);
		frame.add(panelImagen, BorderLayout.CENTER);
		frame.add(panelSur, BorderLayout.SOUTH);
		
		}
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			ImageIcon img1 = new ImageIcon(this.getClass().getResource(
					"/Imagenes/Ralph2.gif"));
			texto1.setText("Hi, Super Nintendo Chalmers.");
			imagen.setIcon(img1);
		}
	}
}
