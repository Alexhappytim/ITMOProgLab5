package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import common.network.Response;

public interface CommandWithArgument {
    Response execute(String arg, Dragon dragon, Integer userId);
}
