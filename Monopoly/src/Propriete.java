/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BernierCorentin
 */
public abstract class Propriete {

    protected final String nom;
    protected final int groupe;
    protected final int totalGroupe;
    protected final int prixAchat;
    protected Joueur proprietaire;

    public Propriete(String nom, int groupe, int totalGroupe, int prixAchat) {
        this.nom = nom;
        this.groupe = groupe;
        this.totalGroupe = totalGroupe;
        this.prixAchat = prixAchat;
        this.proprietaire = null;
    }

    public Joueur getProprietaire() {
        return proprietaire;
    }

    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }

    public String getNom() {
        return nom;
    }

    public int getGroupe() {
        return groupe;
    }

    public int getTotalGroupe() {
        return totalGroupe;
    }

    public int aNbDuGroupe() {
        int nbDuGroupe = 0;
        for (Propriete unePropriete : proprietaire.getSesProprietes()) {
            if (unePropriete.getGroupe() == this.groupe) {
                nbDuGroupe++;
            }
        }
        return nbDuGroupe;
    }

    public int getPrixAchat() {
        return prixAchat;
    }

    public abstract boolean isTerrain();

    public abstract int prixPassage(int resDe);

}

class Terrain extends Propriete {

    private final int prixMaison;

    private int nbMaisons;

    public Terrain(String nom, int groupe, int totalGroupe, int prixAchat, int prixMaison) {
        super(nom, groupe, totalGroupe, prixAchat);

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

    public int getNbMaisons() {
        return nbMaisons;
    }

    public int getPrixMaison() {
        return prixMaison;
    }

    @Override
    public boolean isTerrain() {
        return true;
    }

    @Override
    public int prixPassage(int resDe) {
        switch (nbMaisons) {
            case 0:
                if (this.totalGroupe == this.aNbDuGroupe()) {
                    return prixAchat / 5;
                } else {
                    return prixAchat / 10;
                }
            case 1:
                return prixAchat / 2;
            case 2:
                return prixAchat * 3 / 2;
            case 3:
                return prixAchat * 4;
            case 4:
                return prixAchat * 5;
            case 5:
                return prixAchat * 7;
            default:
                return 0;
        }
    }

}

class Gare extends Propriete {

    public Gare(String nom, int groupe, int totalGroupe, int prixAchat) {
        super(nom, groupe, totalGroupe, prixAchat);
    }

    @Override
    public boolean isTerrain() {
        return false;
    }

    @Override
    public int prixPassage(int resDe) {
        return this.aNbDuGroupe() * 50;
    }

}

class Utilitaire extends Propriete {

    public Utilitaire(String nom, int groupe, int totalGroupe, int prixAchat) {
        super(nom, groupe, totalGroupe, prixAchat);
    }

    @Override
    public boolean isTerrain() {
        return false;
    }

    @Override
    public int prixPassage(int resDe) {
        if (this.aNbDuGroupe() == 2) {
            return resDe * 10;
        }
        return resDe * 4;
    }

}
