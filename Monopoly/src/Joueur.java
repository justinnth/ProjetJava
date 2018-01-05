/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author BernierCorentin
 */
public abstract class Joueur {

    private int argent;
    private int positionPlateau;
    private boolean peuxAcheter;
    private int prio;
    private ArrayList<Propriete> sesProprietes;
    private int enPrison;

    private final Color couleur;
    private final String nom;
    private final int number;

    public Joueur(int couleur[], String nom, int number) {
        this.argent = 2000;
        this.positionPlateau = 0;
        this.peuxAcheter = false;
        this.sesProprietes = new ArrayList();
        this.enPrison = 0;

        this.couleur = new Color(couleur[0], couleur[1], couleur[2]);
        this.nom = nom;
        this.number = number;
    }

    public void setArgent(int changement) {
        this.argent += changement;
    }

    public int getArgent() {
        return argent;
    }

    public void setPositionPlateau(int positionPlateau) {
        this.positionPlateau = positionPlateau;
    }

    public int getPositionPlateau() {
        return positionPlateau;
    }

    public boolean isPeuxAcheter() {
        return peuxAcheter;
    }

    public void setPeuxAcheter(boolean peuxAcheter) {
        this.peuxAcheter = peuxAcheter;
    }

    public int getPrio() {
        return prio;
    }

    public void setPrio(int prio) {
        this.prio = prio;
    }

    public String getNom() {
        return nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public ArrayList<Propriete> getSesProprietes() {
        return sesProprietes;
    }

    public int getEnPrison() {
        return enPrison;
    }

    public void setEnPrison(int enPrison) {
        this.enPrison = enPrison;
    }
    
    public void ajouterPropriete(Propriete laPropriete){
        sesProprietes.add(laPropriete);
    }

}

class JoueurHumain extends Joueur {

    public JoueurHumain(int[] couleur, String nom, int number) {
        super(couleur, nom, number);
    }

}

class JoueurIA extends Joueur {

    public JoueurIA(int[] couleur, String nom, int number) {
        super(couleur, nom, number);
    }

}
