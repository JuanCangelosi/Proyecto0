/**
 * Abstraccion grafica de los personajes dentro del escenario
 * @author Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */

package PersonajesGraficos;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Grafica.EntidadGrafica;
import javax.swing.ImageIcon;
import javax.swing.Timer;

public abstract class PersonajeGrafico extends EntidadGrafica {

	protected int direccion, muerto;
	protected Timer timer;
	protected ImageIcon morir, centro, abajo1, abajo2, arriba1, arriba2,
			arriba3, derecha1, derecha2, derecha3, izquierda1, izquierda2,
			izquierda3;
	private static final long serialVersionUID = 1L;
	private int vel;

	public PersonajeGrafico(int x, int y) {
		super(x, y);
		direccion = 0;
		muerto = 0;
		vel = 1;
	}

	/**
	 * Setea la velocidad del personaje logico
	 * 
	 * @param v
	 *            velocidad incorporar
	 */
	public void setVelocidad(int v) {
		vel = v;
	}
	
	/**
	 * Realiza graficamente el movimiento a derecha
	 */
	public void derecha() {
		for (int i = 0; i < 32; i += 4) {
			x += 4;
			if (direccion != 30 && direccion != 31 && direccion != 32)
				direccion = 30;
			else if (direccion == 30)
				direccion = 31;

			else if (direccion == 31)
				direccion = 32;

			else if (direccion == 32)
				direccion = 30;

			setBounds(x, y, 32, 32);
			try {
				Thread.sleep(calcular());
			} catch (Exception e) {
			}
			repaint();
		}
	}
	/**
	 * Realiza graficamente el movimiento a izquierda
	 */
	public void izquierda() {
		for (int i = 0; i < 32; i += 4) {
			x -= 4;
			if (direccion != 10 && direccion != 11 && direccion != 12)
				direccion = 10;

			else if (direccion == 10)
				direccion = 11;

			else if (direccion == 11)
				direccion = 12;

			else if (direccion == 12)
				direccion = 10;

			setBounds(x, y, 32, 32);
			try {
				Thread.sleep(calcular());
			} catch (Exception e) {
			}

			repaint();
		}

	}

	/**
	 * Realiza graficamente el movimiento a arriba
	 */
	public void arriba() {
		for (int i = 0; i < 32; i += 4) {
			y -= 4;
			if (direccion != 40 && direccion != 41 && direccion != 42)
				direccion = 40;

			else if (direccion == 40)
				direccion = 41;

			else if (direccion == 41)
				direccion = 42;

			else if (direccion == 42)
				direccion = 40;

			setBounds(x, y, 32, 32);
			try {
				Thread.sleep(calcular());
			} catch (Exception e) {
			}
			repaint();
		}
	}
	
	/**
	 * Realiza graficamente el movimiento abajo
	 */
	public void abajo() {
		for (int i = 0; i < 32; i += 4) {
			y += 4;
			if (direccion != 0 && direccion != 20 && direccion != 21)
				direccion = 0;

			else if (direccion == 0)
				direccion = 20;

			else if (direccion == 20)
				direccion = 21;

			else if (direccion == 21)
				direccion = 0;

			setBounds(x, y, 32, 32);
			try {
				Thread.sleep(calcular());
			} catch (Exception e) {
			}
			repaint();
		}

	}
	
	/**
	 * Implementa la animacion de la muerte grafica del personaje
	 */
	public void morir() {
		muerto = 1;
		direccion = -1;
		timer = new Timer(1500, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				eliminar();
			}
		});

		timer.start();
		repaint();
	}
	
	/**
	 * Pinta el componente en el mapa
	 * @param g grafico a pintar
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (muerto == 1)
			g.drawImage(morir.getImage(), 0, 0, this);
		else if (direccion == 0)
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

	/**
	 * Calcula la cantidad de tiempo a esperar segun la velocidad del personaje
	 * @return retorna el tiempo de espera
	 */
	private int calcular() {
		int n = 0;
		switch (vel) {
		case 1: {
			n = 120;
			break;
		}
		case 2: {
			n = 100;
			break;
		}
		case 4: {
			n = 80;
			break;
		}
		case 8: {
			n = 60;
			break;
		}
		case 16: {
			n = 40;
			break;
		}
		case 32: {
			n = 20;
			break;
		}
		}
		return n;
	}

}
