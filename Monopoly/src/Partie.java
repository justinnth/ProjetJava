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

        String[] prop = {"BOULEVARD DE BELLEVILLE", "RUE LECOURBE", "RUE DE VAUGIRARD", "RUE DE COURCELLES", "AVENUE DE LA REPUBLIQUE", "BOULEVARD DE LA VILETTE", "AVENUE DE NEUILLY", "RUE DE PARADIS", "AVENUE MOZART", "BOULEVARD SAINT-MICHEL", "PLACE PIGALLE", "AVENUE MATIGNON", "BOULEVARD MALESGERBES", "AVENUE HERIN-MARTIN", "FAUBOURG SAINT HONORE", "PLACE DE LA BOURSE", "RUE LA FAYETTE", "AVENUE DE BRETEUIL", "AVENUE FOCH", "BOULEVARD DES CAPUCINES", "AVENUE DES CHAMPS-ELYSEES", "RUE DE LA PAIX", "GARE DE MONTPARNASSE", "GARE DE LYON", "GARE DU NORD", "GARE DE SAINT-LAZARE", "COMPAGNIE DE DISTRIBUTION D'ELECTRICITE", "COMPAGNIE DE DISTRIBUTION DES EAUX"};
        int propPrix[] = {60, 60, 100, 100, 120, 140, 140, 160, 180, 180, 200, 220, 220, 240, 260, 260, 280, 300, 300, 320, 350, 400, 200, 200, 200, 200, 150, 150};
        for (int i = 0; i < prop.length; i++) {
            if (i < 22) {
                propNonVendue.add(new Terrains(prop[i], (i + 1) / 3, propPrix[i], ((i + 1) / 6 + 1) * 50));
            } else if (i >= 22 && i < 26) {
                propNonVendue.add(new Utilitaires(prop[i], 8, propPrix[i]));
            } else {
                propNonVendue.add(new Utilitaires(prop[i], 9, propPrix[i]));
            }
            System.out.println(i+" "+prop[i]);
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
        lePlateau[21] = new CaseProprietes(propNonVendue.get(11));;
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

    }

}
