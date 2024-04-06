package ConsoleManager.commands;

import execution.ExecutionManager;

public class ClearCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.collectionManager.clear();
    }
}
