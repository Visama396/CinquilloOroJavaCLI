/**
 * Representa la interfaz del juego del Cinquillo-Oro, en este proyecto va a ser una entrada/salida en modo texto 
 * Se recomienda una implementación modular.
 */

package es.uvigo.esei.aed1.iu;

import es.uvigo.esei.aed1.core.Jugador;

import java.util.*;

public class IU {
    private final Scanner teclado;

    public IU() {
            teclado = new Scanner(System.in).useDelimiter("\r?\n");
    }

    /**
     * Lee un num. de teclado
     * 
     * @param msg El mensaje a visualizar.
     * @return El num., como entero
     */
    public int leeNum(String msg) {
        do {
                System.out.print(msg);

                try {
                        return teclado.nextInt();
                } catch (InputMismatchException exc) {
                        teclado.next();
                        System.out.println("Entrada no válida. Debe ser un entero.");
                }
        } while (true);
    }

    public String leeString(String msg) {
        System.out.print(msg);
        return teclado.next();
    }

    public String leeString(String msg, Object... args) {
        System.out.printf(msg, args);
        return teclado.next();
    }

    public void mostrarMensaje(String msg) {
        System.out.println(msg);
    }

    public void mostrarMensaje(String msg, Object... args) {
        System.out.printf(msg, args);
    }



    public Collection<String> pedirDatosJugadores() {
        List<String> jugadores = new ArrayList<>();
        int numJugadores;

        do {
            numJugadores = leeNum("¿Cuántos jugadores van a jugar? (3 ó 4): ");
        } while(numJugadores < 3 || numJugadores > 4);

        for (int i = 1; i <= numJugadores; i++) {
            String nombre = leeString("Escribe el nombre del jugador "+i+": ");
            jugadores.add(nombre);
        }

        return jugadores;
    }



    public void mostrarJugador(Jugador jugador) {

    }

    public void mostrarJugadores(Collection<Jugador> jugadores) {

    }
   
    
}
