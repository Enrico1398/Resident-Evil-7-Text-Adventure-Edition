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
public class Cantina extends Stanza{

    /**
     *
     */
    public Cantina(){
        SuperObj cartaMorte = new SuperObj("Morte","Un tarocco raffigurante la morte, che sia questa la risposta all'indovinello?");
        SuperObj cartaCane = new SuperObj("Cane","Un tarocco raffigurante un cane che sia questa la risposta all'indovinello?");
        SuperObj cartaFortuna = new SuperObj("Fortuna","Un tarocco raffigurante la fortuna che sia questa la risposta all'indovinello?");
        SuperObj mia = new SuperObj("Mia","Mia ha il fiato corto e si siede per terra per riprendere fiato");
        SuperObj indovinello = new SuperObj("Indovinello","Ti aspetta sempre e può essere dietro l'angolo ,che cos'è?\n" + 
                "Inserisci la carta raffigurante la risposta dell'indovinello o rimarrai bloccato qui per sempre, attento però se sbagli potrebbe succedere qualcosa di brutto \n");
        cartaMorte.setRaccoglibile(true);
        cartaCane.setRaccoglibile(true);
        cartaFortuna.setRaccoglibile(true);
        this.addObject(cartaMorte);
        this.addObject(cartaCane);
        this.addObject(cartaFortuna);
        this.addObject(mia);
        this.addObject(indovinello);
        
    }
    
    /*Attivare trigger quando si osserva la bambola*/

    /**
     *
     * @param p
     */
    
    /**
     * Inserimento della carta Morte, se presente nell'inventario, sblocca l'accesso a un pulsante
     * @param p 
     */

    @Override
    public void inserisci(Player p){
        SuperObj pulsanteCantina = new SuperObj();
        int k = -1;
        boolean g = false;
        pulsanteCantina.setNome("Pulsante_cantina");
        pulsanteCantina.setDescrizione("L'attivazione di questo pulsante nascosto ti porterà nello scantinato, perchè mai utilizzare un passaggio segreto per uno scantinato.");
        pulsanteCantina.setAlias(new String[]{"Bottone_cantina"});
        pulsanteCantina.setVisibile(false);
        
       for (int i =0; i<p.getInventario().size(); i++){
            if (p.getInventario().get(i).getNome().equals("Morte")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
        p.removeDaInventario(k);
        this.setMsg("All'inserimento della risposta tutto si muove come scosso da un meccanismo segreto e compare un pulsante prima nascosto");
        this.getObjects().removeIf(obj -> obj.getNome().equals("Indovinello"));
        this.getObjects().removeIf(obj -> obj.getNome().equals("Cane"));
        this.getObjects().removeIf(obj -> obj.getNome().equals("Fortuna"));
        this.addObject(pulsanteCantina);
        pulsanteCantina.setVisibile(true);
        this.setDescrizione("Sei nella cantina con vini, l'indovinello e risolto e puoi usare il pulsante appena apparso per uscire dalla cantina.\n");
        }
        else{
            this.setMsg("Non hai nulla da inserire ne nulla in cui inserire.");
        }
        
    }
    
    /**
     * Inserimento delle altre carte, che porta al fallimento e quindi alla morte del giocatore
     * @return 
     */
    
    @Override
    public boolean inserisciAltro(){
        boolean g = false;
        for(SuperObj obj : this.getObjects()){
           if(obj.getNome().equals("Indovinello")){
               g = true;
           }
        }
        return g;
    }
    
    @Override
    public void parlaA(Player p, SuperObj person) {
        
        if((person.getNome().equals("Mia"))){
            this.setMsg("Mia è stranamente stanca forse sarebbe meglio concentrarsi su come uscire");
        }
        
    }
    
}
