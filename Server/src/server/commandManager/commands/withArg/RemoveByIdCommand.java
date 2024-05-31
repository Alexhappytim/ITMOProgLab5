package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArgument {

    @Override
    public String execute(String arg, Dragon dragon) {
        try{
            Long id = Long.parseLong(arg);
            if(Server.collectionManager.removeById(id)){
                return "Элемент удален";
            }
        }catch (Exception e){

        }
        return "Элемент не найден";

    }
}
