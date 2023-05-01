/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoTerra;

import Base.Stanza;
import Base.SuperObj;
import Base.SuperObjContainer;
import GameCore.Player;

/**
 *
 * @author sinis
 */
public class CorridoioArmadio extends Stanza {

    public CorridoioArmadio() {
        SuperObjContainer armadio = new SuperObjContainer();
        SuperObj fusibile = new SuperObj("Fusibile", "Un fusibile inseribile in qualche interruttore, potrebbe servirti");
        armadio.setNome("Armadio");
        armadio.setDescrizione("Questo armadio sembra contenere qualcosa peccato che sia chiuso da una catena, magari più avanti troverai qualcosa per romperla.");
        armadio.setAlias(new String[]{"Armadietto"});
        armadio.addList(fusibile);
        fusibile.setVisibile(false);
        fusibile.setRaccoglibile(true);
        this.addObject(armadio);

    }
    
    /**
     * Uso dell'oggetto tronchesi che rende apribile l'armadio
     * @param p 
     */

    @Override
    public void usaTronchesi(Player p) {

        boolean g = false;

        for (int i = 0; i < p.getInventario().size(); i++) {
            if (p.getInventario().get(i).getNome().equals("Tronchesi")) {
                g = true;

            }
        }
        if (g) {
            for (SuperObj obj : this.getObjects()) {
                if (obj.getNome().equals("Armadio"));
                obj.setDescrizione("Ora questo armadio è apribile, ci potrebbe essere qualcosa di utile");
                obj.setApribile(true);
                break;
            }
        } else {
            this.setMsg("Non puoi fare nulla");
        }
    }

    
   

}
