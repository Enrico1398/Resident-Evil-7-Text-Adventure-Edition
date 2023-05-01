/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import GameCore.MainGioco.GestoreScelta;
/**
 *
 * @author sinis
 */
public class Interfaccia {
    private JPanel schermataInizialePanel, menuPrincipalePanel, testoPrincipalePanel, sceltaPanel, playerPanel, inventarioPanel, salvataggioPanel, uscitaPanel;
    private JLabel confermaSalvataggio;
    private JButton nuovaPartitaButton;
    private JButton invioButton;
    private JButton avantiButton;
    private JButton caricaPartitaButton;
    private JButton esciButton;
    private JButton esciButton2;
    private JButton siButton;
    private JButton noButton;
    private JButton menuPrincipaleButton;
    private JTextField campo;
    private JTextArea testoPrincipaleArea, testoPrincipaleAreaExit;
    private final Font normalFont= new Font("Courier ", Font.BOLD, 17);
    private final Font invFont=new Font("Courier ", Font.BOLD, 14);
    private String campotxt = "";
    private boolean pressed = false;
    
    /**
     * Creazione dell'interfaccia dando in input il cH
     * @param gestoreScelta 
     */
    
    public void creaInterfacciaUtente(GestoreScelta gestoreScelta){
        
        //window. Finestra dell'interfaccia
        JFrame finestra = new JFrame();
        finestra.setSize(840,650);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.getContentPane().setBackground(Color.black);
        finestra.setLayout(null);
        
        //title screen. Schermata del titolo 
        schermataInizialePanel = new JPanel();
        schermataInizialePanel.setBounds(100,100,600,300);
        schermataInizialePanel.setBackground(Color.black);
        JLabel titleNameLabel = new JLabel("RESIDENT EVIL 7: TextAdventure Edition");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(new Font("Courier ", Font.BOLD, 30));
        schermataInizialePanel.add(titleNameLabel);
        
        //Pannello menù principale
        menuPrincipalePanel= new JPanel();
        menuPrincipalePanel.setBounds(310,400,200,100);
        menuPrincipalePanel.setBackground(Color.black);
        menuPrincipalePanel.setLayout(new GridLayout(4,1));
        
        //Pulsante nuova partita
        nuovaPartitaButton = new JButton("NUOVA PARTITA");
        nuovaPartitaButton.setBackground(Color.black);
        nuovaPartitaButton.setForeground(Color.white);
        nuovaPartitaButton.setFont(normalFont);
        nuovaPartitaButton.setFocusPainted(false);
        nuovaPartitaButton.addActionListener(gestoreScelta);
        nuovaPartitaButton.setActionCommand("nuovaPartita");
        nuovaPartitaButton.setBorder(null);
        menuPrincipalePanel.add(nuovaPartitaButton);
        
        //Pulsante carica partita
        caricaPartitaButton = new JButton("CARICA PARTITA");
        caricaPartitaButton.setVisible(true);
        caricaPartitaButton.setBackground(Color.black);
        caricaPartitaButton.setForeground(Color.white);
        caricaPartitaButton.setFont(normalFont);
        caricaPartitaButton.setFocusPainted(false);
        caricaPartitaButton.addActionListener(gestoreScelta);
        caricaPartitaButton.setActionCommand("caricaPartita");
        caricaPartitaButton.setBorder(null);
        menuPrincipalePanel.add(caricaPartitaButton);
        
        //Pulsante esci per uscire dal gioco
        esciButton = new JButton("ESCI");
        esciButton.setBackground(Color.black);
        esciButton.setForeground(Color.white);
        esciButton.setFont(normalFont);
        esciButton.setFocusPainted(false);
        esciButton.addActionListener(gestoreScelta);
        esciButton.setActionCommand("esci");
        esciButton.setBorder(null);
        menuPrincipalePanel.add(esciButton);

        //Pulsante avanti che porta alla schermata principale del gioco
        avantiButton = new JButton("Avanti");
        avantiButton.setBackground(Color.black);
        avantiButton.setForeground(Color.white);
        avantiButton.setFont(normalFont);
        avantiButton.setFocusPainted(false);
        avantiButton.addActionListener(gestoreScelta);
        avantiButton.setActionCommand("avanti");
        menuPrincipalePanel.add(avantiButton);
        
        //Pannello conferma dell'uscita
        uscitaPanel= new JPanel();
        uscitaPanel.setBounds(310,400,200,100);
        uscitaPanel.setBackground(Color.black);
        uscitaPanel.setLayout(new GridLayout(4,1));
        uscitaPanel.setVisible(false);
        
        //Pulsante Sì per il ritorno al menù principale
        siButton = new JButton("SI");
        siButton.setBackground(Color.black);
        siButton.setForeground(Color.white);
        siButton.setFont(normalFont);
        siButton.setFocusPainted(false);
        siButton.addActionListener(gestoreScelta);
        siButton.setActionCommand("si");
        siButton.setBorder(null);
        uscitaPanel.add(siButton);
        
        //Pulsante No per ritornare alla schermata principale del gioco
        noButton = new JButton("NO");
        noButton.setBackground(Color.black);
        noButton.setForeground(Color.white);
        noButton.setFont(normalFont);
        noButton.setFocusPainted(false);
        noButton.addActionListener(gestoreScelta);
        noButton.setActionCommand("no");
        noButton.setBorder(null);
        uscitaPanel.add(noButton);
        
        //Pulsante Menù principale che può comparire in caso di caricamento del file fallito o nel caso in cui si raggiunga un finale/morte
        menuPrincipaleButton = new JButton("MENU PRINCIPALE");
        menuPrincipaleButton.setBackground(Color.black);
        menuPrincipaleButton.setForeground(Color.white);
        menuPrincipaleButton.setFont(normalFont);
        menuPrincipaleButton.setFocusPainted(false);
        menuPrincipaleButton.addActionListener(gestoreScelta);
        menuPrincipaleButton.setActionCommand("TornaAlMenu");
        menuPrincipaleButton.setBorder(null);
        uscitaPanel.add(menuPrincipaleButton);
        
        finestra.add(schermataInizialePanel);
        finestra.add(menuPrincipalePanel);
        finestra.add(uscitaPanel);
        
        //Pannello a scomparsa per la visualizzazione dell'inventario
        inventarioPanel=new JPanel();
        inventarioPanel.setBounds(120, 65, 130, 230);
        inventarioPanel.setBackground(Color.black);
        inventarioPanel.setLayout(new GridLayout(12,1));
        finestra.add(inventarioPanel);

        //Pannello per l'area di testo principale
        testoPrincipalePanel = new JPanel();
        testoPrincipalePanel.setBounds(50,100,650,315);
        testoPrincipalePanel.setBackground(Color.black);
        finestra.add(testoPrincipalePanel);

        //Area di testo principale
        testoPrincipaleArea= new JTextArea("");
        testoPrincipaleArea.setBounds(50,50,650,600);
        testoPrincipaleArea.setBackground(Color.black);
        testoPrincipaleArea.setForeground(Color.white);
        testoPrincipaleArea.setFont(normalFont);
        testoPrincipaleArea.setLineWrap(true);
        testoPrincipaleArea.setEditable(false);
        testoPrincipalePanel.add(testoPrincipaleArea);
        
        //Area di testo per l'uscita dal gioco
        testoPrincipaleAreaExit= new JTextArea("");
        testoPrincipaleAreaExit.setBounds(50,50,650,400);
        testoPrincipaleAreaExit.setBackground(Color.black);
        testoPrincipaleAreaExit.setForeground(Color.white);
        testoPrincipaleAreaExit.setFont(normalFont);
        testoPrincipaleAreaExit.setLineWrap(true);
        testoPrincipaleAreaExit.setEditable(false);
        testoPrincipaleAreaExit.setVisible(false);
        testoPrincipalePanel.add(testoPrincipaleAreaExit);
        
        //Pannello per contenere il campo per l'inserimento dei comandi e il tasto Invio
        sceltaPanel = new JPanel();
        sceltaPanel.setBounds(230,430,400,100);
        sceltaPanel.setBackground(Color.black);
        sceltaPanel.setLayout(new GridLayout(2,1));
        finestra.add(sceltaPanel);
        
        //Set dei vari Label per mostrare gli oggetti dell'inventario
        javax.swing.border.Border border = BorderFactory.createLineBorder(Color.white);
        JLabel inv1 = new JLabel();
        inv1.setBackground(Color.black);
        inv1.setForeground(Color.white);
        inv1.setFont(invFont);
        inv1.setBorder(border);

        JLabel inv2 = new JLabel();
        inv2.setBackground(Color.black);
        inv2.setForeground(Color.white);
        inv2.setFont(invFont);
        inv2.setBorder(border);

        JLabel inv3 = new JLabel();
        inv3.setBackground(Color.black);
        inv3.setForeground(Color.white);
        inv3.setFont(invFont);
        inv3.setBorder(border);

        JLabel inv4 = new JLabel();
        inv4.setBackground(Color.black);
        inv4.setForeground(Color.white);
        inv4.setFont(invFont);
        inv4.setBorder(border);

        JLabel inv5 = new JLabel();
        inv5.setBackground(Color.black);
        inv5.setForeground(Color.white);
        inv5.setFont(invFont);
        inv5.setBorder(border);

        JLabel inv6 = new JLabel();
        inv6.setBackground(Color.black);
        inv6.setForeground(Color.white);
        inv6.setFont(invFont);
        inv6.setBorder(border);

        JLabel inv7 = new JLabel();
        inv7.setBackground(Color.black);
        inv7.setForeground(Color.white);
        inv7.setFont(invFont);
        inv7.setBorder(border);

        JLabel inv8 = new JLabel();
        inv8.setBackground(Color.black);
        inv8.setForeground(Color.white);
        inv8.setFont(invFont);
        inv8.setBorder(border);

        JLabel inv9 = new JLabel();
        inv9.setBackground(Color.black);
        inv9.setForeground(Color.white);
        inv9.setFont(invFont);
        inv9.setBorder(border);

        JLabel inv10 = new JLabel();
        inv10.setBackground(Color.black);
        inv10.setForeground(Color.white);
        inv10.setFont(invFont);
        inv10.setBorder(border);

        JLabel inv11 = new JLabel();
        inv11.setBackground(Color.black);
        inv11.setForeground(Color.white);
        inv11.setFont(invFont);
        inv11.setBorder(border);

        JLabel inv12 = new JLabel();
        inv12.setBackground(Color.black);
        inv12.setForeground(Color.white);
        inv12.setFont(invFont);
        inv12.setBorder(border);
        
        inventarioPanel.add(inv1);
        inventarioPanel.add(inv2);
        inventarioPanel.add(inv3);
        inventarioPanel.add(inv4);
        inventarioPanel.add(inv5);
        inventarioPanel.add(inv6);
        inventarioPanel.add(inv7);
        inventarioPanel.add(inv8);
        inventarioPanel.add(inv9);
        inventarioPanel.add(inv10);
        inventarioPanel.add(inv11);
        inventarioPanel.add(inv12);
        
        //Campo per l'inserimento dei comandi
        campo= new JTextField ("");           
        campo.setBackground(Color.black);         
        campo.setForeground(Color.DARK_GRAY);
        campo.setFont(normalFont);
        campo.addActionListener(gestoreScelta);
        campo.setActionCommand("invio");
        campo.setText("                            Digita cosa vuoi fare");

        //Al click del mouse su campo, la scritta "Cosa devo fare?" scompare
        campo.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                campo.setText("");
                campo.setForeground(Color.white);
            }
        });

        //Alla pressione di un qualsiasi tasto, la scritta "Cosa devo fare?" scompare
        campo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed (java.awt.event.KeyEvent evt){
                if (!pressed) {
                    campo.setForeground(Color.white);
                    campo.setText("");
                    pressed = true;
                }
            }
        });

        //Alla pressione dell tasto invio, ricompare la scritta "Cosa devo fare?" e il testo digitato viene salvato in campotxt
        campo.addActionListener((ActionEvent e) -> {
                 campotxt = campo.getText();
                 campo.setForeground(Color.DARK_GRAY);
                 campo.setText("                           Cosa devo fare?");
                 pressed = false;
         });
        sceltaPanel.add(campo);

        //Pulsante per l'acquisizione dei comandi dal campo
        invioButton = new JButton ("Invio");
        invioButton.setBackground(Color.black);        
        invioButton.setForeground(Color.white);
        invioButton.setFont(normalFont);
        invioButton.setFocusPainted(false);
        invioButton.addActionListener(gestoreScelta);
        sceltaPanel.add(invioButton);

        //Alla pressione del JButton "Invio", ricompare la scritta "Cosa devo fare?" e il testo digitato viene salvato in campotxt
        invioButton.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent evt) {
                    campotxt = campo.getText();
                    invioButton.setActionCommand("invio");
                    campo.setForeground(Color.DARK_GRAY);
                    campo.setText("                           Cosa devo fare?");
                    pressed = false;
            }
        });
     
        //Pannello per i pulsanti Salva, Inventario ed Esci
        playerPanel = new JPanel();                     
        playerPanel.setBounds(120,15,600,50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout( new GridLayout(1,4));
        finestra.add(playerPanel);
        
        //Pannello per il messaggio di salvataggio avvenuto
        salvataggioPanel= new JPanel();
        salvataggioPanel.setBounds(320,65,60,50);
        salvataggioPanel.setBackground(Color.black);
        finestra.add(salvataggioPanel);
        salvataggioPanel.setVisible(false);
        
        //Pulsante Inventario per l'apertura e chiusura del panel a scomparsa dell'inventario
        JButton inventarioButton = new JButton("Inventario");
        inventarioButton.setBackground(Color.black);
        inventarioButton.setForeground(Color.white);
        inventarioButton.setFont(normalFont);
        inventarioButton.setFocusPainted(false);
        inventarioButton.addActionListener(gestoreScelta);
        inventarioButton.setActionCommand("inventario");
        playerPanel.add(inventarioButton);
        
        //Pulsante Salva
        JButton salvaButton = new JButton("Salva");
        salvaButton.setBackground(Color.black);
        salvaButton.setForeground(Color.white);
        salvaButton.setFont(normalFont);
        salvaButton.setFocusPainted(false);
        salvaButton.addActionListener(gestoreScelta);
        salvaButton.setActionCommand("salva");
        playerPanel.add(salvaButton);
        
        //Pulsante Esci sulla schermata di gioco (in game)
        esciButton2 = new JButton("Esci");
        esciButton2.setBackground(Color.black);
        esciButton2.setForeground(Color.white);
        esciButton2.setFont(normalFont);
        esciButton2.setFocusPainted(false);
        esciButton2.addActionListener(gestoreScelta);
        esciButton2.setActionCommand("esciDalMenu");
        playerPanel.add(esciButton2);

        //Label di conferma del salvataggio avvenuto
        confermaSalvataggio= new JLabel("");
        confermaSalvataggio.setForeground(Color.white);
        confermaSalvataggio.setFont(normalFont);
        salvataggioPanel.add(confermaSalvataggio);
        
        finestra.setVisible(true);
    }
      
    /**
     *
     * @return
     */
    public String getCampotxt() {
        return campotxt;
    }

    /**
     *
     * @return
     */
    public JTextArea getTestoPrincipaleArea() {
        return testoPrincipaleArea;
    }

    /**
     *
     * @return
     */
    public JTextArea getTestoPrincipaleAreaExit() {
        return testoPrincipaleAreaExit;
    }

    /**
     *
     * @return
     */
    public JTextField getCampo() {
        return campo;
    }

    /**
     *
     * @return
     */
    public JPanel getSchermataInizialePanel() {
        return schermataInizialePanel;
    }

    /**
     *
     * @return
     */
    public JPanel getMenuPrincipalePanel() {
        return menuPrincipalePanel;
    }

    /**
     *
     * @return
     */
    public JPanel getTestoPrincipalePanel() {
        return testoPrincipalePanel;
    }

    /**
     *
     * @return
     */
    public JPanel getSceltaPanel() {
        return sceltaPanel;
    }
    
    /**
     *
     * @return
     */
    public JPanel getPlayerPanel() {
        return playerPanel;
    }

    /**
     *
     * @return
     */
    public JPanel getInventarioPanel() {
        return inventarioPanel;
    }

    /**
     *
     * @return
     */
    public JPanel getSalvataggioPanel() {
        return salvataggioPanel;
    }

    /**
     *
     * @return
     */
    public JPanel getUscitaPanel() {
        return uscitaPanel;
    }

    /**
     *
     * @return
     */
    public JLabel getConfermaSalvataggio() {
        return confermaSalvataggio;
    }

    /**
     *
     * @return
     */
    public JButton getNuovaPartitaButton() {
        return nuovaPartitaButton;
    }

    /**
     *
     * @return
     */
    public JButton getAvantiButton() {
        return avantiButton;
    }

    /**
     *
     * @return
     */
    public JButton getCaricaPartitaButton() {
        return caricaPartitaButton;
    }

    /**
     *
     * @return
     */
    public JButton getEsciButton() {
        return esciButton;
    }

    /**
     *
     * @return
     */
    public JButton getSiButton() {
        return siButton;
    }

    /**
     *
     * @return
     */
    public JButton getNoButton() {
        return noButton;
    }

    /**
     *
     * @return
     */
    public JButton getMenuPrincipaleButton() {
        return menuPrincipaleButton;
    }

    /**
     *
     * @param pressed
     */
    public void setPressed(boolean pressed) {
        this.pressed = pressed;
    }
    
    
}
    

