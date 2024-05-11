package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class AddIfMaxCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        if(Server.collectionManager.addIfMax(new Dragon(dragon.getName(),
                dragon.getCoordinates(),
                dragon.getAge(),
                dragon.isSpeaking(),
                dragon.getColor(),
                dragon.getType(),
                dragon.getHead()))){
            return "Элемент успешно добавлен";
        }else{
            return "Элемент не добавлен";
        }

    }


}
