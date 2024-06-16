package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.io.IOException;

public class SaveCommand implements Command {
    @Override
    public String execute(Dragon dragon, Integer userId) {
        try {
            Server.dumpManager.saveToFile();
        } catch (IOException e) {

        }

        return "Иш что удумали!";
    }
}
