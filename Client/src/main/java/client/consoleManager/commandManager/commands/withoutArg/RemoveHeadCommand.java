package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import common.network.Request;


import java.util.Scanner;

public class RemoveHeadCommand implements Command {
    @Override
    public void execute() {
        Client.requestsManager.sendRequest(new Request("remove_head",null));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }
    @Override
    public void executeFromScript(Scanner scanner) {
        execute();
    }
}
