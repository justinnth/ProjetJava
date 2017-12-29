/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JeuCartes;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author BernierCorentin
 */
public class Carte {

    private String strCouleur;
    private int intCouleur;
    private int nombre;

    public Carte(String strCouleur, int nombre) {
        this.strCouleur = strCouleur.toLowerCase();
        this.nombre = nombre;

        switch (strCouleur.toLowerCase()) {
            case "coeur":
                intCouleur = 0;
                break;
            case "carreau":
                intCouleur = 1;
                break;
            case "trefle":
                intCouleur = 2;
                break;
            case "pique":
                intCouleur = 3;
        }
    }

    public Carte(int intCouleur, int nombre) {
        this.intCouleur = intCouleur;
        this.nombre = nombre;

        switch (intCouleur) {
            case 0:
                strCouleur = "coeur";
                break;
            case 1:
                strCouleur = "carreau";
                break;
            case 2:
                strCouleur = "trefle";
                break;
            case 3:
                strCouleur = "pique";
                break;
        }
    }

    public Carte(String strCouleur, int intCouleur, int nombre) {
        this.strCouleur = strCouleur;
        this.intCouleur = intCouleur;
        this.nombre = nombre;
    }

    public int getNombre() {
        return nombre;
    }

    public int getIntCouleur() {
        return intCouleur;
    }

    public String getStrCouleur() {
        return strCouleur;
    }
    
    public BufferedImage getImage() throws IOException{
        return ImageIO.read(new File(getStrCouleur()+Integer.toString(getNombre())+".jpg"));
    }
}
