/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.*;
import javax.swing.*;

/**
 *
 * @author sinis
 */
public class ManagerInterfaccia {
     Interfaccia interfacciaUtente;
    
    /**
     *
     * @param interfacciaUtente
     */
    public ManagerInterfaccia(Interfaccia interfacciaUtente){
        this.interfacciaUtente=interfacciaUtente;
    }

     /**
     * Mostra la schermata principale con i tasti Nuova Partita,Carica partita ed Esci
     */
     public void mostraMenuPrincipale(){
        interfacciaUtente.getSchermataInizialePanel().setVisible(true);
        interfacciaUtente.getMenuPrincipalePanel().setVisible(true);
        interfacciaUtente.getNuovaPartitaButton().setVisible(true);
        interfacciaUtente.getCaricaPartitaButton().setVisible(true);
        interfacciaUtente.getEsciButton().setVisible(true);
         
        interfacciaUtente.getTestoPrincipaleArea().setVisible(false);
        interfacciaUtente.getSceltaPanel().setVisible(false);
        interfacciaUtente.getPlayerPanel().setVisible(false);
        interfacciaUtente.getInventarioPanel().setVisible(false);
        interfacciaUtente.getAvantiButton().setVisible(false);
        interfacciaUtente.getUscitaPanel().setVisible(false);
        interfacciaUtente.getMenuPrincipaleButton().setVisible(false);
        interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(false);
    }

     /**
     * Apre il panel a scomparsa quando si preme il tasto Inventario mostrando i vari lables
     */
     public void apriInventario(){
        interfacciaUtente.getInventarioPanel().setVisible(true);
    }
    
     /**
     * Chiude l'inventario
     */
     public void chiudiInventario(){
        interfacciaUtente.getInventarioPanel().setVisible(false);
    }
    
     /**
     * Passa dalla schermata principale mostrando l'introduzione iniziale con il tasto "Avanti" nascondendo tutto il resto 
     */
     public void mostraIntroduzione(){
        interfacciaUtente.getTestoPrincipalePanel().setVisible(true);
        interfacciaUtente.getMenuPrincipalePanel().setVisible(true);
        interfacciaUtente.getAvantiButton().setVisible(true);
        interfacciaUtente.getTestoPrincipaleArea().setVisible(true);
        
        interfacciaUtente.getSchermataInizialePanel().setVisible(false);
        interfacciaUtente.getInventarioPanel().setVisible(false);
        interfacciaUtente.getSceltaPanel().setVisible(false);
        interfacciaUtente.getPlayerPanel().setVisible(false);
        interfacciaUtente.getNuovaPartitaButton().setVisible(false);
        interfacciaUtente.getCaricaPartitaButton().setVisible(false);     
        interfacciaUtente.getEsciButton().setVisible(false);
        interfacciaUtente.getUscitaPanel().setVisible(false);
        interfacciaUtente.getMenuPrincipaleButton().setVisible(false);
        interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(false);
    }
     
     /**
     * Se il label della conferma del salvataggio del player p e della mappa.
     * @param m
     * @param p 
     */
     public void mostraSalvataggio(boolean m, boolean p) {
        interfacciaUtente.getConfermaSalvataggio().setVisible((true));
        if (m && p) {
            interfacciaUtente.getConfermaSalvataggio().setText("Salvato");
        }
        else {
            interfacciaUtente.getConfermaSalvataggio().setText("Errore salvataggio");
        }
     }
    
     /**
     * Nasconde il lable della conferma di salvataggio (o errore nel salvataggio)
     */
        public void nascondiSalvataggio(){
        interfacciaUtente.getConfermaSalvataggio().setVisible(false);
    }
    
     /**
     * Nasconde il menù principale e mostra la schermata principale di gioco , in click sul carica partita
     */
     public void nascondiMenuPrincipale(){
        interfacciaUtente.getSchermataInizialePanel().setVisible(false);
        interfacciaUtente.getMenuPrincipalePanel().setVisible(false);
        interfacciaUtente.getInventarioPanel().setVisible(false);
        interfacciaUtente.getUscitaPanel().setVisible(false);
        interfacciaUtente.getMenuPrincipaleButton().setVisible(false);
        interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(false);
        

        interfacciaUtente.getTestoPrincipaleArea().setVisible(true);
        interfacciaUtente.getTestoPrincipalePanel().setVisible(true);
        interfacciaUtente.getSceltaPanel().setVisible(true);
        interfacciaUtente.getCampo().setVisible(true);
        interfacciaUtente.getPlayerPanel().setVisible(true);

        interfacciaUtente.getCampo().setForeground(Color.DARK_GRAY);
        interfacciaUtente.getCampo().setText("                            Cosa devo fare?");
        interfacciaUtente.getCampo().grabFocus();
        interfacciaUtente.setPressed(false);
    }
      
     /**
     * Mostra la schermata per la conferma di uscita dal gioco con i pulsanti Si e No nascondendo gli altri panel
     */
     public void confermaUscita(){
         interfacciaUtente.getPlayerPanel().setVisible(false);
         interfacciaUtente.getInventarioPanel().setVisible(false);
         interfacciaUtente.getSceltaPanel().setVisible(false);
         interfacciaUtente.getTestoPrincipaleArea().setVisible(false);
         
         interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(true);
         interfacciaUtente.getUscitaPanel().setVisible(true);
         interfacciaUtente.getMenuPrincipaleButton().setVisible(false);
         interfacciaUtente.getSiButton().setVisible(true);
         interfacciaUtente.getNoButton().setVisible(true);
    }
     
     /**
      * Nasconde la schemrata per la conferma di uscita dal gioco e i tasti Sì e No
      */
     public void nascondiConfermaUscita(){
         interfacciaUtente.getUscitaPanel().setVisible(false);
         interfacciaUtente.getMenuPrincipaleButton().setVisible(false);
         interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(false);
     }
     
     /**
      * Mostra la schermata di caricamento fallito o di finale/morte raggiunto con il singolo tasto  Menù principale
      */
     public void ritornoAlMenuOrFinale(){
         interfacciaUtente.getPlayerPanel().setVisible(false);
         interfacciaUtente.getInventarioPanel().setVisible(false);
         interfacciaUtente.getSceltaPanel().setVisible(false);
         interfacciaUtente.getTestoPrincipaleArea().setVisible(false);
         interfacciaUtente.getSiButton().setVisible(false);
         interfacciaUtente.getNoButton().setVisible(false);
         
         interfacciaUtente.getTestoPrincipaleAreaExit().setVisible(true);
         interfacciaUtente.getUscitaPanel().setVisible(true);
         interfacciaUtente.getMenuPrincipaleButton().setVisible(true);
     }

     /**
      * Mostra la schemrata principale del gioco
      */
     public void mostraSchermataPrincipale(){
         interfacciaUtente.getPlayerPanel().setVisible(true);
         interfacciaUtente.getTestoPrincipaleArea().setVisible(true);
         interfacciaUtente.getSceltaPanel().setVisible(true);
         interfacciaUtente.getSalvataggioPanel().setVisible(true);
     }
     
     /**
      * Imposta il font base di gioco tramite la dimensione (size)
      * @param size 
      */
     public void setNormalFont(int size){
        Font f= new Font("Courier", Font.BOLD, size);
        interfacciaUtente.getTestoPrincipaleArea().setFont(f);
     }
   
     /**
     * Visualizza nell'area di testo principale il testo text
     * @param text 
     */
     public void scriviTestoPrincipale(String text){
         interfacciaUtente.getTestoPrincipaleArea().setText(text);
     }

     /**
      * Visualizza nell'area di testo, dedicata a quando si entra nel panel RitornoAlMenuOrFinale
      * @param text 
      */
     public void scriviTestoPrincipaleExit(String text){
        interfacciaUtente.getTestoPrincipaleAreaExit().setText(text);
     }

     /**
      * Imposta tutte le dimensioni per il pannello dell'area di testo x ed y identificano il punto di partenza, width e height invece larghezza e altezza
      * @param y
      * @param larghezza
      * @param height 
     * @param altezza 
      */
     public void setTestoPrincipalePanelSize(int x, int y, int larghezza, int altezza){
         interfacciaUtente.getTestoPrincipalePanel().setBounds(x, y, larghezza, altezza);
     }

     /**
      * Restituisce il focus al campo per l'inserimento dell'input
      */
     public void campoFocus(){
         if (interfacciaUtente.getCampo().isVisible())
             interfacciaUtente.getCampo().grabFocus();
     }

     /**
     * Restituisce il componente i-esimo dei lable facenti parte dell'inventare
     * @param i
     * @return
     */
     public JLabel getInvLableComponent(int i){
        return ((JLabel)interfacciaUtente.getInventarioPanel().getComponent(i));
     }

     /**
     * Restituisce il contenuto di campoTxt, ovvero la stringa in ingresso scritta dall'utente
     * @return
     */
     public String getCampoTxt(){
        return interfacciaUtente.getCampotxt();
    }
}
