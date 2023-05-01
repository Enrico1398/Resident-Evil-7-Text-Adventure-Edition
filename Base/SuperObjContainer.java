/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;


import java.util.Set;
import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;


/**
 *
 * @author sinis
 */
public class SuperObjContainer extends SuperObj implements Serializable{
    
    private List<SuperObj> list = new ArrayList<>();
    
    public SuperObjContainer(){  
    }
    
    /**
     *
     * @param nome
     */
    public SuperObjContainer(String nome){
        super(nome);
    }
    
    /**
     *
     * @param nome
     * @param descrizione
     */
    public SuperObjContainer(String nome, String descrizione){
        super(nome,descrizione);
    }
    
    /**
     *
     * @param nome
     * @param descrizione
     * @param alias
     */
    public SuperObjContainer(String nome,String descrizione, Set<String> alias){
        super(nome,descrizione,alias);
    }
    
    /**
     *
     * @return
     */
    public List<SuperObj> getList(){
        return list;
    }
    
    /**
     *
     * @param list
     */
    public void setList(List<SuperObj> list){
        this.list=list;
    }
    
    /**
     *
     * @param o
     */
    public void addList(SuperObj o){
        list.add(o);
    }
    
    public void removeList(SuperObj o){
        list.remove(o);
    }
    
    
}
