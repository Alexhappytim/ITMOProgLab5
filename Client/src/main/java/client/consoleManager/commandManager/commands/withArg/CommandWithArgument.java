package client.consoleManager.commandManager.commands.withArg;

import java.util.Scanner;

public interface CommandWithArgument {
    void execute(String arg);
    void executeFromScript(String arg, Scanner scanner);
}
