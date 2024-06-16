package server.commandManager.commands.withArg;

import common.dragon.Dragon;

public interface CommandWithArgument {
    String execute(String arg, Dragon dragon, Integer userId);
}
