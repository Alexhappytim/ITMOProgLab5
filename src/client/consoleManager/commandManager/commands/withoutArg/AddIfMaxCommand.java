package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import common.dragon.Dragon;
import common.network.Request;
import server.Server;

import java.util.Scanner;

public class AddIfMaxCommand implements Command {
    @Override
    public void execute() {
        Client.requestsManager.sendRequest(new Request("add_if_max",Client.consoleManager.inputNewElement()));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }

    @Override
    public void executeFromScript(Scanner scanner) {
        Dragon dragon = Client.clientCommandManager.inputNewElementFromFile(scanner);
        if(dragon!=null){
            Client.requestsManager.sendRequest(new Request("add_if_max",dragon));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }
    }
}
