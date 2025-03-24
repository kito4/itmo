package com.kito.server;



import com.kito.server.csv_parser.CSVReader;
import com.kito.server.user_command_line.CommandListener;
import com.kito.server.utils.TextSender;

import java.io.FileNotFoundException;
import java.io.InputStream;

public class Application {

    CSVReader collectionFileReader;
    CommandListener commandListener;

    public Application(InputStream dis) {
        collectionFileReader = new CSVReader();
        commandListener = new CommandListener(dis);
    }

    public void launchApplication() {
        try {
            collectionFileReader.initializeFile(Config.getFilePath());
            collectionFileReader.parseFile();
            Config.getCollectionManager().fillWithArray(collectionFileReader.getInfoFromFile());
            commandListener.readCommands();
        } catch (FileNotFoundException e) {
            TextSender.printError("Файл: " + Config.getFilePath() + " не найден");
        } catch (NullPointerException e) {
            TextSender.printError("Пожалуйста проинциализируйте системную переменную HUMAN_INFO, " +
                    "содержащую путь до файла с информацией о коллекции");
        }
    }
}