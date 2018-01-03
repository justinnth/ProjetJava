/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BernierCorentin
 */
public abstract class Proprietes {

    protected final String nom;
    protected final int groupe;
    protected final int prixAchat;
    protected Joueur proprietaire;

    public Proprietes(String nom, int groupe, int prixAchat) {
        this.nom = nom;
        this.groupe = groupe;
        this.prixAchat = prixAchat;
        this.proprietaire = null;
//        System.out.println(groupe + " " + nom);
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public abstract boolean isTerrain();

}

class Terrains extends Proprietes {

    private final int prixMaison;

    private int nbMaisons;

    public Terrains(String nom, int groupe, int prixAchat, int prixMaison) {
        super(nom, groupe, prixAchat);

//        System.out.println(prixMaison);
        this.prixMaison = prixMaison;
        nbMaisons = 0;
    }

    public void ajoutMaisons() {
        if (nbMaisons < 4) {
            this.proprietaire.setArgent(-(prixMaison));
        } else if (nbMaisons == 5) {
            this.proprietaire.setArgent(-(prixMaison * 4));
        }
    }

    @Override
    public boolean isTerrain() {
        return true;
    }

}

class Utilitaires extends Proprietes {

    public Utilitaires(String nom, int groupe, int prixAchat) {
        super(nom, groupe, prixAchat);
    }

    @Override
    public boolean isTerrain() {
        return false;
    }

}
