/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JeuCartes;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author BernierCorentin
 */
public class Fenetre extends JFrame implements ActionListener {

    private JPanel pnlBouton;
    private JPanel pnlMenu;

    public Fenetre() {
        super("Le Jeu de Cartes");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1366, 768);
        getContentPane().setLayout(new BorderLayout());

        pnlBouton = new JPanel(new GridLayout());
        pnlMenu = new JPanel(new GridLayout(2, 3));
        
        getContentPane().add(pnlMenu, "Center");
        getContentPane().add(pnlBouton, "South");
        
        String lesBtnsBas[] = {"Menu", "Quitter"};
        for (String leBtnBas : lesBtnsBas) {
            ajouterBouton(leBtnBas, pnlBouton);
        }
        String lesBtnsMenu[] = {"Solitaire", "Freecell", "Spider Solitaire", "Président", "Bataille", "Menteur"};
        for (String leBtnMenu : lesBtnsMenu) {
            ajouterBouton(leBtnMenu, pnlMenu);
        }

        this.setVisible(true);
    }

    private void ajouterBouton(String lbl, JPanel pnl) {
        JButton btn = new JButton(lbl);
        pnl.add(btn);
        btn.addActionListener(this);
    }
    
    private void remplacerMainPanel(JPanel nouveau){
        getContentPane().add(nouveau, "Center");
        //getContentPane().remove(0);
        getContentPane().getComponent(0).toString();
        
        repaint();
    }

    public static void main(String[] args) {
        Fenetre laFenetre = new Fenetre();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
        if(action.equals("Menu")){
            remplacerMainPanel(pnlMenu);
        }
        
        if(action.equals("Solitaire")){
            System.out.println("wesh ??");
            remplacerMainPanel(new JPanel());
        }
        
        if(action.equals("Quitter")){
            System.exit(0);
        }
    }
}
