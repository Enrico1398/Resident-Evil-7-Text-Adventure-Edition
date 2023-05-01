/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoTerra;

import Base.Stanza;
import Base.SuperObj;
/**
 *
 * @author sinis
 */
public class CancelloPrincipale extends Stanza {
    
    /**
     *
     */
    public CancelloPrincipale(){
    
    SuperObj cancello = new SuperObj("Cancello","Cancello principale che dà accesso alla magione,è bloccato da una catena molto spessa impossibile da distruggere o aprire.\n" +
             "Trova un'altra via,magari puoi passare da quella recinzione rotta ad est .");
    SuperObj campanello = new SuperObj("Campanello","Non funziona,sembra non ci sia corrente.");
    SuperObj furgone = new SuperObj("Furgone","Sembra che tempo fa una troupe televisiva sia giunta qui con questo furgone, ma di loro non c'è traccia.");
    
    campanello.setAlias(new String[]{"Citofono"});
    furgone.setAlias(new String[]{"Furgoncino","Auto"});
    this.addObject(cancello);
    this.addObject(campanello);
    this.addObject(furgone);
    
    }
}
