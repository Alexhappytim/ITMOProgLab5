package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.sql.ResultSet;

public class RemoveHeadCommand implements Command {

    @Override
    public String execute(Dragon dragon, Integer userId) {
        ResultSet res = Server.dbConnection.executeGetReq("delete from dragons where author_id =" +userId+ "and id = (select min(id) from dragons where author_id=" +userId+ ")");


        Dragon temp = Server.collectionManager.removeHead(userId);
        if(temp != null){
            return temp.toString();
        }
        else return "Коллекция пуста";
    }
}
