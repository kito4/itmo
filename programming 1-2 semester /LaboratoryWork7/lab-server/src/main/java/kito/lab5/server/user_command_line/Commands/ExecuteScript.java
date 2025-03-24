package kito.lab5.server.user_command_line.Commands;

import kito.lab5.server.Server;
import kito.lab5.server.abstractions.AbstractCommand;
import kito.lab5.server.annotations.Command;
import kito.lab5.server.user_command_line.CommandListener;
import kito.lab5.server.user_command_line.CommandManager;
import kito.lab5.server.user_command_line.ErrorMessage;
import kito.lab5.server.user_command_line.SuccessMessage;
import kito.lab5.server.utils.TextSender;

import java.io.*;

public class ExecuteScript extends AbstractCommand {

    CommandListener commandListener;

    public ExecuteScript() {
        super("execute_script", "Выполнить скрипт из файла, принимает на вход один аргумент [file_path]",1);
    }

    @Override
    public Object execute(String[] args, TextSender sender) {
        if (args.length == getAMOUNT_OF_ARGS()) {
            String fileName = args[0];
            try {
                commandListener = new CommandListener((ObjectInputStream) initializeFile(fileName), new TextSender(new ByteArrayOutputStream(1024)));
            } catch (IOException e) {
                return e.getMessage();
            }
            commandListener.readCommands(Server.collectionFileReader);
            return new SuccessMessage("Скрипт завершил свою работу");
        } else {
            return new ErrorMessage("Передано неверное количество аргументов");
        }
    }

    private InputStream initializeFile(String fileName) throws FileNotFoundException {
        return new FileInputStream(fileName);
    }
}