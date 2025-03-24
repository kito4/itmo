package com.kito.client;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;


import java.nio.channels.SocketChannel;
import java.util.Scanner;


public final class Client {
    private Client() {
        throw new UnsupportedOperationException("This is an utility class and can not be instantiated");
    }

    public static void main(String[] args) {
        try {

            boolean exit = false;
            SocketChannel sock = SocketChannel.open(new InetSocketAddress("localhost", 4550));
            ByteBuffer buffer = ByteBuffer.allocate(65536);
            Scanner scanner = new Scanner(System.in);

            //создать объект с командой и аргументами , преобразовать объект в bytebuffer end
            sock.read(buffer);

            String msg ="exit" ;

            System.out.println(new String(buffer.array()));
            while (true) {
                if (msg == scanner.nextLine()) {
                    break;
                }
                buffer = ByteBuffer.wrap(scanner.nextLine().getBytes());
                sock.write(buffer);
                buffer.clear();
                sock.read(buffer);
                System.out.println(new String(buffer.array()));

            }


//            Socket sock= new Socket("localhost",4234);
//            OutputStream os = sock.getOutputStream();
//            DataOutputStream out=new DataOutputStream(os);
//            DataInputStream is = new DataInputStream(sock.getInputStream());
//            Scanner scanner = new Scanner(System.in);
//            System.out.println(is.readUTF());
//            while(true) {
//
//                out.writeUTF(scanner.nextLine());
//                System.out.println(is.readUTF());
//                // TODO: условие exit
//            }
//
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    finally {
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}