package ConsoleManager.commands.withArg;

import ConsoleManager.commands.withArg.CommandWithArgument;
import execution.ExecutionManager;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExecuteScriptCommand implements CommandWithArgument {
    int curentlyDepth=0;
    @Override
    public void execute(String arg) {
        curentlyDepth++;

        if(curentlyDepth>3){
            ExecutionManager.consoleManager.println("Превышена глубина рекурсии");
            return;
        }
        try (FileReader reader = new FileReader(arg)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine() && ExecutionManager.isRunning) {
                String temp = scanner.nextLine();
                ExecutionManager.commandManager.runCommand(temp, scanner);
            }
        } catch (FileNotFoundException e) {
            ExecutionManager.consoleManager.println("Ошибка доступа к файлу");
        } catch (Exception e) {
            ExecutionManager.consoleManager.println("Ошибка чтения файла");
        }
        curentlyDepth--;
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
