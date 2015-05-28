package Constructores;

import java.util.LinkedList;

/**
 *
 * @author FelixVives
 */
public interface Constantes {
    LinkedList<Pagina> Paginas = new LinkedList<Pagina>();
    LinkedList<Frame> Frames = new LinkedList<Frame>();
    Memoria Primaria = new Memoria("primaria");
    Memoria Secundaria = new Memoria("secundaria");
    Configuracion config = new Configuracion(null, null, null, null, null, null);
}
//Cristian estuvo aqui