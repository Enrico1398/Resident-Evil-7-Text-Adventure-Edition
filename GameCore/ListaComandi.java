/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

import Base.Comando;
import java.util.List;
import java.util.ArrayList;
/**
 *
 * @author sinis
 */
public class ListaComandi {
    private final List<Comando> comandi = new ArrayList<>();
    
    /**
     * Aggiunta dei vari oggetti comando che formeranno la lista dei comandi di riferimento
     */
    public ListaComandi(){
        Comando nord = new Comando("nord");
        nord.setAlias(new String[]{"n", "nord"});
        this.comandi.add(nord);
        
        Comando sud = new Comando("sud");
        sud.setAlias(new String[]{"s", "sud"});
        this.comandi.add(sud);
        
        Comando est = new Comando("est");
        est.setAlias(new String[]{"e", "est"});
        this.comandi.add(est);
        
        Comando ovest = new Comando("ovest");
        ovest.setAlias(new String[]{"o", "ovest" });
        this.comandi.add(ovest);
        
        Comando esci = new Comando("esci");
        esci.setAlias(new String[]{"e", "esci", "termina"});
        this.comandi.add(esci);
        
        Comando guarda = new Comando("osserva");
        guarda.setAlias(new String[]{"guarda","cerca","analizza"});
        this.comandi.add(guarda);
        
        Comando prendi = new Comando ("raccogli");
        prendi.setAlias(new String[]{"prendi", "ottieni"});
        this.comandi.add(prendi);
        
        Comando usa = new Comando("usa");
        usa.setAlias(new String[]{"usa","attiva", "aziona","utilizza"});
        this.comandi.add(usa);
        
        Comando apri = new Comando("apri");
        apri.setAlias(new String[]{"apri"});
        this.comandi.add(apri);

        Comando parla = new Comando("parla");
        parla.setAlias(new String[]{"interloquisci","conversa"});
        this.comandi.add(parla);

        Comando inventario = new Comando("inventario");
        inventario.setAlias(new String[]{"i","inventario"});
        this.comandi.add(inventario);

        Comando inserisci = new Comando("inserisci");
        inserisci.setAlias(new String[]{"infila", "incastra","metti"});
        this.comandi.add(inserisci);
        
        Comando oggetti = new Comando("oggetti");
        this.comandi.add(oggetti);
        
        Comando comandi = new Comando("comandi");
        this.comandi.add(comandi);
        
    }

    /**
     *
     * @return
     */
    public List<Comando> getComandi() {
        return comandi;
    }
}
