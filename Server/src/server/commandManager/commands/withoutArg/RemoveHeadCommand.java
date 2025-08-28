package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import common.network.Response;
import server.Server;

import java.sql.ResultSet;

public class RemoveHeadCommand implements Command {

    @Override
    public Response execute(Dragon dragon, Integer userId) {
        ResultSet res = Server.dbConnection.executeGetReq("delete from dragons where author_id =" +userId+ "and id = (select min(id) from dragons where author_id=" +userId+ ")");


        Dragon temp = Server.collectionManager.removeHead(userId);
        if(temp != null){
            return new Response(temp.toString(),Response.OK);
        }
        else return new Response("Коллекция пуста",Response.EMPTYCOLLECTION);
    }
}
