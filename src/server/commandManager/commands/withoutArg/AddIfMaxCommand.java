package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class AddIfMaxCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        if(Server.collectionManager.addIfMax(dragon)){
            return "Элемент успешно добавлен";
        }else{
            return "Элемент не добавлен";
        }

    }


}
