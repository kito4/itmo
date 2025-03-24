package com.kito.server.user_command_line.Commands;


import com.kito.server.Config;
import com.kito.server.abstractions.AbstractCommand;
import com.kito.server.user_command_line.ErrorMessage;
import com.kito.server.user_command_line.SuccessMessage;

public class Clear extends AbstractCommand {

    public Clear() {
        super("clear", "Очистить коллекцию", 0);
    }

    @Override
    public Object execute(String[] args) {
        if (args.length == getAMOUNT_OF_ARGS()) {
            Config.getCollectionManager().clearCollection();
            return new SuccessMessage("Коллекция успешно очищена");
        } else {
            return new ErrorMessage("Передано неверное количество аргументов");
        }
    }
}
