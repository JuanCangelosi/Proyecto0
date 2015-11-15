package Grafica;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public abstract class PersonajeGrafico extends EntidadGrafica {

	protected int direccion, muerto;
	protected Timer timer;
	protected ImageIcon morir, centro, abajo1, abajo2, arriba1, arriba2, arriba3, derecha1, derecha2, derecha3,
			izquierda1, izquierda2, izquierda3;
	private static final long serialVersionUID = 1L;
	private static final int recorrido = 4;
	private boolean semaforo;

	public PersonajeGrafico(int x, int y) {
		super(x, y);
		direccion = 0;
		muerto    = 0;
		semaforo  = true;
	}
	
	public boolean semaforo(){
		return semaforo;
	}

	public void derecha() {

		timer = new Timer(10, new ActionListener() {
			int contador = 0;

			public void actionPerformed(ActionEvent e) {
				
				x        += recorrido;
				contador += recorrido;
				if (direccion != 30 && direccion != 31 && direccion != 32)
					direccion = 30;
				else if (direccion == 30)
					direccion = 31;

				else if (direccion == 31)
					direccion = 32;

				else if (direccion == 32)
					direccion = 30;

				setBounds(x, y, 32, 32);

				repaint();

				if (contador >= 32) {
					contador = 0;
					//semaforo = true;
					timer.stop();
					
				}
			}
		});

		if(semaforo){
			semaforo = false;
			timer.start();

		}
			

	}

	public void izquierda() {

		timer = new Timer(10, new ActionListener() {
			int contador = 0;

			public void actionPerformed(ActionEvent e) {

				x        -= recorrido;
				contador += recorrido;

				if (direccion != 10 && direccion != 11 && direccion != 12)
					direccion = 10;

				else if (direccion == 10)
					direccion = 11;

				else if (direccion == 11)
					direccion = 12;

				else if (direccion == 12)
					direccion = 10;

				setBounds(x, y, 32, 32);

				repaint();

				if (contador >= 32) {
					contador = 0;
					//semaforo = true;
					timer.stop();
				}
			}
		});
		if(semaforo){
			semaforo = false;
			timer.start();
		}

	}

	public void arriba() {

		timer = new Timer(10, new ActionListener() {
			int contador = 0;

			public void actionPerformed(ActionEvent e) {

				y -= recorrido;
				contador += recorrido;
				if (direccion != 40 && direccion != 41 && direccion != 42)
					direccion = 40;

				else if (direccion == 40)
					direccion = 41;

				else if (direccion == 41)
					direccion = 42;

				else if (direccion == 42)
					direccion = 40;

				setBounds(x, y, 32, 32);
				repaint();

				if (contador >= 32) {
					contador = 0;
					//semaforo = true;
					timer.stop();
				}
			}
		});

		if(semaforo){
			semaforo = false;
			timer.start();
		}
	}

	public void abajo() {

		timer = new Timer(10, new ActionListener() {
			int contador = 0;

			public void actionPerformed(ActionEvent e) {
				
				y += recorrido;
				contador += recorrido;
				if (direccion != 0 && direccion != 20 && direccion != 21)
					direccion = 0;

				else if (direccion == 0)
					direccion = 20;

				else if (direccion == 20)
					direccion = 21;

				else if (direccion == 21)
					direccion = 0;

				setBounds(x, y, 32, 32);
				repaint();

				if (contador >= 32) {
					contador = 0;
					//semaforo = true;
					timer.stop();
				}
			}
		});

		if(semaforo){
			semaforo = false;
			timer.start();
		}
	}

	public void morir() {
		muerto = 1;
		repaint();
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (muerto == 1)
			g.drawImage(morir.getImage(), 0, 0, null);

		if (direccion == 0)
			g.drawImage(centro.getImage(), 0, 0, this);
		else if (direccion == 20)
			g.drawImage(abajo1.getImage(), 0, 0, this);
		else if (direccion == 21)
			g.drawImage(abajo2.getImage(), 0, 0, this);

		else if (direccion == 10)
			g.drawImage(izquierda1.getImage(), 0, 0, this);
		else if (direccion == 11)
			g.drawImage(izquierda2.getImage(), 0, 0, this);
		else if (direccion == 12)
			g.drawImage(izquierda3.getImage(), 0, 0, this);

		else if (direccion == 30)
			g.drawImage(derecha1.getImage(), 0, 0, this);
		else if (direccion == 31)
			g.drawImage(derecha2.getImage(), 0, 0, this);
		else if (direccion == 32)
			g.drawImage(derecha3.getImage(), 0, 0, this);

		else if (direccion == 40)
			g.drawImage(arriba1.getImage(), 0, 0, this);
		else if (direccion == 41)
			g.drawImage(arriba2.getImage(), 0, 0, this);
		else if (direccion == 42)
			g.drawImage(arriba3.getImage(), 0, 0, this);

	}

}
