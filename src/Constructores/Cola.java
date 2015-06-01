package Constructores;

import java.util.LinkedList;

/**
 *
 * @author FelixVives
 */
public class Cola {
    public LinkedList<Proceso> _Cola;

    public Cola() {
        this._Cola = new LinkedList<>();
    }
    
    public void agrega_proceso(Proceso pProceso) //Agrega los procesos ordenados segun prioridad.
    {
        int indice = 0;
        int largo = _Cola.size();
        boolean agrego = false;
        int prioridad_proceso = pProceso.prioridad;
        while(indice < largo)
        {
            Proceso pro = _Cola.get(indice);
            int prioridad = pro.prioridad;
            if(prioridad > prioridad_proceso)//Verifica la prioridad para agregarlo
            {
                _Cola.add(indice, pProceso);//Lo agrega en el indice que debe.
                agrego = true;
                break;
            }
            indice++;
        }
        if(_Cola.isEmpty() || !agrego) //Si la cola es vacia lo agrega sin importar nada.
        {
            _Cola.add(pProceso);
        }
    }
    
    public Proceso getCliente() //Obtiene el primero, y a la vez lo elimina de la cola.
    {
        if(!_Cola.isEmpty())
        {
            Proceso pro = _Cola.get(0);
            //_Cola.remove(0); //Remueve el obtenido.          
            return pro;
        }
        return null;
    }
}
