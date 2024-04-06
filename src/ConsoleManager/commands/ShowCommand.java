package ConsoleManager.commands;

import execution.ExecutionManager;

public class ShowCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.getCollection());
    }
}
