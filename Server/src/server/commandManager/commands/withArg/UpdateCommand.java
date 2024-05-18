package server.commandManager.commands.withArg;

import common.dragon.Dragon;
import server.Server;

import java.util.Iterator;
import java.util.Scanner;

public class UpdateCommand implements CommandWithArgument {


    @Override
    public String execute(String arg, Dragon dragon) {
        try{
            Long a = Long.parseLong(arg);
            Iterator<Dragon> iter = Server.collectionManager.getCollection().iterator();
            Dragon temp = null;
            while(iter.hasNext()) {
                temp = iter.next();
                if (temp.getId().equals(a)) {
                    Server.collectionManager.updateById(a,dragon);
                    return "Элемент обновлен";
                }
            }
            return "Нет такого id";
        }catch(Exception e){
            return "";
        }
    }
}
