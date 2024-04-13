package ConsoleManager.commands.withoutArg;

import execution.ExecutionManager;

import java.util.Scanner;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.collectionManager.clear();
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
