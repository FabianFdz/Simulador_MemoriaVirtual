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
    
    public static void lastRecentlyUsed(Pagina paginaNueva){
        Frame viejoFrame = Constantes.Frames.getFirst();
        
        //con este for selecciono cual fue el último frame en ejecutarse
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).tiempo.before(viejoFrame.tiempo)){
                viejoFrame = Constantes.Frames.get(i);
            }
        }
        
        //ahora reemplazo la página adentro del frame, por la pagina que se da por parametro.
        viejoFrame.pag = paginaNueva;
        //actualizo el tiempo del frame.
        viejoFrame.tiempo = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
    
    public static void mostRecentlyUsed(Pagina paginaNueva){
        Frame viejoFrame = Constantes.Frames.getFirst();
        
        //con este for selecciono el frame que se ejecutó hace menos tiempo.
        for (int i = 0; i < Constantes.Frames.size(); i++) {
            if(Constantes.Frames.get(i).tiempo.after(viejoFrame.tiempo)){
                viejoFrame = Constantes.Frames.get(i);
            }
        }
        
        //ahora reemplazo la página adentro del frame, por la pagina que se da por parametro.
        viejoFrame.pag = paginaNueva;
        //actualizo el tiempo de ejecución del frame.
        viejoFrame.tiempo = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
    }
}

