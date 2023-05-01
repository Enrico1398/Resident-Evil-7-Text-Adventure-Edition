/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoSuperiore;

import Base.Stanza;
import Base.SuperObj;
import GameCore.Player;

/**
 *
 * @author sinis
 */
public class Soffitta extends Stanza{
    
    /**
     *
     */
    public Soffitta(){
        SuperObj cassetta = new SuperObj("Cassetta","Una cassetta forse inseribile in un registratore.");
        cassetta.setRaccoglibile(true);
        SuperObj interruttore = new SuperObj("Interruttore","Un interruttore senza energia, manca chiaramente un fusibile per farlo funzionare.");
        SuperObj lucernario = new SuperObj("Lucernario","Aprire questo lucernario ti permetterà di uscire ma la sua apertura è legata al funzionamento dell'interruttore.");
        SuperObj scalaSoffitta = new SuperObj();
        scalaSoffitta.setNome("Scala_soffitta");
        scalaSoffitta.setDescrizione("Puoi usare questa scala tornare nel corridoio al piano terra");
        this.addObject(cassetta);
        this.addObject(interruttore);
        this.addObject(scalaSoffitta);
    }
    
    /**
     * Inserimento del fusibile che porta al finale del gioco
     * @param p 
     */
    
    @Override
    public void inserisci(Player p){
        boolean g = false;
        int k = -1;
        for (int i =0; i<p.getInventario().size(); i++){
            if (p.getInventario().get(i).getNome().equals("Fusibile")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
              
            p.removeDaInventario(k);
            
            
            
        } else {
            this.setMsg("Non hai nulla da inserire ne nulla in cui inserire");
        }
        }
    
}
