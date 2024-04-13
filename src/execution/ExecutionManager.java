package execution;

import ConsoleManager.ConsoleManager;
import ConsoleManager.CommandManager;
import collectionManager.CollectionManager;
import dumpManager.DumpManager;

public class ExecutionManager {
    public static ConsoleManager consoleManager;
    public static CollectionManager collectionManager;
    public static CommandManager commandManager;
    public static DumpManager dumpManager;
    public static boolean isRunning = true;
    public static void start(String fileAdress){
        consoleManager = new ConsoleManager();
        consoleManager.start();
        collectionManager = new CollectionManager();
        commandManager = new CommandManager();
        dumpManager = new DumpManager();
        dumpManager.initialReadFromFile(fileAdress);

        while(isRunning){
            String inputCommand = consoleManager.input();
            commandManager.runCommand(inputCommand);
        }
    }

}
