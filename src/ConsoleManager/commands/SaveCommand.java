package ConsoleManager.commands;

import execution.ExecutionManager;

import java.io.IOException;

public class SaveCommand implements Command{
    @Override
    public void execute() {
        try{
            ExecutionManager.dumpManager.saveToFile();
        } catch (IOException e) {
            ExecutionManager.consoleManager.println("Ошибка доступа");
        }
    }
}
