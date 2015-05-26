package Constructores;

import static java.lang.Thread.sleep;

/**
 *
 * @author FelixVives
 */
public class Configuracion {
    public String fetch, placement, replacement, resident_set, 
            replacement_scope, cleaning, tiempo_cleaning, load_control;

    public Configuracion(String fetch, String placement, String replacement, String resident_set, String replacement_scope, String cleaning, String load_control) {
        this.fetch = fetch;
        this.placement = placement;
        this.replacement = replacement;
        this.resident_set = resident_set;
        this.replacement_scope = replacement_scope;
        this.cleaning = cleaning;
        this.load_control = load_control;
    }    
}
