/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.app;

import java.util.Properties;
import org.japo.java.entities.Jugador;
import org.japo.java.libraries.UtilesApp;
import org.japo.java.libraries.UtilesEntrada;
import org.japo.java.libraries.UtilesTennis;

/**
 *
 * @author (c) 2017 Martín Emilov Petkov - marempet@gmail.com
 */
public class App {

    public static final String PRP_NOMBRES = "nombre";
    public static final String PRP_IDS = "id";
    public static final String PRP_PUNTOS = "puntos";
    public static final String PRP_VICTORIAS = "victorias";
    public static final String PRP_DERROTAS = "derrotas";
    public static final String PRP_RANKINGS = "ranking";
    public static final String PRP_SEEDS = "seed";
    public static final String MSG_USR_PART = "";
    public static final String MSG_ERR_PART = "ERROR";
    public static final String MSG_ERR_RAN_PART = "ERROR:Fuera de rango";
    public static final String TABLA_0 = "";
    public static final String TABLA_1 = "S";
    public static final String TABLA_2 = "R";
    public static final String TABLA_3 = "NOMBRE";
    public static final String TABLA_4 = "PUNTOS";
    public static final int LIM_INF_PART = 1;
    public static final int LIM_SUP_PART = 5;
    public static final int LIM_INF_GEN = 1;
    public static final int LIM_SUP_GEN = 2;

    public void launchApp() {
        //Importar propiedades
        Properties prp = UtilesApp.importarPropiedades();

        //importar datos
        String[] nombres = prp.getProperty(PRP_NOMBRES).split(",");
        String[] ids = prp.getProperty(PRP_IDS).split(",");
        String[] puntos = prp.getProperty(PRP_PUNTOS).split(",");
        String[] victorias = prp.getProperty(PRP_VICTORIAS).split(",");
        String[] derrotas = prp.getProperty(PRP_DERROTAS).split(",");
        String[] rankings = prp.getProperty(PRP_RANKINGS).split(",");
        String[] seeds = prp.getProperty(PRP_SEEDS).split(",");

        //transformar arrays string a int
        int[] ids_num = new int[ids.length];
        for (int i = 0; i < ids.length; i++) {
            ids_num[i] = Integer.parseInt(ids[i]);
        }

        int[] puntos_num = new int[puntos.length];
        for (int i = 0; i < puntos.length; i++) {
            puntos_num[i] = Integer.parseInt(puntos[i]);
        }

        int[] victorias_num = new int[victorias.length];
        for (int i = 0; i < victorias.length; i++) {
            victorias_num[i] = Integer.parseInt(victorias[i]);
        }

        int[] derrotas_num = new int[derrotas.length];
        for (int i = 0; i < derrotas.length; i++) {
            derrotas_num[i] = Integer.parseInt(derrotas[i]);
        }

        int[] rankings_num = new int[rankings.length];
        for (int i = 0; i < rankings.length; i++) {
            rankings_num[i] = Integer.parseInt(rankings[i]);
        }

        int[] seeds_num = new int[seeds.length];
        for (int i = 0; i < seeds.length; i++) {
            seeds_num[i] = Integer.parseInt(seeds[i]);
        }

        //crear el array de jugadores
        Jugador[] jugadores_lista = new Jugador[nombres.length];
        for (int i = 0; i < jugadores_lista.length; i++) {
            jugadores_lista[i] = new Jugador(puntos_num[i], nombres[i], ids_num[i], victorias_num[i], derrotas_num[i], rankings_num[i], seeds_num[i]);
            //introduccion

        }

        System.out.println("            BIENVIENIDOS AL MARTIN's TENNIS SIMULATOR 2018            ");
        System.out.println("======================================================================");
        System.out.println("");
        System.out.println("Aqui tenemos el TOP 10");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%-2d %-21s %5d %n", jugadores_lista[i].getRanking(), jugadores_lista[i].getNombre(), jugadores_lista[i].getPuntos());
        }

        System.out.println("\n\n");
        System.out.println("Seleccione número de participantes:");
        System.out.println("1.   8 jugadores");
        System.out.println("2.  16 jugadores");
        System.out.println("3.  32 jugadores");
        System.out.println("4.  64 jugadores");
        System.out.println("5. 128 jugadores");
        int seleccion = UtilesEntrada.leerEnteroRango(MSG_USR_PART, MSG_ERR_PART, MSG_ERR_RAN_PART, LIM_INF_PART, LIM_SUP_PART);
        int num_jugadores = UtilesTennis.numeroJugadores(seleccion);
        System.out.printf("Has seleccionado %d jugadores", num_jugadores);
        System.out.println("\n\n");
        System.out.println("¿Que tipo de draft tiene su torneo?:");
        System.out.println("1.Jugadores por ranking");
        System.out.println("2.Jugadores aleatorios");
        seleccion = UtilesEntrada.leerEnteroRango(MSG_USR_PART, MSG_ERR_PART, MSG_ERR_RAN_PART, LIM_INF_GEN, LIM_SUP_GEN);
        Jugador[] lista_part = new Jugador[num_jugadores];
        if (seleccion == 1) {
            System.out.println("Ha seleccionado Jugadores por ranking");
            lista_part = UtilesTennis.listaParticipantes(num_jugadores, jugadores_lista);
        } else {
            System.out.println("Ha seleccionado Jugadores aleatorios");
            lista_part = UtilesTennis.listaParticipantesAleatorios(num_jugadores, jugadores_lista);
        }
        System.out.println("\n\n");
        System.out.println("                     PARTICIPANTES DEL TORNEO");
        System.out.println("======================================================================");
        System.out.println("");
        lista_part = UtilesTennis.asignarSeed(num_jugadores, lista_part);
        lista_part = UtilesTennis.ordenarSeed(lista_part);
        System.out.printf("%-2s %-3s %-23s %5s %n", TABLA_1, TABLA_2, TABLA_3, TABLA_4);
        for (int i = 0; i < lista_part.length; i++) {
            if (((lista_part[i].getSeed() < 9) && (num_jugadores < 33))
                    || ((lista_part[i].getSeed() < 17) && (num_jugadores == 32))
                    || ((lista_part[i].getSeed() < 33) && (num_jugadores > 33))) {
                System.out.printf("%-2d %-3d %-23s %5d %n", lista_part[i].getSeed(), lista_part[i].getRanking(), lista_part[i].getNombre(), lista_part[i].getPuntos());
            } else {
                System.out.printf("%-2s %-3d %-23s %5d %n", TABLA_0, lista_part[i].getRanking(), lista_part[i].getNombre(), lista_part[i].getPuntos());
            }
        }
        
        boolean exportarPropiedadesStream = UtilesApp.exportarPropiedadesStream(prp,"Apprueba.properties");

    }

}
