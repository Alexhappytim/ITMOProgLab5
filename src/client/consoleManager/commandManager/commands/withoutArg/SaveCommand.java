package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import server.Server;

import java.io.IOException;
import java.util.Scanner;

public class SaveCommand implements Command {
    @Override
    public void execute() {
        Client.consoleManager.println("Ошибка доступа");
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
