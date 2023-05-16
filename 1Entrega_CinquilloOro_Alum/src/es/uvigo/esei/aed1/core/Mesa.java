/*
* Representa la Mesa de juego. 
* Estructura: se utilizar un TAD adecuado. Piensa que hay 4 palos y de cada palo se pueden colocar cartas
* por cualquiera de los dos extremos (un array con 4 doblescolas parece lo más adecuado). La DobleCola se comentó en clase de teoría
* Funcionalidad: saber si es posible colocar una carta en la mesa, colocar una carta en la mesa, mostrar la mesa
 */
package es.uvigo.esei.aed1.core;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class Mesa {

	Deque<Carta>[] mesa = new Deque[4];

	public Mesa(){
		for (Deque d : mesa) {
			d = new ArrayDeque<Carta>();
		}
    }


	// mostrar el estado de la mesa
	@Override
    public String toString(){
		return "";
	}
	
    
}
