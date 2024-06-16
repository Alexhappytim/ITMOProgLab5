package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

public class ClearCommand implements Command {
    @Override
    public String execute(Dragon dragon, Integer userId) {
        Server.dbConnection.executeGetReq("DELETE FROM dragons where dragons.author_id = "+userId);

        Server.collectionManager.clear(userId);
        return "Коллекция очищена";
    }

}
