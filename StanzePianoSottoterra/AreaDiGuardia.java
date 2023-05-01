/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoSottoterra;

import Base.Stanza;
import Base.SuperObj;
import GameCore.Player;

/**
 *
 * @author sinis
 */
public class AreaDiGuardia extends Stanza{

    /**
     *
     */
    public AreaDiGuardia(){
        SuperObj tronchesi = new SuperObj();
        SuperObj cella = new SuperObj();
        SuperObj mia = new SuperObj("Mia","Mia giace sul lettino della cella, magari dovresti liberarla.");
        
        tronchesi.setNome("Tronchesi");
        tronchesi.setDescrizione("Possono essere utili per rompere catene non troppo grandi.");
        tronchesi.setRaccoglibile(true);
        
        cella.setNome("Cella");
        cella.setDescrizione("Dentro la cella c'è Mia , tua moglie , forse la catena che chiude la cella può essere spezzata da qualcosa.");
        cella.setAlias(new String[]{"Prigione"});
        this.addObject(tronchesi);
        this.addObject(cella);
        this.addObject(mia);
       
    }
    
    /** Uso dell'oggetto tronchesi per liberare Mia, se l'oggetto è presente nell'inventario
     * 
     * @param p 
     */
    @Override
    public void usaTronchesi(Player p){
        boolean g = false;
        int k = -1;
        for (int i =0; i<p.getInventario().size(); i++){
            if (p.getInventario().get(i).getNome().equals("Tronchesi")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
            this.setMsg("La cella è aperta , Mia è libera, potresti parlarci.");
            this.getObjects().removeIf(obj -> obj.getNome().equals("Cella"));
            for(SuperObj obj2 : this.getObjects()){
                if(obj2.getNome().equals("Mia")){
                    obj2.setDescrizione("Mia ora è libera e vuole uscire da questa casa con te.");
                }
            }
        } else {
            this.setMsg("Non puoi fare nulla.");
        }
    }
    
    @Override
    public void parlaA(Player p, SuperObj person) {
        
        if((person.getNome().equals("Mia"))){
            this.setMsg("Ethan cosa diavolo ci fai qui??. Dio mio sono davvero passati tre anni ?? \n Adesso non importa, non abbiamo tempo ,forza dobbiamo andare via di qui, o lui tornerà presto!!!");
        }
        
        
    }
}
