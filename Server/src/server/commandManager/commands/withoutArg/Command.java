package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;

public interface Command {
    String execute(Dragon dragon, Integer userId);

}
