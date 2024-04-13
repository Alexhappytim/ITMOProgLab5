package ConsoleManager.commands.withoutArg;

import ConsoleManager.commands.withoutArg.Command;
import execution.ExecutionManager;

import java.io.IOException;
import java.util.Scanner;

public class SaveCommand implements Command {
    @Override
    public void execute() {
        try{
            ExecutionManager.dumpManager.saveToFile();
        } catch (IOException e) {
            ExecutionManager.consoleManager.println("Ошибка доступа");
        }
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
