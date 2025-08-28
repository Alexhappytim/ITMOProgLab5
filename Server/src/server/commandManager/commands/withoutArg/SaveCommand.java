package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

import java.io.IOException;

public class SaveCommand implements Command {
    @Override
    public Response execute(Dragon dragon, Integer userId) {
        try {
            Server.dumpManager.saveToFile();
        } catch (IOException e) {

        }

        return new Response("",Response.OK);
    }
}
