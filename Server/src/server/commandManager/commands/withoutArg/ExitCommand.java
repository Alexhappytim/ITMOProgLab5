package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

public class ExitCommand implements Command {



    @Override
    public Response execute(Dragon dragon, Integer userId) {
        Server.isRunning=false;
        return new Response("",Response.OK);
    }
}
