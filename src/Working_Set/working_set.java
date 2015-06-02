package Working_Set;

import Constructores.Constantes;
import Constructores.Frame;
import Constructores.Proceso;
import java.util.LinkedList;

/**
 *
 * @author FelixVives
 */
public class working_set {
    public boolean tipo; //true:Fijo, false:Variable
    public int minimo, maximo, tasa_crecimiento,actual;

    public working_set(boolean tipo, int minimo) { //Constructor fijo
        this.tipo = tipo;
        this.minimo = minimo;
    }

    public working_set(boolean tipo, int minimo, int maximo, int tasa_crecimiento) { //Constructor variable
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tasa_crecimiento = tasa_crecimiento;
        this.actual = minimo;
    }
    
    public static void asigna_frame(Proceso pr, int requiere){ //Asignar frames para working set fijo
        int cont = 0;
        int largo = Constantes.Frames.size();
        while(cont<largo){ //Condicion largo de Frames totales
            Frame frameTemp = Constantes.Frames.get(cont);
            if(requiere == 0){ //Verifica si ya cumplio todos los requerimientos del proceso
                break;
            }
            if(frameTemp.pertenece_a_proceso==null){
                frameTemp.pertenece_a_proceso.nombre.equals(pr.nombre);
                requiere--;
            }
            cont++;
        }
    }
    
    public void asigna_frame_var(Proceso pr, int requiere){ //Asigna frames para Working Set Variable
        LinkedList frames_vacios = frame_vacios();
        int cant_vacios = frames_vacios.size();
        if(cant_vacios < requiere){ //Si la cantidad de frames disponibles es menor debe crecer o decrecer la cantidad en algun proceso
            decrece_frames(escoge_prioridad(pr));//Decrece los frames de un proceso, para en el siguiente paso poder asignarle al que crece
        }
        asigna_frame(pr,requiere);
    }
    
    public void decrece_frames(Proceso pr){ //Recibe proceso que desea decrece (decrece lo que indica el working_set)
        int cont = 0;                       //Se aume que el proceso crecio una vez al menos
        int largo = Constantes.Frames.size();
        int tasa = Constantes.config.ws.tasa_crecimiento;
        while(cont<largo){
            if(tasa==0){
                break;
            }
            Frame frame_temp = Constantes.Frames.get(cont);
            if(frame_temp.pertenece_a_proceso.equals(pr.nombre)){
                frame_temp.pertenece_a_proceso = null;
                tasa--;
            }
            cont++;
        }
    }
    
    public LinkedList frame_vacios(){ //Devuelve lista con ids con los Frame Vacios
        LinkedList<Integer> frames_vacios = new LinkedList<>();
        int cont= 0;
        int largo = Constantes.Frames.size();
        while(cont < largo){
            Frame frameTemp = Constantes.Frames.get(cont);
            if(frameTemp.pertenece_a_proceso == null){
                frames_vacios.add(frameTemp.id);
            }
            cont++;
        }
        return frames_vacios;
    }
    
    public Proceso escoge_prioridad(Proceso pr){ //Elige el proceso que decrece segun prioridad
        LinkedList<Proceso> lista;
        lista = Constantes.cola_procesos._Cola;
        int cont = 0;
        int largo = lista.size();
        while(cont<largo){
            Proceso proceso_temp = lista.get(cont);
            if(proceso_temp.equals(pr.nombre)){
                return lista.get(cont+1);
            }
        }
        return null;//Si no existe devuelve nulo
    }
}
