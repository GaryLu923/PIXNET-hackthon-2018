package org.gary;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;



public class Application {
    public static void main(String[] args) {
        setServer();
        get("/hello", (request, response) -> "Hello world");

        internalServerError((request, response) -> {
            response.type("application/json");
            Map<String,String > result=new HashMap<>();
            result.put("message","Custom 500 handling");
            return result;
        });


    }

    private static void setServer(){
        port(9090);
        staticFiles.location("/public");

    }

}
