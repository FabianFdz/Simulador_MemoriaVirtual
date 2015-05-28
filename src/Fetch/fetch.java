package Fetch;

import Constructores.Atributos_text;
import Constructores.Configuracion;
import Constructores.Constantes;
import Constructores.Frame;
import Constructores.Pagina;
import Constructores.Proceso;
import Working_Set.working_set;

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
            if (Constantes.Paginas.get(i).id == linea.pagina_a_pasar) {
                new_pag = Constantes.Paginas.get(i);
            }
        }
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if (Constantes.Frames.get(i).id_pagina == 0) {
                Constantes.Frames.get(i).id_pagina = new_pag.id;
                Constantes.Frames.get(i).pertenece_a_proceso = new_pag.pertenece_a_proceso;
            }
        }
    }

    public static void fetch_prepaginacion(Atributos_text linea, String tipo_reemplazo) {
        Pagina new_pag = new Pagina(-1, -1, null);
        for (int i = 0; i < Constantes.Paginas.size(); i++) {
            if (Constantes.Paginas.get(i).id == linea.pagina_a_pasar) {
                new_pag = Constantes.Paginas.get(i);
                break;
            }
        }
        if(todos_frames_llenos()){
            //aqui lo de reemplazo
            System.out.println("Todos los frames estan llenos");
            return;
        }
        for (Frame Frame : Constantes.Frames) {
            if (Frame.id_pagina == 0 && Frame.pertenece_a_proceso.equals(new_pag.pertenece_a_proceso)) {
                Frame.id_pagina = new_pag.id;
                Frame.pertenece_a_proceso = new_pag.pertenece_a_proceso;
                return;
            }
        }
        working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set minimo*/);
        if(/*Working set variable*/true){
            if(/*minimo + tasa de crecimiento > maximo*/true){
                //minimo = maximo
            }else{
                //minimo = minimo + tasa de crecimiento
            }
        }
        for (Frame Frame : Constantes.Frames) {
            if (Frame.id_pagina == 0 && Frame.pertenece_a_proceso.equals(new_pag.pertenece_a_proceso)) {
                Frame.id_pagina = new_pag.id;
                Frame.pertenece_a_proceso = new_pag.pertenece_a_proceso;
                return;
            }
        }
    }
    
    private static boolean todos_frames_llenos(){
        for (Frame Frame : Constantes.Frames) {
            if (Frame.pertenece_a_proceso.equals(null)) {
                return false;
            }
        }
        return true;
    }
}
