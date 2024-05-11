package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import common.network.Request;
import server.Server;

import java.util.Scanner;

public class ClearCommand implements Command {
    @Override
    public void execute() {
        Client.requestsManager.sendRequest(new Request("clear",null));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
