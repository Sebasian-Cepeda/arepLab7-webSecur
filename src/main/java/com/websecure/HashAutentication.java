package com.websecure;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashAutentication {

    public static boolean validatePsw(String psw, String correctPsw) {
        System.out.println(hashSha256(psw));
        return correctPsw.equals(hashSha256(psw));
    }

    public static String hashSha256(String password) {

        MessageDigest md;
        String sha256 = null;
        try {
            md = MessageDigest.getInstance("SHA3-256");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

            // imprimir resumen de mensaje SHA-256
            System.out.println("HashCode: " + sha256);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error en el hash -> " + sha256);
        }
        System.out.println("el hash es: " + sha256);
        return sha256;
    }

}
