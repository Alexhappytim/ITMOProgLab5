package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import dragon.Dragon;
import execution.ExecutionManager;

import java.util.Iterator;
import java.util.Scanner;

public class UpdateCommand implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        try{
            Long a = Long.parseLong(arg);
            Iterator<Dragon> iter = ExecutionManager.collectionManager.getCollection().iterator();
            Dragon temp = null;
            while(iter.hasNext()) {
                temp = iter.next();
                if (temp.getId().equals(a)) {
                    ExecutionManager.collectionManager.updateById(a,ExecutionManager.consoleManager.inputNewElement(),false);
                    return;
                }
            }
            ExecutionManager.consoleManager.println("Нет такого id");
        }catch(Exception e){
            ExecutionManager.consoleManager.println("Неправильный id");
            return;
        }
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        try{
            Long a = Long.parseLong(arg);
            Iterator<Dragon> iter = ExecutionManager.collectionManager.getCollection().iterator();
            Dragon temp = null;
            while(iter.hasNext()) {
                temp = iter.next();
                if (temp.getId().equals(a)) {
                    Dragon inputDragon = ExecutionManager.commandManager.inputNewElementFromFile(scanner);
                    if(inputDragon != null){
                        ExecutionManager.collectionManager.updateById(a,inputDragon,false);
                    }
                    return;
                }
            }
            ExecutionManager.consoleManager.println("Нет такого id");
        }catch(Exception e){
            ExecutionManager.consoleManager.println("Неправильный id");
        }
    }
}
