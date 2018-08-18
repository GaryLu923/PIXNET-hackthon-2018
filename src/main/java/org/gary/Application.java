package org.gary;


import org.gary.database.Sql2oDBAccess;

import java.io.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class Application {
//    private static final String path="/opt/hackthon/" ;
    private static final String path="/opt/pixnet/" ;
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
        writeFileToFolder();

    }
    private static void writeFileToFolder(){
        String speechtext="結果 先往市政府 再往北車 \n";
        String speechtext1="請到左手邊seven購買餐點 \n";
        LocalDateTime currentDateTime=LocalDateTime.now();
        File file=new File(path+ currentDateTime.getYear()
                +currentDateTime.getMonthValue()
                +currentDateTime.getDayOfMonth()
                +currentDateTime.getHour()
                +currentDateTime.getMinute()
                +".txt");
        if(!file.exists()){
            file.delete();
        }
        BufferedWriter bufferedWriter= null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.append(speechtext);
            bufferedWriter.append(speechtext1);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }





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
