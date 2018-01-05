
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
public class De {

    public static int lancer() {
        Random rand = new Random();
        int res = 1 + rand.nextInt(6);
        return res;
    }
}
