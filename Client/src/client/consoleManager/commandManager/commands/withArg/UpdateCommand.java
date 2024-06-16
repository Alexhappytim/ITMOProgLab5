package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;

import java.util.Scanner;

public class UpdateCommand implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        try{
            Long a = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("update "+arg,Client.consoleManager.inputNewElement()));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }catch(Exception e){
            Client.consoleManager.println("Неправильный id");
            return;
        }
    }

    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        try{
            Long a = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("update "+arg,Client.clientCommandManager.inputNewElementFromFile(scanner)));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }catch(Exception e){
            Client.consoleManager.println("Неправильный id");
            return;
        }
    }
}
