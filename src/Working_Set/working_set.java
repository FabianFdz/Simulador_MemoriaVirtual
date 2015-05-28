package Working_Set;

import Constructores.Constantes;
import Constructores.Frame;
import Constructores.Proceso;

/**
 *
 * @author FelixVives
 */
public class working_set {
    public boolean tipo; //true:Fijo, false:Variable
    public int minimo, maximo, tasa_crecimiento;

    public working_set(boolean tipo, int minimo) { //Constructor fijo
        this.tipo = tipo;
        this.minimo = minimo;
    }

    public working_set(boolean tipo, int minimo, int maximo, int tasa_crecimiento) { //Constructor variable
        this.tipo = tipo;
        this.minimo = minimo;
        this.maximo = maximo;
        this.tasa_crecimiento = tasa_crecimiento;
    }
    
    public void asigna_frame(Proceso pr, int requiere){
        int cont = 0;
        int largo = Constantes.Frames.size();
        while(cont<largo){ //Condicion largo de Frames totales
            Frame frameTemp = Constantes.Frames.get(cont);
            if(requiere == 0){ //Verifica si ya cumplio todos los requerimientos del proceso
                break;
            }
            if(frameTemp.pertenece_a_proceso==null){
                frameTemp.pertenece_a_proceso = pr.nombre; 
                requiere--;
            }
            cont++;
        }
    }       
}
