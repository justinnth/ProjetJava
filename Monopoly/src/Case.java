
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author BernierCorentin
 */
public abstract class Case {

    private final String nom;

    public Case(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public abstract boolean estAchetable();

    public abstract void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat);
}

class CaseProprietes extends Case {

    private Propriete laPropriete;

    public CaseProprietes(Propriete laPropriete) {
        super(laPropriete.getNom());
        this.laPropriete = laPropriete;
    }

    @Override
    public boolean estAchetable() {
        return true;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        if(laPropriete.getProprietaire() != null){
            int prixPassage = laPropriete.prixPassage(resDe);
            laPropriete.getProprietaire().setArgent(prixPassage);
            leJoueur.setArgent(-(prixPassage));
        }
    }

}

class CaseParcGratuit extends Case {

    private int quantiteArgent;

    public CaseParcGratuit() {
        super("Parc gratuit");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        leJoueur.setArgent(quantiteArgent);
        quantiteArgent = 0;
    }
    
    public void ajouterArgent(int quantite){
        quantiteArgent += quantite;
    }

}

class CaseAllezEnPrison extends Case {

    public CaseAllezEnPrison() {
        super("Allez en prison");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        leJoueur.setPositionPlateau(10);
        leJoueur.setEnPrison(3);
    }

}

class CasePrison extends Case {

    public CasePrison() {
        super("Prison");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
    }

}

class CaseChances extends Case {

    public CaseChances() {
        super("Carte chance");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        Random rand = new Random();
        int quantite = (1+rand.nextInt(9))*10;
        switch (rand.nextInt(2)){
            case 0:
                lePlat.popUp("Carte chance !", "Vous gagnez "+quantite+"$ !");
                leJoueur.setArgent(quantite);
                break;
            case 1:
                lePlat.popUp("Carte chance !", "Vous perdez "+quantite+"$ !");
                leJoueur.setArgent(-quantite);
                lePlat.ajouterArgentParcGratuit(quantite);
                break;
        }
    }

}

class CaseCaisseCommunautaires extends Case {

    public CaseCaisseCommunautaires() {
        super("Carte caisse communautaire");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        Random rand = new Random();
        int quantite = (1+rand.nextInt(9))*10;
        switch (rand.nextInt(2)){
            case 0:
                lePlat.popUp("Carte chance !", "Vous gagnez "+quantite+"$ !");
                leJoueur.setArgent(quantite);
                break;
            case 1:
                lePlat.popUp("Carte chance !", "Vous perdez "+quantite+"$ !");
                leJoueur.setArgent(-quantite);
                lePlat.ajouterArgentParcGratuit(quantite);
                break;
        }
    }

}

class CaseTaxes extends Case {

    private int prixTaxe;

    public CaseTaxes(String nom, int prixTaxe) {
        super(nom);
        this.prixTaxe = prixTaxe;
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        leJoueur.setArgent(-prixTaxe);
        lePlat.ecrireHisto(leJoueur.getNom()+" perds "+prixTaxe+"$ en arrivant sur la case "+this.getNom());
        lePlat.ajouterArgentParcGratuit(prixTaxe);
    }
}

class CaseDepart extends Case {

    public CaseDepart() {
        super("Départ");
    }

    @Override
    public boolean estAchetable() {
        return false;
    }

    @Override
    public void actionArrive(Joueur leJoueur, int resDe, Plateau lePlat) {
        leJoueur.setArgent(200);
        lePlat.ecrireHisto(leJoueur.getNom()+" gagne 400$ pour avoir fini son tour sur la case Départ!");
    }

}
