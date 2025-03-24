package kito.lab5.server.user_command_line.Commands;

import kito.lab5.server.Server;
import kito.lab5.server.abstractions.AbstractCommand;
import kito.lab5.server.user_command_line.ErrorMessage;
import kito.lab5.server.user_command_line.SuccessMessage;
import kito.lab5.server.utils.TextSender;

public class Account extends AbstractCommand {

    public Account() {
        super("account", "Создать логин и пароль", 0); // потому что +2 в super()
    }

    @Override
    public Object execute(String[] args, TextSender sender) {
        if (args.length == getAMOUNT_OF_ARGS()) {
            try {

                Server.pgManager.doCommand("INSERT INTO users VALUES ('" + args[1] + "','" + args[2] + ");");


//                HumanInfoInput humanInfoInput = new HumanInfoInput(args);
//                humanInfoInput.inputHuman();

//                sender.sendObjectNeeded(args);


//                Config.getCollectionManager().addHuman(humanInfoInput.getNewHumanToInput());
                return new SuccessMessage("Новый пользователь успешно зарегестрирован!");
            } catch (IllegalArgumentException e) {
                return new ErrorMessage(e.getMessage());
            }
        } else {
            return new ErrorMessage("Передано неправильное количество аргументов");
        }
    }

}
