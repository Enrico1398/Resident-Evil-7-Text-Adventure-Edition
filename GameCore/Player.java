/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import Base.SuperObj;
/**
 *
 * @author sinis
 */
public class Player implements Serializable{
    private List<SuperObj> inventario = new ArrayList<>();
    
    public void setInventario(List<SuperObj> inventario){
        this.inventario=inventario;
        
    }
    
    /**
     *
     * @return
     */
    public List<SuperObj> getInventario(){
        return this.inventario;
    }
    
    /**
     *
     * @param obj
     */
    public void addAInventario(SuperObj obj){
        this.inventario.add(obj);
    }
    
    public void removeDaInventario(SuperObj obj){
        this.inventario.remove(obj);
    }
    
    /**
     *
     * @param i
     */
    public void removeDaInventario(int i){
        this.inventario.remove(i);
    }
    
    /**
     *
     * @param p
     */
    public void setPlayer(Player p){
        this.setInventario(p.getInventario());
    }
}
