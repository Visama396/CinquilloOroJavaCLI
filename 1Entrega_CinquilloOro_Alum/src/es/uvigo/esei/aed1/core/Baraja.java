/*
* Representa la baraja española pero con 8 y 9, en total 48 cartas, 4 palos, valores de las cartas de 1 a 12. 
* Estructura: se utilizará un TAD adecuado
* Funcionalidad: barajar las cartas, devolver la carta situada encima del montón de cartas
 */

package es.uvigo.esei.aed1.core;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baraja {

    private List<Carta> cartas = new ArrayList<Carta>();

    public Baraja(boolean barajar) {
        crearBaraja();

        if (barajar) {
            barajar();
        }
    }

    private void crearBaraja() {
        for (int i = 0; i < Carta.Palo.values().length; i++) {
            for (int j = 0; j < Carta.Valor.values().length; j++) {
                cartas.add(new Carta(Carta.Valor.values()[j], Carta.Palo.values()[i]));
            }
        }
    }

    public List<Carta> getCartas() {
        return cartas;
    }

    public void barajar() {
        Collections.shuffle(cartas);
    }
}
