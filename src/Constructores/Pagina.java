package Constructores;

/**
 * @author Fabian_Fdz
 */

public class Pagina {
    public int id,tamaño;
    public Proceso pertenece_a_proceso;

    public Pagina(int id, int tamaño, Proceso pertenece_a_proceso) {
        this.id = id;
        this.tamaño = tamaño;
        this.pertenece_a_proceso = pertenece_a_proceso;
    }
}
