package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class ExitCommand implements Command {

    @Override
    public String execute(Dragon dragon) {
        return "Иш че удумали!";
    }
}
