package com.client.consoleManager.commandManager.commands.withArg;


import com.client.Client;
import common.dragon.Color;
import common.network.Request;
import common.network.Response;
import com.client.consoleManager.ValidateError;

import java.util.Scanner;

;

public class FilterByColor implements CommandWithArgument {
    @Override
    public Response execute(String arg) {
        Color color = null;

        switch (arg) {
            case "GREEN" -> {
                color = Color.GREEN;
            }
            case "BLACK" -> {
                color = Color.BLACK;
            }
            case "BLUE" -> {
                color = Color.BLUE;
            }
            case "ORANGE" -> {
                color = Color.ORANGE;
            }
            case "BROWN" -> {
                color = Color.BROWN;
            }
            default -> {
                Client.consoleManager.printError(ValidateError.NOSUCHCOLOR);
                return null;
            }}
        Client.requestsManager.sendRequest(new Request("filter_by_color "+arg,null));
        return Client.requestsManager.receiveRespond();
    }

    @Override
    public Response executeFromScript(String arg, Scanner scanner) {
        return execute(arg);
    }
}
