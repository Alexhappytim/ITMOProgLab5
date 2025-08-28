package com.client.consoleManager.commandManager.commands.withoutArg;

import com.client.Client;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class InfoCommand implements Command {
    @Override
    public Response execute() {
        Client.requestsManager.sendRequest(new Request("info",null));
        return Client.requestsManager.receiveRespond();
    }
    @Override
    public Response executeFromScript(Scanner scanner) {
        return execute();
    }
}
