package client.consoleManager.commandManager.commands.withoutArg;

import client.Client;
import common.dragon.Dragon;
import common.network.Request;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public void execute() {
        Client.requestsManager.sendRequest(new Request("add",Client.consoleManager.inputNewElement()));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }

    @Override
    public void executeFromScript(Scanner scanner) {
        Dragon dragon = Client.clientCommandManager.inputNewElementFromFile(scanner);
        if(dragon!=null){
            Client.requestsManager.sendRequest(new Request("add",dragon));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }
    }
}
