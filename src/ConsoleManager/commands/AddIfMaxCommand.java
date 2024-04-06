package ConsoleManager.commands;

import dragon.Dragon;
import execution.ExecutionManager;

public class AddIfMaxCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.collectionManager.addIfMax(ExecutionManager.consoleManager.inputNewElement());
    }
}
