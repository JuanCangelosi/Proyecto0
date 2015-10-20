package Bomba;

import Logica.*;

public class FabricaBomba implements AbstractFactory {
	// Atributos de Intancia
	protected int radio;
	protected int cantBombas;

	// Constructor
	public FabricaBomba() {
		radio = 1;
		cantBombas = 0;
	}

	// Metodos
	public void duplicar() {
		radio *= 2;
	}

	public void aumentarBombas() {
		cantBombas++;
	}

	// Consultas
	public Bomba darBomba(Celda c) {
		Bomba b = new Bomba(c);
		cantBombas++;
		b.setRadio(radio);
		return b;
	}

	public int cantBombas() {
		return cantBombas;
	}
}
