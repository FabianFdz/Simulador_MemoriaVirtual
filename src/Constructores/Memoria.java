package Constructores;

import java.util.LinkedList;

/**
 * @author Fabian_H
 */
public class Memoria {
    public String id;//Posibles valores ={secundaria,principal}
    public LinkedList en_memoria; //almacena las paginas en memoria secundaria o frames en memoria principal

    public Memoria(String id) { //Constructor para memoria principal y secundaria
        this.id = id;
        this.en_memoria = new LinkedList();
    }
    /*
        Ambos tipos de memoria poseen una lista en donde se almacenan ya sea los frames (en caso de principal) o
        las paginas (en caso de secundaria), al pasar una pagina a memoria principal se le adiere a la cola deel id de pagina 
        a
    */
}
