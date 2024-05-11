package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArgument {

    @Override
    public String execute(String arg, Dragon dragon) {
        try{
            Long id = Long.parseLong(arg);
            Server.collectionManager.removeById(id);
        }catch (Exception e){

        }
        return "Элемент удален";
    }
}
