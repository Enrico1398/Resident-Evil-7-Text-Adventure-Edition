/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Base;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import GameCore.Player;

/**
 *
 * @author sinis
 */
public class Stanza implements Serializable{
    private String nome;
    private String descrizione;
    private Stanza sud = null;
    private Stanza nord = null;
    private Stanza est = null;
    private Stanza ovest = null;
    private List<SuperObj> objects = new ArrayList<>();
    private Stanza nextNord = null;
    private Stanza nextEst = null; 
    private Stanza nextOvest = null;
    private Stanza nextSud = null;
    private String msg = "";
           
    /**
     *
     */
    public Stanza() {}
    
    /**
     *
     * @param nome
     * @param descrizione
     */
    public Stanza(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.objects = new ArrayList<>();
    }

    public Stanza(String nome, String descrizione, List<SuperObj> objects) {
        this.nome = nome;
        this.descrizione = descrizione;
        this.objects = objects;
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

    /**
     *
     * @return
     */
    public String getDescrizione() {
        return descrizione;
    }

    /**
     *
     * @param descrizione
     */
    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    /**
     *
     * @return
     */
    public Stanza getSud() {
        return sud;
    }

    /**
     *
     * @param sud
     */
    public void setSud(Stanza sud) {
        this.sud = sud;
    }

    /**
     *
     * @return
     */
    public Stanza getNord() {
        return nord;
    }

    /**
     *
     * @param nord
     */
    public void setNord(Stanza nord) {
        this.nord = nord;
    }

    /**
     *
     * @return
     */
    public Stanza getEst() {
        return est;
    }

    /**
     *
     * @param est
     */
    public void setEst(Stanza est) {
        this.est = est;
    }

    /**
     *
     * @return
     */
    public Stanza getOvest() {
        return ovest;
    }

    public void setOvest(Stanza ovest) {
        this.ovest = ovest;
    }

    /**
     *
     * @return
     */
    public List<SuperObj> getObjects() {
        return objects;
    }
    
    public void setObject(List<SuperObj> objects){
        this.objects = objects;
    }
    
    /**
     *
     * @param object
     */
    public void addObject(SuperObj object){
            this.objects.add(object);
    }

    /**
     * Aggiunta di un oggetto alla lista degli oggetti della stanza attraverso nome e descrizione
     * @param nome
     * @param descrizione
     */
    public void addObject(String nome, String descrizione){
        SuperObj obj = new SuperObj(nome, descrizione);
        this.objects.add(obj);
    }

    /**
     * Aggiunta di un oggetto alla lista degli oggetti della stanza attraverso nome,descrizione e sinonimi
     * @param nome
     * @param descrizione
     * @param sinonimi 
     */
    public void addObject(String nome, String descrizione, String[] sinonimi){
        SuperObj obj = new SuperObj(nome, descrizione);
        obj.setAlias(sinonimi);
        this.objects.add(obj);
    }

    /**
     * Confronto tra due oggetti Room
     * @param obj
     * @return true se gli oggetti sono uguali, altrimenti false
     */
    
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        return getClass() == obj.getClass();
    }

    /**
     *
     * @param nextNord
     */
    public void setNextNord(Stanza nextNord){
        this.nextNord = nextNord;
    }
    
    /**
     *
     * @return
     */
    public Stanza getNextNord(){
        return this.nextNord;
    }
    
    /**
     *
     * @param nextOvest
     */
    public void setNextOvest(Stanza nextOvest){
        this.nextOvest = nextOvest;
    }
    
    /**
     *
     * @return
     */
    public Stanza getNextOvest(){
        return this.nextOvest;
    }
    
    /**
     *
     * @param nextEst
     */
    public void setNextEst(Stanza nextEst){
        this.nextEst = nextEst;
    }
    
    /**
     *
     * @return
     */
    public Stanza getNextEst(){
        return this.nextEst;
    }

    /**
     *
     * @param nextSud
     */
    public void setNextSud(Stanza nextSud){
        this.nextSud = nextSud;
    }

    /**
     *
     * @return
     */
    public Stanza getNextSud(){
        return this.nextSud;
    }
    /**
     * Metodo base che permette la ricerca di un'oggetto nell'inventario .
     * 
     * @param p
     * @return 
     */
    public boolean checkInventario(Player p){
        boolean g = false;
        this.setMsg("Non hai questo oggetto nell'inventario");
        return g;
    }
    
    /**
     * Metodo base che permette l'uso dell'ascia.
     * 
     */
    
    public void usoAscia(){
        this.setMsg("Non puoi usare l'ascia ora");
    }
    
    /**
     * Metodo base che permette di parlare con un determinato oggetto se possibile.
     * @param p
     * @param obj 
     */
    
    public void parlaA(Player p, SuperObj obj){
        this.setMsg("Non puoi parlare con nessuno");
    }
 
    /**
     * Metodo base che permette di usare l'oggetto tronchesi.
     * @param p 
     */
    public void usaTronchesi(Player p){
        this.setMsg("Non puoi fare niente");
    }
    
    /**
     * Metodo base per l'inseriimento di un'oggetto.
     * @param p 
     */
    public void inserisci(Player p){
        this.setMsg("Non puoi inserire niente");
    }
    
    /**
     * Metodo base ma alternativo per l'inserimento di alcuni oggetti particolari.
     * @return true se si verifica una determinata condizione
     */
    public boolean inserisciAltro(){
        boolean g = false;
        this.setMsg("Non puoi più inserire questo oggetto");
        return g;
    }
    
    /**
     * Metodo base per l'iterazione riguardante l'oggetto telefono
     */
    public void rispostaTelefono(){
        this.setMsg("Il telefono non squilla più.");
    }
    
    /**
     *
     * @return
     */
    public String getMsg() {
        return msg;
    }

    /**
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
}
