/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;

/**
 *
 * @author BernierCorentin
 */
public abstract class Joueur {

    private int argent;
    private int positionPlateau;
    private boolean peuxAcheter;

    private final Color couleur;
    private final String nom;

    public Joueur(int couleur[], String nom) {
        this.argent = 2000;
        this.positionPlateau = 0;
        this.peuxAcheter = false;

        this.couleur = new Color(couleur[0], couleur[1], couleur[2]);
        this.nom = nom;

        System.out.println(nom + " " + this.couleur.toString());
    }

    public void setArgent(int argent) {
        this.argent = argent;
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
}
