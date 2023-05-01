/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import GameCore.Mappa;
import GameCore.Player;

/**
 *
 * @author sinis
 */
public class FileManager {
    /**
     * Salvataggio dell'oggetto Mappa su file 
     * @param file
     * @param mappa
     * @return 
     */
    public boolean salvataggioMappa(File file, Mappa mappa) {
         boolean savemap = false;
         
         try {
            FileOutputStream fileStream = new FileOutputStream(file);   
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   

            objectStream.writeObject(mappa);

            objectStream.close();   
            fileStream.close();   

            System.out.println("Mappa salvata con successo.");
            savemap = true;
         } catch (IOException e) {
            System.out.println("Fallimento nel salvataggio.");
            e.printStackTrace();
         }
         return savemap;
    }
     
     /**
      * Salvataggio dell'oggetto Player su file
      * @param file
      * @param player
      * @return boolean savepl true se il salvataggio è avvenuto con successo, false altrimenti
      */
     public boolean salvataggioPlayer(File file, Player player) {
         boolean savepl = false;

         try {
            FileOutputStream fileStream = new FileOutputStream(file);   
            ObjectOutputStream objectStream = new ObjectOutputStream(fileStream);   


            objectStream.writeObject(player);

            objectStream.close();   
            fileStream.close();   

            System.out.println("Giocatore salvato con successo.");
            savepl = true;


         } catch (IOException e) {
            System.out.println("Fallimento nel salvataggio."); 
            e.printStackTrace();
         }
         return savepl;
    }
    
    /**
     * Caricamento del file sull'oggetto Map
     * @param file
     * @return Oggetto Map caricato da file
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException 
     */ 
    public Mappa caricamentoMappa(File file) throws ClassNotFoundException, FileNotFoundException, IOException{  
        
        Mappa filemap = new Mappa();
        
        FileInputStream fileStream = new FileInputStream(file);   
        
        ObjectInputStream objectStream = new ObjectInputStream(fileStream);   

        filemap.setMappa((Mappa)objectStream.readObject());

        objectStream.close();
        
        System.out.println("Mappa caricata con successo.");

        return filemap; 
     }
    
    /**
     * Caricamento del file sull'oggetto Player
     * @param file
     * @return Oggetto Player caricato da file
     * @throws ClassNotFoundException
     * @throws FileNotFoundException
     * @throws IOException 
     */ 
    public Player caricamentoPlayer(File file) throws ClassNotFoundException, FileNotFoundException, IOException{   

        Player fileplayer = new Player();

        FileInputStream fileStream = new FileInputStream(file);   

        ObjectInputStream objectStream = new ObjectInputStream(fileStream);   

         fileplayer.setPlayer((Player)objectStream.readObject());

        objectStream.close();

         System.out.println("Giocatore caricato con successo.");

         return fileplayer;
    }
}
