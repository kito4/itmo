package com.kito.server.user_command_line.Commands;


import com.kito.server.Config;
import com.kito.server.abstractions.AbstractCommand;
import com.kito.server.user_command_line.ErrorMessage;
import com.kito.server.user_command_line.SuccessMessage;

public class Info extends AbstractCommand {


    public Info() {
        super("info", "Вывести информацию о коллекции", 0);
    }

    @Override
    public Object execute(String[] args) {
        if (args.length == getAMOUNT_OF_ARGS()) {
            return new SuccessMessage(Config.getCollectionManager().getInfoAboutCollection());
        } else {
            return new ErrorMessage("Передано неправильное количество аргументов");
        }
    }
}
