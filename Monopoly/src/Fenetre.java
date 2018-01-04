/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

/**
 *
 * @author BernierCorentin
 */
public class Fenetre extends JFrame implements ActionListener {

    private Menu pnlMenu;
    private Partie laParte;
    private Plateau lePlateau;

    public Fenetre() {
        super("Le Jeu de Cartes");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1366, 768);
        getContentPane().setLayout(new BorderLayout());
        
        pnlMenu = new Menu(this);
        getContentPane().add(pnlMenu, "Center");

        this.setVisible(true);
    }
    
//    private void remplacerMainPanel(JPanel nouveau){
//        getContentPane().add(nouveau, "Center");
//        getContentPane().remove(0);
//        
//        repaint();
//    }

    public static void main(String[] args) {
        Fenetre laFenetre = new Fenetre();
    }
    
    public void commencerPartie(int nbHumains, int nbAI, String nomsJoueurs[]){
        laParte = new Partie(nbHumains, nbAI);
        lePlateau = new Plateau();
        getContentPane().remove(0);
        getContentPane().add(lePlateau, "Center");
        validate();
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        
//        if(action.equals("Menu")){
//            remplacerMainPanel(pnlMenu);
//        }
//        
//        if(action.equals("Solitaire")){
//            System.out.println("wesh ??");
//            remplacerMainPanel(new JPanel());
//        }
        
//        if(action.equals("Quitter")){
//            System.exit(0);
//        }
    }
}