package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import execution.ExecutionManager;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        try{
            Long id = Long.parseLong(arg);
            ExecutionManager.collectionManager.removeById(id);
        }catch (Exception e){ExecutionManager.consoleManager.println("Неправильный аргумент");}

    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
