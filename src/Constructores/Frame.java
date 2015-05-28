package Constructores;

import java.sql.Timestamp;

/**
 * @author Fabian_H
 */
public class Frame {
    public int id,id_pagina,tamaño;
    public String pertenece_a_proceso;
    public Timestamp tiempo;

    public Frame(int id, int tamaño) {
        this.id = id;
        this.id_pagina = 0; //0 quiere decir que no tiene ninguna pagina asignada
        this.tamaño = tamaño;
        this.pertenece_a_proceso = null;
        this.tiempo = null;
    }
}
