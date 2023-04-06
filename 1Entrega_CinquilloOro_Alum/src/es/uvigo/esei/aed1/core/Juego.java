/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


public class Juego {
    private final IU iu;
    private List<Jugador> jugadores;
    private Baraja baraja;

    public Juego(IU iu) {
        this.iu = iu;
        baraja = new Baraja(true);
        jugadores = new ArrayList<>();
    }

    /**
     * Ordena la lista de jugadores del juego para determinar el orden en el que juegan.
     * El primero de la lista siempre será el que tenga la carta CINCO de OROS, y el resto vendrán después, según se inscribieron en la partida.
     */
    private void ordenarJugadores() {
        List<Jugador> temp = new ArrayList<>();
        // La carta CINCO DE OROS tendrá el ordinal de PALO = 0, y de Valor = 4
        Carta cincoOros = new Carta(Carta.Valor.CINCO, Carta.Palo.OROS);

        for (Jugador jugador: jugadores) {
            if (jugador.getMano().contains(cincoOros)) {
                temp.add(jugador);
            }
        }

        for (Jugador jugador: jugadores) {
            if (!temp.contains(jugador)) {
                temp.add(jugador);
            }
        }
        jugadores.clear();
        jugadores = temp;
    }

    public void jugar() {
        // Preguntar cuantos jugadores van a jugar (3 o 4)
        Collection<String> nombres = iu.pedirDatosJugadores();

        for (String nombre : nombres) {
            jugadores.add(new Jugador(nombre));
        }

        iu.mostrarMensaje("Hay " + baraja.getCartas().size() + " cartas");
        for (Carta carta: baraja.getCartas()) {

            System.out.println(carta);
        }

        // Ahora que ya están los jugadores con sus nombres y la baraja de cartas creada en el constructor
        // Siguiente paso es repartir las cartas entre los jugadores
        int index = 0;
        for (Carta carta: baraja.getCartas()) {
            jugadores.get(index).recibeCarta(carta);

            index++;

            if (index == jugadores.size()) index=0;
        }

        // Mostrar la mano de cada jugador con su nombre
        for (Jugador jugador: jugadores) {
            iu.mostrarMensaje("\nEl jugador " + jugador + " tiene en mano las cartas:");

            for (Carta carta: jugador.getMano()) {
                System.out.println(carta);
            }
        }

        ordenarJugadores(); // Ahora el primer jugador va el primero de la lista.
        iu.mostrarMensaje("\nEl primer jugador es " + jugadores.get(0));

    }

}
