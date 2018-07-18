package org.gary;
import static spark.Spark.*;



public class Application {
    public static void main(String[] args) {
        setServer();
        get("/hello", (request, response) -> "Hello world");

    }

    private static void setServer(){
        port(9090);

    }

}
