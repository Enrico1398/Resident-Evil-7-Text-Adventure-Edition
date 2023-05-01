/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package StanzePianoTerra;

import Base.Stanza;
import Base.SuperObj;


/**
 *
 * @author sinis
 */
public class CorridoioTrigger extends Stanza{

    /**
     *
     */
    public CorridoioTrigger(){
        SuperObj ascia = new SuperObj("Ascia","Un'ascia da lavoro attaccata al muro.");
        SuperObj telefono = new SuperObj("Telefono","Il telefono squilla forse dovresti rispondere");
        ascia.setAlias(new String[]{"Accetta"});
        ascia.setRaccoglibile(true);
        this.addObject(ascia);
        this.addObject(telefono);
    }
    
    /**
     * Rispondere al telefono porta la modifica della descrizione della stanza
     */
    
    @Override
    public void rispostaTelefono(){
        this.setMsg("Alzi la cornetta e una voce ti risponde" +
                "<<Ethan so chi sei e perchè sei qui, ma Mia non può essere salvata,non è più quella di una volta." +
                "Fuggi da lì il prima possible!!>>");
        this.getObjects().removeIf(obj -> obj.getNome().equals("Telefono"));
        for(SuperObj obj : this.getObjects()){
            if(obj.getNome().equals("Ascia")){
                this.setDescrizione("Appena hai premuto il pulsante e ti si è aperta la porta segreta , Mia è fuggita come fosse impazzita all'improvviso.\n" +
                "Hai attraversato il passaggio segreto dalla cantina e ti ritrovi in questo lungo corridoio, c'è un telefono su un comodino e un'ascia è incastrata nel muro, di Mia non c'è traccia \n");
            }
            else{
            this.setDescrizione("Appena hai premuto il pulsante e ti si è aperta la porta segreta , Mia è fuggita come fosse impazzita all'improvviso.\n" +
                "Hai attraversato il passaggio segreto dalla cantina e ti ritrovi in questo lungo corridoio, c'è un telefono su un comodino ed un'ascia è incastrata nel muro, di Mia non c'è traccia \n");
            }
        }
    }
    
}
