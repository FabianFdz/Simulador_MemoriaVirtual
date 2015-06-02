package Cleaning;

import Constructores.Constantes;
import Constructores.Frame;
import Constructores.Pagina;
import static java.lang.Thread.sleep;

/**
 *
 * @author FelixVives
 */
public class cleaning {
    public boolean tipo; //true:Demand, false:Precleaning
    public int tiempo;

    public cleaning(boolean tipo) { //Constructor Demand
        this.tipo = tipo;
    }

    public cleaning(boolean tipo, int tiempo) { //Constructor Precleaning
        this.tipo = tipo;
        this.tiempo = tiempo;
    }
   
    public void cleaning_demanda(Pagina pagina_reemplazada){ //Recibe la pagina reeplaza
        buscarFrame(pagina_reemplazada.id).dirty_bit=0; //Cambia el dirty_bit a 0
    }
    
      public void precleaning(){ 
        boolean estado = true;
        while(estado){
            int largo = Constantes.Primaria.en_memoria.size();
            int cont = 0;
            while(cont<largo){
                Frame frame_temp = Constantes.Primaria.en_memoria.get(cont);
                frame_temp.dirty_bit = 0;
                cont++;
            }
        }
        try {
            sleep(this.tiempo); //Se ejecuta en la cantidad de tiempo fijado
        } catch (InterruptedException ex) {            
        }              
    }
      
    public Frame buscarFrame(int id_Pagina){ //Busca un Frame que tenga relacionado cierto ID de pagina
        int largo = Constantes.Frames.size();
        int contador = 0;
        while(contador<largo){
            Frame frame_temp = Constantes.Frames.get(contador);
            if(frame_temp.id_pagina==id_Pagina){
                return frame_temp;              
            }
            contador++;
        }
        return null;
    } 
}
