package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

public class InfoCommand implements Command {
    @Override
    public Response execute(Dragon dragon, Integer userId) {
        return new Response(Server.collectionManager.info(),Response.OK);
    }
}
