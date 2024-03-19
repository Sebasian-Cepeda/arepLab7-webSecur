package com.websecure;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.post;
import static spark.Spark.secure;
import static spark.Spark.staticFiles;

/**
 * 
 *
 * @author Juan Cepeda
 */
public class Main {
    public static void main(String[] args) {
        secure("certificados/ecikeystore.p12", "123456", null, null);
        port(getPort());
        staticFiles.location("/public");
        get("/hello", (req, res) -> "Hello World");

        post("/login", (req, res) -> {
            String user = req.queryParams("user"), psw = req.queryParams("psw");
            return SecureURLReader.secureURLRead(user, psw);
        });

    }

    /**
     * Retrieves the port from the environment variable or uses the default port
     * 5000.
     *
     * @return the port to use
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000;
    }

}