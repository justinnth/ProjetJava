/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;

/**
 *
 * @author BernierCorentin
 */
public class Partie {

    private ArrayList<Joueur> lesJoueurs;
    private ArrayList<Proprietes> propNonVendue;

    private int argentCentre;
    private Case[] lePlateau;

    public Partie(int nbHumain, int nbAI) {
        lesJoueurs = new ArrayList();
        propNonVendue = new ArrayList();

        int couleurs[][] = {{255, 0, 0}, {0, 0, 255}, {0, 255, 0}, {255, 255, 0}, {255, 128, 0}, {128, 0, 128}, {86, 86, 86}, {172, 172, 172}};
        for (int i = 0; i < nbHumain; i++) {
            lesJoueurs.add(new JoueurHumain(couleurs[i], "JH"));
        }
        for (int i = 0; i < nbAI; i++) {
            lesJoueurs.add(new JoueurIA(couleurs[i + nbHumain], "Bot" + i));
        }

        String[] propTerr = {"BOULEVARD DE BELLEVILLE", "RUE LECOURBE", "RUE DE VAUGIRARD", "RUE DE COURCELLES", "AVENUE DE LA REPUBLIQUE", "BOULEVARD DE LA VILETTE", "AVENUE DE NEUILLY", "RUE DE PARADIS", "AVENUE MOZART", "BOULEVARD SAINT-MICHEL", "PLACE PIGALLE", "AVENUE MATIGNON", "BOULEVARD MALESGERBES", "AVENUE HERIN-MARTIN", "FAUBOURG SAINT HONORE", "PLACE DE LA BOURSE", "RUE LA FAYETTE", "AVENUE DE BRETEUIL", "AVENUE FOCH", "BOULEVARD DES CAPUCINES", "AVENUE DES CHAMPS-ELYSEES", "RUE DE LA PAIX", "GARE DE MONTPARNASSE", "GARE DE LYON", "GARE DU NORD", "GARE DE SAINT-LAZARE", "COMPAGNIE DE DISTRIBUTION D'ELECTRICITE", "COMPAGNIE DE DISTRIBUTION DES EAUX"};
        int propPrix[] = {60, 60, 100, 100, 120, 140, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 280, 300, 300, 320, 350, 400, 200, 200, 200, 200, 150, 150};
        for (int i = 0; i < propTerr.length; i++) {
            if (i < 22) {
                propNonVendue.add(new Terrains(propTerr[i], (i + 1) / 3, propPrix[i], ((i + 1) / 6 + 1) * 50));
            } else if (i >= 22 && i < 26) {
                propNonVendue.add(new Utilitaires(propTerr[i], 8, propPrix[i]));
            } else {
                propNonVendue.add(new Utilitaires(propTerr[i], 9, propPrix[i]));
            }
        }

        lePlateau = new Case[40];
        lePlateau[0] = new CaseDepart();

        lePlateau[2] = new CaseCaisseCommunautaires();
        lePlateau[10] = new CasePrison();

        lePlateau[20] = new CaseParcGratuit();

        lePlateau[30] = new CaseAllezEnPrison();

    }

}
