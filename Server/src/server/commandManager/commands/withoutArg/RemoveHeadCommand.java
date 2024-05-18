package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class RemoveHeadCommand implements Command {

    @Override
    public String execute(Dragon dragon) {
        return Server.collectionManager.removeHead().toString();
    }
}
