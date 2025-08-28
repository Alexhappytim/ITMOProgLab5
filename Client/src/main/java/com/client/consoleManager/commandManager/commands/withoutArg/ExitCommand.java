package com.client.consoleManager.commandManager.commands.withoutArg;


import com.client.Client;
import common.network.Response;

import java.util.Scanner;

public class ExitCommand implements Command {
    @Override
    public Response execute() {
        Client.isRunning=false; return null;
    }
    @Override
    public Response executeFromScript(Scanner scanner) {
        execute();
        return null;
    }
}
