package Fetch;

import Constructores.Atributos_text;
import Constructores.Configuracion;
import Constructores.Constantes;
import Constructores.Frame;
import Constructores.Pagina;
import Constructores.Proceso;
import Working_Set.working_set;
import java.util.LinkedList;

/**
 * @author Fabian_Fdz
 */

/*
 La idea es que esta memoria pricipal con n frames y secundaria con m frames, cuando se hace fetch se hace referencia a la
 pagina que se quiere traer a memoria principal
 */
public class fetch {

    public static void fetch_prepaginacion(Atributos_text linea, String tipo_reemplazo) {
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

    /*public static void fetch_demanda(Atributos_text linea, String tipo_reemplazo) {
        Pagina new_pag = new Pagina(-1, -1, null);
        for (int i = 0; i < Constantes.Paginas.size(); i++) {
            if (Constantes.Paginas.get(i).id == linea.pagina_a_pasar) {
                new_pag = Constantes.Paginas.get(i);
                break;
            }
        }
        if (todos_frames_llenos()) {
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
        if (/*Working set variable/true) {
            if (/*minimo == maximo/true) {
                working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual/);
            } else if (/*minimo + tasa de crecimiento > maximo/true) {
                working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual/);
                //actual = maximo
            } else {
                working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual/);
                //actual = actual + tasa de crecimiento
            }
        } else {
            working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set minimo/);
        }
        for (Frame Frame : Constantes.Frames) {
            if (Frame.id_pagina == 0 && Frame.pertenece_a_proceso.equals(new_pag.pertenece_a_proceso)) {
                Frame.id_pagina = new_pag.id;
                Frame.pertenece_a_proceso = new_pag.pertenece_a_proceso;
                return;
            }
        }
    }*/

    public static void fetch_demanda(Atributos_text linea, String tipo_reemplazo) {
        //cada vez que hace una referencia pasa la pagina a memoria
        Pagina new_pag = new Pagina(-1, -1, null);
        int bandera = 0;
        int paginaDeseada = ((linea.pagina_a_pasar) / (((int) Math.pow(2, constantes.L_Esquema.get(0).getBits_Offset())) / 1024));
        if (constantes.Paginas.size() >= paginaDeseada) {
            if (constantes.Paginas.get(paginaDeseada).pertenece_a_proceso.getId() == Integer.parseInt(linea.id_proceso)) {
                new_pag = constantes.Paginas.get(paginaDeseada);
                bandera = 1;
            } else {
                JOptionPane.showMessageDialog(null, "Error de Carga de referencia", "Error al cargar ", JOptionPane.ERROR_MESSAGE);
                bandera = 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Error de Carga de referencia", "Error al cargar", JOptionPane.ERROR_MESSAGE);
            bandera = 0;
        }
        if (bandera == 1) {
            if (todos_frames_llenos()) {
                //aqui lo de reemplazo
                System.out.println("Todos los frames estan llenos y se debe aplicar reemplazo");
                return;
            }
            for (Frame Frame : Constantes.Frames) {
                if (Frame.id_pagina == 0 && Frame.pertenece_a_proceso.equals(new_pag.pertenece_a_proceso)) {
                    Frame.id_pagina = new_pag.id;
                    Frame.pertenece_a_proceso = new_pag.pertenece_a_proceso;
                    return;
                }
            }
            if (/*Working set variable*/true) {
                if (/*minimo == maximo*/true) {
                    working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual*/);
                } else if (/*minimo + tasa de crecimiento > maximo*/true) {
                    working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual*/);
                    //actual = maximo
                } else {
                    working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set actual*/);
                    //actual = actual + tasa de crecimiento
                }
            } else {
                working_set.asigna_frame(new_pag.pertenece_a_proceso,/*Aqui working set minimo*/);
            }
            for (Frame Frame : Constantes.Frames) {
                if (Frame.id_pagina == 0 && Frame.pertenece_a_proceso.equals(new_pag.pertenece_a_proceso)) {
                    Frame.id_pagina = new_pag.id;
                    Frame.pertenece_a_proceso = new_pag.pertenece_a_proceso;
                    return;
                }
            }
        }
    }

    private static LinkedList procesos_en_memoria() {
        LinkedList procesos = new LinkedList();
        for (Frame Frame : Constantes.Frames) {
            procesos.add(Frame.pertenece_a_proceso);
        }
        return procesos;
    }

    private static boolean pagina_en_mprincipal(int num_pag) {
        for (Frame Frame : Constantes.Frames) {
            if (Frame.id_pagina == num_pag) {
                return true;
            }
        }
        return false;
    }

    private static boolean todos_frames_reservados() {
        for (Frame Frame : Constantes.Frames) {
            if (Frame.pertenece_a_proceso.equals(null)) {
                return false;
            }
        }
        return true;
    }

    private static boolean todos_frames_llenos() {
        for (Frame Frame : Constantes.Frames) {
            if (Frame.id_pagina == 0) {
                return false;
            }
        }
        return true;
    }
}
/*
 Cristian

 public static void fetch_demanda(Atributos_text linea, String tipo_reemplazo) {
 //cada vez que hace una referencia pasa la pagina a memoria
 Pagina new_pag = new Pagina(-1, -1, null);
 int bandera = 0;
 int paginaDeseada = ((linea.pagina_a_pasar)/(((int) Math.pow(2,constantes.L_Esquema.get(0).getBits_Offset()))/1024));
 if(constantes.Paginas.size() >= paginaDeseada)  {
 if(constantes.Paginas.get(paginaDeseada).pertenece_a_proceso.getId() == Integer.parseInt(linea.id_proceso)){           
 new_pag = constantes.Paginas.get(paginaDeseada);
 bandera = 1;
 }else{
 JOptionPane.showMessageDialog(null, "Error de Carga de referencia","Error al cargar ", JOptionPane.ERROR_MESSAGE);
 bandera = 0;
 }
 }else{
 JOptionPane.showMessageDialog(null, "Error de Carga de referencia","Error al cargar", JOptionPane.ERROR_MESSAGE);
 bandera = 0;
 }
 if (bandera == 1){
 for (int i = 0; i < constantes.Frames.size(); i++) {
 if(constantes.Frames.get(i).id_pagina == 0){
 constantes.Frames.get(i).id_pagina = new_pag.id;
 constantes.Frames.get(i).pertenece_a_proceso = new_pag.pertenece_a_proceso; 
 Frame x = constantes.Frames.get(i);
 System.out.println("Frame hecho" + x.pertenece_a_proceso.getNombre());
 break;
 }
 }
 }
 }


 */
