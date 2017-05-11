package pl.fotoszop.model;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class HashGenerator {
	
	private HashGenerator(){
		
	}

    public static String doHash(String haslo) {

        String wynik = " ";
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(haslo.getBytes());

            byte tablicaBajtow[] = md.digest();
            StringBuilder hasz = new StringBuilder();

            for (int i = 0; i < tablicaBajtow.length; i++) {
                hasz.append(Integer.toString((tablicaBajtow[i] & 0xff) + 0x100, 16).substring(1));
            }
            wynik = hasz.toString();

        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(HashGenerator.class.getName()).log(Level.SEVERE, null, ex);
        }

        return wynik;

    }

}