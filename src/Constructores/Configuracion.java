package Constructores;

import static java.lang.Thread.sleep;

/**
 *
 * @author FelixVives
 */
public class Configuracion {
    public String fetch, placement, replacement, resident_set, 
            replacement_scope, cleaning, tiempo_cleaning, load_control;

    public Configuracion(String fetch, String placement, String replacement, String resident_set, String replacement_scope, String cleaning, String load_control) {
        this.fetch = fetch;
        this.placement = placement;
        this.replacement = replacement;
        this.resident_set = resident_set;
        this.replacement_scope = replacement_scope;
        this.cleaning = cleaning;
        this.load_control = load_control;
    }
    
    public void cleaningDemand(Pagina pagina_reemplazada){ //Recibe la pagina reeplaza
        pagina_reemplazada.fue_modificado = 0;
    }
    
    public void preCleaning(int tiempo){ 
        try {
            sleep(5000);
        } catch (InterruptedException ex) {
            
        }
        
        
        int largo = Constantes.pr.en_memoria.size(); //Todas las paginas en memoria secundaria
        int cont = 0;
        while(cont<largo){
            Frame frame_temp = Constantes.pr.en_memoria.get(cont);
            Pagina pagina_temp = buscarPagina(frame_temp.id_pagina); //Una pagina por Frame
            pagina_temp.fue_modificado = 0;
            cont++;
        }
    }
    
    public Pagina buscarPagina(int id_Pagina){
        int largo = Constantes.Paginas.size();
        int contador = 0;
        while(contador<largo){
            Pagina pagina_temp = Constantes.Paginas.get(contador);
            if(pagina_temp.id==id_Pagina){
                return pagina_temp;
            }
            contador++;
        }
        return null;
    }
    
}
