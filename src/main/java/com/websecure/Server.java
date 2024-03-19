package com.websecure;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.secure;
import static spark.Spark.staticFiles;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class Server {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) throws NoSuchAlgorithmException {

        users.put("admin", HashAutentication.hashSha256("admin"));

        secure("certificados/ecikeystore.p12", "123456", null, null);
        port(getPort());

        get("/login", (req, res) -> {
            String user = req.queryParams("user");
            String psw = req.queryParams("psw");

            if (!users.containsKey(user)) {
                return "El Usuario No Existe";
            }

            if (HashAutentication.validatePsw(psw, users.get(user))) {

                return "acceso permitido";
            } else {
                return "password incorrecta";
            }

        });

    }

    /**
     * Retrieves the port from the environment variable or uses the default port
     * 4567.
     *
     * @return the port to use
     */
    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

}
