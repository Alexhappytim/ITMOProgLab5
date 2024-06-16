package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

public class ExitCommand implements Command {



    @Override
    public String execute(Dragon dragon, Integer userId) {
        Server.isRunning=false;
        return "Иш че удумали!";
    }
}
