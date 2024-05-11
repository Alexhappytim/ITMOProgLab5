package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.dragon.Dragon;
import common.network.Request;
import server.Server;

import java.util.Iterator;
import java.util.Scanner;

public class UpdateCommand implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        try{
            Long a = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("info",Client.consoleManager.inputNewElement()));
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
            Client.requestsManager.sendRequest(new Request("info",Client.clientCommandManager.inputNewElementFromFile(scanner)));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }catch(Exception e){
            Client.consoleManager.println("Неправильный id");
            return;
        }
    }
}
