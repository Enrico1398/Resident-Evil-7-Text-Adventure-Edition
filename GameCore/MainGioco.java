/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import File.FileManager;
import Interface.*;
import Parser.*;
/**
 *
 * @author sinis
 */
public class MainGioco {
    GestoreScelta gestoreScelta= new GestoreScelta();
    Interfaccia interfacciaUtente = new Interfaccia();
    ManagerInterfaccia mi= new ManagerInterfaccia(interfacciaUtente);
    Storia storia= new Storia();
    Player player= new Player();
    Mappa mappa = new Mappa();
    File mapfile = new File(".\\MapSaveFile.txt");
    File playerfile = new File(".\\PlayerSaveFile.txt");
    FileManager fw = new FileManager();
    Parser parser = new Parser();
    ListaComandi comandi = new ListaComandi();
    String inventarioStatus = "";
    
    /**
     *
     * @param args
     */
    public static void main(String[] args){
        new MainGioco();
    }
    
    /**
     *
     */
    public MainGioco(){
        interfacciaUtente.creaInterfacciaUtente(gestoreScelta);  //accediamo ai metodi della classe UI = crea la finestra di dialogo
        mi.mostraMenuPrincipale();   //accediamo ai metodi della classe VisibilityManager = mostra la schermata iniziale
    }
    
    /**
     * Inner Class che gestisce le actionPerformed in base al button cliccato determinando la conseguente transizione.
     */
    public class GestoreScelta implements ActionListener{ //gestore per le scelte che aspetta l'evento(cioè il click)
         @Override
         public void actionPerformed(ActionEvent event){
            String scelta= event.getActionCommand();
           
            
            switch(scelta){
                  case "nuovaPartita": //Click su "Nuova Partita "
                       mi.setTestoPrincipalePanelSize(50,100,650,420);
                       mi.nascondiConfermaUscita();
                       mi.mostraSchermataPrincipale();
                       mi.setNormalFont(18);
                       mi.mostraIntroduzione();
                       storia.inizio(mi);
                       break;

                  case "caricaPartita": //Click su "Carica Partita"
                      mi.setTestoPrincipalePanelSize(50,100,650,300);
                      mi.nascondiConfermaUscita();
                      mi.mostraSchermataPrincipale();
                      mi.setNormalFont(18);
                      mi.nascondiMenuPrincipale();
                      try {
                          mappa.setMappa(fw.caricamentoMappa(mapfile));
                          player.setPlayer(fw.caricamentoPlayer(playerfile));
                          caricaSetup();
                      } catch (NullPointerException | ClassNotFoundException | IOException e){
                          mi.ritornoAlMenuOrFinale();
                          mi.scriviTestoPrincipaleExit("                             Caricamento fallito. Dati inesistenti o danneggiati :(");
                      }
                      break;

                  case "avanti": //Click su "Avanti"
                      mi.setNormalFont(18);
                      mi.setTestoPrincipalePanelSize(50,100,650,300);
                      mi.nascondiSalvataggio();
                      mi.nascondiMenuPrincipale();
                      defaultSetup();
                      break;

                  case "invio": //Click su "Invio " o pressione del tasto Invio (Enter)
                      mi.nascondiSalvataggio();
                      ParserOutput parserOutput = parser.parse(mi.getCampoTxt(), comandi.getComandi(), mappa.getStanzaCorrente().getObjects(), player.getInventario());
                      
                      
                      //Se viene inserito il comando fine o eventuali sinonimi, viene chiusa la finestra
                      if (parserOutput.getComando()!=null && parserOutput.getComando().getNome().equals("fine")){
                          System.exit(0);
                      }
                      
                      boolean end = storia.Mossa(parserOutput, player, mappa, mi); //true se si è raggiunti l'ultima interazione, false altrimenti
                      mi.campoFocus();
                      
                      //Se end == true viene visualizzata l'ultima interazione prima della schermata finale
                      if (end){
                           mi.ritornoAlMenuOrFinale();
                           
                          }
                      break;

                  case "salva"://Click su "Salva"
                      mi.mostraSalvataggio(fw.salvataggioMappa(mapfile, mappa), fw.salvataggioPlayer(playerfile, player));
                      mi.campoFocus();
                      break;


                  

                  case "esciDalMenu": //Click su "Esci". Porta alla schermata di conferma dell'uscita
                       mi.nascondiSalvataggio();
                       mi.confermaUscita();
                       mi.scriviTestoPrincipaleExit("                                        Sei sicuro di voler abbandonare la partita?\n                                       Tutti i progressi non salvati andranno persi.");
                       break;

                  case "si": //Click su "Sì" nella schermata di conferma dell'uscita. Esce dal gioco e torna al menù principale
                       mi.setTestoPrincipalePanelSize(50,100,650,300);
                       mi.mostraMenuPrincipale();
                       mappa = new Mappa();
                       player = new Player();
                       mi.nascondiConfermaUscita();
                       break;

                  case "no": //Click su "No" nella schermata di conferma dell'uscita. Torna al gioco
                       mi.nascondiConfermaUscita();
                       mi.mostraSchermataPrincipale();
                       break;

                   case "esci": //Click su "Esci" nel menù principale. Chiude la finestra del gioco
                       System.exit(0);
                       break;  

                   case "TornaAlMenu": //Click su "Torna al menù principale" dalla schermata del caricamento fallito
                        mi.mostraMenuPrincipale();
                       break;

                   case "inventario": //Click su "Inventario". Mostra il contenuto la lista Inventorio con un set di JLabel a scomparsa
                       mi.nascondiSalvataggio();
                       if(inventarioStatus.equals("close")){
                           mi.apriInventario();
                           mi.campoFocus();
                           if (!player.getInventario().isEmpty()){
                               for (int i = 0; i<player.getInventario().size(); i++ ){
                                   if (player.getInventario().get(i)!=null){
                                       mi.getInvLableComponent(i).setText(player.getInventario().get(i).getNome());
                                   }
                               }
                           }
                           mi.getInvLableComponent(player.getInventario().size()).setText("");
                           inventarioStatus= "open";
                       } else if (inventarioStatus.equals("open")){
                           mi.chiudiInventario();
                           mi.campoFocus();
                           inventarioStatus="close";
                       }
                       break;
               }
           }
    }
        /**
         * Metodo per l'impostazione dei paramentri iniziali ad un nuovo inzio del gioco.
         */
         public void defaultSetup(){ 
            mappa = new Mappa();
            player = new Player();
            
            inventarioStatus="close";
            mi.scriviTestoPrincipale(mappa.getStanzaCorrente().getNome() + "\n================================================\n" + mappa.getStanzaCorrente().getDescrizione());
            mi.campoFocus();
    }
        /**
         * Metodo per l'impostazione dei paramentri al caricamento di un salvataggio.
         */
        public void caricaSetup(){
        String mitxt = "";
            
            inventarioStatus="close";
            mitxt = (mappa.getStanzaCorrente().getNome() + "\n================================================\n" + mappa.getStanzaCorrente().getDescrizione());
            
            mi.scriviTestoPrincipale(mitxt);
            mi.campoFocus();
    }
}
