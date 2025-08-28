package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;

public interface Command {
    Response execute(Dragon dragon, Integer userId);

}
