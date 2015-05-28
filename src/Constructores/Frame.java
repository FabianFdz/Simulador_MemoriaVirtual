package Constructores;

import java.sql.Timestamp;
import java.util.LinkedList;

/**
 * @author Fabian_H
 */
public class Frame {
    public int id,id_pagina,tamaño;
    public String pertenece_a_proceso;
    public Timestamp tiempo_ejecucion;//tiempo en el que el frame se ejecutó.
    public Timestamp tiempo_entrada; //tiempo en el que el frame entró a memoria.
    public Pagina pag;

    public Frame(int id, int tamaño) {
        this.id = id;
        this.id_pagina = -1; //-1 quiere decir que no tiene ninguna pagina asignada
        this.tamaño = tamaño;
        this.pertenece_a_proceso = null;
        this.tiempo_ejecucion = null;
    }

    //metodo que recibe todos los frames, y saca los frames de un solo proceso.
    public LinkedList frames_de_un_proceso (String proceso){
        LinkedList<Frame> frames_de_un_proceso = new LinkedList<Frame>();
        
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).pertenece_a_proceso.equals(proceso)){
                frames_de_un_proceso.add(Constantes.Frames.get(i));
            }
        }
        
        return frames_de_un_proceso;
    }
}
