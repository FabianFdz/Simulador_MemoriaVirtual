package Constructores;
/**
 * @author Fabian_Fdz
 */
public class Atributos_text {
    public String id_proceso;
    public int pagina_a_pasar;
    public char w_O_r;

    public Atributos_text(String id_proceso, int posicion_memoria, char w_O_r) {
        this.id_proceso = id_proceso;
        this.pagina_a_pasar = posicion_memoria;
        this.w_O_r = w_O_r;
    }    
}
