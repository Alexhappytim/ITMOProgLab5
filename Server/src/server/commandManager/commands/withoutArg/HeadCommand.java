package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

public class HeadCommand implements Command {
    @Override
    public Response execute(Dragon dragon, Integer userId) {
        Dragon temp = Server.collectionManager.head();
        if(temp != null){
        return new Response(temp.toString(),Response.OK);
        }
        else return new Response("Коллекция пуста",Response.EMPTYCOLLECTION);
    }
}
