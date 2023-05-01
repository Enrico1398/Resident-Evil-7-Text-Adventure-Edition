/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameCore;

import StanzePianoTerra.*;
import StanzePianoSottoterra.*;
import StanzePianoSuperiore.*;
import java.io.Serializable;
import Base.Stanza;
import Base.SuperObj;

/**
 *
 * @author sinis
 */
public class Mappa implements Serializable{
    private Stanza cancelloPrincipale = new CancelloPrincipale();
    private Stanza cortile = new Stanza();
    private Stanza cortile2 = new Stanza();
    private Stanza entrata = new Stanza();
    private Stanza corridoio = new CorridoioArmadio();
    private Stanza cucina = new Cucina();
    private Stanza corridoio2 = new Stanza();
    private Stanza corridoio3 = new Stanza();
    private Stanza soggiorno = new Soggiorno();
    private Stanza corridoio4 = new Stanza();
    private Stanza areadiguardia = new AreaDiGuardia();
    private Stanza cantina = new Cantina();
    private Stanza soffitta = new Soffitta();
    private Stanza corridoio5 = new CorridoioTrigger();
    private Stanza corridoio6 = new StanzaCombattimento();
    
    
    
    private Stanza stanzaCorrente = new Stanza();
    private Stanza stanzaPrec = new Stanza();
    
    /**
     * Creazione della mappa di gioco e di ogni stanza che farà parte di essa
     */
    public Mappa(){
        
        cancelloPrincipale.setNome("CancelloPrincipale");
        cancelloPrincipale.setDescrizione("Ti trovi dinanzi alla magione dalla quale ti è giunto la richiesta d'aiuto di Mia.C'è un grosso cancello principale con davanti un furgone apparentemente abbandonato");
        cancelloPrincipale.setOvest(cortile);
        
        cortile.setNome("Cortile");
        cortile.setDescrizione("Sei passato sotto una grata aperta circondata da zampe di cavallo mozzate e legate insieme , in lontananza vedi un falò ,però per raggiungerlo devi andare più avanti.");
        cortile.setNord(cortile2);
        cortile.setEst(cancelloPrincipale);
        
        cortile2.setNome("Cortile d'entrata");
        cortile2.setDescrizione("Ti trovi dinanzi al falò visto prima ,magari c'è qualcosa vicino. Davanti a te invece c'è una piccola casa, sembra essere la casa per gli ospiti.La porta è stranamente già aperta.");
        
        SuperObj borsa = new SuperObj("Borsa","Questa borsa contiene documenti appartenenti a Mia, ora hai la certezza che lei sia passata da qui");
        SuperObj falo = new SuperObj("Falò","Un falò utlizzato per bruciare la spazzatura , anche se sembra qualcosa di diverso da una normale spazzatura,emette un odore di morte.Vicino ad esso c'è una borsa");
        falo.setAlias(new String[]{"Fuoco","Fuocherello"});
        borsa.setAlias(new String[]{"Borsetta"});
        cortile2.addObject(falo);
        cortile2.addObject(borsa);
        cortile2.setNord(entrata);
        cortile2.setSud(cortile);
        
        entrata.setNome("Entrata");
        entrata.setDescrizione("Sei entrato nella casa degli ospiti, è tutto in disordine e c'è una puzza di morte molto forte.");
        entrata.setEst(corridoio);
        entrata.setSud(cortile2);
        
        corridoio.setNome("Corridoio di entrata");
        corridoio.setDescrizione("Il corridoio è lungo con un armadio sul lato mentre a destra hai accesso alla cucina.");
        corridoio.setEst(cucina);
        corridoio.setOvest(entrata);
        
        cucina.setNome("Cucina");
        cucina.setDescrizione("Anche qui il disordine fa da padrone, con un frigorifero semi-aperto e un microonde buttatato per terra, per non parlare della muffa che riveste buona parte del soffitto");
        cucina.setEst(corridoio2);
        cucina.setOvest(corridoio);
        
        SuperObj scala = new SuperObj();
        scala.setNome("Scala");
        scala.setDescrizione("Puoi usare questa scala per andare in soffitta");
        corridoio2.addObject(scala);
        corridoio2.setNome("Corridoio");
        corridoio2.setDescrizione("Appena uscito dalla cucina , puoi salire la scala o proseguire in avanti.");
        corridoio2.setSud(corridoio3);
        corridoio2.setOvest(cucina);
        
        corridoio3.setNome("Proseguo corridoio");
        corridoio3.setDescrizione("Sei arrivato alla fine del corridoio , sembra che un tempo qui ci fosse una porta stranemente murata, mentre alla tua destra c'è con tua sorpresa un'ordinato soggiorno.");
        corridoio3.setOvest(soggiorno);
        corridoio3.setNord(corridoio2);
        
        soggiorno.setNome("Soggiorno");
        soggiorno.setDescrizione("Ora ti trovi in uno strano ordinato soggiorno, di tutt'altro tono rispetto alla raccapricciante cucina, hai un registratore collegato a una televisione e con una foto sopra di esso.");
        soggiorno.setEst(corridoio3);
        
        corridoio4.setNome("Corridoio passaggio segreto");
        corridoio4.setDescrizione("Dopo aver aperto il passaggio segreto del soggiorno,ed essere passato attraverso la fogna della casa, sbuchi in un corridoio , magari più avanti troverai delle risposte...");
        corridoio4.setEst(areadiguardia);
        
        areadiguardia.setNome("Area di guardia");
        areadiguardia.setDescrizione("Ti ritrovi nell'area di guardia dove è presente un tavolo con vari oggetti di dubbia utilità, tra cui una trochesi.Inoltre c'è la cella vista nella foto,sembra esserci qualcuno all'interno della cella");
        areadiguardia.setOvest(corridoio4);
        
        cantina.setNome("Cantina");
        cantina.setDescrizione("Sei giunto in una cantina con vini, ma con un indovinello scritto sul muro e una fessura in cui è inseribile qualcosa.\n" +
                "Accanto c'è un tavolo avente sopra di esso tre tarocchi diversi raffiguranti la morte, una cane e la fortuna" +
                "Mia nel frattempo si siede per terra come se non avesse più forze.");
        cantina.setOvest(areadiguardia);
        
        soffitta.setNome("Soffitta");
        soffitta.setDescrizione("Sei salito  dalle scale e sei giunto in soffitta , una piccola stanza con un'interruttore che sembra non funzionare e una strana cassetta sul tavolo.Puoi usare la scala per tornare al piano di sotto\n" +
                "(Si consiglia di specificare Scala_soffitta e questo vale per ogni oggetto composto.)");
        
        
        corridoio5.setNome("Corridoio dalla cantina");
        corridoio5.setDescrizione("Appena hai premuto il pulsante e ti si è aperta la porta segreta , Mia è fuggita come fosse impazzita all'improvviso.\n" +
                "Hai attraversato il passaggio segreto dalla cantina e ti ritrovi in questo lungo corridoio, c'è un telefono su un comodino che ha iniziato a squillare ed un'ascia è incastrata nel muro, di Mia non c'è traccia \n");
        corridoio5.setOvest(corridoio6);
        
        corridoio6.setNome("Corridoio murato");
        corridoio6.setDescrizione("Sembra essere la fine del corridoio ma davanti a te c'è una porta murata . Che questo corridoio sia collegato all'altro corrodoio del piano terra?\n" +
                "Dinanzi a te ritrovi Mia ma rivolta verso il muro");
        
        
        this.setStanzaCorrente(cancelloPrincipale);
    }
    
    /**
     *
     * @param stanza
     */
    public void setStanzaCorrente (Stanza stanza){
        this.stanzaCorrente = stanza;
    }
    
    public Stanza getStanzaCorrente(){
        return this.stanzaCorrente;
    }
    
    public void setStanzaPrec(Stanza stanza){
        this.stanzaPrec = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getStanzaPrec(){
        return this.stanzaPrec;
    }
    
    /**
     *
     * @param cancelloPrincipale
     */
    public void setCancelloPrincipale (Stanza cancelloPrincipale){
        this.cancelloPrincipale=cancelloPrincipale;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCancelloPrincipale(){
        return cancelloPrincipale;
    }
           
    /**
     *
     * @param cucina
     */
    public void setCucina (Stanza cucina){
        this.cucina=cucina;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCucina(){
        return cucina;
    }
    
    /**
     *
     * @param soggiorno
     */
    public void setSoggiorno (Stanza soggiorno){
        this.soggiorno=soggiorno;
    }
    
    /**
     *
     * @return
     */
    public Stanza getSoggiorno(){
        return soggiorno;
    }
    
    /**
     *
     * @param areadiguardia
     */
    public void setAreaDiGuardia(Stanza areadiguardia){
        this.areadiguardia=areadiguardia;
    }
    
    public Stanza getAreaDiGuardia(){
        return areadiguardia;
    }
    
    /**
     *
     * @param cantina
     */
    public void setCantina (Stanza cantina){
        this.cantina=cantina;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCantina(){
        return cantina;
    }
    
    /**
     *
     * @param soffitta
     */
    public void setSoffitta (Stanza soffitta){
        this.soffitta=soffitta;
    }
    
    /**
     *
     * @return
     */
    public Stanza getSoffitta(){
        return soffitta;
    }
    
    /**
     *
     * @param corridoioArmadio
     */
    public void setCorridoio (Stanza corridoioArmadio){
        this.corridoio = corridoioArmadio;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCorridoio(){
        return corridoio;
    }
    
    /**
     *
     * @param stanza
     */
    public void setCorridoio2 (Stanza stanza){
        this.corridoio2 = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCorridoio2(){
        return corridoio2;
    }
    
    /**
     *
     * @param stanza
     */
    public void setCorridoio3 (Stanza stanza){
        this.corridoio3 = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCorridoio3(){
        return corridoio3;
    }
    
    /**
     *
     * @param stanza
     */
    public void setCorridoio4 (Stanza stanza){
        this.corridoio4 = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCorridoio4(){
        return corridoio4;
    }
    
    /**
     *
     * @param CorridoioTrigger
     */
    public void setCorridoio5 (Stanza CorridoioTrigger){
        this.corridoio5 = CorridoioTrigger;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCorridoio5(){
        return corridoio5;
    }
    
    /**
     *
     * @param StanzaCombattimento
     */
    public void setCorridoio6 (Stanza StanzaCombattimento){
        this.corridoio6 = StanzaCombattimento;
    }
    
    public Stanza getCorridoio6(){
        return corridoio6;
    }
    
    /**
     *
     * @param stanza
     */
    public void setCortile (Stanza stanza){
        this.cortile = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCortile(){
        return corridoio2;
    }
    
    /**
     *
     * @param stanza
     */
    public void setCortile2 (Stanza stanza){
        this.cortile2 = stanza;
    }
    
    /**
     *
     * @return
     */
    public Stanza getCortile2(){
        return cortile2;
    }
    
    /**
     *
     * @param stanza
     */
    public void setEntrata (Stanza stanza){
        this.entrata = stanza;
    }
    
    public Stanza getEntrata(){
        return entrata;
    }
    
    /**
     * Set della mappa in base all'oggetto mappa dato in input.
     * @param mappa 
     */
    
    public void setMappa(Mappa mappa){
        this.setCancelloPrincipale(mappa.getCancelloPrincipale());
        this.setCortile(mappa.getCortile());
        this.setCortile2(mappa.getCortile2());
        this.setEntrata(mappa.getEntrata());
        this.setCorridoio(mappa.getCorridoio());
        this.setCucina(mappa.getCucina());
        this.setCorridoio2(mappa.getCorridoio2());
        this.setCorridoio3(mappa.getCorridoio3());
        this.setSoggiorno(mappa.getSoggiorno());
        this.setSoffitta(mappa.getSoffitta());
        this.setCorridoio4(mappa.getCorridoio4());
        this.setAreaDiGuardia(mappa.getAreaDiGuardia());
        this.setCantina(mappa.getCantina());
        this.setCorridoio5(mappa.getCorridoio5());
        this.setCorridoio6(mappa.getCorridoio6());
        this.setStanzaCorrente(mappa.getStanzaCorrente());
        this.setStanzaPrec(mappa.getStanzaPrec());
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
