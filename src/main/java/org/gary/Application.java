package org.gary;


import org.gary.database.Sql2oDBAccess;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Application {

    public static void main(String[] args) {
        setServer();
        Sql2oDBAccess sql2oDBAccess = getDataDBAccess();

        get("/hello", (request, response) -> "Hello world");

        internalServerError((request, response) -> {
            response.type("application/json");
            Map<String, String> result = new HashMap<>();
            result.put("message", "Custom 500 handling");
            return result;
        });


    }

    private static void setServer() {
        port(9090);
        staticFiles.location("/public");

    }

    private static Sql2oDBAccess getDataDBAccess() {
        Sql2oDBAccess sql2oDBAccess = new Sql2oDBAccess();
        return sql2oDBAccess;
    }
}
