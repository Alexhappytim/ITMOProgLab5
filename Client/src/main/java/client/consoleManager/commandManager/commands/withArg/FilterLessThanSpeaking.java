package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;


import java.util.Scanner;

public class FilterLessThanSpeaking implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        if(arg.equals("true") || arg.equals("false")){
            Client.requestsManager.sendRequest(new Request("filter_less_than_speaking "+arg,null));
            Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
        }else{
            Client.consoleManager.println("Введите true или false");
        }
    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
