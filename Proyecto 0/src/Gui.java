import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Gui extends JPanel {
	private JPanel panelImagen;
	private JPanel panelTexto;
	private JButton boton;
	private JFrame frame;
	private JLabel imagen;
	private JLabel texto;
	public static void main(String[] args) {
		Gui window = new Gui();
		window.frame.setVisible(true);
	}
	public Gui(){
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new FlowLayout());
		
		panelTexto=new JPanel();
		texto=new JLabel();
		panelImagen=new JPanel();
		Image img = new ImageIcon(this.getClass().getResource(
				"/Imagenes/Ralph.jpg")).getImage();
		imagen=new JLabel(new ImageIcon(img));
		panelImagen.add(imagen);
		panelTexto.add(texto);
		
		boton=new JButton("Presione Aqui");
		boton.addActionListener(new OyenteBoton());
		frame.add(panelTexto);
		frame.add(panelImagen);
		frame.add(boton);
		
		}
	private class OyenteBoton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Image img1 = new ImageIcon(this.getClass().getResource(
					"/Imagenes/Ralph Gif.gif")).getImage();
			imagen.setIcon(new ImageIcon(img1));
			texto.setText("Hola super nintendo Chalmers");
			panelTexto.add(texto);
		}
	}
}
