package ConsoleManager.commands;

import dragon.Dragon;
import execution.ExecutionManager;

import java.util.Iterator;

public class UpdateCommand implements CommandWithArgument{
    @Override
    public void execute(String arg) {
        try{
            Long a = Long.parseLong(arg);
            Iterator<Dragon> iter = ExecutionManager.collectionManager.getCollection().iterator();
            Dragon temp = null;
            while(iter.hasNext()) {
                temp = iter.next();
                if (temp.getId().equals(a)) {
                    ExecutionManager.collectionManager.updateById(a,ExecutionManager.consoleManager.inputNewElement());
                    return;
                }
            }
            ExecutionManager.consoleManager.println("Нет такого id");
        }catch(Exception e){
            ExecutionManager.consoleManager.println("Неправильный id");
            return;
        }






    }
}
