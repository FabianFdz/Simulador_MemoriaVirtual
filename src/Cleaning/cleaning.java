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
        pagina_reemplazada.dirty_bit = 0;
    }
    
      public void precleaning(){  //Probar
        boolean estado = true;
        while(estado){
            int largo = Constantes.Primaria.en_memoria.size();//Todas los frames con alguna pagina asociada
            int cont = 0;
            while(cont<largo){
                Frame frame_temp = Constantes.Primaria.en_memoria.get(cont);
                Pagina pagina_temp = buscarPagina(frame_temp.id_pagina); //Suponiendo una pagina por Frame
                pagina_temp.dirty_bit = 0;
                cont++;
            }
        }
        try {
            sleep(this.tiempo); //Se ejecuta en la cantidad de tiempo fijado
        } catch (InterruptedException ex) {            
        }              
    }
      
    public Pagina buscarPagina(int id_Pagina){ //Busca una pagina por ID
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
