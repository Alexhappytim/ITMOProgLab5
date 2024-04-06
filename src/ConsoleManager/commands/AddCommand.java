package ConsoleManager.commands;

import execution.ExecutionManager;

public class AddCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.collectionManager.add(ExecutionManager.consoleManager.inputNewElement());

    }
}
