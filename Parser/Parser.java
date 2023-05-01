/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Base.Comando;
import Base.SuperObj;
import java.util.List;

/**
 *
 * @author sinis
 */
public class Parser {
     /**
     * Confronta il token con la lista dei comandi. Ritorna la posizione del comando trovato nella lista
     * @param token parola da analizzare
     * @param commands lista dei comandi
     * @return posizione del comando trovato nella lista
     */
    private int checkForCommand(String token, List<Comando> comandi) {
        for (int i = 0; i < comandi.size(); i++) {
            if (comandi.get(i).getNome().toLowerCase().equals(token))
                return i;
                if (comandi.get(i).getAlias()!=null)
                    if (comandi.get(i).getAlias().contains(token))
                        return i;
        }
        return -1;
    }

    /**
     * Confronta il token con la lista degli oggetti di una specifica stanza. Ritorna la posizione dell'oggetto trovato nella lista
     * @param token parola da analizzare
     * @param objects lista degli oggetti della stanza
     * @return posizione dell'oggetto trovato nella lista
     */
    private int checkForObject(String token, List<SuperObj> objects) {
        for (int i = 0; i < objects.size(); i++) {
            if (!objects.isEmpty()) {
                if (objects.get(i).getNome().toLowerCase().equals(token))
                    return i;
                if (objects.get(i).getAlias() != null)
                    if (objects.get(i).getAlias().contains(token))
                        return i;
            }
        }
        return -1;
    }

    /**
     * Metodo che segue le istruzioni di controllo di tutte le parole ottenute in ingresso
     * 
     * @param comando
     * @param comandi
     * @param objects
     * @param inventario
     * @return ParserOutput oggetto contenete gli eventuali comandi, oggetti con cui interagire e direzioni
     */
   public ParserOutput parse(String comando, List<Comando> comandi, List<SuperObj> objects, List<SuperObj> inventario) {
        String cmd = comando.toLowerCase().trim();
        String[] tokens = cmd.split("\\s+");
        int i = 0;
        int io = -1, ic = -1, ioinv = -1;
        String idir = "";
        if (tokens.length > 0) {
            while (ic<0 && i<tokens.length){
                ic = checkForCommand(tokens[i], comandi);
                i++;
            }
            if (ic > -1) {
                i = 0; //riparte dalla prima parola
                if (tokens.length > 1) {
                    while (io<0 && i<tokens.length){
                        io = checkForObject(tokens[i], objects);
                        i++;
                    }
                    if (io<0) {
                        i = 0;
                        while (ioinv<0 && i<tokens.length){
                            ioinv = checkForObject(tokens[i], inventario);
                            i++;
                        }
                    }
                    
                    if (io > -1) {
                        return new ParserOutput(comandi.get(ic), objects.get(io));
                    } else if (ioinv > -1) {
                        return new ParserOutput(comandi.get(ic), inventario.get(ioinv));
                    } else {
                        return new ParserOutput(comandi.get(ic), null);
                    }
                } else {
                    return new ParserOutput(comandi.get(ic), null);
                }
            } else {
                return new ParserOutput(null, null);
            }
        } else {
            return null;
        }
    }
}
