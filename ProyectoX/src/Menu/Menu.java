package Menu;

import Grafica.*;

import java.applet.Applet;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.media.jfxmedia.AudioClip;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

public class Menu extends JFrame {
	JPanelConFondo panel;
	JLabel hola;
	JButton pantalla;
	Juego j;

	public static void main(String[] args) {
		Menu m = new Menu();
		m.setVisible(true);
	}

	public Menu() {
		setTitle("Bomberman");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 540);
		setLayout(new GridLayout());
			panel = new JPanelConFondo();
			hola = new JLabel("hola");
			panel.add(hola);
			setContentPane(panel);
			pantalla = new JButton("press");
			pantalla.addActionListener(new OyenteBoton());
			panel.add(pantalla);
	}

	private class OyenteBoton implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			j = new Juego();
			j.setVisible(true);
		}
	}
}
