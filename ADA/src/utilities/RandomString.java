package utilities;

import java.util.Random;

/**
 *
 * @author Carlos Torres
 */
public class RandomString {
    public static String getRandomString (int tam){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String randomString = "";
        
        Random rand = new Random();
        
        char text[] = new char[tam];
        
        for(int i=0 ; i<tam ; i++){
            text[i] = characters.charAt(rand.nextInt(characters.length()));
        }
        
        for(int i=0; i< text.length ; i++){
            randomString += text[i];
        }
        
        return randomString;
    }
}
