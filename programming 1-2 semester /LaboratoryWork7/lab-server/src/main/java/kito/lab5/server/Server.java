package kito.lab5.server;

import kito.lab5.server.csv_parser.CSVReader;

import java.io.*;
import java.net.ServerSocket;

public final class Server {


    public static CSVReader collectionFileReader;
    public static PgManager pgManager;

    public static void main(String[] args) {
        Server server = new Server();
//        TextSender.changePrintStream(server.objectOutputStream);      // removed 1609
//        Application application = new Application(server.is);            // TODO 0709 REPLACED  .objectInputStream);
//        System.out.println(System.getenv("HUMAN_INFO"));
//        application.launchApplication();
    }
    public Server(){
        collectionFileReader = new CSVReader();
        pgManager = new PgManager();
        setUpConnection();
    }
    public void setUpConnection(){
        ServerSocket ss=null;
        try {

//            collectionFileReader.initializeFile("humans.csv");               // TODO 0709 Config.getFilePath());
            collectionFileReader.parseFile();
            Config.getCollectionManager().fillWithArray(collectionFileReader.getHumanArray());

            ss = new ServerSocket(4515);
//            Socket s= ss.accept();


            while (true) {
                new ConnectionManager(ss.accept(), collectionFileReader);
            }

//            TextSender.os = os;     // TODO 0709 added



        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файл: " + Config.getFilePath() + " не найден");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (NullPointerException e) {
            e.printStackTrace();
            System.out.println("Пожалуйста проинциализируйте системную переменную HUMAN_INFO, " +
                    "содержащую путь до файла с информацией о коллекции");
        } finally {
            try {
                if (ss != null) {
                    ss.close();
                }
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }
}
