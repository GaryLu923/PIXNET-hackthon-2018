package org.gary;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketClient {
    private final String host="";
    private final int port=6000;
    public void createSocket(){
        try{
            Socket socket=new Socket(host,port);
            InputStream inputStream=socket.getInputStream();
            OutputStream outputStream=socket.getOutputStream();
        }catch(IOException e){
            System.out.println(e.getCause());
            System.out.println(e.getMessage());
        }
    }
}
