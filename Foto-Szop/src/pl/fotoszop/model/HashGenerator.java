package pl.fotoszop.model;


import org.slf4j.Logger;import org.slf4j.LoggerFactory;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class HashGenerator {
    private static final Logger logger = LoggerFactory.getLogger(HashGenerator.class.getName());
    private HashGenerator() {

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
            logger.error("There is no supported hash algorithm: " + ex.getMessage());
        }

        return wynik;

    }

}