package com.websecure;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap; // import the HashMap class

public class hashSha {

    HashMap<String, String> datos = new HashMap<String, String>();

    public String hashSha256(String password) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(password.getBytes(StandardCharsets.UTF_8));
            String sha256 = DatatypeConverter.printHexBinary(digest).toLowerCase();

            // imprimir resumen de mensaje SHA-256
            System.out.println("HashCode: "+sha256);
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }

}
