package ConsoleManager.commands;

import collectionManager.ValidateError;
import dragon.Color;
import execution.ExecutionManager;

public class FilterByColor implements CommandWithArgument{
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
}
