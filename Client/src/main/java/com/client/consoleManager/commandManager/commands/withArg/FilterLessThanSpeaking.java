package com.client.consoleManager.commandManager.commands.withArg;

import com.client.Client;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class FilterLessThanSpeaking implements CommandWithArgument {
    @Override
    public Response execute(String arg) {
        if(arg.equals("true") || arg.equals("false")){
            Client.requestsManager.sendRequest(new Request("filter_less_than_speaking "+arg,null));
            return Client.requestsManager.receiveRespond();
        }else{
            Client.consoleManager.println("Введите true или false");
        }
        return null;
    }
    @Override
    public Response executeFromScript(String arg, Scanner scanner) {
        return execute(arg);
    }
}
