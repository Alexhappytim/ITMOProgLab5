package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        Server.collectionManager.add(new Dragon(dragon.getName(),
                dragon.getCoordinates(),
                dragon.getAge(),
                dragon.isSpeaking(),
                dragon.getColor(),
                dragon.getType(),
                dragon.getHead()));
        return "Элемент успешно добавлен";
    }


}
