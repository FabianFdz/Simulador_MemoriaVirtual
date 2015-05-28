package Constructores;

import Working_Set.working_set;
import static java.lang.Thread.sleep;

/**
 *
 * @author FelixVives
 */
public class Configuracion {
    public String fetch, placement, replacement, 
            replacement_scope, cleaning, tiempo_cleaning, load_control;
    public working_set ws;

    public Configuracion(String fetch, String placement, String replacement, String replacement_scope, String cleaning, String load_control) {
        this.fetch = fetch;
        this.placement = placement;
        this.replacement = replacement;
        this.replacement_scope = replacement_scope;
        this.cleaning = cleaning;
        this.load_control = load_control;
        this.ws = new working_set(true,2,3,4); //
    }    
}
