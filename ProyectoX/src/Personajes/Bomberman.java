/**
 * Es el personaje principal del juego, el usuario lo utilizara para tratar de ganar el juego,
 * @authors Leandro Furyk, Juan Ignacio Cangelosi, Luciano Fuentes
 */
package Personajes;

import mapa.Celda;

import javax.swing.JOptionPane;

import Bomba.*;
import Grafica.BombermanGrafico;
//import Grafica.GameOver;
import Grafica.Mensaje;

public class Bomberman extends Personaje {
	// Atributos de Instancia
	private AbstractFactory a;
	protected int cantBombas;
	protected boolean termino;

	// Constructor
	public Bomberman(Celda c) {
		super(c);
		p=new BombermanGrafico(celda.getPosX()*32,celda.getPosY()*32);
		velocidad = 2;
		especial = false;
		termino= false; //Indicara que el efecto masacrality termino pero permitira a el personaje salir de un lugar rodeado de paredes
		cantBombas = 1;
		a=new FabricaBomba();
		p.setVelocidad(velocidad);
	}

	// Metodos
	/**
	 * Aumenta o reduce la velocidad segun le parametro n
	 * 
	 * @param n
	 *            es el numero por el cual sera reemplazada la velocidad
	 */
	public void setVelocidad(int n) {
		velocidad = n;
		p.setVelocidad(n);
	}

	/**
	 * Permite a boomberman darle el modo especial donde puede atravesar paredes
	 * y poner bombas ilimitadas
	 * 
	 * @param b
	 *            indica el valor que permitira a bomberman ser o no especial
	 */
	public void ponerEspecial(Boolean b) {
		especial = b;
	}

	/**
	 * Puede aumentar o disminuir la cantidad de bombas disponibles para
	 * Bomberman
	 * 
	 * @param n
	 *            es la nueva cantidad de bombas disponibles a colocar
	 */
	public void setCantBombas(int n) {
		cantBombas = n;
	}

	/**
	 * Si el personaje es tocado por algun enemigo � alcanzado por la bomba, se
	 * muere
	 */
	public void morir() {
		System.out.println("bomberman murio, game over");
		celda.setBomberman(null);
		p.morir();
		muerto = true;
	}

	/**
	 * Libera la celda actual y ocupa la siguiente con Bomberman
	 */
	protected void ocupar(Celda c, int n) {
		c.avanzar(this,n);
	}

	// Consultas
	/**
	 * Le pide una bomba a la fabrica y la coloca en el mapa
	 * 
	 * @return Devuelve la bomba colocada en el mapa
	 */
	public Bomba colocarBomba() {
		Bomba b1=null;
		if (especial) {
			b1=a.darBomba(celda);
			celda.ponerBomba(b1);
		} else {
			if (a.cantBombas() < cantBombas){
				b1=a.darBomba(celda);
				celda.ponerBomba(b1);
			}	
		}
		return b1;
	}

	/**
	 * Devuelve la cantidad de bombas que bomberman puede colocar
	 * 
	 * @return retorna el maximo de bombas a colocar
	 */
	public int cantBombas() {
		return cantBombas;
	}

	/**
	 * Devuelve la velocidad que bomberman puede andar
	 * 
	 * @return retorna la velocidad de bomberman
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Devuelve la fabrica de bombas de Bomberman
	 * 
	 * @return retorna la fabrica de bombas
	 */
	public AbstractFactory fabrica() {
		return a;
	}
	/**
	 * Avisa a bomberman que el efecto termino asi puede escapar de una pared indestructible
	 */
	public void setTermino(boolean b){
		termino=b;
	}
	
	/**
	 * Devuelve el flag de que termino el efecto
	 */
	public boolean termino(){
		return termino;
	}
	
}
