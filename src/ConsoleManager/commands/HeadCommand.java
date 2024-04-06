package ConsoleManager.commands;

import execution.ExecutionManager;

public class HeadCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.consoleManager.println(ExecutionManager.collectionManager.head().toString());
    }
}
