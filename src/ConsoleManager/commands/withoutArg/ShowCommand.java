package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.withoutArg.Command;
import execution.ExecutionManager;

import java.util.Scanner;

public class ShowCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.getCollection());
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
