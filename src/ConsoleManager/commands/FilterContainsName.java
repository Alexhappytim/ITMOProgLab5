package ConsoleManager.commands;

import execution.ExecutionManager;

public class FilterContainsName implements CommandWithArgument{
    @Override
    public void execute(String arg) {
        ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterContainsName(arg));
    }
}
