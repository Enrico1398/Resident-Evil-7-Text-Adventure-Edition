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
public class StanzaCombattimento extends Stanza{
    public StanzaCombattimento(){
        SuperObj Mia = new SuperObj("Mia","Dopo esser fuggita la ritrovi Mia rivolta verso un muro senza uscita ,è dinanzi a te ma di spalle...");
        this.addObject(Mia);
    }
    
    /**
     * Uso dell'oggetto Ascia , che permette di sconfiggere Mia e di accedere al resto della casa
     */
    
    @Override
    public void usoAscia(){
                  this.setMsg("Afferri la tua ascia , cerchi di difenderti ma nell'irruenza dello scontro colpisci Mia al collo.\n" +
                          "Lei crolla a terra morente e ti dice <<Ethan finchè sei in tempo scappa o lui ti prenderà!!>>");
                  this.getObjects().removeIf(obj -> obj.getNome().equals("Mia"));
                  this.setDescrizione("Dopo il combattimento con mia il muro di cartongesso che separava questa stanza dal resto del corridoio della casa è caduto. Puoi accedere al resto della casa.");
    }
    
    /**
     * Controllo della presenza dell'oggetto Ascia nell'inventario , che può portare alla morte se l'oggetto non è presente 
     * @param p
     * @return 
     */
    
    @Override
    public boolean checkInventario (Player p){
        boolean g = false;
        
        for(int i=0 ; i<p.getInventario().size() ; i++){
            if(p.getInventario().get(i).getNome().equals("Ascia")){
               g=true;
            }
        }
        
        
        return g;
    }
    
    @Override
    public void parlaA(Player p, SuperObj person) {
        if((person.getNome().equals("Mia"))){
            String txt = "Ti avvicini e cerchi di parlarle, ma lei si gira , ha delle sembianze non umane , sogghigna e con occhi insanguinati ti guarda, come fosse posseduta da una forza maligna \n" + 
                    "Ha un coltello in mano lo stringe forte e ti attacca violentemente , cerca di colpirti in faccia ma tu ti proteggi il volto con una mano e ti infilza il coltello in essa \n" +
                    "Devi difenderti e cerchi qualcosa disperatamente nel tuo inventario\n";
            this.setMsg(txt);
            
        }
    }
}
