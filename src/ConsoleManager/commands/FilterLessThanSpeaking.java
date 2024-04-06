package ConsoleManager.commands;

import execution.ExecutionManager;

public class FilterLessThanSpeaking implements CommandWithArgument{
    @Override
    public void execute(String arg) {
        switch(arg){
            case "true"->{ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterLessThanSpeaking(true));}
            case "false"->{ExecutionManager.consoleManager.printCollection(ExecutionManager.collectionManager.filterLessThanSpeaking(false));}
            default -> {ExecutionManager.consoleManager.println("Неверный аргумент");}
        }

    }
}
