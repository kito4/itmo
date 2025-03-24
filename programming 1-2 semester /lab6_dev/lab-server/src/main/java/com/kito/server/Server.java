package com.kito.server;

import com.kito.server.utils.TextSender;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    InputStream inputStream;
    OutputStream outputStream;
    Socket s;

    public static void main(String[] args) {
        Server server = new Server();
        TextSender.changePrintStream(server.outputStream);
        Application application = new Application(server.inputStream);
        application.launchApplication();
    }

    public Server(){
        setUpConnection();
    }

    public void setUpConnection() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(4550);
            s = ss.accept(); //блокирующий
            inputStream = s.getInputStream();
            outputStream = s.getOutputStream();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }




}
