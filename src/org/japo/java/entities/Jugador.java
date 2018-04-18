/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.japo.java.entities;

import java.util.Objects;

/**
 *
 * @author (c) 2017 Martín Emilov Petkov - marempet@gmail.com ®
 */
public class Jugador {

    // CONSTANTES - VARIABLES DE TRABAJO
    // CONSTANTES - VARIABLES POR DEFECTO
    public final int DEF_PUNTOS = 0;
    public final String DEF_NOMBRE = "";
    public final int DEF_ID = 0;
    public final int DEF_VICTORIAS = 0;
    public final int DEF_DERROTAS = 0;
    public final int DEF_RANKING = 0;
    public final int DEF_SEED = 1;

    // VARIABLES DE ENTORNO
    private int puntos;
    private String nombre;
    private int id;
    private int victorias;
    private int derrotas;
    private int ranking;
    private int seed;

    //CONSTRUCTOR PREDETERMINADO
    public Jugador() {
        puntos = DEF_PUNTOS;
        nombre = DEF_NOMBRE;
        id = DEF_ID;
        victorias = DEF_VICTORIAS;
        derrotas = DEF_DERROTAS;
        ranking = DEF_RANKING;
        seed = DEF_SEED;
    }

    //CONSTRUCTOR PARAMETRIZADO
    public Jugador(int puntos, String nombre, int id, int victorias, int derrotas, int ranking,int seed) {
        this.puntos = puntos;
        this.nombre = nombre;
        this.id = id;
        this.victorias = victorias;
        this.derrotas = derrotas;
        this.ranking = ranking;
        this.seed = seed;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVictorias() {
        return victorias;
    }

    public void setVictorias(int victorias) {
        this.victorias = victorias;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.puntos;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + this.id;
        hash = 71 * hash + this.victorias;
        hash = 71 * hash + this.derrotas;
        hash = 71 * hash + this.ranking;
        hash = 71 * hash + this.seed;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Jugador other = (Jugador) obj;
        if (this.puntos != other.puntos) {
            return false;
        }
        if (this.id != other.id) {
            return false;
        }
        if (this.victorias != other.victorias) {
            return false;
        }
        if (this.derrotas != other.derrotas) {
            return false;
        }
        if (this.ranking != other.ranking) {
            return false;
        }
        return Objects.equals(this.nombre, other.nombre);
    }

    

}
