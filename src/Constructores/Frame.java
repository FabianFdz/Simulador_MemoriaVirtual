package Constructores;

/**
 * @author Fabian_H
 */
class Frame {
    public int id,id_pagina,dirty_bit,tamaño;

    public Frame(int id, int id_pagina, int tamaño) {
        this.id = id;
        this.id_pagina = -1; //-1 quiere decir que no tiene ninguna pagina asignada
        this.dirty_bit = 0;
        this.tamaño = tamaño;
    }
}
