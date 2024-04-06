package ConsoleManager.commands;

import execution.ExecutionManager;

public class ExitCommand implements Command{
    @Override
    public void execute() {
        ExecutionManager.isRunning=false;
    }
}
