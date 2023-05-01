/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parser;

import Base.Comando;
import Base.SuperObj;

/**
 *
 * @author sinis
 */
public class ParserOutput {
    
    private final Comando comando; //comando
    private final SuperObj object;    //oggetto interagibile
    
    /**
     *
     * @param comando
     * @param object
     */
    public ParserOutput(Comando comando, SuperObj object) {
        this.comando = comando;
        this.object = object;
    }

    /**
     *
     * @return
     */
    public Comando getComando() {
        return comando;
    }

    /**
     *
     * @return
     */
    public SuperObj getObject() {
        return object;
    }

}
