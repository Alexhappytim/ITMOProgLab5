package ConsoleManager.commands;

import execution.ExecutionManager;

public class RemoveHeadCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.consoleManager.println(ExecutionManager.collectionManager.removeHead().toString());
    }
}
