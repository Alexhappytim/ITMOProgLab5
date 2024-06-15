package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

public class InfoCommand implements Command {
    @Override
    public String execute(Dragon dragon, Integer userId) {
        return Server.collectionManager.info();
    }
}
