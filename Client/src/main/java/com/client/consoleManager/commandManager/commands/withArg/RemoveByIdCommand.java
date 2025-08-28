package com.client.consoleManager.commandManager.commands.withArg;


import com.client.Client;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class RemoveByIdCommand implements CommandWithArgument {
    @Override
    public Response execute(String arg) {
        try{
            Long id = Long.parseLong(arg);
            Client.requestsManager.sendRequest(new Request("remove_by_id "+arg,null));
            return Client.requestsManager.receiveRespond();
        }catch (Exception e){
            Client.consoleManager.println("Неправильный аргумент");}
        return null;
    }
    @Override
    public Response executeFromScript(String arg, Scanner scanner) {
        return execute(arg);
    }
}
