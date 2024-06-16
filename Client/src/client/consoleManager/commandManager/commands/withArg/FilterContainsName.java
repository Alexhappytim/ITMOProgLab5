package client.consoleManager.commandManager.commands.withArg;

import client.Client;
import common.network.Request;

import java.util.Scanner;

public class FilterContainsName implements CommandWithArgument {
    @Override
    public void execute(String arg) {
        Client.requestsManager.sendRequest(new Request("filter_contains_name "+arg,null));
        Client.consoleManager.println(Client.requestsManager.receiveRespond().getResponse());
    }
    @Override
    public void executeFromScript(String arg, Scanner scanner) {
        execute(arg);
    }
}
