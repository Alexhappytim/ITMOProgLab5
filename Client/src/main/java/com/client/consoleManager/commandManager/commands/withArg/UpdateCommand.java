package com.client.consoleManager.commandManager.commands.withArg;

import com.client.Client;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class UpdateCommand implements CommandWithArgument {
    @Override
    public Response execute(String arg) {
        try{
            Long a = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("update "+arg,Client.consoleManager.inputNewElement()));
            return Client.requestsManager.receiveRespond();
        }catch(Exception e){
            Client.consoleManager.println("Неправильный id");
            return null;
        }
    }

    @Override
    public Response executeFromScript(String arg, Scanner scanner) {
        try{
            Long a = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("update "+arg,Client.clientCommandManager.inputNewElementFromFile(scanner)));
            return Client.requestsManager.receiveRespond();
        }catch(Exception e){
            Client.consoleManager.println("Неправильный id");
            return null;
        }
    }
}
