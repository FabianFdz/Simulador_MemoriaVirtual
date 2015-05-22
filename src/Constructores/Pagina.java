package Constructores;

/**
 * @author Fabian_Fdz
 */

public class Pagina {
    public int id,tamaño;
    public String pertenece_a_proceso;

    public Pagina(int id, int tamaño, String pertenece_a_proceso) {
        this.id = id;
        this.tamaño = tamaño;
        this.pertenece_a_proceso = pertenece_a_proceso;
    }
}
