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
public class Cucina extends Stanza{

    /**
     *
     */
    public Cucina(){
        SuperObj frigorifero = new SuperObj();
        SuperObj microonde = new SuperObj();
        frigorifero.setNome("Frigorifero");
        frigorifero.setDescrizione("Un frigorifero molto vecchio appena socchiuso.Contiene cibo che sembra esser scaduto da anni");
        frigorifero.setAlias(new String[]{"Frigo"});
        microonde.setNome("Microonde");
        microonde.setDescrizione("Osservando meglio il microonde noti che al suo interno c'è un piccione morto.Chi mai compierebbe un'atrocità del genere?");
        this.addObject(frigorifero);
        this.addObject(microonde);
        
    }
}
