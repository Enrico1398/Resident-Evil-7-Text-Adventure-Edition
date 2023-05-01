/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author sinis
 */
public class SuperObj implements Serializable {
    
    private String nome;
    private Set<String> alias;
    private boolean visibile = true;
    private boolean raccoglibile = false;
    
    private boolean apribile = false;
    private String descrizione;
    
    /**
     *
     */
    public SuperObj(){}
    
    /**
     *
     * @param nome
     */
    public SuperObj(String nome){
        this.nome=nome;
    }
    
    /**
     *
     * @param nome
     * @param descrizione
     */
    public SuperObj(String nome, String descrizione){
        this.nome=nome;
        this.descrizione=descrizione;
    }
    
    
    
    public SuperObj(String nome, String descrizione, Set<String> alias){
        this.nome=nome;
        this.descrizione=descrizione;
        this.alias=alias;
    }
    
    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
    
    public boolean Visibile() {
        return visibile;
    }

    /**
     *
     * @param visibile
     */
    public void setVisibile(boolean visibile) {
        this.visibile = visibile;
    }

    public boolean Raccoglibile() {
        return raccoglibile;
    }

    /**
     *
     * @param raccoglibile
     */
    public void setRaccoglibile(boolean raccoglibile) {
        this.raccoglibile = raccoglibile;
    }
    
    /**
     *
     * @return
     */
    public boolean Apribilie(){
        return apribile;
    }
    
    /**
     *
     * @param apribile
     */
    public void setApribile(boolean apribile){
        this.apribile= apribile;
    }

    /**
     *
     * @return
     */
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
