package Fetch;

import Constructores.Atributos_text;
import Constructores.Proceso;

/**
 * @author Fabian_Fdz
 */

/*
La idea es que esta memoria pricipal con n frames y secundaria con m frames, cuando se hace fetch se hace referencia a la
pagina que se quiere traer a memoria principal
*/
public class fetch {

    public static void fetch_demanda(Atributos_text linea, String tipo_reemplazo) {
        //cada vez que hace una referencia pasa la pagina a memoria
        System.out.println("hola");
        Proceso P = new Proceso(null, null, 0, 0);
        for (int i = 0; i < Proceso.cola_procesos.size(); i++) {
            if(linea.id_proceso.equals(Proceso.cola_procesos.get(i).nombre)){
                if (linea. > Proceso.cola_procesos.get(i).memoria) {
                    
                }
            }
        }
    }

    public static void fetch_prepaginacion() {
        /*  
            cada vez que hace una referencia pasa n paginas a memoria
            donde n = 2 elevado a la [valor del offset]
        */
    }
}
