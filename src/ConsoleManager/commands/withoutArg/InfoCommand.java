package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.withoutArg.Command;
import execution.ExecutionManager;

import java.util.Scanner;

public class InfoCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.consoleManager.println(ExecutionManager.collectionManager.info());
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
