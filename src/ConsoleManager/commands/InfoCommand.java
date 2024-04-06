package ConsoleManager.commands;

import execution.ExecutionManager;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.consoleManager.println(ExecutionManager.collectionManager.info());
    }
}
