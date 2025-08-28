package com.client.consoleManager.commandManager.commands.withoutArg;


import com.client.Client;
import common.dragon.Dragon;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class AddCommand implements Command {
    @Override
    public Response execute() {
        Client.requestsManager.sendRequest(new Request("add",Client.consoleManager.inputNewElement()));
        return Client.requestsManager.receiveRespond();
    }

    @Override
    public Response executeFromScript(Scanner scanner) {
        Dragon dragon = Client.clientCommandManager.inputNewElementFromFile(scanner);
        if(dragon!=null){
            Client.requestsManager.sendRequest(new Request("add",dragon));
            return Client.requestsManager.receiveRespond();
        }
        return null;
    }
}
