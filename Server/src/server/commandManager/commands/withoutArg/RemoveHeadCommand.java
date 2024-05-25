package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class RemoveHeadCommand implements Command {

    @Override
    public String execute(Dragon dragon) {
        Dragon temp = Server.collectionManager.removeHead();
        if(temp != null){
            return temp.toString();
        }
        else return "Коллекция пуста";
    }
}
