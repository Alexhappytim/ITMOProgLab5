package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import execution.ExecutionManager;

import java.util.Scanner;

public class FilterContainsName implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterContainsName(arg));
    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
