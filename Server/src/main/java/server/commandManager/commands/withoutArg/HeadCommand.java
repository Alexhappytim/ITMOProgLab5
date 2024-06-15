package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.sql.ResultSet;

public class HeadCommand implements Command {
    @Override
    public String execute(Dragon dragon, Integer userId) {
        Dragon temp = Server.collectionManager.head();
        if(temp != null){
        return temp.toString();
        }
        else return "Коллекция пуста";
    }
}
