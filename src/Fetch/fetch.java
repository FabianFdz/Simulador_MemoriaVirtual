package Fetch;

import Constructores.Atributos_text;
import Constructores.Configuracion;
import Constructores.Constantes;
import Constructores.Pagina;
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
        Pagina new_pag = new Pagina(-1, -1, null);
        for (int i = 0; i < Constantes.Paginas.size(); i++) {
            if(Constantes.Paginas.get(i).id == linea.pagina_a_pasar){
                new_pag = Constantes.Paginas.get(i);
            }
        }
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).id_pagina == -1){
                Constantes.Frames.get(i).id_pagina = new_pag.id;
                Constantes.Frames.get(i).pertenece_a_proceso = new_pag.pertenece_a_proceso;
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
