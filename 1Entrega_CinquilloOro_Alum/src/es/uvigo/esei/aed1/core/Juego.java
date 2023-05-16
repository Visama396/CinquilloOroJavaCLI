/**
 * Representa el juego del Cinquillo-Oro, con sus reglas (definidas en el documento Primera entrega). 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.core;

import es.uvigo.esei.aed1.iu.IU;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;
import java.util.List;


public class Juego {
    private final IU iu;
    private List<Jugador> players;
    private Baraja deck;

    public Juego(IU iu) {
        this.iu = iu;
        deck = new Baraja(true);
        players = new ArrayList<>();
    }

    /**
     * Ordena la lista de jugadores del juego para determinar el orden en el que juegan.
     */
    private void ordenarJugadores() {
        List<Jugador> _temp = new ArrayList<>();
        Random _r = new Random();
        int _index = _r.nextInt(1, players.size()+1);

        _temp.add(players.get(_index));

        for (Jugador jugador: players) {
            if (!_temp.contains(jugador)) {
                _temp.add(jugador);
            }
        }

        players.clear();
        players = _temp;
    }

    public void jugar() {
        // Preguntar cuantos jugadores van a jugar (3 o 4)
        Collection<String> nombres = iu.pedirDatosJugadores();

        for (String nombre : nombres) {
            players.add(new Jugador(nombre));
        }

        // Ahora que ya están los jugadores con sus nombres y la baraja de cartas creada en el constructor
        // Siguiente paso es repartir las cartas entre los jugadores
        int index = 0;
        for (Carta carta: deck.getCartas()) {
            players.get(index).recibeCarta(carta);

            index++;
            if (index == players.size()) index=0;
        }

        // Mostrar la mano de cada jugador con su nombre
        for (Jugador jugador: players) {
            iu.mostrarMensaje("\n" + jugador);
            iu.mostrarMano(jugador);
        }

        ordenarJugadores();

    }

}
