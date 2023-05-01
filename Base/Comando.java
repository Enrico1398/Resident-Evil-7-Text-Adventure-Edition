/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


/**
 *
 * @author sinis
 */
public class Comando {
    private final String nome;
    private Set<String> alias;
 
    public Comando(String nome){
        this.nome=nome;
    }
    
    /**
     *
     * @param nome
     * @param alias
     */
    public Comando(String nome, Set<String> alias){
        this.nome=nome;
        this.alias=alias;
    }
    
    public String getNome() {
        return nome;
    }

    public Set<String> getAlias() {
        return alias;
    }

    /**
     *
     * @param alias
     */
    public void setAlias(Set<String> alias) {
        this.alias = alias;
    }
    
    /**
     *
     * @param sinonimi
     */
    public void setAlias(String[] sinonimi) {
        this.alias = new HashSet<>(Arrays.asList(sinonimi));
    }
}
