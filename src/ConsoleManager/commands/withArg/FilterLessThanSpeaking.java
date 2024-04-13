package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import execution.ExecutionManager;

import java.util.Scanner;

public class FilterLessThanSpeaking implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        switch(arg){
            case "true"->{ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterLessThanSpeaking(true));}
            case "false"->{ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterLessThanSpeaking(false));}
            default -> {ExecutionManager.consoleManager.println("Неверный аргумент");}
        }
    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
