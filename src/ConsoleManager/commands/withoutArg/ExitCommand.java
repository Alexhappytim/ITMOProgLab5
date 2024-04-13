package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.withoutArg.Command;
import execution.ExecutionManager;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        ExecutionManager.isRunning=false;
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
