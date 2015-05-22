package Constructores;

import java.util.LinkedList;

/**
 *
 * @author FelixVives
 */
public interface Constantes {
    LinkedList<Pagina> Paginas = new LinkedList<Pagina>();
    Memoria seg = new Memoria("secundaria");
    Memoria pri = new Memoria("primaria");
}
