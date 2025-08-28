package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

import java.util.concurrent.locks.ReentrantLock;

public class ClearCommand implements Command {
    @Override
    public Response execute(Dragon dragon, Integer userId) {
        Server.dbConnection.executeGetReq("DELETE FROM dragons where dragons.author_id = "+userId);

        Server.collectionManager.clear(userId);
        return new Response("Коллекция очищена",Response.OK);
    }

}
