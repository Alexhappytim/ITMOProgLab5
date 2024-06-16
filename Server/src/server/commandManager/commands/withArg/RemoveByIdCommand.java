package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import server.Server;

public class RemoveByIdCommand implements CommandWithArgument {

    @Override
    public String execute(String arg, Dragon dragon, Integer userId) {

        try{
            Long id = Long.parseLong(arg);
            Server.dbConnection.executeGetReq("DELETE FROM dragons where dragons.author_id = "+userId+" and dragons.id="+id);

            if(Server.collectionManager.removeById(id, userId)){
                return "Элемент удален";
            }
        }catch (Exception e){

        }
        return "Элемент не найден";

    }
}
