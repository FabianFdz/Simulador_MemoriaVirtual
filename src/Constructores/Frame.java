package Constructores;

/**
 * @author Fabian_H
 */
public class Frame {
    public int id,id_pagina,dirty_bit,tamaño;
    public String pertenece_a_proceso;

    public Frame(int id, int tamaño) {
        this.id = id;
        this.id_pagina = -1; //-1 quiere decir que no tiene ninguna pagina asignada
        this.dirty_bit = 0;
        this.tamaño = tamaño;
        this.pertenece_a_proceso = null;
    }
}
