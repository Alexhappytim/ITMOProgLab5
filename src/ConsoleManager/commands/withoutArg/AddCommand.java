package ConsoleManager.commands.withoutArg;

import dragon.Dragon;
import execution.ExecutionManager;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.collectionManager.add(ExecutionManager.consoleManager.inputNewElement());
    }

    @Override
    public void executeFromScript(Scanner scanner) {
        Dragon dragon = ExecutionManager.commandManager.inputNewElementFromFile(scanner);
        if(dragon!=null){
            ExecutionManager.collectionManager.add(dragon);
        }
    }
}
