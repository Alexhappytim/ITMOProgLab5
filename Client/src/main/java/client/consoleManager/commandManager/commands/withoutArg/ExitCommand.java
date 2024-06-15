package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;


import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public void execute() {
        Client.isRunning=false;
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
