package ConsoleManager.commands.withoutArg;

import java.util.Scanner;

public interface Command {
    void execute();
    void executeFromScript(Scanner scanner);
}
