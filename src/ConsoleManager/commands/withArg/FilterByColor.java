package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import collectionManager.ValidateError;
import dragon.Color;
import execution.ExecutionManager;

import java.util.Scanner;

public class FilterByColor implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        Color color = null;

        switch (arg) {
            case "GREEN" -> {
                color = Color.GREEN;
            }
            case "BLACK" -> {
                color = Color.BLACK;
            }
            case "BLUE" -> {
                color = Color.BLUE;
            }
            case "ORANGE" -> {
                color = Color.ORANGE;
            }
            case "BROWN" -> {
                color = Color.BROWN;
            }
            default -> {
                ExecutionManager.consoleManager.printError(ValidateError.NOSUCHCOLOR);
                return;
            }}
        ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterByColor(color));
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
