/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.libraries;

import java.util.Random;
import org.japo.java.entities.Jugador;

/**
 *
 * @author Martin Emilov Petkov
 */
public class UtilesTennis {

    public static int numeroJugadores(int seleccion) {
        int num_jugadores = 0;
        switch (seleccion) {
            case 1:
                num_jugadores = 8;
                break;
            case 2:
                num_jugadores = 16;
                break;
            case 3:
                num_jugadores = 32;
                break;
            case 4:
                num_jugadores = 64;
                break;
            case 5:
                num_jugadores = 128;
                break;
        }
        return num_jugadores;
    }

    public static Jugador[] listaParticipantes(int num_jugadores, Jugador[] jugadores) {
        Jugador[] lista_part = new Jugador[num_jugadores];
        System.arraycopy(jugadores, 0, lista_part, 0, num_jugadores);
        return lista_part;
    }

    public static Jugador[] listaParticipantesAleatorios(int num_jugadores, Jugador[] jugadores) {
        Jugador[] lista_part = new Jugador[num_jugadores];
        jugadores = randomizarOrdenLista(jugadores);
        System.arraycopy(jugadores, 0, lista_part, 0, num_jugadores);
        return lista_part;
    }

    public static Jugador[] randomizarOrdenLista(Jugador[] jugadores) {
        Jugador aux;
        int index;
        Random random = new Random();
        for (int i = jugadores.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            aux = jugadores[index];
            jugadores[index] = jugadores[i];
            jugadores[i] = aux;
        }
        return jugadores;
    }

    public static Jugador[] asignarSeed(int num_jugadores, Jugador[] jugadores) {

        for (int i = 0; i < num_jugadores; i++) {
            for (int j = 0; j < num_jugadores; j++) {
                if (jugadores[i].getRanking() > jugadores[j].getRanking()) {
                    jugadores[i].setSeed((jugadores[i].getSeed() + 1));
                }
            }
        }
        return jugadores;
    }

    public static Jugador[] ordenarSeed(Jugador[] jugadores) {
        Jugador[] ordenados = new Jugador[jugadores.length];
        for (int i = 0; i < ordenados.length; i++) {
            int aux = jugadores[i].getSeed();
            ordenados[aux-1] = jugadores[i];
        }
        return ordenados;
    }
}
