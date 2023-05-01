/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoTerra;

import Base.Stanza;
import Base.SuperObj;
import GameCore.Player;


/**
 *
 * @author sinis
 */
public class Soggiorno extends Stanza{

    /**
     *
     */
    public Soggiorno(){
        SuperObj registratore = new SuperObj();
        SuperObj fotografia = new SuperObj("Fotografia","Questa foto ritrae una cella all'interno di uno scantinato. A chi servirebbe mai una cella e con quale scopo?E dove si trova questo scantinato?");
        SuperObj televisore = new SuperObj("Televisore","Questo televisore è collegato al registratore, non funziona nessun canale.");
        registratore.setNome("Registratore");
        registratore.setDescrizione("Un registratore connesso a questa TV . Forse c'è una cassetta da qualche parte.");
        registratore.setAlias(new String[]{"VideoRegistratore","VHS"});
        fotografia.setAlias(new String[]{"Foto","Immagine"});
        televisore.setAlias(new String[]{"TV"});
        
        this.addObject(registratore);
        this.addObject(fotografia);
        this.addObject(televisore);
        
    }
    
    /**Inserimento dell'oggetto cassetta , porta alla creazione dell'oggetto pulsante_soggiorno
     * 
     * @param p 
     */
    
    @Override
    public void inserisci(Player p){
        SuperObj pulsanteSoggiorno = new SuperObj();
        pulsanteSoggiorno.setNome("Pulsante_soggiorno");
        pulsanteSoggiorno.setDescrizione("L'attivazione di questo pulsante nascosto ti porterà nello scantinato, perchè mai utilizzare un passaggio segreto per uno scantinato.");
        pulsanteSoggiorno.setAlias(new String[]{"Bottone_soggiorno"});
        pulsanteSoggiorno.setVisibile(false);
        boolean g = false;
        int k = -1;
        for (int i =0; i<p.getInventario().size(); i++){
            if (p.getInventario().get(i).getNome().equals("Cassetta")) {
                 g = true;
                 k = i;
            }
        }
        if (g){
            this.setMsg("Appena hai inserito la cassetta nel registratore è partito un filmato. E' una ripresa fatta dalla troupe che ha lasciato il furgone davanti  al cancello principale\n" +
                      "Stavano facendo un servizio sulle persone scomparse in questa casa, e dopo averla esplorata sono giunti in soggiorno come te. A quanto pare c'è un pulsante nascosto dietro il camino che porta nello scantinato.\n" +
                      "Improvvisamente però mentre stanno attraversando il passaggio segreto, il filmato si interrompe con le urla della troupe.");
            p.removeDaInventario(k);
            this.getObjects().removeIf(obj -> obj.getNome().equals("Registratore"));
            this.addObject(pulsanteSoggiorno);
            pulsanteSoggiorno.setVisibile(true);
            this.setDescrizione("Ora ti trovi in uno strano ordinato soggiorno, di tutt'altro tono rispetto alla raccapricciante cucina, hai un registratore(che hai appena usato) collegato a una televisione e con una foto sopra di esso.\n" +
                    "Ora hai scoperto che c'è anche un pulsante dietro la TV utilizzabile per accedere al passaggio segreto.");
            
        } else {
            this.setMsg("Non hai nulla da inserire ne nulla in cui inserire.");
        }
        }
    
   
}
