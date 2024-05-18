package client.consoleManager.commandManager.commands.withArg;

import client.Client;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExecuteScriptCommand implements CommandWithArgument {
    int curentlyDepth=0;
    @Override
    public void execute(String arg) {
        curentlyDepth++;

        if(curentlyDepth>3){
            Client.consoleManager.println("Превышена глубина рекурсии");
            return;
        }
        try (FileReader reader = new FileReader(arg)) {
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine() && Client.isRunning) {
                String temp = scanner.nextLine();
                Client.clientCommandManager.runCommand(temp, scanner);
            }
        } catch (FileNotFoundException e) {
            Client.consoleManager.println("Ошибка доступа к файлу");
        } catch (Exception e) {
            Client.consoleManager.println("Ошибка чтения файла");
        }
        curentlyDepth--;
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
