
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BernierCorentin
 */
public class Plateau extends javax.swing.JPanel {

    private Joueur leJoueurActuel;
    private int optionsActueljBtn;

    private ArrayList<Joueur> lesJoueurs;
    private ArrayList<Propriete> propNonVendue;

    private int argentCentre;
    private Case[] lePlateau;

    /**
     * Creates new form Plateau
     */
    public Plateau(int nbHumains, int nbAI, String nomsJoueurs[]) {
        initComponents();

        lesJoueurs = new ArrayList();
        propNonVendue = new ArrayList();

        int couleurs[][] = {{255, 0, 0}, {0, 0, 255}, {0, 255, 0}, {255, 255, 0}, {255, 128, 0}, {128, 0, 128}, {86, 86, 86}, {172, 172, 172}};
        for (int i = 0; i < nbHumains; i++) {
            lesJoueurs.add(new JoueurHumain(couleurs[i], nomsJoueurs[i], i));
        }
        //IA non fonctionnel
//        for (int i = 0; i < nbAI; i++) {
//            lesJoueurs.add(new JoueurIA(couleurs[i + nbHumains], "Bot" + i, i + nbHumains));
//        }

        String[] prop = {"BOULEVARD DE BELLEVILLE", "RUE LECOURBE", "RUE DE VAUGIRARD", "RUE DE COURCELLES", "AVENUE DE LA REPUBLIQUE", "BOULEVARD DE LA VILETTE", "AVENUE DE NEUILLY", "RUE DE PARADIS", "AVENUE MOZART", "BOULEVARD SAINT-MICHEL", "PLACE PIGALLE", "AVENUE MATIGNON", "BOULEVARD MALESGERBES", "AVENUE HERIN-MARTIN", "FAUBOURG SAINT HONORE", "PLACE DE LA BOURSE", "RUE LA FAYETTE", "AVENUE DE BRETEUIL", "AVENUE FOCH", "BOULEVARD DES CAPUCINES", "AVENUE DES CHAMPS-ELYSEES", "RUE DE LA PAIX", "GARE DE MONTPARNASSE", "GARE DE LYON", "GARE DU NORD", "GARE DE SAINT-LAZARE", "COMPAGNIE DE DISTRIBUTION D'ELECTRICITE", "COMPAGNIE DE DISTRIBUTION DES EAUX"};
        int propPrix[] = {60, 60, 100, 100, 120, 140, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 280, 300, 300, 320, 350, 400, 200, 200, 200, 200, 150, 150};
        for (int i = 0; i < prop.length; i++) {
            if (i < 22) {
                int totalGroupe = 3;
                if ((i + 1) / 3 == 0 || (i + 1) / 3 == 7) {
                    totalGroupe = 2;
                }
                propNonVendue.add(new Terrain(prop[i], (i + 1) / 3, totalGroupe, propPrix[i], ((i + 1) / 6 + 1) * 50));
            } else if (i >= 22 && i < 26) {
                propNonVendue.add(new Gare(prop[i], 8, 4, propPrix[i]));
            } else {
                propNonVendue.add(new Utilitaire(prop[i], 9, 2, propPrix[i]));
            }
        }

        lePlateau = new Case[40];
        lePlateau[0] = new CaseDepart();
        lePlateau[1] = new CaseProprietes(propNonVendue.get(0));
        lePlateau[2] = new CaseCaisseCommunautaires();
        lePlateau[3] = new CaseProprietes(propNonVendue.get(1));
        lePlateau[4] = new CaseTaxes("IMPOTS SUR LE REVENU", 200);
        lePlateau[5] = new CaseProprietes(propNonVendue.get(22));
        lePlateau[6] = new CaseProprietes(propNonVendue.get(2));
        lePlateau[7] = new CaseChances();
        lePlateau[8] = new CaseProprietes(propNonVendue.get(3));
        lePlateau[9] = new CaseProprietes(propNonVendue.get(4));
        lePlateau[10] = new CasePrison();
        lePlateau[11] = new CaseProprietes(propNonVendue.get(5));
        lePlateau[12] = new CaseProprietes(propNonVendue.get(26));
        lePlateau[13] = new CaseProprietes(propNonVendue.get(6));
        lePlateau[14] = new CaseProprietes(propNonVendue.get(7));
        lePlateau[15] = new CaseProprietes(propNonVendue.get(23));
        lePlateau[16] = new CaseProprietes(propNonVendue.get(8));
        lePlateau[17] = new CaseCaisseCommunautaires();
        lePlateau[18] = new CaseProprietes(propNonVendue.get(9));
        lePlateau[19] = new CaseProprietes(propNonVendue.get(10));
        lePlateau[20] = new CaseParcGratuit();
        lePlateau[21] = new CaseProprietes(propNonVendue.get(11));
        lePlateau[22] = new CaseChances();
        lePlateau[23] = new CaseProprietes(propNonVendue.get(12));
        lePlateau[24] = new CaseProprietes(propNonVendue.get(13));
        lePlateau[25] = new CaseProprietes(propNonVendue.get(24));
        lePlateau[26] = new CaseProprietes(propNonVendue.get(14));
        lePlateau[27] = new CaseProprietes(propNonVendue.get(15));
        lePlateau[28] = new CaseProprietes(propNonVendue.get(27));
        lePlateau[29] = new CaseProprietes(propNonVendue.get(16));
        lePlateau[30] = new CaseAllezEnPrison();
        lePlateau[31] = new CaseProprietes(propNonVendue.get(17));
        lePlateau[32] = new CaseProprietes(propNonVendue.get(18));
        lePlateau[33] = new CaseCaisseCommunautaires();
        lePlateau[34] = new CaseProprietes(propNonVendue.get(19));
        lePlateau[35] = new CaseProprietes(propNonVendue.get(25));
        lePlateau[36] = new CaseChances();
        lePlateau[37] = new CaseProprietes(propNonVendue.get(20));
        lePlateau[38] = new CaseTaxes("TAXE DE LUXE", 100);
        lePlateau[39] = new CaseProprietes(propNonVendue.get(21));

        this.getNouveauJoueur();
    }

    public Joueur getGagnant() {
        if (lesJoueurs.size() < 2) {
            return lesJoueurs.get(0);
        } else {
            return null;
        }
    }

    public void getNouveauJoueur() {
        Joueur leJoueur = lesJoueurs.get(0);
        for (int i = 1; i < lesJoueurs.size(); i++) {
            if (lesJoueurs.get(i).getPrio() < leJoueur.getPrio()) {
                leJoueur = lesJoueurs.get(i);
            }
        }
        lesJoueurs.remove(leJoueur);
        leJoueurActuel = leJoueur;

        jLblTourJoueur.setText("Au tour de " + leJoueurActuel.getNom());
        jLblTourJoueur.setForeground(leJoueurActuel.getCouleur());
        actualiseInfoJoueur();
        jBtnTour.setEnabled(false);

        optionsActueljBtn = 0;
        jBtnOption.setText("Lancer le dé");
        jBtnOption.setEnabled(true);

        ecrireHisto("Au tour de " + leJoueurActuel.getNom() + ". Il se trouve sur la case " + getNomPosition());
    }

    public void ecrireHisto(String nouvelleLigne) {
        jTAHisto.setText(jTAHisto.getText() + nouvelleLigne + "\n");
    }

    private String getNomPosition() {
        return lePlateau[leJoueurActuel.getPositionPlateau()].getNom() + " (" + leJoueurActuel.getPositionPlateau() + ").";
    }

    private void actualiseInfoJoueur() {
        jLblArgent.setText(leJoueurActuel.getArgent() + "$");

        ArrayList<Propriete> sesProprietes = leJoueurActuel.getSesProprietes();
        String textProp = "";
        for (Propriete unePropriete : sesProprietes) {
            textProp += unePropriete.getNom();
            if (unePropriete.isTerrain()) {
                Terrain leTerrain = (Terrain) unePropriete;
                textProp += " - ";
                if (leTerrain.getNbMaisons() < 5) {
                    textProp += leTerrain.getNbMaisons() + " Maison";
                    if (leTerrain.getNbMaisons() >= 2) {
                        textProp += "s";
                    }
                } else {
                    textProp += "1 Hotel";
                }
            }
            textProp += "\n";
        }
        jTAProp.setText(textProp);
    }

    public void popUp(String titre, String message) {
        JOptionPane.showMessageDialog(this, message, titre, JOptionPane.PLAIN_MESSAGE);
    }

    public void ajouterArgentParcGratuit(int quantite) {
        CaseParcGratuit leParc = (CaseParcGratuit) lePlateau[20];
        leParc.ajouterArgent(quantite);
    }

    // test afin de dessiner les pions des personnages sur le plateau de jeu (non focntionnel)
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);       
//
//        // Draw Text
//        g.drawString("This is my custom Panel!",10,20);
//        g.setColor(new Color(255, 0, 0));
//        g.fillOval(300, 300, 300, 300);
//    }  
//    @Override
//    public void paint(Graphics g){
//        ArrayList<Joueur> lesJoueurs = laPartie.getLesJoueurs();
//        for (Joueur unJoueur : lesJoueurs) {
//        }
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAHisto = new javax.swing.JTextArea();
        jLblTourJoueur = new javax.swing.JLabel();
        jBtnOption = new javax.swing.JButton();
        jBtnTour = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLblArgent = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAProp = new javax.swing.JTextArea();

        setPreferredSize(new java.awt.Dimension(1366, 768));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Files\\Documents\\Projects\\ProjetJava\\Monopoly\\plateau.png")); // NOI18N
        jLabel1.setText("mlsdkf11");
        jLabel1.setPreferredSize(new java.awt.Dimension(745, 745));

        jTAHisto.setEditable(false);
        jTAHisto.setColumns(20);
        jTAHisto.setRows(5);
        jScrollPane1.setViewportView(jTAHisto);

        jLblTourJoueur.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLblTourJoueur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblTourJoueur.setText("Au tour de lkdjflskdjf$");

        jBtnOption.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBtnOption.setText("Lancer le Dé");
        jBtnOption.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOptionActionPerformed(evt);
            }
        });

        jBtnTour.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jBtnTour.setText("Finir son tour");
        jBtnTour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnTourActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Vous avez ");

        jLblArgent.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLblArgent.setText("17000$");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Vos propriétés");

        jTAProp.setEditable(false);
        jTAProp.setBackground(new java.awt.Color(240, 240, 240));
        jTAProp.setColumns(20);
        jTAProp.setRows(20);
        jTAProp.setText("RUE LECOURBE - 3 Maisons\nAVENUE MOZART - 1 Hotel\nCOMPAGNIE DE DISTRIBUTION DES EAUX");
        jScrollPane2.setViewportView(jTAProp);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLblArgent)
                        .addGap(94, 94, 94))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 42, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(113, 113, 113))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jBtnTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jBtnOption, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblTourJoueur, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLblTourJoueur, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLblArgent))
                        .addGap(71, 71, 71)
                        .addComponent(jBtnOption)
                        .addGap(18, 18, 18)
                        .addComponent(jBtnTour)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1)))
                .addGap(0, 23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOptionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOptionActionPerformed
        switch (optionsActueljBtn) {
            case 0:
                int de1 = De.lancer();
                int de2 = De.lancer();

                String textHisto = leJoueurActuel.getNom() + " fait un " + de1 + " et un " + de2 + ".";
                if (de1 == de2) {
                    textHisto += " Il pourra rejouer !";
                    leJoueurActuel.setPrio(0);
                } else {
                    leJoueurActuel.setPrio(1);
                }
                ecrireHisto(textHisto);
                if (leJoueurActuel.getPositionPlateau() + de1 + de2 > 39) {
                    if (leJoueurActuel.getPositionPlateau() + de1 + de2 != 40) {
                        ecrireHisto(leJoueurActuel.getNom() + " gagne 200$ en passant par la case Départ.");
                    }
                    leJoueurActuel.setArgent(200);
                    if (!leJoueurActuel.isPeuxAcheter()) {
                        leJoueurActuel.setPeuxAcheter(true);
                    }
                }
                leJoueurActuel.setPositionPlateau((leJoueurActuel.getPositionPlateau() + de1 + de2) % 40);
                ecrireHisto(leJoueurActuel.getNom() + " se déplace en case " + getNomPosition());
                lePlateau[leJoueurActuel.getPositionPlateau()].actionArrive(leJoueurActuel, de1 + de2, this);
                jBtnTour.setEnabled(true);
                actualiseInfoJoueur();

                if (lePlateau[leJoueurActuel.getPositionPlateau()].estAchetable()) {
                    Propriete laProp = ((CaseProprietes) lePlateau[leJoueurActuel.getPositionPlateau()]).getLaPropriete();
                    if (laProp.getProprietaire() == null && leJoueurActuel.isPeuxAcheter()) {
                        optionsActueljBtn = 1;
                        jBtnOption.setText("Acheter (" + laProp.getPrixAchat() + "$)");
                        if (leJoueurActuel.getArgent() < laProp.getPrixAchat()) {
                            jBtnOption.setEnabled(false);
                        }
                    } else if (laProp.getProprietaire() != null) {
                        if (laProp.getProprietaire().equals(leJoueurActuel) && laProp.isTerrain()) {
                            optionsActueljBtn = 2;
                            jBtnOption.setText("Construire une maison (" + ((Terrain) laProp).getPrixMaison() + "$)");
                            if (((Terrain) laProp).getNbMaisons() > 5 || leJoueurActuel.getArgent() < ((Terrain) laProp).getPrixMaison() || !(laProp.aNbDuGroupe() == laProp.getTotalGroupe())) {
                                jBtnOption.setEnabled(false);
                            }
                        } else {
                            jBtnOption.setEnabled(false);
                        }
                    } else {
                        jBtnOption.setEnabled(false);
                    }
                } else {
                    jBtnOption.setEnabled(false);
                }
                break;
            case 1:
                Propriete laPropVendue = ((CaseProprietes) lePlateau[leJoueurActuel.getPositionPlateau()]).getLaPropriete();
                propNonVendue.remove(laPropVendue);
                leJoueurActuel.ajouterPropriete(laPropVendue);
                leJoueurActuel.setArgent(-(laPropVendue.getPrixAchat()));
                this.actualiseInfoJoueur();
                jBtnOption.setEnabled(false);
                break;
        }
        repaint();
    }//GEN-LAST:event_jBtnOptionActionPerformed

    private void jBtnTourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnTourActionPerformed
        lesJoueurs.add(leJoueurActuel);
        getNouveauJoueur();
    }//GEN-LAST:event_jBtnTourActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnOption;
    private javax.swing.JButton jBtnTour;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblArgent;
    private javax.swing.JLabel jLblTourJoueur;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTAHisto;
    private javax.swing.JTextArea jTAProp;
    // End of variables declaration//GEN-END:variables
}
