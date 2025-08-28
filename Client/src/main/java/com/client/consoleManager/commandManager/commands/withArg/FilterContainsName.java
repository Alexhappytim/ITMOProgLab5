package com.client.consoleManager.commandManager.commands.withArg;


import com.client.Client;
import common.network.Request;
import common.network.Response;

import java.util.Scanner;

public class FilterContainsName implements CommandWithArgument {
    @Override
    public Response execute(String arg) {
        Client.requestsManager.sendRequest(new Request("filter_contains_name "+arg,null));
        return Client.requestsManager.receiveRespond();
    }
    @Override
    public Response executeFromScript(String arg, Scanner scanner) {
        return execute(arg);
    }
}
