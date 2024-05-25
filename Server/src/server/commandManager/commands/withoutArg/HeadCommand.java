package server.commandManager.commands.withoutArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Scanner;

public class HeadCommand implements Command {
    @Override
    public String execute(Dragon dragon) {
        Dragon temp = Server.collectionManager.head();
        if(temp != null){
        return temp.toString();
        }
        else return "Коллекция пуста";
    }
}
