package replacement;
import Constructores.Frame;
import Constructores.Pagina;
import Constructores.Constantes;
import java.util.Calendar;

/**
 *
 * @author Esteban Leandro
 */
public class replacementPolicy {
    
    public static void replacement_last_recently_used(Pagina paginaNueva){
        Frame viejoFrame = Constantes.Frames.getFirst();
        
        //con este for selecciono cual fue el último frame en ejecutarse
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).tiempo_ejecucion.before(viejoFrame.tiempo_ejecucion)){
                viejoFrame = Constantes.Frames.get(i);
            }
        }
        
        //ahora reemplazo la página adentro del frame, por la pagina que se da por parametro.
        viejoFrame.pag = paginaNueva;
        //actualizo el tiempo de ejecución del frame por null, ya que no se ha ejecutado
        viejoFrame.tiempo_ejecucion = null;//viejoFrame.tiempo_ejecucion = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
        
        //cambio el tiempo de entrada por el tiempo actual de ejecucion.
        viejoFrame.tiempo_entrada = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
    
    public static void replacement_most_recently_used(Pagina paginaNueva){
        Frame viejoFrame = Constantes.Frames.getFirst();
        
        //con este for selecciono el frame que se ejecutó hace menos tiempo.
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).tiempo_ejecucion.after(viejoFrame.tiempo_ejecucion)){
                viejoFrame = Constantes.Frames.get(i);
            }
        }
        
        //ahora reemplazo la página adentro del frame, por la pagina que se da por parametro.
        viejoFrame.pag = paginaNueva;
        //actualizo el tiempo de ejecución del frame por null, ya que no se ha ejecutado
        viejoFrame.tiempo_ejecucion = null;//viejoFrame.tiempo_ejecucion = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

        //cambio el tiempo de entrada por el tiempo actual de ejecucion.
        viejoFrame.tiempo_entrada = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
    
    public static void replacement_fifo(Pagina paginaNueva){
        Frame viejoFrame = Constantes.Frames.getFirst();
        
        //con este for selecciono cual fue el último frame en ejecutarse
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).tiempo_entrada.before(viejoFrame.tiempo_entrada)){
                viejoFrame = Constantes.Frames.get(i);
            }
        }
        //ahora reemplazo la página adentro del frame, por la pagina que se da por parametro.
        viejoFrame.pag = paginaNueva;
        
        //cambio el tiempo de entrada por el tiempo actual de ejecucion.
        viejoFrame.tiempo_entrada = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}

