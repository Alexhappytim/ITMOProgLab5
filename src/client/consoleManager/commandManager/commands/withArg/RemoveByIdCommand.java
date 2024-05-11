package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;
import server.Server;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        try{
            Long id = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("remove_by_id "+arg,null));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }catch (Exception e){
            Client.consoleManager.println("Неправильный аргумент");}

    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
