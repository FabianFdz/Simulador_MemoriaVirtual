package Constructores;

import java.util.LinkedList;

/**
 * @author Fabian_H
 */
public class Proceso {
    public String nombre,unidad_memoria; //Unidad = MB, GB, Byte, etc.
    public int memoria,prioridad;
    public static LinkedList<Proceso> cola_procesos = new LinkedList();

    public Proceso(String nombre, String unidad_memoria, int memoria, int prioridad) {
        this.nombre = nombre;
        this.unidad_memoria = unidad_memoria;
        this.memoria = memoria;
        this.prioridad = prioridad;
    }
}
