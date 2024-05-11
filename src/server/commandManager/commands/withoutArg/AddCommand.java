package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        Server.collectionManager.add(dragon);
        return "Элемент успешно добавлен";
    }


}
