package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;
import server.commandManager.ValidateError;
import common.dragon.Color;
import server.Server;

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
                Client.consoleManager.printError(ValidateError.NOSUCHCOLOR);
                return;
            }}
        Client.requestsManager.sendRequest(new Request("filter_by_color "+arg,null));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
