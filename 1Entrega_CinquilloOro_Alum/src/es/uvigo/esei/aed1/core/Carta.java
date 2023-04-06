/*
 * Representa una carta, formada por un número y su palo correspondiente
 */


package es.uvigo.esei.aed1.core;

public class Carta {
    public enum Palo { OROS, ESPADAS, BASTOS, COPAS };
    public enum Valor { AS, DOS, TRES, CUATRO, CINCO, SEIS, SIETE, OCHO, NUEVE, SOTA, CABALLO, REY };
    private final Palo palo;
    private final Valor carta;
    public Carta(Valor carta, Palo palo) {
        this.palo = palo;
        this.carta = carta;
    }

    public Palo getPalo() {
        return palo;
    }

    public Valor getCarta() {
        return carta;
    }

    public int getValor() {
        return carta.ordinal()+1;
    }

    @Override
    public String toString() {
        return String.format("%s de %s", carta, palo);
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        if (obj instanceof Carta other) {
            result = other.carta.equals(carta) && other.palo.equals(palo);
        }

        return result;
    }
}
