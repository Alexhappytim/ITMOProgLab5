package ConsoleManager.commands;

import execution.ExecutionManager;

public class RemoveByIdCommand implements CommandWithArgument{
    @Override
    public void execute(String arg) {
        try{
            Long id = Long.parseLong(arg);
            ExecutionManager.collectionManager.removeById(id);
        }catch (Exception e){ExecutionManager.consoleManager.println("Неправильный аргумент");}

    }
}
