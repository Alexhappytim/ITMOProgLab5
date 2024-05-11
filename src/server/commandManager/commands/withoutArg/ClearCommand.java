package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class ClearCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        Server.collectionManager.clear();
        return "Коллекция очищена";
    }

}
