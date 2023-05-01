/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

import Base.*;
import Parser.*;
import Interface.*;

/**
 *
 * @author sinis
 */
public class Storia {
    
    /**
     *
     */
    public Storia(){ }
   
   /**
    * Metodo che riconosce i comandi inseriti in input mediante il parser e che gestisce le interazioni che può avere l'utente con gli oggetti e che delineano lo sviluppo della storia.
    * @param parserOutput
    * @param p
    * @param mappa
    * @param mi
    * @return fine=true se si è usciti dal gioco o si è raggiunto un finale/morte.
    */
   
   public boolean Mossa(ParserOutput parserOutput, Player p, Mappa mappa, ManagerInterfaccia mi){
           boolean fine = false;
           String mitxt = "";
           SuperObjContainer objC = new SuperObjContainer();
           ListaComandi comandi = new ListaComandi();
           
           
           
           if(parserOutput.getComando() == null){
               mi.scriviTestoPrincipale("Comando non riconosciuto");
           }
           else{
               boolean stanza = false;
               boolean mossa = false;
               
               if(parserOutput.getComando().getNome().equals("nord")){
                   if(mappa.getStanzaCorrente().getNord()!= null){
                      mappa.setStanzaPrec(mappa.getStanzaCorrente());
                      mappa.setStanzaCorrente(mappa.getStanzaCorrente().getNord());
                      mossa = true;
                   }
                   else {
                       stanza = true;
                   }
               }
               
               if(parserOutput.getComando().getNome().equals("sud")){
                   if(mappa.getStanzaCorrente().getSud()!= null){
                      mappa.setStanzaPrec(mappa.getStanzaCorrente());
                      mappa.setStanzaCorrente(mappa.getStanzaCorrente().getSud());
                      mossa = true;
                   }
                   else {
                       stanza = true;
                   }
               }
               
               if(parserOutput.getComando().getNome().equals("est")){
                   if(mappa.getStanzaCorrente().getEst()!= null){
                      mappa.setStanzaPrec(mappa.getStanzaCorrente());
                      mappa.setStanzaCorrente(mappa.getStanzaCorrente().getEst());
                      mossa = true;
                   }
                   else {
                       stanza = true;
                   }
               }
               
               if(parserOutput.getComando().getNome().equals("ovest")){
                   if(mappa.getStanzaCorrente().getOvest()!= null){
                      mappa.setStanzaPrec(mappa.getStanzaCorrente());
                      mappa.setStanzaCorrente(mappa.getStanzaCorrente().getOvest());
                      mossa = true;
                   }
                   else {
                       stanza = true;
                   }
                   
                }  
                
                if(parserOutput.getComando().getNome().equals("comandi")){
                    for (Comando comando : comandi.getComandi()){
                        mitxt = (mitxt + comando.getNome() + ",");
                    }
                    mi.scriviTestoPrincipale("Questa è la lista comandi: \n " + mitxt);
                }
               
                if(parserOutput.getComando().getNome().equals("osserva")){
                    if (parserOutput.getObject() == null) {
                        boolean forward = false;
                        mitxt = (mappa.getStanzaCorrente().getDescrizione() + "\n\nLe direzioni in cui puoi proseguire sono: ");
                        if (mappa.getStanzaCorrente().getNord()!=null){
                            mitxt =(mitxt + " [Nord] ");
                            
                            forward = true;
                        }
                        if (mappa.getStanzaCorrente().getSud()!=null){
                            mitxt =(mitxt + " [Sud] ");
                            
                            forward = true;
                        }
                        if (mappa.getStanzaCorrente().getOvest()!=null){
                            mitxt =(mitxt + " [Ovest] ");
                            
                            forward = true;
                        }
                        if (mappa.getStanzaCorrente().getEst()!=null){
                            mitxt =(mitxt + " [Est]");
                            
                            forward = true;
                        }
                        if (!forward)
                            mitxt = (mappa.getStanzaCorrente().getDescrizione() + "\n\nNon puoi proseguire in nessuna direzione: può darsi che il passaggio sia bloccato.");
                    
                
                    }
                    else if (parserOutput.getObject()!= null && parserOutput.getObject().Visibile()){
                        int k= -1;
                        for(int i=0 ; i<mappa.getStanzaCorrente().getObjects().size() && k==-1 ; i++){
                            if(mappa.getStanzaCorrente().getObjects().get(i).getNome().equals(parserOutput.getObject().getNome())){
                                k=i;
                            }
                        }
                        if (k>-1){
                            mitxt = mappa.getStanzaCorrente().getObjects().get(k).getDescrizione();
                        }else {
                            if (p.getInventario()!=null){
                                for (int i = 0; i < p.getInventario().size() && k==-1; i++) {
                                    if (p.getInventario().get(i).getNome().equals(parserOutput.getObject().getNome())) {
                                        k = i;
                                    }
                                }
                                mitxt = (p.getInventario().get(k).getDescrizione());
                            }
                        }
                       
                    }
                    mi.scriviTestoPrincipale(mitxt);
                }
                
                if(parserOutput.getComando().getNome().equals("oggetti")){
                    for(SuperObj obj : mappa.getStanzaCorrente().getObjects()){
                        if(obj.Visibile()){
                            mitxt =(mitxt + "\n- "+ obj.getNome());
                        }
                       
                    }
                    mi.scriviTestoPrincipale("Questi sono gli oggetti visibili nella stanza : " + mitxt);
                }
               
                if(parserOutput.getComando().getNome().equals("raccogli")){
                    if(parserOutput.getObject() == null){
                        mi.scriviTestoPrincipale("Non ho capito cosa vorresti raccogliere");
                    }
                    else{
                        for (int i = 0; i< mappa.getStanzaCorrente().getObjects().size(); i++) {
                            if (mappa.getStanzaCorrente().getObjects().get(i).getNome().equals(parserOutput.getObject().getNome())) {
                                if (mappa.getStanzaCorrente().getObjects().get(i).Raccoglibile()) {
                                    p.addAInventario(mappa.getStanzaCorrente().getObjects().get(i));
                                    mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getObjects().get(i).getNome() + " aggiunto al tuo inventario");
                                    mappa.getStanzaCorrente().getObjects().remove(i);
                                } else {
                                    mi.scriviTestoPrincipale("Non puoi raccogliere questo oggetto");
                                }
                            }
                        }
                    }
                }
               
               if (parserOutput.getComando().getNome().equals("usa")){
                   if (parserOutput.getObject() == null){
                       mi.scriviTestoPrincipale("Specifica cosa vorresti usare");
                   }
                   else{ 
                        if (parserOutput.getObject().getNome().equals("Pulsante_soggiorno")){
                            mappa.setStanzaPrec(mappa.getStanzaCorrente());
                            mappa.setStanzaCorrente(mappa.getCorridoio4());
                            mossa = true;
                            }
                        if(parserOutput.getObject().getNome().equals("Pulsante_cantina")){
                            mappa.setStanzaPrec(mappa.getStanzaCorrente());
                            mappa.setStanzaCorrente(mappa.getCorridoio5());
                            mossa = true;
                        }
                        if(parserOutput.getObject().getNome().equals("Tronchesi")){
                                mappa.getStanzaCorrente().usaTronchesi(p);
                                if(mappa.getStanzaCorrente().getNome().equals("Area di guardia")){
                                    mappa.getStanzaCorrente().setEst(mappa.getCantina());
                                }
                                
                                mi.scriviTestoPrincipale("Hai usato le tronchesi.\n" +
                                        mappa.getStanzaCorrente().getMsg());
                            }
                        
                        if(parserOutput.getObject().getNome().equals("Scala")){
                            mappa.setStanzaPrec(mappa.getStanzaCorrente());
                            mappa.setStanzaCorrente(mappa.getSoffitta());
                            mossa = true;
                            }
                        if(parserOutput.getObject().getNome().equals("Scala_soffitta")){
                            mappa.setStanzaPrec(mappa.getStanzaCorrente());
                            mappa.setStanzaCorrente(mappa.getCorridoio2());
                            mossa = true;
                            }
                        if(parserOutput.getObject().getNome().equals("Ascia")){
                            mappa.getStanzaCorrente().usoAscia();
                            mappa.getStanzaCorrente().setOvest(mappa.getCorridoio3());
                            mappa.getCorridoio3().setEst(mappa.getStanzaCorrente());
                            mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg());
                        }
                        if(parserOutput.getObject().getNome().equals("Telefono")){
                            mappa.getStanzaCorrente().rispostaTelefono();
                            mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg());
                        }
                        
                    
                    }
                }
                
                if (parserOutput.getComando().getNome().equals("apri")){
                    if(parserOutput.getObject()== null){
                        mi.scriviTestoPrincipale("Non ho capito cosa vorresti aprire");
                    }else {
                        if(parserOutput.getObject().Apribilie()== true){
                           objC =(SuperObjContainer) parserOutput.getObject();
                           for (SuperObj obj : objC.getList()){
                               mappa.getStanzaCorrente().addObject(obj);
                               objC.removeList(obj);
                               obj.setVisibile(true);
                               mi.scriviTestoPrincipale("Ora è presente in stanza l'oggetto: \n" + "-" + obj.getNome());
                           }
                        }
                        else{
                            mi.scriviTestoPrincipale("Questo oggetto non è apribile");
                        }
                    }
                    
                            
                }
               
                
                if(parserOutput.getComando().getNome().equals("parla")){
                    if(parserOutput.getObject() == null){
                        mi.scriviTestoPrincipale("Con chi vorresti parlare?");
                   
                    }
                    else {
                        mappa.getStanzaCorrente().parlaA(p, parserOutput.getObject());
                        mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg());
                        if(mappa.getStanzaCorrente().getNome().equals("Corridoio murato")){
                            if(mappa.getStanzaCorrente().checkInventario(p)==true){
                                mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg() +  "Hai trovato l'ascia raccolta precedentemente che potresti usare per difenderti...");
                            }
                            else{
                                mi.scriviTestoPrincipaleExit(mappa.getStanzaCorrente().getMsg() + "Non hai trovato nulla nel tuo inventario con cui difenderti...\n" +
                                "Mia ti attacca con tutta la sua rabbia, come se una forza malefica la stessa controllando... \n" +
                                "e con il suo coltello ti trafigge la giugulare... \n" +
                                "\n" +
                                "\n" +
                                "SEI MORTO\n" +
                                "FINE.");
                                
                                fine=true;
                            }
                        }
                        
                    }
                }
                
                if(parserOutput.getComando().getNome().equals("inventario")){
                    if (!p.getInventario().isEmpty()){
                    mitxt = ("Oggetti attualmente nel tuo inventario:");
                    for (SuperObj obj : p.getInventario()){
                        mitxt =(mitxt + "\n- " + obj.getNome());
                    }
                    } else{
                    mitxt = ("Non hai niente nel tuo inventario");
                    }
                    mi.scriviTestoPrincipale(mitxt);
                }
                
                if(parserOutput.getComando().getNome().equals("inserisci")){
                    if(parserOutput.getObject()== null){
                        mi.scriviTestoPrincipale("Non ho capito cosa vorresti inserire");
                    }
                    else {
                        if(parserOutput.getObject().getNome().equals("Cassetta")){
                            mappa.getStanzaCorrente().inserisci(p);
                            mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg());
                        }
                        if(parserOutput.getObject().getNome().equals("Morte")){
                            mappa.getStanzaCorrente().inserisci(p);
                            mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getMsg());
                        }
                        if(parserOutput.getObject().getNome().equals("Cane")){
                            if(mappa.getStanzaCorrente().inserisciAltro()== true){
                            mi.scriviTestoPrincipaleExit("Hai inserito il tarocco sbagliato.\n"+
                                    "Sotto i tuoi piedi senti scricchiolare e ti si apre una botola.\n"+
                                    "La caduta è fatale. Ritenta magari sarai più fortunato e riuscirai ad uscire dai qui.\n"+
                                    "\n" +
                                    "\n" +
                                    "SEI MORTO.\n" +
                                    "FINE.");
                            fine = true;
                            }
                            else{
                                mi.scriviTestoPrincipale("Non puoi inserire questo oggetto");
                            }
                        }
                        if(parserOutput.getObject().getNome().equals("Fortuna")){
                            if(mappa.getStanzaCorrente().inserisciAltro()== true){
                                mi.scriviTestoPrincipaleExit("Hai inserito il tarocco sbagliato.\n" +
                                     "Sotto i tuoi piedi senti scricchiolare e ti si apre una botola.\n" +
                                     "La caduta è fatale. Ritenta magari sarai più fortunato e riuscirai ad uscire dai qui.\n" +
                                     "\n" +
                                     "\n" +
                                     "SEI MORTO.\n" +
                                     "FINE.");
                            
                                fine = true;
                            }
                            else{
                                mi.scriviTestoPrincipale("Non puoi inserire questo oggetto");
                            }
                        }
                        if(parserOutput.getObject().getNome().equals("Fusibile")){
                            mappa.getStanzaCorrente().inserisci(p);
                            mi.scriviTestoPrincipaleExit("Hai inserito il fusibile.\n" +
                                        "Ora puoi attivare l'interruttore il quale aprirà il lucernario meccanizzato , ma... \n" +
                                        "Appena ti accingi ad attivare l'interruttore ,senti dei passi dietro di te.\n" +
                                        "Ti volti di scatto ma un pugno di colpisce il viso facendoti cadere per terra.\n" +
                                        "Intontito riesci solo a vedere una sagoma di un uomo , che violentemente ti da un altro pugno.\n" +
                                        "Sei svenuto.\n" +
                                        "Quale sarà il destino di Ethan? Chi era l'uomo che l'ha colpito? Forse lo scoprirai giocando il vero gioco e non questo picccolo tributo.\n" +
                                        "\n" +
                                        "\n" +
                                        "FINE.");
                            fine = true;
                        }
                    }
                }
                
                
                if(parserOutput.getComando().getNome().equals("esci")){
                    mi.scriviTestoPrincipaleExit("Clicca su 'MENU PRINCIPALE' per tornare al menu principale.");
                    fine = true;
                }
                
                if (stanza) {//In caso fosse impossibile proseguire nella direzione specificata
                    mi.scriviTestoPrincipale("Non puoi proseguire in quella direzione");
                }
                if (mossa){ //In caso fosse possibile proseguire nella direzione specificata, ne vengono visualizzati nome e descrizione della stanza di arrivo.
                    mitxt = (mappa.getStanzaCorrente().getNome() + "\n================================================\n" + mappa.getStanzaCorrente().getDescrizione());
                
                    mi.scriviTestoPrincipale(mitxt);
                }
               
           
               
           }  
           
           return fine;
        }
               
    /**
     * Introduzione iniziale alla storia mostrata a schermo dal manager interfaccia.
     * @param mi 
     */            
    
    public void inizio(ManagerInterfaccia mi){
        mi.scriviTestoPrincipale("Ti chiami Ethan e tua moglie è scomparsa da 3 anni senza lasciare alcuna traccia.\n" +
                "Solo adesso dopo tanto tempo, ti è giunta una videocassetta con una sua richiesta d'aiuto e con un'indirizzo che ti porta direttamente in Louisiana ...\n"+
                "Dopo tanta strada ti ritrovi davanti ad una magione, ora sta a te decidere cosa fare e scoprire il mistero dietro questa storia." + 
                "Puoi guardare ciò che ti circonda con il comando 'Osserva'.\n" + 
                "Puoi 'Raccogliere' alcuni oggetti  mettendoli nel tuo inventario, per poi 'Usarli' in determinate situazioni.\n" +
                "Per muoverti seguendo i punti cardinali NORD, SUD, EST e OVEST ,quando possibile.\n");
    }

    
 
}

